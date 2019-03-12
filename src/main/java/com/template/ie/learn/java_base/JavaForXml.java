package com.template.ie.learn.java_base;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Clyde
 * xml
 * 
 * DOM、SAX、JAXP机制来解析xml
 */
public class JavaForXml {
	
	/**
	 * 经典方法：DOM方式读取XML
	 */
	public static void readXML() {	
		
		try {
			
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();		//调用静态方法，创实例化(工厂方法？)
			DocumentBuilder builder = docfactory.newDocumentBuilder();						//创建一个新的DocumentBuilder
			Document document = builder.parse(new File("test.xml"));						//创建一个Document，获得路径中的文件
			
			Element root = document.getDocumentElement();									//获得根节点
			System.out.println("cat = " + root.getAttribute("cat"));						//获得根节点的属性并输出
			
			NodeList list = root.getElementsByTagName("");									//获得root的子节点
			
			for (int i = 0; i < list.getLength(); i++) {									//通过循环开始获得数据
				
				Element xxx = (Element) list.item(i);										//获得所有的root子节点
				
				System.out.println("-----------");
				System.out.println("id = " + xxx.getAttribute("id"));						//获得子节点的id属性并输出
				
				/* 此方法有点笨
				Element name = (Element) xxx.getElementsByTagName("name").item(0); 			//获得name节点元素
				System.out.println("name = " + name.getTextContent());						//输出name
				Element ide = (Element) xxx.getElementsByTagName("ide").item(0); 			//获得ide节点元素
				System.out.println("ide = " + ide.getTextContent());						//输出ide
				*/
				
				/* 使用此方法  */
				NodeList child = xxx.getChildNodes();										//获得子节点的每个元素
				for (int j = 0; j < child.getLength(); j++) {								//通过循环开始获得子节点
					
					Node c = child.item(j);													//获得子节点
					
					if (c instanceof Element) {												//判断：如果当前节点 c 是 Element 的话，才输出,用于过滤掉空格等
						System.out.println(c.getNodeName() + "=" + c.getTextContent());		//获得节点名称并输出
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}										
	}
	
	/**
	 * 经典方法：DOM方式创建XML
	 */
	public static void createXML() {
		
		try {
			
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();		//调用静态方法，创实例化(工厂方法？)
			DocumentBuilder builder = docfactory.newDocumentBuilder();						//创建一个新的DocumentBuilder
			Document document = builder.newDocument();										//创建一个全新的xml文件
			
			Element root = document.createElement("root");									//创建一个root根元素
			root.setAttribute("cat", "black");												//给root添加一个属性
			
			Element one = document.createElement("one");									//创建一个root根节点下的子节点one
			one.setAttribute("猫咪", "1");													//给子节点添加一个属性
			
			Element nameone = document.createElement("name");								//创建one子节点下的第一个节点nameone
			nameone.setTextContent("abc");													//给节点添加内容（元素）
			Element nemetwo = document.createElement("ide");								//创建one子节点下的第二个节点nemetwo
			nemetwo.setTextContent("def");													//给节点添加内容（元素）
			
			one.appendChild(nameone);														//将nameone节点添加到one节点下
			one.appendChild(nemetwo);														//将nemetwo节点添加到one节点下
			
			root.appendChild(one);															//将子节点one添加到根节点root下
			
			document.appendChild(root);														//将根节点root添加到文件里
			
			/*xml文件创建完毕,用transformer*/
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();		
			Transformer transformer = transformerFactory.newTransformer();					//Transformer 将xml格式文档，转换成其他格式
			
			StringWriter writer = new StringWriter();										//创建用于网络传输的字符串 StringWriter
			transformer.transform(new DOMSource(document), new StreamResult(writer));		//transform（输入，输出） 
			System.out.println(writer.toString());											//输出 writer
			
			transformer.transform(new DOMSource(document), new StreamResult(new File("test.xml")));	//输入doument 输出为xml文件
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		/*
		 
		 	<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<root cat="black">
				<one 猫咪="1">
					<name>abc</name>
					<ide>def</ide>
				</one>
			</root>
		
		*/
	}
	
	/****************************************************************************************/
	
	/**
	 * 测试用main函数
	 * @param args
	 */
	public static void main(String[] args) {
		createXML();
		//readXML();
	}
}