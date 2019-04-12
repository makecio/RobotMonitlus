package br.com.RobotMonitlus.entity;

import java.io.Serializable;

public class Mensagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String device_id;
	private Long time;
	private double snr;
	private String station;
	private int data;
	private String rssi;
	private String lat;
	private String lng;
	private Long datesend;
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public double getSnr() {
		return snr;
	}
	public void setSnr(double snr) {
		this.snr = snr;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getRssi() {
		return rssi;
	}
	public void setRssi(String rssi) {
		this.rssi = rssi;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Long getDatesend() {
		return datesend;
	}
	public void setDatesend(Long datesend) {
		this.datesend = datesend;
	}
	
	
	

}
