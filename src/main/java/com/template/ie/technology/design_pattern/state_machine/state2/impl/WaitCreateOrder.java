package com.template.ie.technology.design_pattern.state_machine.state2.impl;

import com.template.ie.technology.design_pattern.state_machine.state2.OrderState;

/**
 * 订单待创建(初始状态 A待支付 B待支付)
 */
public class WaitCreateOrder extends OrderState {

	
	
	@Override
	public String toString() {
		return "订单还未生成";
	}
}