package com.example.evenimentemondene;

import java.io.Serializable;
import java.util.Calendar;


public class Event implements Serializable {

	private static final long serialVersionUID = -1020902066168297934L;
	
	private String title;
	private Calendar date;
	private String description, location;
	private String thumbImageUrl, imageUrl;
	private double latitude, longitude;
	private int id;
	
	public Event(String title,String description, String thumbImageUrl) {
		this.setTitle(title);
		this.setThumbImageUrl(thumbImageUrl);
		this.setDescription(description);
	}

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar calendar) {
		this.date = calendar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbImageUrl() {
		return thumbImageUrl;
	}

	public void setThumbImageUrl(String thumbImageUrl) {
		this.thumbImageUrl = thumbImageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double d) {
		this.latitude = d;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
