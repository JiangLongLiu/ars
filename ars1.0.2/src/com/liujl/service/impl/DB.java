package com.liujl.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.liujl.bean.Flight;
import com.liujl.bean.Reservation;
import com.liujl.bean.SeatClass;

public class DB  {
	  private static DB instance;
	  private static List<Flight> flights=new ArrayList<Flight>();//航班
	  private static List<Reservation> reservations=new ArrayList<Reservation>();//预约信息 
	 
	  private DB(){}
	  public static DB getInstance(){
		  if(instance==null){
			  instance=new DB(); 
		  }
		  return instance;
	  }
	  
	  
	  {
		  	flights.clear();
		  	reservations.clear();
			try {
				  initFlights();
				  initReservations();
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	public  void initFlights() throws Exception {
		InputStream is=DB.class.getResourceAsStream("/plane.properties");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader ois = new BufferedReader(isr);
		
		SeatClass sc1=null;
		SeatClass sc2=null;
		SeatClass sc3=null;
		List<SeatClass> seatClassess=null;
		while (true) {
			String s = ois.readLine();
			if (s == null||"".equals(s)) {
				break;
			}
			
			String[] ss = s.split(",");
			if (ss.length != 8) {
				continue;
			}
				String flightName=ss[0];
				String departPlace=ss[1];
				String arrivePlace=ss[2];
				String departTime=ss[3];
				String arriveTime=ss[4];
				double firstClassAmount=Double.parseDouble(ss[5]);
				double businessClassAmount=Double.parseDouble(ss[6]);
				double economyClassAmount=Double.parseDouble(ss[7]);
				sc1=new SeatClass("First Class",firstClassAmount);
				sc2=new SeatClass("Business Class",businessClassAmount);
				sc3=new SeatClass("Economy Class",economyClassAmount);
				seatClassess=new ArrayList<SeatClass>();
				seatClassess.add(sc1);
				seatClassess.add(sc2);
				seatClassess.add(sc3);
				Flight ft = new Flight(flightName, departPlace, arrivePlace, departTime, arriveTime, seatClassess);
				flights.add(ft);
		}
//		System.out.println("航班数量: "+flights.size());
//		for (Flight ff : flights) {
//			System.out.println(ff);
//		}
	}

	/**
	 * 根据reservation_history.dat,初始化已经预约信息
	 * liujianglong0829@qq.com
	 * Jan 10, 2015
	 * TODO
	 * @throws Exception
	 */
	public  void initReservations() throws Exception {
		File file=new File(DB.class.getResource("/").getPath()+"reservation_history.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		
		InputStream is=DB.class.getResourceAsStream("/reservation_history.dat");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader ois = new BufferedReader(isr);
		
		while (true) {
			String s = ois.readLine();
			if (s == null||"".equals(s)) {
				break;
			}
			
			String[] ss = s.split(",");
			if (ss.length != 10) {
				continue;
			}
				String flightName=ss[0];
				String departPlace=ss[1];
				String arrivePlace=ss[2];
				String departDate=ss[3];
				String departTime=ss[4];
				int adultTotal=Integer.parseInt(ss[5]);
				int childTotal=Integer.parseInt(ss[6]);
				String seatClass=ss[7];
				double totalAmount=Double.parseDouble(ss[8]);
				String reservationNumber=ss[9];
				Reservation rsv=new Reservation(flightName, departPlace, arrivePlace, departDate, departTime, adultTotal, childTotal, seatClass, totalAmount, reservationNumber);
				reservations.add(rsv);
		}
//		System.out.println("预约数量: "+reservations.size());
//		for (Reservation rr : reservations) {
//			System.out.println(rr);
//		}
	}
	
	
	public static List<Flight> getFlights() {
		return flights;
	}
	public static List<Reservation> getReservations() {
		return reservations;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
//		Map <String,List<Flight>> map=new FlightDaoImpl().groupByDepartPlace( flights);
//		for (String key : map.keySet()) {
//			   System.out.println("key= "+ key + " and value= " + map.get(key));
//			  }
		new DB();
		
	}
	




	
	
	

	
	
}
