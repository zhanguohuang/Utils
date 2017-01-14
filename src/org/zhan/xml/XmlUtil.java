package org.zhan.xml;

import java.util.Map;

import org.dom4j.Branch;
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
		detectChildValue(doc, obj, rootName);
		return doc;
	}
	
	/**
	 * @param parentElement
	 * @param obj
	 * @param childName
	 */
	private static void detectChildValue(Branch parentElement, Object obj, String childName) {
		if(!StringUtils.isEmpty(childName)) {
			parentElement = parentElement.addElement(childName);
		}
		if(isSimpleClass(obj.getClass())) {
			((Element) parentElement).addText(obj.toString());
		} else {
			Map map = null;
			if(obj instanceof Map) {
				map = (Map) obj;
			} else {
				map = BeanMap.create(obj);
			}
			for(Object key : map.keySet()) {
				if(map.get(key) == null) continue;
				//是简单java对象
				if(isSimpleClass(map.get(key).getClass()) || obj instanceof Map) {
					detectChildValue(parentElement, map.get(key), key.toString());
				} else {
					detectChildValue(parentElement, map.get(key), obj.getClass().getSimpleName());
				}
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
		detectChildValue(doc, map, rootName);
		return doc;
	}	
	
	
	public static String parseMapToString(Map map) {
		return parseMapToString(map, null);
	}
	
	public static String parseMapToString(Map map, String rootName) {
		return parseMap(map, rootName).asXML();
	}
	
}
