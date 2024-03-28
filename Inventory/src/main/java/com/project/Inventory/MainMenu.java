package com.project.Inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Scanner sc = new Scanner(System.in);
			MainMethod m = new MainMethod();
			
			
			int choice;
			do
			{
				System.out.println("=================WELCOME=================");
				 System.out.println("1. Add Item");
		            System.out.println("2. Remove Item");
		            System.out.println("3. Update Quantity");
		            System.out.println("4. Display All Items");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();
		            

					switch(choice)
					{
					case 1:
						m.Add();
						break;
					case 2:
						m.Remove();
						break;
					case 3:
						m.Update();
					case 4:
						m.Display();
						break;
					case 5:
						System.out.println("Exiting...");
		            	break;
		            default :
		            	System.out.println("Invalid choice. Please enter a number between 1 and 5");
						
					}
			}
		
				while(choice != 5);
				{
					sc.close();
				}
			
		}
}
