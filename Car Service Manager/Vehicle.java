/*
 * Author: Zain Raza
 *
 * Vehicle.java
 * Represents the vehicle which has
 * been serviced at a given car service provider.
 *
 * Date created: Monday, August 12, 2019
 */ 
 
 import java.util.ArrayList;
 import java.text.NumberFormat;
 
 public class Vehicle
 {
 	private String carType;
 	private String deliveryDay;
 	private String qualityOfService;
 	private int vehicleNumber;
 	public static int numOfCars;
 
 	/* each vehicle has its own purchase history of car services */
 	private ArrayList<Service> services;
 	
 	//-------------------------------------------
 	/* Constructor 1: entering in a new car */
 	//-------------------------------------------
 	public Vehicle(int c, int d, int q)
 	{
 		services = new ArrayList<Service>();
 		carType = setCar(c);
 		deliveryDay = setDelivery(d);
 		qualityOfService = setQuality(q);
 		numOfCars++;
 		vehicleNumber = numOfCars;
 	}
 	
   /*--------------------------------------------
 	* Constructor 2: revising car information 
 	--------------------------------------------*/
 	public Vehicle(int c, int d, int q, int v)
 	{
 		services = new ArrayList<Service>();
 		carType = setCar(c);
 		deliveryDay = setDelivery(d);
 		qualityOfService = setQuality(q);
 		vehicleNumber = v;
 	}
 	
 	
 	/*---------------------------------------
 	 * setCar
 	 * pre: int car
 	 * post: String type stores to
 	 * "Car", "Bus", "Truck", "Other"
 	 ---------------------------------------*/
 	 public String setCar(int car)
 	 {
 	 	String type = "";
 	 	
 	 	switch(car)
 	 	{
 	 		case 1:
 	 		type = "Car";
 	 		
 	 		break;
 	 		
 	 		case 2:
 	 		type = "Truck";
 	 		
 	 		break;
 	 		
 	 		case 3: 
 	 		type = "Bus";
 	 		
 	 		break;
 	 		
 	 		case 4:
 	 		type = "Other";
 	 		
 	 		break;
 	 		
 	 		default:
 	 		type = "This car has no type.";
 	 	}
 	 	
 	 	return type;	
 	  }
 	  
 	/*-------------------------------------------
 	 * setDelivery
 	 * pre: int delivery
 	 * post: String type stores a day of the week
 	 -------------------------------------------*/
 	 public String setDelivery(int delivery)
 	 {
 	 	String type = "";
 	 	
 	 	switch(delivery)
 	 	{
 	 		case 1:
 	 		type = "Sunday";
 	 		
 	 		break;
 	 		
 	 		case 2:
 	 		type = "Monday";
 	 		
 	 		break;
 	 		
 	 		case 3: 
 	 		type = "Tuesday";
 	 		
 	 		break;
 	 		
 	 		case 4:
 	 		type = "Wednesday";
 	 		
 	 		break;
 	 		
 	 		case 5:
 	 		type = "Thursday";
 	 		
 	 		break;
 	 		
 	 		case 6:
 	 		type = "Friday";
 	 		
 	 		break;
 	 		
 	 		case 7:
 	 		type = "Saturday";
 	 		
 	 		break;
 	 		
 	 		default:
 	 		type = "This car has no delivery preference.";
 	 	}
 	 	
 	 	return type;	
 	  }
 	  
 	/*---------------------------------------
 	 * setQuality
 	 * pre: int quality
 	 * post: String type stores service plan
 	 ---------------------------------------*/
 	 public String setQuality(int quality)
 	 {
 	 	String type = "";
 	 	
 	 	switch(quality)
 	 	{
 	 		case 1:
 	 		type = "Basic";
 	 		
 	 		break;
 	 		
 	 		case 2:
 	 		type = "Advanced";
 	 		
 	 		break;
 	 		
 	 		case 3: 
 	 		type = "Extreme";
 	 		
 	 		break;
 	 		
 	 		default:
 	 		type = "This car has no service plan chosen.";
 	 	}
 	 	
 	 	return type;	
 	  }
 	  
 	  /*------------------------------
 	   * get carType
 	   ------------------------------*/
 	   public String getCarType()
 	   {
 	   		return carType;
 	   }
 	   
 	  /*------------------------------
 	   * get deliveryDay
 	   ------------------------------*/
 	   public String getDelivery()
 	   {
 	   		return deliveryDay;
 	   }
 	   
 	  /*------------------------------
 	   * get qualityOfService
 	   ------------------------------*/
 	   public String getQuality()
 	   {
 	   		return qualityOfService;
 	   }
 	  
 	  /*------------------------------
 	   * get vehicleNumber
 	   ------------------------------*/
 	   public int getVehicleNo()
 	   {
 	   	return vehicleNumber;
 	   }
 	   
 	  /*-------------------------------------------------------
 	   * setRenewal: helper method for initWash and initCoating
 	   * pre: int choice stores user choice of subscription
 	   * post: String renew stores subscription length
 	   -------------------------------------------------------*/
 	   public String setRenewal(int choice)
 	   {
 	   		String renew = "";
 	   		switch(choice)
			{
				case 1:
				renew = "Seasonal";
				break;
				
				case 2:
				renew = "Bi-annual";
				break;
				
				case 3:
				renew = "Yearly";
				break;
				
				default:
				renew = "No subscription";
			} 
			
			return renew;  
 	   }
 	   
 	  /*---------------------------------------------
 	   * initWash
 	   * pre: user has chosen to order a car wash,
 	   * String renewal - the subscription user wants
 	   * for their future washes
 	   * post: new Wash object added to services
 	   ---------------------------------------------*/
 	   public void initWash(int chosen)
 	   {
			Wash out = null;
			String renewal = setRenewal(chosen);
		
 	   		System.out.println("Thank you for your order!");
 	   	
 	   		if(getQuality().equalsIgnoreCase("Basic"))
 	   		{
 	   			out = new Wash(out.setCost("Basic"), out.setDuration("Basic"), renewal);	
 	   		}
 	   		else if(getQuality().equalsIgnoreCase("Advanced"))
 	   		{
 	   			out = new Wash(out.setCost("Advanced"), out.setDuration("Advanced"), renewal);
 	   		}
 	   		else if(getQuality().equalsIgnoreCase("Extreme"))
 	   		{
 	   			out = new Wash(out.setCost("Extreme"), out.setDuration("Extreme"), renewal);
 	   		}
 	   		
 	   		services.add(out);
 	   }
		
	  /*---------------------------------------------
 	   * initCoat
 	   * pre: user has chosen to order a car coating,
 	   * String renewal - the subscription user wants
 	   * for their future coats
 	   * post: new Coating object added to services
 	   ---------------------------------------------*/
 	   public void initCoat(int coatClass, int renewChoice, int coatType)
 	   {
 	   		Coating out = null;
 	   		String cc, ct; // String equivalents of user choice for coatClass and coatType
 	   		String renewal = setRenewal(renewChoice);
 	   		
 	   		switch(coatClass)
 	   		{
 	   			case 1:
 	   			cc = "Initial";
 	   			break;
 	   			
 	   			case 2:
 	   			cc = "Quartz";
 	   			break;
 	   			
 	   			default:
 	   			cc = "None";
 	   		}
 	   		
 	   		switch(coatType)
 	   		{
 	   			case 1:
 	   			ct = "Summer-style";
 	   			break;
 	   			
 	   			case 2:
 	   			ct = "Year Round";
 	   			break;
 	   			
 	   			case 3:
 	   			ct = "Iron Man";
 	   			break;
 	   			
 	   			default:
 	   			ct = "No style chosen";
 	   		}
 	   		
 	   		if(cc.equals("Initial"))
 	   		{
 	   			//out = new Initial(cost, duration, renewal, ct); 
 	   			services.add(out);	
 	   		}
 	   		else
 	   		{
 	   			//out = new Quartz(cost, duration, renewal, ct)
 	   			services.add(out);	
 	   		}
 	   }
 	   
 	   /*---------------------------------------------------------
 	    * toString
 	    ---------------------------------------------------------*/
 	    public String toString()
 	    {
 	   		String output = "";
 	   		output += "Vehicle type: " + getCarType() + "\n" +
 	   				  "Vehicle number: " + getVehicleNo() + "\n" +
 	   		 	   	  "Day of delivery: " + getDelivery() + "\n" +
 	   		 	   	  "Service plan: " + getQuality() + "\n";   	  
 	   	    for(int i = 0; i < services.size(); i++)
 	   	    {
 	   	    	output += services.get(i).toString();
 	   	    }
 	   		
 	   		return output; 	
 	    }
 	   
 }