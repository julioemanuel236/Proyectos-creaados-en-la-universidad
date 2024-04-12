package project;

public class CarGarageDriver {

	
	public static void main(String[] args) {
		InputRead.setDelimeter();
		boolean exit=false;
		while(!exit) {	
			System.out.println("Welcome to the Car and Garage program");
			System.out.println("Enter the number of parking space you would like to have in the garage");		
			Garage garage = new Garage(InputRead.parkingSize());
			boolean run=true;
			while(run) {
				if(!garage.isEmpty())garage.showParking();
				else garage.noCarsError();
				System.out.println("A) Refuel a car");
				System.out.println("B) Get a Car to drive");
				System.out.println("C) Add a Car");
				System.out.println("Q) Quit");
				System.out.println("\nPlease select one of the above choices.");
				char op = InputRead.option();
				switch(op) {
					case 'a':garage.refuelCar();break;
					case 'b':garage.driveCar();	break;
					case 'c':garage.addCar();	break;
					case 'q':run=false;break;
					default:System.out.println("Invalid menu choice");break;
				}
			}
			System.out.println("Thank you for using the garage.");
			System.out.println("Would you like to repeat this program?");
			System.out.println("Please enter \"y\" for yes or \"n\" for no.");			
			exit = !InputRead.yesNo();				
			}			
		}
	}

