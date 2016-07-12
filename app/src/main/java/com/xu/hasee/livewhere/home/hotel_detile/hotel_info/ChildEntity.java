package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

public class ChildEntity {

	private String name;
	private String address;
	private String distance;

	private String picture;
    private String telphone;
	public ChildEntity() {
	}

	public ChildEntity(String name, String address, String distance, String picture, String telphone) {
		this.name = name;
		this.address = address;
		this.distance = distance;
		this.picture = picture;
		this.telphone = telphone;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
