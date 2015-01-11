package com.liujl.dao;

import java.util.List;
import java.util.Map;

import com.liujl.bean.Reservation;

public interface ReservationDao {
		//根据出发日期分组
		public Map<String,List<Map<String,Reservation>>> groupByDepartDate(String departDate,List<Reservation> list) throws Exception;
		
}
