package com.template.ie.technology.design_pattern.state_machine.state1.impl;

import com.template.ie.technology.design_pattern.state_machine.state1.GumballMachine;
import com.template.ie.technology.design_pattern.state_machine.state1.State;

/**
 * 已经投币的状态
 */
public class HasQuarterState implements State {
	
	GumballMachine gumballMachine;
	
	/**
	 * 已经投币的状态的构造函数
	 */
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("不能重复投币");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("退币");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("摇动摇杆");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	@Override
	public void dispense() {
		System.out.println("没有糖滚出来");
	}

	@Override
	public String toString() {
		return "等待摇杆";
	}
}