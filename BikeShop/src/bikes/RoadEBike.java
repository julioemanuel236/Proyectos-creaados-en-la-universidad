// Lecture #17 - Object Oriented Programming 03/29/2023
// In class live demo for Inheritance
// 16/19 students in attendance, Instrutor: Dr. Charles Thangaraj
// Post lecture comment: 

// Lecture #18 - Object Oriented Programming 04/03/2023
// In class live demo for Inheritance
// 13/19 students in attendance, Instrutor: Dr. Charles Thangaraj
// Post lecture comment: 


// Lecture #19 - Object Oriented Programming 04/05/2023
// In class live demo for Inheritance
// 12/19 students in attendance, Instrutor: Dr. Charles Thangaraj
// Post lecture comment: 
package bikes;

import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

// Inherited/sub/child class from the Base class
// Base/super/parent/root class: RoadBike
// Interface class: EBike
// Inherited class: RoadEBike

// Mimic the EBike class as an interface to implement elsewhere
interface EBikeInterface
{
	// Variable in an interface must have a default value, which is not changeable
	public int rangeMiles = 100; // Range in miles
	public String batteryType = "Li-ion"; // Li-ion, NiMH, SLA, AGM, LiPo
	public int batterySize = 25; // A-hours
	public int batteryVolt = 48; // 12/24/36/48 
	public double motorPower = 1.1; // in KW 0.5. 1.0 etc

	// Methods in an interface cannot have a body and must be declarations only i.e. abstract method
	// The intentions is for any class that implements this interface to redefine these methods
	public String getBatteryInfo();
	public String getInfo();

	
	
}



public class RoadEBike extends RoadBike implements EBikeInterface
{
	
	// Constructors  - only one is used here - you can have multiple 
	// constructors if you want to
	
	public RoadEBike(boolean FHB, int S, int G, String C, String SF)
	{
		//Passing the base class parameters to the base class constructor
		// "super" is a keyword
		// Make sure this is the first line in any inherited class' constructor
		super(FHB, S, G, C, SF);
		// super(); - to call the base class's constructor - it is the same as 
		// RoadBike();
		// super.noOfGears is not the same as this.noOfGears
		
		
	}
	
		
	// Methods 
	
	// getters and setters
	
	// Getters and Setters for public variable are not needed as they can be 
	// accessed freely by others.
	// Here we only need one getter and setter since we have only one private variable i.e. flatHandleBar
	
	
	// behavior methods
		
	// Polymorphism (run time) - this inherited class method OVERRIDES 
	// the base class method

	
	
	public String getBatteryInfo()
	{
		String msg = "";
		msg = "Battery Type: " + this.batteryType + " | Battery Size: " + this.batterySize + " | Battery Voltage: " + this.batteryVolt;
		return msg;
	}
		
	
	public String getInfo()
	{
		String msg;
		
		msg = "Bike Info 1/4: {Max speed setting: " + maxSpeed + " | No of gears: " + noOfGears + " | Frame color: " + paintColor + " | Safety features: " + safetyFeatures + "}\n";
		msg = msg + "Bike Info 2/4: {" + getBatteryInfo() + " }\n";
		msg = msg + "Bike Info 3/4: {Range in Miles: " + rangeMiles + " | Motor Power: " + motorPower + " }\n";
		msg = msg + "Bike Info 4/4: {Flat Handle Bar: " + isFlatHandleBar() + " }\n";
		
		return msg;
		
	}

	
	
} // End class RoadEBike
