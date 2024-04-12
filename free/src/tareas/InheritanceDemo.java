// Lecture #17 - Object Oriented Programming 03/29/2023
// In class live demo for Inheritance
// 16/19 students in attendance, Instrutor: Dr. Charles Thangaraj
// Post lecture comment: 

// Lecture #18 - Object Oriented Programming 04/03/2023
// In class live demo for Inheritance
// 13/19 students in attendance, Instrutor: Dr. Charles Thangaraj
// Post lecture comment: 
package tareas;

import java.util.*;

import bikes.BasicBike;
import bikes.EBike;
import bikes.MountainBike;
import bikes.RoadBike;
import bikes.RoadEBike;

import java.math.*;
import java.io.*;
import java.lang.*;

// Here we are attempting to create objects for the classes that we have defined
// Base class: BasicBike
// Level 1 inherited classes: MountainBike

public class InheritanceDemo
{
	public static void main(String[] args)
	{
		// create an object for the base class
		
		BasicBike basicBike01 = new BasicBike(20, 18, "Pink", "ceramic brakes, titanium");
		
		System.out.println(basicBike01.getInfo());	
		
		MountainBike mountainBike01 = new MountainBike(4, false, true, 8, 36, "Neon", "Mg brakes, titanium, carbon fibre seatpost");
		
		System.out.println(mountainBike01.getInfo());
		
		// I want to change the color of the mountainBike01 
		// 
		
		mountainBike01.paintColor = "green";
		
		System.out.println(mountainBike01.getInfo());
		
		basicBike01.paintColor = "Baby Pink";
		
		System.out.println(basicBike01.getInfo());	
			
		System.out.println(mountainBike01.currSpeed);
		
		mountainBike01.speedUp(10);
		
		System.out.println(mountainBike01.currSpeed);
		
		mountainBike01.applyBrake(3);
		
		System.out.println(mountainBike01.currSpeed);	
		
		RoadBike roadBike01 = new RoadBike(true, 45, 36, "lightning red", "Mg paddles, carbon fiber frame, super brakes");
		
		System.out.println(roadBike01.getInfo());
		
		EBike eBike01 = new EBike(120, "Lion", 25, 48, 1.25, 5, true, true, 60, 4, "Blue", "Auto cut off, dual disk brakes, air bags");
		
		System.out.println(eBike01.getInfo());
		
		RoadEBike roadEBike01 = new RoadEBike(true, 60, 4, "Teal Fiusion", "Auto power off, GPS, disk brakes, battery saver");
		
		System.out.println(roadEBike01.getInfo());
	}
	
}
