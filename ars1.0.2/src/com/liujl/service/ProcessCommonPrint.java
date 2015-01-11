package com.liujl.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liujl.bean.Flight;

public class ProcessCommonPrint {
	public static final String SP="****************************************"; 

	public static void printHead(String title){
		System.out.println();
		System.out.println(SP);
		System.out.println();
		System.out.println(title);
		System.out.println();
		System.out.println(SP);
		System.out.println();
	}
	
	public static void printFoot(boolean isDisplay,int n){
		System.out.println();
		if(n==2&&isDisplay){
			
			System.out.println();
			System.out.println("P. Previous Menu");
		}
		System.out.println("Q. Quit");
		System.out.println();
		System.out.println("Pease, Input reservation number.");
		System.out.println(SP);
		System.out.print("Input:");
	}
	
	public static String getUserInput(String[] strArr,int i) throws IOException{
		 String s=null;
		 boolean flag=false;
		 InputStreamReader isr=new InputStreamReader(System.in);
         BufferedReader br=new BufferedReader(isr);
  outer:while(true){
	      	  s=br.readLine();
	      	  for(int m=1;m<=strArr.length;m++){
	      		  if((m+"").equals(s)){
	      			flag=true;
	      			break outer;  
	      		  }
	      	  }
	      	  
	      	  String[] qp=null;
	      	  if(i==1){
	      		 qp=new String[]{"q"}; 
	      	  }else{
	      		qp=new String[]{"q","p"}; 
	      	  }
	         for(int j=0;j<qp.length;j++){
	        	 if(qp[j].equalsIgnoreCase(s)){
	        		 flag=true;
	        		 break outer;
	        	 }
	         }
	      	  
	      		if(!flag){
	      			 System.out.println("error message. (Message : ERROR!!! Wrong Input. Select Again)");
		        	 System.out.print("Input:");
	      		}
	         	
		 }
		return s;
	}
	
	
	public static String[] printMapBody(Map map){
		String[] strArr=null;
		Set<String> keys = map.keySet();
		strArr=new String[keys.size()];
		int i=0;
		for(String key:keys){
			System.out.println((i+1)+". " +key);
			System.out.println();
			strArr[i]=key;
			i++;
		}
		return strArr;
	}
}
