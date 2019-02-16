package com.template.ie.technology.design_pattern.state_machine.state1;

/**
 * 糖果机启动测试类
 */
public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		 
		System.out.println(gumballMachine);
 
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
 
		System.out.println(gumballMachine);
 
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.turnCrank();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
	}
}