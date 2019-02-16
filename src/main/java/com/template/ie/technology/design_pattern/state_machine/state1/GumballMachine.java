package com.template.ie.technology.design_pattern.state_machine.state1;

import com.template.ie.technology.design_pattern.state_machine.state1.impl.HasQuarterState;
import com.template.ie.technology.design_pattern.state_machine.state1.impl.NoQuarterState;
import com.template.ie.technology.design_pattern.state_machine.state1.impl.SoldOutState;
import com.template.ie.technology.design_pattern.state_machine.state1.impl.SoldState;

/**
 * 被一个事件推动的一个公共类，通常叫法是Context，通过糖果机学习状态模式
 */
public class GumballMachine {

	State soldOutState;			// 糖果卖完了
	State noQuarterState;		// 没有投钱
	State hasQuarterState;		// 已投钱了
	State soldState;			// 正在出售糖果

	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
 
		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	/**
	 * 投币
	 */
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	/**
	 * 退币
	 */
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	/**
	 * 转动摇柄
	 * 发糖果
	 */
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void setState(State state) {
		this.state = state;
	}
 
	public void releaseBall() {
		System.out.println("一个糖滚出来了...");
		if (count != 0) {
			count = count - 1;
		}
	}
 
	public int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}
 
    public State getState() {
        return state;
    }
 
    public State getSoldOutState() {
        return soldOutState;
    }
 
    public State getNoQuarterState() {
        return noQuarterState;
    }

    /**
     * 获得 - 已投钱了(已经投币的状态的的对象)
     */
    public State getHasQuarterState() {
        return hasQuarterState;
    }
 
    /**
     * 获得 - 正在出售糖果(正在售出的状态的对象)
     */
    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n糖球公司");
		result.append("\njava提供技术支持");
		result.append("\n库存: " + count + " 糖球");
		/*if (count != 1) {
			result.append("s");
		}*/
		result.append("\n");
		result.append("糖球机处于 " + state + "\n");
		return result.toString();
	}
}