package com.template.ie.technology.design_pattern.state_machine.state2;

/**
 * 订单抽象类 - 封装订单行为
 */
public abstract class OrderState {

	/**
	 * A发起交换(生成两个订单，A支付中状态，B待支付状态，此状态下10分钟内A未支付成功则默认A取消订单)
	 */
	public void userARequestExchange() {
		
	}
	
	/**
	 * wx支付，A支付回调成功(进入A已支付，B待支付状态，此状态下3小时内B未支付成功则默认B取消订单)
	 */
	public void paySuccess() {
		
	}
	
	/**
	 * B同意交换(进入A已支付，B支付中状态，此状态下3小时内B未支付成功则默认B取消订单)
	 */
	public void userBAgreeExchange() {
		
	}
	
	/**
	 * wx支付，B支付回调成功(进入A待发货，B待发货状态 ；在外面 调用双方快递下单方法)
	 */
	public void userBPaySuccess() {
		
	}
	
	/**
	 * 已发货(待收货)
	 */
	
	/**
	 * 已收货(已完成)
	 */
	
	/**
	 * 取消订单(A 待支付，支付中，已支付 ； B 待支付，支付中 ； 双方在此笛卡尔积的状态下可以取消订单)
	 */
	public void cancelOrder() {
		
	}
	
	/**
	 * 人工介入(A 已支付，待发货 ； B 待发货 ； 双方在此笛卡儿积的状态下要由后台的人工介入进行人肉处理)
	 */
	public void customerServiceCenter() {
		
	}
}