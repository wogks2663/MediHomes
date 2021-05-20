package com.medihomes.domain;

// 기구 병원정보
public class Instruments {
	private int no;
	private String area;
	private String name;
	private String instruments;
	private String lat;
	private String log;
	private String img;
	
	public Instruments() {}
	public Instruments(int no, String area, String name, String instruments, String lat, String log, String img) {
		
		this.no = no;
		this.area = area;
		this.name = name;
		this.instruments = instruments;
		this.lat = lat;
		this.log = log;
		this.img = img;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstruments() {
		return instruments;
	}
	public void setInstruments(String instruments) {
		this.instruments = instruments;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}



