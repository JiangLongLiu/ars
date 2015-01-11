package com.liujl.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取当前时间(yyyyMMddHHmmss)
	 * liujianglong0829@qq.com
	 * Jan 10, 2015
	 * @return
	 */
	public static String getDateDayFormat2(){
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		return ft.format(new Date());
	}
	
	
	public static String selfFormat(int i){
		DateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");  
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");  
		DateFormat format3 = new SimpleDateFormat("yyyyMMdd");  
		DateFormat format4 = new SimpleDateFormat("yyyyMMddHHmmss");
		if(i==0){
			return format0.format(new Date());
		}
		else if(i==1){
			return format1.format(new Date());
		}
		else if(i==2){
			return format2.format(new Date());	
		}
		else if(i==3){
			return format3.format(new Date());
		}
		else{
			return format4.format(new Date());
		}
		
	}
	
	 /**
     * 将long类型时间戳转换为日期字符串
     * @author liujianglong
     * @param date 时间 
     * @return
     */
    public static String getDateTimeStringFormat(long date){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ft.format(new Date(date));
    }
    
    /**
	 * 日期转换成Long型
	 * @author liujianglong
	 * @param dateString
	 * @return
	 */
	 public static Long stringDate2Long(String dateString){
	        if(dateString == null) {
	            return null;
	        }
	        SimpleDateFormat simpleDateFormat =
	                new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return simpleDateFormat.parse(dateString).getTime();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
}
