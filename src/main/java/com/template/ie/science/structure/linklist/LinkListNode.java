package com.template.ie.science.structure.linklist;

/**
 * 链表节点模型
 */
public class LinkListNode {

	private Object date;			// 存放数据变量
	private LinkListNode next;		// 存放节点变量，默认null
	
	public LinkListNode(Object date) {
		this.date = date;
	}

	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}

	public LinkListNode getNext() {
		return next;
	}
	public void setNext(LinkListNode next) {
		this.next = next;
	}
}