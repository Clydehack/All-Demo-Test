package com.template.ie.technology.design_pattern.state_machine.state1;

public interface State {

	/* 
	 * 学习1	糖果机例子	https://blog.csdn.net/shuangde800/article/details/10132825
	 * 
	 * 初期我们根据糖果机的状态,定义4种状态,用整形常量来表示
	 * 
	 * 要用代码实现糖果机的功能, 如果不用状态模式:
	 * 		一种方法是创建一个类,它的作用就是一个状态机,对每一个动作,我们都创建了一个对应的方法,
	 * 		这些方法用条件语句来决定在每一个状态内什么方法是最恰当的.比如对"投入25分钱"这个动作,
	 * 对应的方法如下:
	 */
	final static int SOLD_OUT= 0; 		// 糖果卖完了
	final static int NO_QUARTER = 1; 	// 没有投钱
	final static int HAS_QUARTER = 2;  	// 已投钱了
	final static int SOLD = 3; 			// 正在出售糖果
	
	// 投币动作
	public static void insertQurter() {
	    
		int state = 0;					// 根据不同的状态,会有不同的动作反应
	    
	    if (state == HAS_QUARTER) {
	        // 如果状态是已投钱了 
	    	System.out.println("不能重复投钱");
	    } else if (state == SOLD_OUT) {
	        // 如果糖果卖完了 
	    	System.out.println("不能投钱,糖果机售罄了");
	    } else if (state == SOLD) {
	        // 如果正在出售糖果
	    	System.out.println("请等待,糖果机正在出糖果");
	    } else if (state == NO_QUARTER) {
	        // 如果状态是没有投钱
	    	state = HAS_QUARTER;
	    	System.out.println("你投了一次钱，状态改为已投钱");
	    }
	}
	
	/**
	 * 状态模式开始
	 * 		这个模式将状态封装成为独立的类，并将动作委托到代表当前状态的对象，我们知道行为会随着内部状态而改变。 
	 * 
	 * 初学思考
	 * 		就是说有多少状态就有多少的类呗；将动作委托到类的对象上，理解起来像是说，一个事件推动一个公共类，这个公共类根据自己状态调用当前状态的对象
	 */
	
	/* 封装四种动作 */
	/**
	 * 投币
	 */
	public void insertQuarter();
	/**
	 * 退币
	 */
	public void ejectQuarter(); 
	/**
	 * 转动摇柄
	 */
	public void turnCrank();
	/**
	 * 发糖果
	 */
	public void dispense();
}