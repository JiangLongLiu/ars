package com.liujl.bean;

/**
 * 预定中的航班
 * @author liujianglong0829@qq.com
 */
public class Reservation{
	/**航班名*/
	private String flightName;
	
	/**出发地 */
	private String departPlace;
	
	/**到达地 */
	private String arrivePlace;
	
	/**出发日期 */
	private String departDate;
	
	/**出发时间*/
	private String departTime;
	
	/**成人数量*/
	private int adultTotal;
	
	/**儿童数量*/
	private int childTotal;
	
	/**座位等级 */
	private String seatClass;
	
	/**合计金额*/
	private double totalAmount;
	
	/**预约号码*/
	private String reservationNumber;
	
	
	
	public Reservation() {
		super();
	}

	public Reservation(String flightName, String departPlace,
			String arrivePlace, String departDate, String departTime,
			int adultTotal, int childTotal, String seatClass,
			double totalAmount, String reservationNumber) {
		super();
		this.flightName = flightName;
		this.departPlace = departPlace;
		this.arrivePlace = arrivePlace;
		this.departDate = departDate;
		this.departTime = departTime;
		this.adultTotal = adultTotal;
		this.childTotal = childTotal;
		this.seatClass = seatClass;
		this.totalAmount = totalAmount;
		this.reservationNumber = reservationNumber;
	}


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



	public String getDepartDate() {
		return departDate;
	}



	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}



	public String getDepartTime() {
		return departTime;
	}



	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}



	public int getAdultTotal() {
		return adultTotal;
	}



	public void setAdultTotal(int adultTotal) {
		this.adultTotal = adultTotal;
	}



	public int getChildTotal() {
		return childTotal;
	}



	public void setChildTotal(int childTotal) {
		this.childTotal = childTotal;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getReservationNumber() {
		return reservationNumber;
	}



	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	



	public String getSeatClass() {
		return seatClass;
	}



	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	@Override
	public String toString() {
		return "Reservation [flightName=" + flightName + ", departPlace="
				+ departPlace + ", arrivePlace=" + arrivePlace
				+ ", departDate=" + departDate + ", departTime=" + departTime
				+ ", adultTotal=" + adultTotal + ", childTotal=" + childTotal
				+ ", seatClass=" + seatClass + ", totalAmount=" + totalAmount
				+ ", reservationNumber=" + reservationNumber + "]";
	}
	
}
