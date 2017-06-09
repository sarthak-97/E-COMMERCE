package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class SellerDet {

	@Id
private String SellerEmailId;
private String SellerName;
@Lob
private String SellerAddress;
private int SellerPincode;
@Lob
private String SellerDetails;
private String password;
public String getSellerEmailId() {
	return SellerEmailId;
}
public void setSellerEmailId(String sellerEmailId) {
	SellerEmailId = sellerEmailId;
}
public String getSellerName() {
	return SellerName;
}
public void setSellerName(String sellerName) {
	SellerName = sellerName;
}
public String getSellerAddress() {
	return SellerAddress;
}
public void setSellerAddress(String sellerAddress) {
	SellerAddress = sellerAddress;
}
public int getSellerPincode() {
	return SellerPincode;
}
public void setSellerPincode(int sellerPincode) {
	SellerPincode = sellerPincode;
}
public String getSellerDetails() {
	return SellerDetails;
}
public void setSellerDetails(String sellerDetails) {
	SellerDetails = sellerDetails;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

	
}
