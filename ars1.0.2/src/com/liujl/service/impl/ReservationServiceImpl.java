package com.liujl.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liujl.bean.Flight;
import com.liujl.bean.Reservation;
import com.liujl.bean.SeatClass;
import com.liujl.common.util.DateUtil;
import com.liujl.common.util.FileUtil;
import com.liujl.dao.FlightDao;
import com.liujl.dao.impl.FlightDaoImpl;
import com.liujl.dao.impl.ReservationDaoImpl;
import com.liujl.service.process.ProcessCommonPrint;

public class ReservationServiceImpl {
	private FlightDao fdi=new FlightDaoImpl();
	private DB db;
	private Reservation rvs;
	private List<Flight> resultList; 
	
	public final void doReser() throws Exception{
		//1.加载数据库
		db=DB.getInstance();
		//2.列举，接收输入首页菜单
		homePage();
	}
	
	
	//2.列举，接收输入首页菜单--后加q
	private final void homePage() throws Exception{
		ProcessCommonPrint.printHead("Welcome to Xi’an Airline");
		System.out.println("1. Reservation");
		System.out.println();
		System.out.println("2. Check Reservation");
		ProcessCommonPrint.printFoot(1);
		 
         String[] strArr=new String[2];
         String s= ProcessCommonPrint.getUserInput(strArr,1);
         
         if("1".equals(s)){
        	 departureAirport();
         }else if("2".equals(s)){
        	 doCheckReservation();
         }else if("q".equals(s)){
        	 quit_();
         }
         
	}
	
	//1.1 选择出发地
	public void departureAirport() throws Exception{
		ProcessCommonPrint.printHead("Departure Airport");
		//调用业务方法，得到本页面菜单
		Map<String, List<Flight>> map=fdi.groupByDepartPlace(db.getFlights());
		String[] strArr=ProcessCommonPrint.printMapBody(map);
		ProcessCommonPrint.printFoot(2);
		
		String s=ProcessCommonPrint.getUserInput(strArr, 2);
         
		for(int m=1;m<=strArr.length;m++){
			if((m+"").equals(s)){
				if(rvs==null){
					  rvs=new Reservation();  
				  }
				  rvs.setDepartPlace(strArr[Integer.parseInt(s)-1]);
		          resultList=map.get(strArr[Integer.parseInt(s)-1]);
		          arrivalAirport();
		          break;
			}
		}
         
		 if("q".equalsIgnoreCase(s)){
        	 quit_();
         }else if("p".equalsIgnoreCase(s)){
        	 prePage();
         }
	}
	
	//1.1.1 选择到达地
	public void arrivalAirport() throws Exception{
		
		ProcessCommonPrint.printHead("Arrival Airport");
		//调用业务方法，得到本页面菜单
		Map<String, List<Flight>> map=fdi.groupByArrivePlace(resultList);
		String[] strArr=ProcessCommonPrint.printMapBody(map);
		ProcessCommonPrint.printFoot(2);
		
		String s=ProcessCommonPrint.getUserInput(strArr, 2);
         
         for(int m=1;m<=strArr.length;m++){
 			if((m+"").equals(s)){
 				if(rvs==null){
 					  rvs=new Reservation();  
 				  }
 				  rvs.setArrivePlace(strArr[Integer.parseInt(s)-1]);
 		          resultList=map.get(strArr[Integer.parseInt(s)-1]);
 		         departDate();
 		          break;
 			}
 		}
         
        if("q".equalsIgnoreCase(s)){
       	 quit_();
        }else if("p".equalsIgnoreCase(s)){
       	 prePage();
        }
	}
	
	//1.1.2 选择出发日期
	public void departDate() throws Exception{
		
		ProcessCommonPrint.printHead("Depart Date");
		System.out.println("Please, Input depart date. (YYYY-MM-DD)");
		ProcessCommonPrint.printFoot(2);
		
		
		InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=null;
		while(true){
	      	  s=br.readLine();
	      	 String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	      	 Pattern pat = Pattern.compile(rexp);  
	         Matcher mat = pat.matcher(s);  
	         boolean flag = mat.matches();
	         if(flag){
	        	 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	        	 long leftLimit=DateUtil.stringDate2Long(sf.format(new Date()))+86400000L;//明天
	        	 long rightLimit=leftLimit+86400000L*364;//明天
	        	 long inputDate=DateUtil.stringDate2Long(s);
	        	 if(inputDate>leftLimit&&inputDate<rightLimit){
		        	 break;
	        	 }else{
	        		 System.out.println("(Message : ERROR!!! You can input date from "+sf.format(new Date(leftLimit))+" to "+sf.format(new Date(rightLimit))+")");
	        		 System.out.print("Input:");
	        	 }
	      	  }else{
	      		  System.out.println(" error massage. (Message : ERROR!!! You have to input date in right format.)");
	      		  System.out.print("Input:");
	      		  continue;
	      	  }
	          if("q".equalsIgnoreCase(s)||"p".equalsIgnoreCase(s)){
	          	  break;
	          }
		 }
		
		if(rvs==null){
			  rvs=new Reservation(); 
		  }
		rvs.setDepartDate(s);
		departTime();
		
	}
	
