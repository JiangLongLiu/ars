package com.liujl.common.comparator;

import java.util.Comparator;

import com.liujl.bean.Flight;

public class ArrivePlaceComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Flight fl=(Flight)o1;
		Flight f2=(Flight)o2;
		int f1Len=fl.getArrivePlace().length();
		int f2Len=f2.getArrivePlace().length();
		if(f1Len<f2Len){
			return 1;
		}else if(f1Len>f2Len){
			return -1;
		}
		return 0;
	}
}
