package com.liujl.common.comparator;

import java.util.Comparator;

import com.liujl.bean.Flight;
import com.liujl.bean.SeatClass;

public class SeatClassComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		SeatClass sc1=(SeatClass)o1;
		SeatClass sc2=(SeatClass)o2;
		double sc1class=sc1.getSeatAmount();
		double sc2class=sc2.getSeatAmount();
		if(sc1class<sc2class){
			return 1;
		}else if(sc1class>sc2class){
			return -1;
		}
		return 0;
	}
}