	//1.1.3 出发时间
	public void departTime() throws Exception{
		
		ProcessCommonPrint.printHead("Arrival Airport");
		//调用业务方法，得到本页面菜单
		Map<String, List<Flight>> map=fdi.groupByDepartTime(resultList);
		String[] strArr=ProcessCommonPrint.printMapBody(map);
		ProcessCommonPrint.printFoot(2);
		
		String s=ProcessCommonPrint.getUserInput(strArr, 2);

        for(int m=1;m<=strArr.length;m++){
 			if((m+"").equals(s)){
 				if(rvs==null){
 					  rvs=new Reservation();  
 				  }
 				  rvs.setDepartTime(strArr[Integer.parseInt(s)-1]);
 		          resultList=map.get(strArr[Integer.parseInt(s)-1]);
 		          customerTotal();
 		          break;
 			}
 		}
        
        if("q".equalsIgnoreCase(s)){
          	 quit_();
           }else if("p".equalsIgnoreCase(s)){
          	 prePage();
           }
		
	}
	
	
	//1.1.4 选择人员
	public void customerTotal() throws Exception{
		
		//成人人数
		int adultTotal=getCustomerTotal("Adult");
		//儿童人数
		int childTotal=getCustomerTotal("Child");
		
		if(adultTotal+childTotal==0){
			System.out.println("(Message : ERROR!!! You have toinput more than 0.");
			customerTotal();
		}else{
			rvs.setAdultTotal(adultTotal);
			rvs.setChildTotal(childTotal);
			seatClass();
		}
	}

	//1.1.4.1 乘客数量
	public int getCustomerTotal(String ctype) throws Exception{
		
		ProcessCommonPrint.printHead("Passenger");
		System.out.println("Please, Input the number of "+ctype);
		System.out.println();
		System.out.println("(0 ~ 10)");
		System.out.println();
		ProcessCommonPrint.printFoot(2);
		
		int total=0;
		
		InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=null;
		while(true){
	      	 s=br.readLine();

	         if("q".equalsIgnoreCase(s)||"p".equalsIgnoreCase(s))
	          	  break;
	         
	      	 String rexp = "^\\d|10$";
	      	 Pattern pat = Pattern.compile(rexp);  
	         Matcher mat = pat.matcher(s);  
	         boolean flag = mat.matches();
	         if(flag){
	        	 total= Integer.parseInt(s);
	        	 break;
	      	  }else{
	      		  System.out.println(" error massage. (Message : ERROR!!! You have to input date in right format.)");
	      		  System.out.print("Input:");
	      		  continue;
	      	  }
		 }
		return total;
	}
	
	//1.1.5 选择座位等级
	public void seatClass() throws Exception{
		
		ProcessCommonPrint.printHead("Seat Class");
		List<SeatClass> scs=fdi.groupBySeatClass(resultList);
		SeatClass sc=null;
		for(int i=0;i<scs.size();i++){
			sc=scs.get(i);
			System.out.println((i+1)+". "+sc.getSeatName()+" ("+sc.getSeatAmount()+" Yuan)");
			System.out.println();
		}
		ProcessCommonPrint.printFoot(2);
		
		String s=ProcessCommonPrint.getUserInput(new String[scs.size()], 2);
        
        boolean invokeFlag=false;
        for(int m=0;m<scs.size();m++){
 			if(((m+1)+"").equals(s)){
 				invokeFlag=true;
 				if(rvs==null){
 					  rvs=new Reservation();  
 				  }
 				  rvs.setSeatClass(scs.get(m).getSeatName());
 				  rvs.setTotalAmount((rvs.getAdultTotal()+rvs.getChildTotal())*scs.get(m).getSeatAmount());
 		          break;
 			}
 		}
        
        
        if("q".equalsIgnoreCase(s)){
          	 quit_();
           }else if("p".equalsIgnoreCase(s)){
          	 prePage();
           }

   		 rvs.setFlightName(resultList.get(0).getFlightName());
   		 rvs.setReservationNumber(genernateResNum());
   		 if(invokeFlag){
   			displayAccountInfo(); 
   		 }
	}
	
	
	
