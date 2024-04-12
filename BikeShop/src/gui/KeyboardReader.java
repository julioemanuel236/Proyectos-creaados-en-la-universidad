// Lecture #08 - Object Oriented Programming 09/19/2022
// Riddle flash card game 
// 9/9 students in attendance, Instrutor: Dr. Charles Thangaraj

// Standard imports
package gui;

import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import javax.swing.JOptionPane;
// Primary class 
// This class is for defining some methods for handeling textual user interface 
// therefore this file is not intented for being executed, rather just to be imported or be placed
// in the same folder as any program that wants to use the features provided for my the methods
// of the KeyboardReader class
public class KeyboardReader
{
	// Declare an object of the BufferredReader class to better handle the inputs from the keyborad
	// The BufferedReader class is part of java.io.* package
	private BufferedReader myBR; // Declaration only
	
	
	//Constructor 
	public KeyboardReader()
	{
		// Create and initialize the object to read from the standard input i.e. keyboard
				
	}
	
	// Internal error handeling - methods that do not need outside access
	private String sanityCheck(String txt)
	{
		// Empty string
		String line = "";
		
		// try to execute this block and see if there are any errors or exceptions thown by the OS
		// if so then catch those exceptions and handle them inside, don't let the user see this
		try
		{
			line = JOptionPane.showInputDialog(txt);			
			
		}catch (Exception exp)
		{
			line = "Unable to read from keyboard - ERROR #92187310984";
			exp.printStackTrace();			
		}
		
		return line;				
	}
	
	// Interface methods
	// These are methods that is intender for use by external users i.e. API 
	
	public String getKeyboardInput(String txt)
	{
		return sanityCheck(txt);
	}
	
	public int getKeyboardInt(String txt)
	{
		return Integer.parseInt(sanityCheck(txt));
	}
	
	public double getKeyboardDouble(String txt)
	{
		return Double.parseDouble(sanityCheck(txt));
	}
	
} // End class KeyboardReader
