package dataprocessing;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CompanyShares {
	private String symbol;
	private static int noOfShares = 200;
	private int date;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
	String dateFormat;
	String timeFormat;
	private int totalValue = 20000;

	public int getTotalValue() {
		return totalValue;
	}

	int buyTotalValue(int amount) {
		int output = 0;
		if ((this.totalValue - amount) < 0) {

		} else {
			this.totalValue = this.totalValue - amount;
			output = 1;
		}
		return output;
	}

	void sellTotalValue(int amount) {
		this.totalValue = this.totalValue + amount;
	}

	int getTotalShares() {
		return noOfShares;
	}

	LocalDateTime localDateTime = LocalDateTime.now();

	void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	String getSymbol() {
		return symbol;
	}

	void buyShare(int noOfShares) {
		this.noOfShares = this.noOfShares + noOfShares;
	}

	int sellShare(int noOfShares) {
		int output = 0;
		if ((this.noOfShares - noOfShares) < 0) {

		} else {
			this.noOfShares = this.noOfShares - noOfShares;
			output = 1;
		}
		return output;
	}

	void setDate(LocalDateTime localDateTime) {
		date = localDateTime.getDayOfMonth();
		month = localDateTime.getMonthValue();
		year = localDateTime.getYear();
		dateFormat = Integer.toString(date) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
	}

	String getDate() {
		return dateFormat;
	}

	void setTime(LocalDateTime localDateTime) {
		hour = localDateTime.getHour();
		minute = localDateTime.getMinute();
		second = localDateTime.getSecond();
		timeFormat = Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second);
	}

	String getTime() {
		return timeFormat;
	}
}