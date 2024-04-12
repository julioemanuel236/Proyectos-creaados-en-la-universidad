/+-9/
package tareas;

import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

import javax.swing.*;

import bikes.BasicBike;
import bikes.EBike;
import bikes.MountainBike;
import bikes.RoadBike;
import bikes.RoadEBike;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class USTBikeShopPro extends Canvas 

{

	public static void main(String[] args)
	{
		
		
		final int MAX_INVENTORY_SIZE = 500;
		
		// Is there a per bike type stock limit? - Yes
		final int MAX_INVENTORY_SIZE_PER_TYPE = 100;
		

		boolean verboseMode = false;
		
	
		
		BasicBike [] basicBikeArray; // Declaring the array 
		basicBikeArray = new BasicBike[MAX_INVENTORY_SIZE_PER_TYPE]; // Creating
		
		MountainBike [] mountainBikeArray; // Declare 
		mountainBikeArray = new MountainBike[MAX_INVENTORY_SIZE_PER_TYPE]; // Creating
		
		RoadBike [] roadBikeArray; // Declare 
		roadBikeArray = new RoadBike[MAX_INVENTORY_SIZE_PER_TYPE]; // Creating
		
		EBike [] eBikeArray; // Declare 
		eBikeArray = new EBike[MAX_INVENTORY_SIZE_PER_TYPE]; // Creating
		
		RoadEBike [] roadEBikeArray; // Declare 
		roadEBikeArray = new RoadEBike[MAX_INVENTORY_SIZE_PER_TYPE]; // Creating
						
		// To initalize each element in the array to the default object values of the basic bike
		int i;
		
		for(i = 0; i < MAX_INVENTORY_SIZE_PER_TYPE; i++)
		{
			
			// Go to every element in the array to initialize the object
			basicBikeArray[i] = new BasicBike(0, 0, "", ""); 
							
			
			mountainBikeArray[i] = new MountainBike(0, false, false, 0, 0, "", "");
			
			roadBikeArray[i] = new RoadBike(false, 0, 0, "", "");
			
			eBikeArray[i] = new EBike(0, "", 0, 0, 0.0, 0, false, false, 0, 0, "", "");
			
			roadEBikeArray[i] = new RoadEBike(false, 0, 0, "", "");
		
		}
		
		// ----------------------DO NOT TOUCH ANYTHING ABOVE THIS LINE--------------//
		
		// ------------ User Interface section -------------------------------------//
		// I need a way to get user inputs, so I will include KeyboardReader class 
		// in this folder
		
		// This is for the user interface (text based) 
		int count = 0;
		int choice;
		boolean exitNow = true;
		KeyboardReader myKBR = new KeyboardReader();		
		
		do
		{
			// Display user options
			System.out.println("----------------------------------------------------------------------");
			System.out.println("-----------------------UST BIKE SHOP PRO------------------------------");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("I am here: run #" + count);
			System.out.println("-------------------------MAIN MENU------------------------------------\n");
			System.out.println("Enter action number \n 1 - List selected inventory\n 2 - Display all inventory");
			System.out.println(" 3 - Add a new bike\n 4 - Remove a bike" );
			System.out.println(" 5 - Modify an existing bike\n 6 - EXIT APPLICATION\n" );
			
			// Wait for user choice
			System.out.print("Enter your choice: ");
			choice = myKBR.getKeyboardInt();
			
			String choiceConfirm = "";
						
			switch (choice)
			{
				
				case (1):	displayInventory(MAX_INVENTORY_SIZE_PER_TYPE, verboseMode, basicBikeArray, mountainBikeArray, roadBikeArray, eBikeArray, roadEBikeArray );
							break;
				
				case (2): 	displayAllInventory(MAX_INVENTORY_SIZE_PER_TYPE, verboseMode, basicBikeArray, mountainBikeArray, roadBikeArray, eBikeArray, roadEBikeArray );
							break;
				
				case (3): 	addToInventory(MAX_INVENTORY_SIZE_PER_TYPE, verboseMode, basicBikeArray, mountainBikeArray, roadBikeArray, eBikeArray, roadEBikeArray );
							break;
				
				case (4): 	removeFromInventory(MAX_INVENTORY_SIZE_PER_TYPE, verboseMode, basicBikeArray, mountainBikeArray, roadBikeArray, eBikeArray, roadEBikeArray );
							break;
				
				case (5): 	modifyCurrentInventory(MAX_INVENTORY_SIZE_PER_TYPE, verboseMode, basicBikeArray, mountainBikeArray, roadBikeArray, eBikeArray, roadEBikeArray );
							break;
				
				case (6): 	System.out.print("Exit application? Confirm - Y/N: ");
							choiceConfirm = myKBR.getKeyboardInput();
							if(choiceConfirm.equals("Y") || choiceConfirm.equals("y") )
								exitNow = false;
							break;
				
				default: 	System.out.println("Illegal entry - retry");
							//exitNow = false;
							break; 
				
			}
			
			count++;
		
		} while (exitNow);
		
		
		
		// ------------ END User Interface section ----------------------------------//
	
	
	}// End PSVM
	
	
	
	// Methods for user interaction
	
	static void displayBasicBikeInventory(int maxSize, BasicBike [] arr, boolean verbose )
	{
		System.out.println("\n\n---------------------BASIC BIKE-----------------------------");
		int i;
		
		for(i = 0; i < maxSize; i++)
		{
			System.out.printf("Basic_Bike_Stock_No_%03d:\n",i+1);
			//System.out.println("Basic Bike Stock No:" + (i+1));
			System.out.println(">> "+arr[i].getInfo()+" <<\n" );
		}
	}
	
	
	static void displayMountainBikeInventory(int maxSize, MountainBike [] arr, boolean verbose )
	{
		System.out.println("\n\n-------------------MOUNTAIN BIKE-----------------------------");
		int i;
		
		for(i = 0; i < maxSize; i++)
		{
			System.out.printf("Mountain_Bike_Stock_No_%03d:\n",i+1);
			System.out.println(">> "+arr[i].getInfo()+" <<\n" );
		}
	}
	
	static void displayRoadBikeInventory(int maxSize, RoadBike [] arr, boolean verbose )
	{
		System.out.println("\n\n------------------------ROAD BIKE-----------------------------");
		int i;
		
		for(i = 0; i < maxSize; i++)
		{
			System.out.printf("Road_Bike_Stock_No_%03d:\n",i+1);
			System.out.println(">> "+arr[i].getInfo()+" <<\n" );
		}
	}
	
	
	static void displayEBikeInventory(int maxSize, EBike [] arr, boolean verbose )
	{
		System.out.println("\n\n---------------------------E BIKE-----------------------------");
		int i;
		
		for(i = 0; i < maxSize; i++)
		{
			System.out.printf("E_Bike_Stock_No_%03d:\n",i+1);
			System.out.println(">> "+arr[i].getInfo()+" <<\n" );
		}
	}

	
	static void displayRoadEBikeInventory(int maxSize, RoadEBike [] arr, boolean verbose )
	{
		System.out.println("\n\n-----------------------ROAD E BIKE-----------------------------");
		int i;
		
		for(i = 0; i < maxSize; i++)
		{
			System.out.printf("Road_E_Bike_Stock_No_%03d:\n",i+1);
			System.out.println(">> "+arr[i].getInfo()+" <<\n" );
		}
	}


	static void displayAllInventory(int maxSize, boolean verbose, BasicBike [] arr1, MountainBike [] arr2, RoadBike [] arr3, EBike [] arr4, RoadEBike [] arr5)
	{
		displayBasicBikeInventory(maxSize, arr1, verbose);
		displayMountainBikeInventory(maxSize, arr2, verbose);
		displayRoadBikeInventory(maxSize, arr3, verbose);
		displayEBikeInventory(maxSize, arr4, verbose);
		displayRoadEBikeInventory(maxSize, arr5, verbose);
	}

	
	static void displayInventory(int maxSize, boolean verbose, BasicBike [] arr1, MountainBike [] arr2, RoadBike [] arr3, EBike [] arr4, RoadEBike [] arr5)
	{
		KeyboardReader myKBR = new KeyboardReader();
		
		// Display user options
		System.out.println("\n\nWhich type of bike's inventory to list?");
		System.out.println("1 - Basic bike\n2 - Mountain bike");
		System.out.println("3 - Road bike\n4 - E bike");
		System.out.println("5 - Road E bike\n");
		
		// Wait for user choice
		System.out.print("Enter the bike type to list: ");
		int choice;
		choice = myKBR.getKeyboardInt();
		
		switch (choice)
		{
			
			case (1): 	displayBasicBikeInventory(maxSize, arr1, verbose);
						break;
					
			case (2):	displayMountainBikeInventory(maxSize, arr2, verbose);
						break;
			
			case (3):	displayRoadBikeInventory(maxSize, arr3, verbose);
						break;
			
			case (4): 	displayEBikeInventory(maxSize, arr4, verbose);
						break;
			
			case (5):	displayRoadEBikeInventory(maxSize, arr5, verbose);
						break;
		
			default: 	System.out.println("Unknown bike type - return to main menu\n");
						break; 		
		}
		
	}


	static void addToInventory(int maxSize, boolean verbose, BasicBike [] arr1, MountainBike [] arr2, RoadBike [] arr3, EBike [] arr4, RoadEBike [] arr5)
	{
		KeyboardReader myKBR = new KeyboardReader();
		
		// Display user options
		System.out.println("\n\nWhich type of bike do you want to add?");
		System.out.println("1 - Basic bike\n2 - Mountain bike");
		System.out.println("3 - Road bike\n4 - E bike");
		System.out.println("5 - Road E bike\n");
		
		// Wait for user choice
		System.out.print("Enter the bike type to add: ");
		int choice;
		choice = myKBR.getKeyboardInt();
		
		switch (choice)
		{
			
			case (1): 	addBasicBike(maxSize, verbose, arr1);
						break;
					
			case (2):	addMountainBike(maxSize, verbose, arr2);
						break;
			
			case (3):	addRoadBike(maxSize, verbose, arr3);
						break;
			
			case (4): 	addEBike(maxSize, verbose, arr4);
						break;
			
			case (5):	addRoadEBike(maxSize, verbose, arr5);
						break;
		
			default: 	System.out.println("Unknown bike type - return to main menu\n");
						break; 
		
		}
	}


	static void addBasicBike(int maxSize, boolean verbose, BasicBike [] arr)
	{
		KeyboardReader myKBR = new KeyboardReader();
		int MS = 0;
		int NG = 0;
		String PC = "";
		String SF = "";
		boolean found = false;
		
		for(int i = 0; i < maxSize; i++)
		{
			if( !found & (arr[i].maxSpeed == 0) & (arr[i].noOfGears == 0) & (arr[i].paintColor.equals("")))
			{
				System.out.print("\n\nEnter Max Speed rating:");
				MS = myKBR.getKeyboardInt();
				
				System.out.print("Enter No of Gears:");
				NG = myKBR.getKeyboardInt();
				
				System.out.print("Enter Paint Color:");
				PC = myKBR.getKeyboardInput();
				
				System.out.print("Enter Safety Features:");
				SF = myKBR.getKeyboardInput();				
			
				found = true;			
			}
			
						
			if (found)
			{	
				arr[i].maxSpeed = MS;
				arr[i].noOfGears = NG;
				arr[i].paintColor = PC;
				arr[i].safetyFeatures = SF;
				break;		
			}
		}
		System.out.println("Added Basic Bike\n\n");
	}
	
	
	static void addMountainBike(int maxSize, boolean verbose, MountainBike [] arr)
	{
		
		KeyboardReader myKBR = new KeyboardReader();
		int SH = 0;
		boolean FS = false;
		boolean FPT = false;
		int MS = 0;
		int NG = 0;
		String PC = "";
		String SF = "";
		boolean found = false;
		
		for(int i = 0; i < maxSize; i++)
		{
			if( !found & (arr[i].maxSpeed == 0) & (arr[i].noOfGears == 0) & (arr[i].paintColor.equals("")))
			{
				
				System.out.print("\n\nEnter Seat height:");
				SH = myKBR.getKeyboardInt();
				
				System.out.print("\n\nEnter if Full suspension (T/F):");
				FS = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter if Flat proof tyres (T/F):");
				FPT = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter Max Speed rating:");
				MS = myKBR.getKeyboardInt();
				
				System.out.print("Enter No of Gears:");
				NG = myKBR.getKeyboardInt();
				
				System.out.print("Enter Paint Color:");
				PC = myKBR.getKeyboardInput();
				
				System.out.print("Enter Safety Features:");
				SF = myKBR.getKeyboardInput();				
			
				found = true;			
			}
				
			if (found)
			{	
				arr[i].seatHeight = SH;
				arr[i].flatProofTyres = FPT;
				arr[i].fullSuspension = FS;
				arr[i].maxSpeed = MS;
				arr[i].noOfGears = NG;
				arr[i].paintColor = PC;
				arr[i].safetyFeatures = SF;
				break;		
			}
		}

		System.out.println("Added Mountain Bike\n\n");
	}
	
	static void addRoadBike(int maxSize, boolean verbose, RoadBike [] arr)
	{
		KeyboardReader myKBR = new KeyboardReader();
		boolean FHB = false;
		int MS = 0;
		int NG = 0;
		String PC = "";
		String SF = "";
		boolean found = false;

		for(int i = 0; i < maxSize; i++)
		{
			if( !found & (arr[i].maxSpeed == 0) & (arr[i].noOfGears == 0) & (arr[i].paintColor.equals("")))
			{
				
				System.out.print("\n\nEnter if Flat handlebar (T/F):");
				FHB = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter Max Speed rating:");
				MS = myKBR.getKeyboardInt();
				
				System.out.print("Enter No of Gears:");
				NG = myKBR.getKeyboardInt();
				
				System.out.print("Enter Paint Color:");
				PC = myKBR.getKeyboardInput();
				
				System.out.print("Enter Safety Features:");
				SF = myKBR.getKeyboardInput();				
			
				found = true;			
			}
				
			if (found)
			{	
				arr[i].maxSpeed = MS;
				arr[i].noOfGears = NG;
				arr[i].paintColor = PC;
				arr[i].safetyFeatures = SF;
				arr[i].setFlatHandleBar(FHB);
								
				break;		
			}
		}

		System.out.println("Added Road Bike\n\n");		
	}

	static void addEBike(int maxSize, boolean verbose, EBike [] arr)
	{
		KeyboardReader myKBR = new KeyboardReader();
		int RM = 0;
		String BT = "";
		int BS = 0;
		int BV = 0;
		double MP = 0.0;
		int SH = 0;
		boolean FS = false;
		boolean FPT = false;
		int MS = 0;
		int NG = 0;
		String PC = "";
		String SF = "";
		boolean found = false;
		
		for(int i = 0; i < maxSize; i++)
		{
			if( !found & (arr[i].maxSpeed == 0) & (arr[i].noOfGears == 0) & (arr[i].paintColor.equals("")))
			{
				
				System.out.print("\n\nEnter range in miles:");
				RM = myKBR.getKeyboardInt();
				
				System.out.print("\n\nEnter battery type:");
				BT = myKBR.getKeyboardInput();
				
				System.out.print("\n\nEnter battery size A-h:");
				BS = myKBR.getKeyboardInt();
				
				System.out.print("\n\nEnter battery volt V:");
				BV = myKBR.getKeyboardInt();
				
				System.out.print("\n\nEnter motor power kW:");
				MP = myKBR.getKeyboardDouble();
								
				System.out.print("\n\nEnter Seat height:");
				SH = myKBR.getKeyboardInt();
				
				System.out.print("\n\nEnter if Full suspension (T/F):");
				FS = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter if Flat proof tyres (T/F):");
				FPT = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter Max Speed rating:");
				MS = myKBR.getKeyboardInt();
				
				System.out.print("Enter No of Gears:");
				NG = myKBR.getKeyboardInt();
				
				System.out.print("Enter Paint Color:");
				PC = myKBR.getKeyboardInput();
				
				System.out.print("Enter Safety Features:");
				SF = myKBR.getKeyboardInput();				
			
				found = true;			
			}
				
			if (found)
			{	
				arr[i].rangeMiles = RM;
				arr[i].batteryType = BT;
				arr[i].batterySize = BS;
				arr[i].batteryVolt = BV;
				arr[i].motorPower = MP;
				arr[i].seatHeight = SH;
				arr[i].flatProofTyres = FPT;
				arr[i].fullSuspension = FS;
				arr[i].maxSpeed = MS;
				arr[i].noOfGears = NG;
				arr[i].paintColor = PC;
				arr[i].safetyFeatures = SF;
				break;		
			}
		}
		
		System.out.println("Added E Bike\n\n");
	}

	static void addRoadEBike(int maxSize, boolean verbose, RoadEBike [] arr)
	{
		KeyboardReader myKBR = new KeyboardReader();
		boolean FHB = false;
		int MS = 0;
		int NG = 0;
		String PC = "";
		String SF = "";
		boolean found = false;

		for(int i = 0; i < maxSize; i++)
		{
			if( !found & (arr[i].maxSpeed == 0) & (arr[i].noOfGears == 0) & (arr[i].paintColor.equals("")))
			{
				
				System.out.print("\n\nEnter if Flat handlebar (T/F):");
				FHB = (myKBR.getKeyboardInput().equals("T"));
				
				System.out.print("\n\nEnter Max Speed rating:");
				MS = myKBR.getKeyboardInt();
				
				System.out.print("Enter No of Gears:");
				NG = myKBR.getKeyboardInt();
				
				System.out.print("Enter Paint Color:");
				PC = myKBR.getKeyboardInput();
				
				System.out.print("Enter Safety Features:");
				SF = myKBR.getKeyboardInput();				
			
				found = true;			
			}
				
			if (found)
			{	
				arr[i].maxSpeed = MS;
				arr[i].noOfGears = NG;
				arr[i].paintColor = PC;
				arr[i].safetyFeatures = SF;
				arr[i].setFlatHandleBar(FHB);
								
				break;		
			}
		}
	
		System.out.println("Added Road E Bike\n\n");
	}
	

	static void removeFromInventory(int maxSize, boolean verbose, BasicBike [] arr1, MountainBike [] arr2, RoadBike [] arr3, EBike [] arr4, RoadEBike [] arr5)
	{
		KeyboardReader myKBR = new KeyboardReader();
		
		// Display user options
		System.out.println("\n\nWhich type of bike do you want to remove?");
		System.out.println("1 - Basic bike\n2 - Mountain bike");
		System.out.println("3 - Road bike\n4 - E bike");
		System.out.println("5 - Road E bike\n");
		
		// Wait for user choice
		System.out.print("Enter the bike type to remove: ");
		int typeToRemove;
		typeToRemove = myKBR.getKeyboardInt();
		
		int stockNo;
				
		switch (typeToRemove)
		{
			
			case (1): 	System.out.print("Enter the basic bike stock number to remove: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = new BasicBike(0, 0, "", "");
						System.out.println("Removed 1 basic bike !!");
						break;
					
			case (2):	System.out.print("Enter the mountain bike stock number to remove: ");
						stockNo = myKBR.getKeyboardInt();			
						arr2[stockNo - 1] = new MountainBike(0, false, false, 0, 0, "", "");
						System.out.println("Removed 1 mountain bike !!");
						break;
			
			case (3):	System.out.print("Enter the road bike stock number to remove: ");
						stockNo = myKBR.getKeyboardInt();
						arr3[stockNo - 1] = new RoadBike(false, 0, 0, "", "");
						System.out.println("Removed 1 road bike !!");
						break;
			
			
			case (4): 	System.out.print("Enter the E bike stock number to remove: ");
						stockNo = myKBR.getKeyboardInt();
						arr4[stockNo - 1] = new EBike(0, "", 0, 0, 0.0, 0, false, false, 0, 0, "", "");
						System.out.println("Removed 1 E bike !!");
						break;
			
						
			case (5):	System.out.print("Enter the road E bike stock number to remove: ");
						stockNo = myKBR.getKeyboardInt();
						arr5[stockNo - 1] = new RoadEBike(false, 0, 0, "", "");
						System.out.println("Removed 1 road E bike !!");
						break;
		
			default:	System.out.println("Unknown bike type - return to main menu\n");
						break; 
		
		}

		
	}
	
	static void modifyCurrentInventory(int maxSize, boolean verbose, BasicBike [] arr1, MountainBike [] arr2, RoadBike [] arr3, EBike [] arr4, RoadEBike [] arr5)
	{
		KeyboardReader myKBR = new KeyboardReader();
		
		// Display user options
		System.out.println("\n\nWhich type of bike do you want to modify?");
		System.out.println("1 - Basic bike\n2 - Mountain bike");
		System.out.println("3 - Road bike\n4 - E bike");
		System.out.println("5 - Road E bike\n");
		
		// Wait for user choice
		System.out.print("Enter the bike type to modify: ");
		int typeToModify;
		typeToModify = myKBR.getKeyboardInt();
		
		int stockNo;
				
		switch (typeToModify)
		{
			case (1):	System.out.print("Enter the basic bike stock number to modify: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = modifyBasicBike(arr1[stockNo - 1]);
						System.out.println("Modified 1 basic bike !!");
						break;
			
			case (2): 	System.out.print("Enter the basic bike stock number to modify: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = modifyBasicBike(arr1[stockNo - 1]);
						System.out.println("Modified 1 basic bike !!");
						break;
			
			case (3): 	System.out.print("Enter the basic bike stock number to modify: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = modifyBasicBike(arr1[stockNo - 1]);
						System.out.println("Modified 1 basic bike !!");
						break;
			
			case (4):	System.out.print("Enter the basic bike stock number to modify: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = modifyBasicBike(arr1[stockNo - 1]);
						System.out.println("Modified 1 basic bike !!");
						break;
			
			case (5): 	System.out.print("Enter the basic bike stock number to modify: ");
						stockNo = myKBR.getKeyboardInt();
						arr1[stockNo - 1] = modifyBasicBike(arr1[stockNo - 1]);
						System.out.println("Modified 1 basic bike !!");
						break;
			
			default: 
			
			
		}

	}
	
	
	static BasicBike modifyBasicBike(BasicBike bike)
	{
		KeyboardReader myKBR = new KeyboardReader();
		String userEdits;
				
		System.out.println("\nThe current data on this bike is as follow:\n" + bike.getInfo());
		System.out.println("\nEnter the data you want to modify separated by a semicolon, as shown below.");
		System.out.println("Max speed; No of gears; Paint color; Safety features");
		
		userEdits = myKBR.getKeyboardInput();
		
		String [] values = userEdits.split(";");
		
		bike.maxSpeed = Integer.valueOf(values[0]);
		bike.noOfGears = Integer.valueOf(values[1]);
		bike.paintColor = values[2];
		bike.safetyFeatures = values[3];	
		
		return bike;
	}

	static MountainBike modifyMountainBike(MountainBike bike)
	{
		KeyboardReader myKBR = new KeyboardReader();
		String userEdits;
				
		System.out.println("\nThe current data on this bike is as follow:\n" + bike.getInfo());
		System.out.println("\nEnter the data you want to modify separated by a semicolon, as shown below.");
		System.out.println("Max speed; No of gears; Paint color; Safety features");
		
		userEdits = myKBR.getKeyboardInput();
		
		String [] values = userEdits.split(";");
		
		bike.maxSpeed = Integer.valueOf(values[0]);
		bike.noOfGears = Integer.valueOf(values[1]);
		bike.paintColor = values[2];
		bike.safetyFeatures = values[3];	
		
		return bike;
	}
	
	static RoadBike modifyMountainBike(RoadBike bike)
	{
		KeyboardReader myKBR = new KeyboardReader();
		String userEdits;
				
		System.out.println("\nThe current data on this bike is as follow:\n" + bike.getInfo());
		System.out.println("\nEnter the data you want to modify separated by a semicolon, as shown below.");
		System.out.println("Max speed; No of gears; Paint color; Safety features");
		
		userEdits = myKBR.getKeyboardInput();
		
		String [] values = userEdits.split(";");
		
		bike.maxSpeed = Integer.valueOf(values[0]);
		bike.noOfGears = Integer.valueOf(values[1]);
		bike.paintColor = values[2];
		bike.safetyFeatures = values[3];	
		
		return bike;
	}
	
	static EBike modifyMountainBike(EBike bike)
	{
		KeyboardReader myKBR = new KeyboardReader();
		String userEdits;
				
		System.out.println("\nThe current data on this bike is as follow:\n" + bike.getInfo());
		System.out.println("\nEnter the data you want to modify separated by a semicolon, as shown below.");
		System.out.println("Max speed; No of gears; Paint color; Safety features");
		
		userEdits = myKBR.getKeyboardInput();
		
		String [] values = userEdits.split(";");
		
		bike.maxSpeed = Integer.valueOf(values[0]);
		bike.noOfGears = Integer.valueOf(values[1]);
		bike.paintColor = values[2];
		bike.safetyFeatures = values[3];	
		
		return bike;
	}
		
	static RoadEBike modifyMountainBike(RoadEBike bike)
	{
		KeyboardReader myKBR = new KeyboardReader();
		String userEdits;
				
		System.out.println("\nThe current data on this bike is as follow:\n" + bike.getInfo());
		System.out.println("\nEnter the data you want to modify separated by a semicolon, as shown below.");
		System.out.println("Max speed; No of gears; Paint color; Safety features");
		
		userEdits = myKBR.getKeyboardInput();
		
		String [] values = userEdits.split(";");
		
		bike.maxSpeed = Integer.valueOf(values[0]);
		bike.noOfGears = Integer.valueOf(values[1]);
		bike.paintColor = values[2];
		bike.safetyFeatures = values[3];	
		
		return bike;
	}	
} // END public class USTBikeShopPro
