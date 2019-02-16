package com.template.ie.learn.java_base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Clyde
 * 2018-1-23 开始 -- 2018-1-24 结束
 * 
 * Java 文件类
 */
public class JavaForFile {

	/** 测试用main函数 */
	public static void main(String[] args) {
//		traversalFolder();
//		simpleReadFile();
//		simpleWriteFile();
	}
	
	/** 简单写文件 */
	public static void simpleWriteFile () {
		try {
			File file = new File("test.txt");
			
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("abcd \n");
			bw.write("xxxxxxx\n");
			bw.write("yyyyyyy\n");
			bw.write("aaaaaaa\n");
			bw.write("bbbbbbb\n");
			bw.write(1234567890);
			bw.write("1234567890");	// 这样输出int类型
			
			bw.close();
			osw.close();
			fos.close();
			
			System.out.println("文件创建完成");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 简单读文件 */
	public static void simpleReadFile () {
		try {
			File file = new File("apiclient_cert.p12");
			
			if (file.exists()) {												//exists() 如果文件存在
				
				FileInputStream fis = new FileInputStream(file);				//获取文件输入流，字节流
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");	//字符流，字节流转成字符流时要加编码格式，不然出现乱码
				BufferedReader br = new BufferedReader(isr);					//带缓冲区的reader
				
				String line;													//用于临时存放读取到的数据
				while ((line = br.readLine()) != null) {						//如果readLine不为空，说明文件还未结束，循环读取直到读完文件
					System.out.println(line);
				}
				
				br.close();
				isr.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 写文件属性 */
	public static void writeFile () {
		
		File file = new File("test.txt");
		if (file.exists()) {
			
			file.setWritable(true);		//设置为可写
			file.setReadable(false);	//设置为可读
			
			file.setReadOnly();			//设置为只读
			
		}
	}
	
	/** 读文件属性 */
	public static void readFile () {
		File file = new File("test.txt");
		System.out.println(file.exists());									//判断文件是否存在
		System.out.println(file.getName());									//读取文件名
		System.out.println(file.getPath());									//读取文件相对路径-自身路径
		System.out.println(file.getAbsolutePath());							//读取文件绝对路径-全部路径
		
		System.out.println(file.getParent());								//读取文件父级路径，返回null，因为"test.txt"是没有父级的
		System.out.println(new File(file.getAbsolutePath()).getParent());	//这样就获取到父级路径了
		
		System.out.println(file.length() + "byte");							//读取文件大小，(float)file.length()/1000 + "kb"
		System.out.println(file.isHidden());								//判断文件是否隐藏
		System.out.println(file.canRead());									//判断文件是否可读
		System.out.println(file.canWrite());								//判断文件是否可写
		System.out.println(file.isDirectory());								//判断文件是否为文件夹
	}
}