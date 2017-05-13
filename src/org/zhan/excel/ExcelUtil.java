package org.zhan.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtil {

	public <T> void getExcel(List<T> list, Class<T> c, OutputStream output)
			throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Method> methodMap = new LinkedHashMap<>();
		Method[] methods = c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String name = method.getName();
			Pattern pattern = Pattern.compile("get(.*)");
			Matcher matcher = null;
			if ((matcher = pattern.matcher(name)).matches()) {
				name = matcher.group(1);
				char ch = name.charAt(0);
				char newch = (char) (ch + 32);
				name = name.replace(ch, newch);
				methodMap.put(name, method);
			}
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(c.getCanonicalName());
		int rownum = 0;
		XSSFRow firstrow = sheet.createRow(rownum++);
		int cellnum = 0;
		for (String key : methodMap.keySet()) {
			XSSFCell cell = firstrow.createCell(cellnum++);
			cell.setCellValue(key);
		}

		for (T t : list) {
			XSSFRow row = sheet.createRow(rownum++);
			cellnum = 0;
			for (String key : methodMap.keySet()) {
				Method method = methodMap.get(key);
				// 设置可访问，之前不知道这方法，所以关于反射那篇文章有错误，见谅见谅
				method.setAccessible(true);
				Object obj = method.invoke(t);
				XSSFCell cell = row.createCell(cellnum++);
				cell.setCellValue(obj == null ? "" : obj.toString());
			}

		}
		workbook.write(output);
		workbook.close();
	}
}
