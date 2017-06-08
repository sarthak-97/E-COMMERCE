package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminDet {
	
@Id
private int AdminEmailId;
private String AdminName;
private String password;
public int getAdminEmailId() {
	return AdminEmailId;
}
public void setAdminEmailId(int adminEmailId) {
	AdminEmailId = adminEmailId;
}
public String getAdminName() {
	return AdminName;
}
public void setAdminName(String adminName) {
	AdminName = adminName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
