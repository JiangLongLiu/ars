package com.liujl.dao;

import java.util.List;
import java.util.Map;

import com.liujl.bean.Flight;
import com.liujl.bean.SeatClass;

public interface FlightDao {
	//根据出发地分组--满足“出发地只能选择在Properties中的数据 ”
	public Map<String, List<Flight>>  groupByDepartPlace(List<Flight> list) throws Exception;
	
	//根据到达地分组--满足“选择在 A 里作为出发地被选择的地点时,是违法的”
	public Map<String, List<Flight>>  groupByArrivePlace(List<Flight> list) throws Exception;
	
	//根据出发时间分组
	public Map<String, List<Flight>>  groupByDepartTime(List<Flight> list) throws Exception;
	
	//根据座位等级分组
	public List<SeatClass>  groupBySeatClass(List<Flight> list) throws Exception;
}
