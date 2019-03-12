package com.template.ie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 各个需要main函数的测试方法
 */
public class Main {

	public static void main(String[] args) throws Exception {
		/*LocalDate today = LocalDate.now();
		System.out.println(today);
		
		//获得系统的时间，单位为毫秒,转换为妙
        long totalMilliSeconds = System.currentTimeMillis();
        
        DateFormat dateFormatterChina = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);//格式化输出
        TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");//获取时区 这句加上，很关键。
        dateFormatterChina.setTimeZone(timeZoneChina);//设置系统时区
        long totalSeconds = totalMilliSeconds / 1000;
        
        //求出现在的秒
        long currentSecond = totalSeconds % 60;
        
        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        
        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;
        
        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);
        
        // 毫秒格式化为日期对外显示
        Date nowTime = new Date(System.currentTimeMillis());
        //SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        SimpleDateFormat sdFormatter = new SimpleDateFormat("HH");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        System.out.println(retStrFormatNowDate);
        
        long longNow = System.currentTimeMillis();
        Date dateNow = new Date(longNow);
        String retStr = sdFormatter.format(dateNow);
		int intNow = Integer.valueOf(retStr);
		System.out.println(intNow);
		
		int[] intArr = {9,10,11,12,13,14,15,16};
		intNow = 16;
		int i = 0;
		for(;i < intArr.length;i++) {
			System.out.println(i);
			if(intNow == intArr[i]) {
				System.out.println(i);
				while(i<8) {
					System.out.println("添加时间:"+i);
					i++;
				}
				break;
			}
		}
		System.out.println("i="+i);
		
		
		String pickUpTime = "2019-02-22 12:00-17:00";	// 预约取件时间		(前端显示用，格式：2019-02-22 12:00-17:00)
		String date = pickUpTime.substring(0, 10);
		 取件时间再处理 
		pickUpTime = date + " " + pickUpTime.substring(11, 16) + ":00";
		System.out.println(pickUpTime);
		
		longNow = System.currentTimeMillis();
		dateNow = new Date(longNow);
		SimpleDateFormat sdFormatterMin = new SimpleDateFormat("mm");
		String retStrMin = sdFormatterMin.format(dateNow);
		int intNowMin = Integer.valueOf(retStrMin);
		System.out.println(intNowMin);*/
		
		Date pDate = change2Date("2019-03-12 14:00:00");
		long leftTime = (System.currentTimeMillis() - pDate.getTime()) / (1000 * 60);
		System.out.println(leftTime);
		leftTime = 3 * 60 - leftTime-1;
		System.out.println(leftTime);
		
		//获得系统的时间，单位为毫秒,转换为妙
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000 * 60;
        System.out.println("1： " + totalSeconds);
        
        //求出现在的秒
        long currentSecond = totalSeconds % 60;
         
        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
         
        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;
         
        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);
        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");
	}
	/**
	 * 将字符串转变为yyyy-MM-dd HH:mm:ss.SSS
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date change2Date(String dStr) throws ParseException {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dStr);
		} catch (ParseException e) {
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = df.parse(dStr);
		}
		return date;
	}
}