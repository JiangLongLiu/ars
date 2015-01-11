package com.liujl.bean;

import java.util.List;

/**
 * 航班
 * @author liujianglong0829@qq.com
 */
public class Flight {
	/**航班名*/
	private String flightName;
	
	/**出发地 */
	private String departPlace;
	
	/**到达地 */
	private String arrivePlace;
	
	/**出发时间*/
	private String departTime;
	
	/**到达时间*/
	private String arriveTime;
	
	/**座位类型*/
	private List<SeatClass> seatClassess;

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public List<SeatClass> getSeatClassess() {
		return seatClassess;
	}

	public void setSeatClassess(List<SeatClass> seatClassess) {
		this.seatClassess = seatClassess;
	}

	public Flight(String flightName, String departPlace, String arrivePlace,
			String departTime, String arriveTime, List<SeatClass> seatClassess) {
		super();
		this.flightName = flightName;
		this.departPlace = departPlace;
		this.arrivePlace = arrivePlace;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.seatClassess = seatClassess;
	}

	public Flight() {
		super();
	}

	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", departPlace="
				+ departPlace + ", arrivePlace=" + arrivePlace
				+ ", departTime=" + departTime + ", arriveTime=" + arriveTime
				+ ", seatClassess=" + seatClassess + "]";
	}

}
