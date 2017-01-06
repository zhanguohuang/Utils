package org.zhan.xml;

import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * XmlUtil 工具类
 * 将对象转换为Document 
 * 
 */
public class XmlUtil {
	
	public static final String DEFAULT_ROOT_ELEMENT = "root";
	
	/**
	 * 将对象转换成xmlDocument
	 * @param obj
	 * @return
	 */
	public static Document parseObject(Object obj) {
		return parseObject(obj, null);
	}
	
	/**
	 * @param obj
	 * @param rootName 根节点名称
	 * @return
	 */
	public static Document parseObject(Object obj, String rootName) {
		Assert.notNull(obj, "obj must not be null");
		Document doc = DocumentHelper.createDocument();
		rootName = StringUtils.isEmpty(rootName) ? DEFAULT_ROOT_ELEMENT : rootName;
		Element root = doc.addElement(rootName);
		createObjectElement(root, obj);
		return doc;
	}
	
	/**
	 * @param parentElement 父节点
	 * @param obj
	 */
	private static void createObjectElement(Element parentElement, Object obj) {
		Assert.notNull(parentElement, "parentElement must not be null");
		Assert.notNull(obj, "obj must not be null");
		if(parentElement.isRootElement() && isSimpleClass(obj.getClass())) {
			parentElement.addText(obj.toString());
			return;
		}
		BeanMap beanMap = BeanMap.create(obj);
		for(Object key : beanMap.keySet()) {
			if(beanMap.get(key) == null) continue;
			if(isSimpleClass(beanMap.get(key).getClass())) {
				Element childElement = parentElement.addElement(key.toString());
				childElement.addText(beanMap.get(key).toString());
			} else {
				Element childElement = parentElement.addElement(obj.getClass().getSimpleName());
				createObjectElement(childElement, beanMap.get(key));
			}
		}
	}
	
	/**
	 * 判断传入的class是否为基本类型和在java.lang包下的对象
	 * @param clazz
	 * @return
	 */
	private static boolean isSimpleClass(Class clazz) {
		return clazz.isPrimitive() || clazz.getName().matches("java.lang.\\w+"); 
	}
	
	/**
	 * 将对象转换成xmlString
	 * @param obj
	 * @return
	 */
	public static String parseObjectToString(Object obj) {
		return parseObjectToString(obj, null);
	}
	
	/**
	 * 将对象转换成xmlString
	 * @param obj
	 * @param hasHeader 判断头部是否带有DEFAULT_XML_HEADER
	 * @return
	 */
	public static String parseObjectToString(Object obj, String rootName) {
		return parseObject(obj, rootName).asXML();
	}
	
	/**
	 * 将map对象转换成xml
	 * @param map
	 * @return
	 */
	public static Document parseMap(Map map) {
		return parseMap(map, null);
	}
	
	/**
	 * @param map
	 * @param rootName 根节点名称
	 * @return
	 */
	public static Document parseMap(Map map, String rootName) {
		Assert.notNull(map, "map must not be null");
		Document doc = DocumentHelper.createDocument();
		rootName = StringUtils.isEmpty(rootName) ? DEFAULT_ROOT_ELEMENT : rootName;
		Element root = doc.addElement(rootName);
		createMapElement(root, map);
		return doc;
	}	
	
	private static void createMapElement(Element parentElement, Map map) {
		Assert.notNull(parentElement, "parentElement must not be null");
		Assert.notNull(map, "map must not be null");
		for(Object key : map.keySet()) {
			Assert.isTrue(isSimpleClass(key.getClass()), "key must be basic data type");
			Element childElement = parentElement.addElement(key.toString());
			if(isSimpleClass(map.get(key).getClass())) {
				childElement.addText(map.get(key).toString());
			} else {
				detectMapValue(childElement, map.get(key));
			}
			
		}
	}
	
	private static void detectMapValue(Element parentElement, Object obj) {
		Assert.notNull(parentElement, "parentElement must not be null");
		Assert.notNull(obj, "obj must not be null");
		BeanMap beanMap = BeanMap.create(obj);
		for(Object key : beanMap.keySet()) {
			if(beanMap.get(key) == null) continue;
			if(isSimpleClass(beanMap.get(key).getClass())) {
				Element childElement = parentElement.addElement(key.toString());
				childElement.addText(beanMap.get(key).toString());
			} else {
				detectMapValue(parentElement, beanMap.get(key));
			}
		}
	}
	
	public static String parseMapToString(Map map) {
		return parseMapToString(map, null);
	}
	
	public static String parseMapToString(Map map, String rootName) {
		return parseMap(map, rootName).asXML();
	}
	
}
