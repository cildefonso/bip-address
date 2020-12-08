package com.bip.api.dtos;

import org.bson.types.ObjectId;

public class AddressDto {

	
	private ObjectId _id;
	private String street;
	private String zip;
	private String district;
	private String city;
	private String state;
	private String country;
	private String createdAt;
	
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
		return "AddressDto [_id=" + _id + ", street=" + street + ", zip=" + zip + ", district=" + district + ", city="
				+ city + ", state=" + state + ", country=" + country + ", createdAt=" + createdAt + "]";
	}
	
		
}
