package com.booksLandApp;

import java.sql.ResultSet;
import java.util.Scanner;

import com.booksLandApp.dao.AdminOperations;
import com.booksLandApp.dao.UserOperation;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminOperations aob = new AdminOperations();
		UserOperation up = new UserOperation();
		boolean status = true;
		try {
			do {
				System.out.println("*******************************");
				System.out.println("          OnlineBookstore          ");
				System.out.println("*******************************");
				System.out.println("1-> ADMIN");
				System.out.println("2-> CUSTOMER");
				int op = sc.nextInt();
				if (op == 1) {
					System.out.println("Please Enter UserName");
					String username = sc.next();
					System.out.println("Please Enter password");
					String Password = sc.next();

					if (aob.login(username, Password)) {
						System.out.println("=======================================================================");
						System.out.println("                       Logged in successfully!!             ");
						System.out.println("=======================================================================");
						System.out.println("1.Show Books\r\n" + "2.Add Books\r\n" + "3.Remove Books\r\n"
								+ "4.Log Out\r\n");
						int op1 = sc.nextInt();
						if (op1 == 1) {
							aob.showBooks();
						} else if (op1 == 2) {
							System.out.println("Enter Book code:");
							String bc = sc.next();
							System.out.println("Enter BookName:");
							String bname = sc.next();
							System.out.println("Enter Book AuthorName:");
							String authorname = sc.next();
							System.out.println("Enter pages of book ");
							int pg = sc.nextInt();
							System.out.println("Enter Price of Book:");
							double price = sc.nextDouble();
							System.out.println("Enter stock of book:");
							int qty = sc.nextInt();
							if (aob.AddBook(bc, bname, authorname, pg, price, qty)) {
								System.out.println("item added successfully");
							} else {
								System.out.println("Something went wrong");
							}

						} else if (op1 == 3) {
							System.out.println("Please Enter the Book Code to Remove the Book");
							String bc = sc.next();
							if (aob.removeBooks(bc)) {
								System.out.println("Item Removed Successfully");
							} else {
								System.out.println("Please Enter The Correct Book ID");
							}
						}  else if (op1 == 4) {
							if (aob.logout()) {
								status = false;
								System.out.println("Logged Out");
							}

						}

					} else {
						System.out.println("Username or Password is incorrect");
					}

				} else if (op == 2) {
					System.out.println("1->sign up (New customer)");
					System.out.println("2->sign in (If already a customer)");
					int op2 = sc.nextInt();
					if (op2 == 1) {
						System.out.println("Please Enter the User Name");
						String us = sc.next();
						System.out.println("Please Enter the Password");
						String pass = sc.next();
						System.out.println("Please Enter the Name");
						String name = sc.next();
						System.out.println("Please Enter the address");
						String add = sc.next();
						System.out.println("Please Enter the LandMark");
						String lm = sc.next();
						System.out.println("Please Enter the Mobile Number");
						long num = sc.nextLong();
						System.out.println("Please Enter the E-Mail");
						String em = sc.next();
						if (up.signUp(us, pass, name, add, lm, num, em)) {
							System.out.println("Sign up successfully");
						} else {
							System.out.println("Problem in Sign Up");
						}
					} else if (op2 == 2) {
						System.out.println("Please Enter UserName");
						String username = sc.next();
						System.out.println("Please Enter password");
						String Password = sc.next();
						if (up.login(username, Password)) {
							System.out
									.println("=======================================================================");
							System.out.println("                       Login successfull!!                   ");
							System.out
									.println("=======================================================================");
							up.showBooks();
							System.out.println("1.Buy Book\r\n"+"2.Order Status\r\n"+"3.Update Profile"+"4.LogOut");
							int op3 = sc.nextInt();
							if (op3 == 1) {

								System.out.println("Please Enter The BookCode");
								String bc = sc.next();
								System.out.println("Please Enter the Bookname");
								String bn = sc.next();
								System.out.println("Please Enter the Quantity");
								int qty = sc.nextInt();
								System.out.println("Please Enter the Delivery Address");
								String address = sc.next();
								if (up.buyNow(bc, bn, qty, address)) {
									System.out.println("Order Successfully Placed");
								} else {
									System.out.println("Problem in Placing Order");
								}
							} 
							
								 else if (op3 == 2) {
									

								
							} else if (op3 == 3) {
								System.out.println("Please Enter the User Name");
								String us = sc.next();
								System.out.println("Please Enter the Password");
								String pass = sc.next();
								System.out.println("Please Enter the Name");
								String name = sc.next();
								System.out.println("Please Enter the address");
								String add = sc.next();
								System.out.println("Please Enter the LandMark");
								String lm = sc.next();
								System.out.println("Please Enter the Mobile Number");
								long num = sc.nextLong();
								System.out.println("Please Enter the E-Mail");
								String em = sc.next();
								if (up.profileSetting(us, pass, name, add, lm, num, em)) {
									System.out.println("Updated successfully");
								} else {
									System.out.println("Problem in Updating Profile");
								}

							} 
							else if (op3==4) {
								if (up.logout()) {
									status = false;
									System.out.println("Logged Out");
								}
							}
						} else {
							System.out.println("Problem in Login");
						}
					}
				}
				}
			 while (status);
		} catch (Exception e) {
			System.out.println("Wrong data!!");
		}

	}
}
