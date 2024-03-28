package com.project.Inventory;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMethod {
	
	Connection getConnection() throws ClassNotFoundException, SQLException 
	{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","root");
		return con;
	
	}
	
	public void Add() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = getConnection().prepareStatement("insert into item value(?,?,?,?)");
		
		
		System.out.println("--------Enter The Item Details-------------");
		System.out.println("Enter the id: ");
		int id = sc.nextInt();
		System.out.println("Enter the name: ");
		String name = sc.next();
		System.out.println("Enter the quantity: ");
		int quantity = sc.nextInt();
		System.out.println("Enter the price: ");
		double price = sc.nextInt();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, quantity);
		ps.setDouble(4, price);
		
		ps.executeUpdate();
		
	}
	public void Remove() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = getConnection().prepareStatement("delete from item where name = ?");
		
//		System.out.println("--------Enter The Item Details-------------");
//		System.out.println("Enter the id: ");
//		int id = sc.nextInt();
		System.out.println("Enter the name: ");
		String name = sc.next();
//		System.out.println("Enter the quantity: ");
//		int quantity = sc.nextInt();
//		System.out.println("Enter the price: ");
//		double price = sc.nextInt();
		
//		ps.setInt(1, id);
		ps.setString(1, name);
//		ps.setInt(3, quantity);
//		ps.setDouble(4, price);
		
		ps.executeUpdate();
		
	}
	public void Update() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = getConnection().prepareStatement("update item set quantity = ? where name =? ");
		

		System.out.println("Enter the name: ");
		String name = sc.next();
		System.out.println("Enter the quantity: ");
		int quantity = sc.nextInt();

		ps.setInt(1, quantity);
		ps.setString(2, name);
		
		
		ps.executeUpdate();

	}
	
	public void Display() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = getConnection().prepareStatement("update into item value(?,?,?,?)");
		
		ResultSet rs = ps.executeQuery("select * from item");
		
		//process the result
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4));
		}
		
			
	}
	
}
