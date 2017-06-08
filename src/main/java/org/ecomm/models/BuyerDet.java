package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class BuyerDet {
	
@Id	
private String EmailId;
private String Name;
@Lob
private String Address;
private String City;
private String State;
private String Country;
private int ContactNo;
private int Age;
private String ImgUrl;
private String password;
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public int getContactNo() {
	return ContactNo;
}
public void setContactNo(int contactNo) {
	ContactNo = contactNo;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getImgUrl() {
	return ImgUrl;
}
public void setImgUrl(String imgUrl) {
	ImgUrl = imgUrl;
}
}
