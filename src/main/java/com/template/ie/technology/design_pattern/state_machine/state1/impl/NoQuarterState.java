package com.template.ie.technology.design_pattern.state_machine.state1.impl;

import com.template.ie.technology.design_pattern.state_machine.state1.GumballMachine;
import com.template.ie.technology.design_pattern.state_machine.state1.State;

/**
 * 没有投币的状态
 */
public class NoQuarterState implements State {

	GumballMachine gumballMachine;
	
	/**
	 * 没有投币的状态的构造函数
	 */
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("投了一次币");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("还没投币呢");
	}

	@Override
	public void turnCrank() {
		System.out.println("摇动了一次，但是还未投币");
	}

	@Override
	public void dispense() {
		System.out.println("需要先支付");
	}

	@Override
	public String toString() {
		return "等待投币";
	}
}