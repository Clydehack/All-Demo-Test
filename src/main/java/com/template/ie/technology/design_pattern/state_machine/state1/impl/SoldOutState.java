package com.template.ie.technology.design_pattern.state_machine.state1.impl;

import com.template.ie.technology.design_pattern.state_machine.state1.GumballMachine;
import com.template.ie.technology.design_pattern.state_machine.state1.State;

/**
 * 售完的状态
 */
public class SoldOutState implements State {

	GumballMachine gumballMachine;
	
	/**
	 * 售完的状态的构造函数
	 */
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
	@Override
	public void insertQuarter() {
		System.out.println("不能投币，无货状态");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("还没投币呢");
	}

	@Override
	public void turnCrank() {
		System.out.println("摇动摇杆，但是没有货了");
	}

	@Override
	public void dispense() {
		System.out.println("没有糖果了");
	}

	@Override
	public String toString() {
		return "售罄";
	}
}