package com.liujl.bean;

public class SeatClass {
	/**航班名称*/
	private String seatName;
	/**航班费用*/
	private double seatAmount;
	
	
	public SeatClass() {
		super();
	}
	public SeatClass(String seatName, double seatAmount) {
		super();
		this.seatName = seatName;
		this.seatAmount = seatAmount;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public double getSeatAmount() {
		return seatAmount;
	}
	public void setSeatAmount(double seatAmount) {
		this.seatAmount = seatAmount;
	}
	@Override
	public String toString() {
		return "SeatClass [seatName=" + seatName + ", seatAmount=" + seatAmount
				+ "]";
	}
}
