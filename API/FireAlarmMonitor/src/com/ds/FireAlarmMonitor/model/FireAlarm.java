package com.ds.FireAlarmMonitor.model;

public class FireAlarm {

	private int id;
	private	String roomNo;
	private String floorNo;
	private int smokeLevel;
	private int co2Level;
	private int status;
	
	public FireAlarm() {
		super();
	}
	
	public FireAlarm(int id, String roomNo, String floorNo, int smokeLevel, int co2Level, int status) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.floorNo = floorNo;
		this.smokeLevel = smokeLevel;
		this.co2Level = co2Level;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public int getSmokeLevel() {
		return smokeLevel;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
	}

	public int getCo2Level() {
		return co2Level;
	}

	public void setCo2Level(int co2Level) {
		this.co2Level = co2Level;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
