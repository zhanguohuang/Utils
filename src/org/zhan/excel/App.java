package org.zhan.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		List<Object> list = new ArrayList<>();
		OutputStream output = new FileOutputStream("/home/paul/user.xlsx");
		new ExcelUtil().getExcel(list, Object.class, output);
		output.close();
	}
}
