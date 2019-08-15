/*
 * Author: Zain Raza
 *
 * Client.java
 * Represents a kiosk used by a client
 * at a car service provider.
 *
 * Date created: Tuesday, August 13, 2019
 */
 
 import java.util.Scanner;
 import java.util.ArrayList;
 
 public class Client
 {
 	/*--------------------------------------------------------------------
 	 * getVehicle: 
 	 * pre: ArrayList of Vehicle objects, idNum represents a vehicleNumber 
 	 * post: Vehicle output has matching vehicleNumber to idNum
 	 --------------------------------------------------------------------*/
 	public static Vehicle getVehicle(ArrayList<Vehicle> list, int idNum)
 	{
 		Vehicle output;
 		for(Vehicle v: list)
 		{
 			if(v.getVehicleNo() == idNum)
 			{
 				output = v;
 				return output;
 			}
 		}
 		
 		return null;
 	}
 	
 	/*------------------------------------
 	 * main method:
 	 * UI for car service customers 
 	 * to enter their vehicle info and
 	 * order services for the vehicle
 	 ------------------------------------*/
 	public static void main(String[] args)
 	{
 		int choice = 6; // user choooses operation
 		Scanner scan = new Scanner(System.in);
 		ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
 		
 		/*
 		 * 0: quit
 		 * 1: add vehicle
 		 * 2: order a service
 		 * 3: edit vehicle or order info
 		 * 4: delete a vehicle or order
 		 * 5: view order history (gives option to see all vehicles or just one)
 		 */
 		do
 		{
 			System.out.print("What would you like to do? Enter the corresponding number: ");
 			choice = scan.nextInt();
 			System.out.println("");
 			int option = 0; // stores vehicleNumber user is looking for
 			
 			switch(choice)
 			{
 				case 0:
 				System.out.println("Thank you for using the Car Service Manager!");
 				
 				break;
 				
 				case 2:
 				/* Check to make sure there are vehicles in the system */
 				if(cars.size() == 0)
 				{
 					System.out.println("Sorry, you cannot order a service until you enter in a vehicle.");
 					System.out.println("");
 					break;
 				}
 				else
 				{
 					System.out.print("Enter the ID number of the vehicle you are servicing: ");
 					option = scan.nextInt();
 					System.out.println("");
 					
 					// Check to ensure ID number is valid
 					if(getVehicle(cars, option) == null)
 					{
 						System.out.println("Sorry, that is not a valid ID number.");
 					}
 					else
 					{
 						// prompt user to choose service
 						System.out.print("Which service would you like to order? \n\n" +
 											"1: Car wash \n" +
 											"2: Ceramic coating \n\n" +
 											"Enter the number of the service you would like: ");
 						option = scan.nextInt();
 						System.out.println("");
 						switch(option)
 						{
 							case 1: 
 							System.out.print("You are about to buy a one-time wash for $2.99. \n" +
 												"Would you like to pay for a subscription? \n\n" +
 												"0: No subscription \n" +
 												"1: Seasonal: 3 months for one charge of $8.99 \n" +
 												"2: Bi-annual: 6 months for one charge of $11.99 \n" +
 												"3: Yearly: 12 months for -one charge of $24.99 \n\n" +
 												"Enter the number of your choice: ");	
 							getVehicle(cars, option).initWash(scan.nextInt());	
 							System.out.println("");
 							break;
 							
 							case 2:
 							
 							break;
 							
 							default:
 							System.out.println("Sorry, we do not currently offer that option.");
 						}
 						
 					}
 						
 				}
 				
 				// break;
 				
 				default:
 				System.out.println("Sorry, that is not a valid option. Please try again.");
 			}
 		} while(choice != 0);
 	}
 }