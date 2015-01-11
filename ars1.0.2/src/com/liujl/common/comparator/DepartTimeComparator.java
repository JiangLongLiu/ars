package com.liujl.common.comparator;

import java.util.Comparator;

import com.liujl.bean.Flight;

public class DepartTimeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Flight fl=(Flight)o1;
		Flight f2=(Flight)o2;
		int f1N=Integer.parseInt(fl.getArriveTime().substring(0, 2).trim());
		int f2N=Integer.parseInt(f2.getArriveTime().substring(0, 2).trim());
		if(f1N<f2N){
			return 1;
		}else if(f1N>f2N){
			return -1;
		}
		return 0;
	}
}
