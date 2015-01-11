package com.liujl.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.liujl.bean.Flight;
import com.liujl.bean.SeatClass;
import com.liujl.common.comparator.ArrivePlaceComparator;
import com.liujl.common.comparator.DepartPlaceComparator;
import com.liujl.common.comparator.DepartTimeComparator;
import com.liujl.common.comparator.SeatClassComparator;
import com.liujl.dao.FlightDao;

public class FlightDaoImpl implements FlightDao {
	
	/**
	 * 根据出发地分组--满足“出发地只能选择在Properties中的数据 ”
	 */
	@Override
	public Map<String, List<Flight>> groupByDepartPlace(
			 List<Flight> list) throws Exception {
		Map<String, List<Flight>> groupFlights=new TreeMap<String,List<Flight>>(
			new Comparator<String>(){  
            public int compare(String o1, String o2) {  
                return o2.compareTo(o1);  
            }     
        });//分组后返回<组名,数据>
		
		List<Flight> fls=new ArrayList<Flight>();
		
		Collections.sort(list,new DepartPlaceComparator());
		if(list.size()>0){
			String  departPlace=list.get(0).getDepartPlace();//临时存放
			Flight fl=null;
			for(int i=0;i<list.size();i++){
				fl=list.get(i);
				if(departPlace.equals(fl.getDepartPlace())){
					fls.add(fl);
					if(i==list.size()-1)
					groupFlights.put(departPlace, fls);
				}else{
					groupFlights.put(departPlace, fls);//保存上一组
					fls=new ArrayList<Flight>();//新建下一组
					departPlace=fl.getDepartPlace();
					fls.add(fl);
				}
			}
			groupFlights.put(departPlace, fls);//把最后一组加进去
		}
		return groupFlights;
	}
	

	@Override
	public Map<String, List<Flight>> groupByArrivePlace(
			List<Flight> list) throws Exception {
		
		Map<String, List<Flight>> groupFlights=new TreeMap<String,List<Flight>>(
				new Comparator<String>(){  
	            public int compare(String o1, String o2) {  
	                return o2.compareTo(o1);  
	            }     
	        });//分组后返回<组名,数据>
			
			List<Flight> fls=new ArrayList<Flight>();
			
			Collections.sort(list,new ArrivePlaceComparator());
			if(list.size()>0){
				String  arrivePlace=list.get(0).getArrivePlace();//临时存放
				Flight fl=null;
				for(int i=0;i<list.size();i++){
					fl=list.get(i);
					if(arrivePlace.equals(fl.getArrivePlace())){
						fls.add(fl);
						if(i==list.size()-1)
						groupFlights.put(arrivePlace, fls);
					}else{
						groupFlights.put(arrivePlace, fls);//保存上一组
						fls=new ArrayList<Flight>();//新建下一组
						arrivePlace=fl.getArrivePlace();
						fls.add(fl);
					}
				}
				groupFlights.put(arrivePlace, fls);//把最后一组加进去
			}
			return groupFlights;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Flight>> groupByDepartTime(
			List<Flight> list) throws Exception {
		Map<String, List<Flight>> groupFlights=new TreeMap<String,List<Flight>>(
				new Comparator<String>(){  
	            public int compare(String o1, String o2) {  
	                return o2.compareTo(o1);  
	            }     
	        });//分组后返回<组名,数据>
			
			List<Flight> fls=new ArrayList<Flight>();
			
			Collections.sort(list,new DepartTimeComparator());
			if(list.size()>0){
				String  departTime=list.get(0).getDepartTime();//临时存放
				Flight fl=null;
				for(int i=0;i<list.size();i++){
					fl=list.get(i);
					if(departTime.equals(fl.getDepartTime())){
						fls.add(fl);
						if(i==list.size()-1)
						groupFlights.put(departTime, fls);
					}else{
						groupFlights.put(departTime, fls);//保存上一组
						departTime=fl.getDepartTime();
						fls=new ArrayList<Flight>();//新建下一组
						fls.add(fl);
					}
				}
				groupFlights.put(departTime, fls);//把最后一组加进去
			}
			return groupFlights;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SeatClass> groupBySeatClass(List<Flight> list) throws Exception {
			List<SeatClass> seatList=list.get(0).getSeatClassess();//从之前的航班中选择航班类型
			Collections.sort(seatList,new SeatClassComparator());
			return seatList;
	}

	
}
