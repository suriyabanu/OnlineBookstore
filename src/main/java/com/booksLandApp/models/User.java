package com.booksLandApp.models;

public class User {
String username;
String password;
String name;
String address;
String landmark;
Long mobile;
String email;
public User() {
	super();
	
}
public User(String username, String password, String name, String address, String landmark, Long mobile, String email) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.address = address;
	this.landmark = landmark;
	this.mobile = mobile;
	this.email = email;
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", name=" + name + ", address=" + address
			+ ", landmark=" + landmark + ", mobile=" + mobile + ", email=" + email + "]";
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
