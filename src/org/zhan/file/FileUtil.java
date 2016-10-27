package org.zhan.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 工具类，用于快速读写文件
 * @author Administrator
 *
 */
public class FileUtil extends ArrayList<String> {

	/**
	 * 输入路径的路径，读取文件转换为一个String
	 * @param filename
	 * @return
	 */
	public static String read(String filename) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");  /*每读一行就加一个换行符*/
				}
			}finally {
				in.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	/**
	 * 将字符串写入文件中
	 * @param fileName
	 * @param text
	 */
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public FileUtil(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		if(get(0).equals(""))
			remove(0);  /*如果第一行为空，就移除*/
	}
	
	public FileUtil(String fileName) {
		this(fileName, "\n");
	}
	
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String item : this)   /*调用this的iterator方法*/
					out.println(item);
			} finally {
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		String file = read("./src/org/chapter18/TextFile.java");
		write("./src/org/chapter18/TextFile.data", file); /*将file中的内容写进data中*/
		FileUtil text = new FileUtil("./src/org/chapter18/TextFile.data");  /*开始存储内容到List中*/
		text.write("./src/org/chapter/TextFile.data2");  /*将数据以List的方式写入到data2中*/
		TreeSet<String> words = new TreeSet(new FileUtil("./src/org/chapter18/TextFile.java", "\\W+")); /* 将文件内容以非数字字符的切割的方式读取List中*/
		System.out.println(words.headSet("a"));
	}
}
