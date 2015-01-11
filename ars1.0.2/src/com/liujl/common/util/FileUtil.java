package com.liujl.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FileUtil {

	 /**
     * 向DAT文件中写内容
     *
     * @param fileDirectory 将要写的文件所在的目录
     * @param fileName 将要写入的文件名
     * @param titleArray 标题字符串数组
     * @param list 主数据字符串数组集合
     */
    public static void writeDATFile(String fileDirectory, String fileName, 
    								List<String[]> list,String encoding){
        BufferedWriter bf = null;
        try {
        	if(null==fileDirectory || null==fileName || null==list) {
        		throw new NullPointerException("参数有空或者参数格式不正确");
        	} else {
        		File directory = new File(fileDirectory);
  	            if(!directory.exists()) {
  	            	directory.mkdirs();
  	            }
        	}
            bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDirectory +File.separator+  fileName,true),encoding));
            for(int i=0; i<list.size(); i++) {
            	String[] string = list.get(i);
            	bf.write(StringUtils.join(string, ","));
            	bf.newLine();
            }
            
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if(bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
    	List<String[]> list = new ArrayList<String[]>();
    	String[] string1 = {"A100", "Xi’an", "Incheon", "2014-12-21","10:00","4","10","Economy","18000","A101XI20140302174312"};
    	String[] string2 = {"A101", "Incheon", "Incheon", "2014-12-22","10:00","4","10","Economy","18000","A102XI20140302174312"};
    	String[] string3 = {"A102", "Incheon", "Incheon", "2014-12-23","10:00","4","10","Economy","18000","A103XI20140302174312"};
    	String[] string4 = {"A103", "Xi’an", "Incheon", "2014-12-24","10:00","4","10","Economy","18000","A104XI20140302174312"};
    	String[] string5 = {"A104", "Xi’an", "Incheon", "2014-12-25","10:00","4","10","Economy","18000","A105XI"+DateUtil.getDateDayFormat2()};
    	list.add(string1);
    	list.add(string2);
    	list.add(string3);
    	list.add(string4);
    	list.add(string5);
    	URL u = FileUtil.class.getResource("/");
    	writeDATFile(u.getPath(), "reservation_history.dat",  list,"UTF-8");

	}
}
