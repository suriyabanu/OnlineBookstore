package com.booksLandApp.models;

public class Admin {
String username;
String password;
String name;
String empId;
public Admin() {
	super();
	
}
public Admin(String username, String password, String name, String empId) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.empId = empId;
}
@Override
public String toString() {
	return "Admin [username=" + username + ", password=" + password + ", name=" + name + ", empId=" + empId + "]";
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
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}

}
