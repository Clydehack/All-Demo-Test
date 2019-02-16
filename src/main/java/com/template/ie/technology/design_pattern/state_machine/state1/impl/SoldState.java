package com.template.ie.technology.design_pattern.state_machine.state1.impl;

import com.template.ie.technology.design_pattern.state_machine.state1.GumballMachine;
import com.template.ie.technology.design_pattern.state_machine.state1.State;

/**
 * 正在售出的状态
 */
public class SoldState implements State {

	GumballMachine gumballMachine;
	
	/**
	 * 正在售出的状态的构造函数
	 */
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
	@Override
	public void insertQuarter() {
		System.out.println("请等待，已经在出糖果");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("已经摇动摇杆了");
	}

	@Override
	public void turnCrank() {
		System.out.println("重复摇动不会有新糖果出现");
	}

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("天，售罄了");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

	@Override
	public String toString() {
		return "出来了一个糖果";
	}
}