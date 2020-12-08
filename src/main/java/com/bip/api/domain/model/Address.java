package com.bip.api.domain.model;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
	

@Document(collection = "addresses")
public class Address implements Serializable {
	
	
	private static final long serialVersionUID = -798159258306205274L;

	@org.springframework.data.annotation.Id
	private ObjectId _id;
	private String street;
	private String zip;
	private String district;
	private String city;
	private String state;
	private String country;
	private String createdAt;
	
	 //this.age = getDiffYears(dateOfBirth, new Date());
	 private int getDiffYears(Date first, Date last) {
	       Calendar a = getCalendar(first);
	       Calendar b = getCalendar(last);
	       int diff = b.get(YEAR) - a.get(YEAR);
	       if (a.get(MONTH) > b.get(MONTH) ||
	               (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
	           diff--;
	       }
	       return diff;
	   }
	   private Calendar getCalendar(Date date) {
	       Calendar cal = Calendar.getInstance(Locale.US);
	       cal.setTime(date);
	       return cal;
	   }
	   
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Address [_id=" + _id + ", street=" + street + ", zip=" + zip + ", district=" + district + ", city="
				+ city + ", state=" + state + ", country=" + country + ", createdAt=" + createdAt + "]";
	}
	   
	
	

					 	
}