	public void displayAccountInfo() throws Exception{
		ProcessCommonPrint.printHead("Review");
		System.out.println("Please, Input any key.");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		if(str!=null){
			viewReservationInfo(rvs);
			save(rvs);//保存预定信息
		}
	}
	
	//1.2
	public void doCheckReservation() throws IOException{
		ProcessCommonPrint.printHead("Check Reservation");
		System.out.println("Pease, Input reservation number.");
		ProcessCommonPrint.printFoot(2);
		
		//接收输入
		InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=null;
		while(true){
	      	 s=br.readLine();
	         if(s!=null)
	          	 break;
		 }
		
		if("q".equalsIgnoreCase(s)){
         	 quit_();
        }else if("p".equalsIgnoreCase(s)){
         	 prePage();
        }
		Reservation rr=findByNumber(s);
		if(rr!=null){
			viewReservationInfo(rr);
		}else{
			System.out.println("(Message : ERROR!!! There is no such data.)");
		}
		
	}
	
	private final void quit_(){
		System.exit(0);
	}
	private final void prePage(){
		
	}
	
	private void viewReservationInfo(Reservation rvs){
		System.out.println();
		System.out.println();
		System.out.println("Flight: "+rvs.getFlightName());
		System.out.println("Departure Airport: "+rvs.getDepartPlace());
		System.out.println("Arrival Airport: "+rvs.getArrivePlace());
		System.out.println("Depart Date: "+rvs.getDepartDate());
		System.out.println("Depart Time: "+rvs.getDepartTime());
		System.out.println("Passenger: "+rvs.getAdultTotal()+" Adult, "+rvs.getChildTotal()+" Child");
		System.out.println("Seat Class: "+rvs.getSeatClass());
		System.out.println("Total Amount: "+rvs.getTotalAmount() );
		System.out.println("Reservation Number: "+rvs.getReservationNumber());
		System.out.println();
		System.out.println("****************************************");
		System.out.println();
		System.out.println();
		System.out.println("Thank you for reservation!");
	}
	
	
	private Reservation findByNumber(String s){
		List<Reservation> relist=DB.getReservations();
		Reservation rr=null;
		for(int i=0;i<relist.size();i++){
			rr=relist.get(i);
			if(rr.getReservationNumber().equals(s)){
				break;
			}
		}
		return rr;
	}
	
	private  void save(Reservation rvs) throws ClassNotFoundException{
		//保存到内存
		DB.getReservations().add(rvs);
		//保存到文件数据库
		List<String[]> listData=new ArrayList<String[]>();
		listData.add(objectToStringArr(rvs));
		FileUtil.writeDATFile(FileUtil.class.getResource("/").getPath(), "reservation_history.dat", 
				listData, "UTF-8");
	}
	
	
	

	public String[] objectToStringArr(Reservation rvs) throws ClassNotFoundException{
		  Class cls = Class.forName("com.liujl.bean.Reservation"); 
	      Field fieldlist[] = cls.getDeclaredFields(); 
	      String[] strArr=new String[fieldlist.length];
	      strArr[0]=rvs.getFlightName();
	      strArr[1]=rvs.getDepartPlace();
	      strArr[2]=rvs.getArrivePlace();
	      strArr[3]=rvs.getDepartDate();
	      strArr[4]=rvs.getDepartTime();
	      strArr[5]=rvs.getAdultTotal()+"";
	      strArr[6]=rvs.getChildTotal()+"";
	      strArr[7]=rvs.getSeatClass();
	      strArr[8]=rvs.getTotalAmount()+"";
	      strArr[9]=rvs.getReservationNumber();
	      return strArr;
	}
	
	
	
	/**
	 * 生成预约号码
	 * liujianglong0829@qq.com
	 * Jan 10, 2015
	 * @return
	 */
	private  String genernateResNum(){
		StringBuffer sb=new StringBuffer();
		sb.append(this.rvs.getFlightName());
		sb.append(this.rvs.getDepartPlace().subSequence(0, 1)); 
		sb.append(this.rvs.getArrivePlace().subSequence(0, 1));
		sb.append(DateUtil.getDateDayFormat2());
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		new ReservationServiceImpl().doReser();
	}
}
