package project;

import java.text.DecimalFormat;

public class Garage {

	final private Car parking[];
	private int cars;
	private int selectedPos;
	DecimalFormat format = new DecimalFormat("#.00");
	
	public Garage(int n) {
		parking = new Car[n];
	}
	
	public Car get(int pos) {
		if(pos<1||pos>parking.length)return null;
		return parking[pos-1];
	}
	
	public void showParking() {
		for(int i=0;i<parking.length;i++) {
			if(parking[i]==null)continue;
			System.out.print("Space "+(i+1)+": ");
			if(parking[i]==null)System.out.println("empty");
			else System.out.println(parking[i].toString());			
		}
	}
	
	public void noCarsError() {
		System.out.println("There are no cars currently in the garage.");
	}
	
	public void driveCar() {
		if(isEmpty()) {
			return;
		}
		Car car = selectCar();
		if(car==null) {
			System.out.println("THere is no car in that space!");
			System.out.println("Please create a Car for that space.");			
			return;
		}
		if(car.getFuelLevel()==0) {
			System.out.println("The tank its empty, refuel it first");
			return;
		}
		System.out.println("How far will you like to drive");
		System.out.println("Give a value bigger than zero");
		double distance = InputRead.nextDouble();
		if(distance<0) {
			System.out.println("Not valid");
			return;
		}
		
		System.out.println("How fast will you like to drive");
		System.out.println("Give a value bigger than zero");
		double speed = InputRead.nextDouble();
		if(speed<0) {
			System.out.println("Not valid");
			return;
		}
		car.setUpTrip(speed, distance);
		if(!car.driveCar()) {
			System.out.println(
					car.getModel()
					+ " ran out of fuel.\r\n"
					+ "It is parked somewhere on the side of the road.\r\n"
					+ "");
			parking[selectedPos] = null;
			cars--;
		}
		else {
			System.out.println(car.getModel()+ "returns to garage after the trip");
		}
	}
	
	public Car createCar() {
		System.out.println("Would you like to input the data yourself or create a random car?");
		System.out.println("Please enter \"c\" for create yourself or \"r\" for random car.");
		boolean op = InputRead.createRandom();
		if(op) {
			System.out.println("Input the year of the car?");
			int year = InputRead.carYear();								
			
			System.out.println("Please enter the Make of the car.");
			String make = InputRead.nextLine();
			
			System.out.println("Please enter the Model of the car.");
			String model = InputRead.nextLine();
			
			System.out.println("Please enter the color of the car.");
			String color = InputRead.nextLine();
			
			System.out.println("Input the size of the car's fuel tank.");
			double fts = InputRead.fuelTankSize();
			
			System.out.println("Input the car's optimal driving speed for best mileage.");
			double optimalSpeed = InputRead.optimalSpeed();
			
			System.out.println("Input the car's fuel economy.");
			double econmoy = InputRead.fuelEconomy();

			parking[selectedPos] = new Car(make,model,year,fts,econmoy,optimalSpeed,color);
		}
		else {
			 parking[selectedPos] = new Car();
		}
		cars++;
		return parking[selectedPos];
	}
	
	public void refuelCar() {
		if(isEmpty()) {
			return;
		}
		Car car = selectCar();
		if(car==null) {
			System.out.println("THere is no car in that space!");
			System.out.println("Please create a Car for that space.");			
			return;
		}
		System.out.println("How much fuel would you like to add?");
		System.out.println("Please enter an amount greater than zero.");
		
		int fuel = InputRead.nextInt();
		if(fuel<0) {
			System.out.println("Not valid");
			return;
		}
		double result = car.addFuel(fuel);
		if(result<0) {
			result = - result;
			System.out.println("The tank is not full and can take "+format.format(result) + " mor gallons of fule");						
		}		
		else {
			System.out.println("The tank is full and you have "+format.format(result)+" gallons left in the can." );
		}
		
	}

	public void addCar() {
		if(cars==parking.length) {
			System.out.println("The garage its full");
			return;
		}
		for(int i=0;i<parking.length;i++)
			if(parking[i]==null) {
				selectedPos=i;
				break;
			}
		createCar();
	}
	
	public Car selectCar() {
		showParking();
		System.out.println("Wich SPace you want to choose");
		while(true) {
			int pos = InputRead.nextInt();
			if( pos<1||pos>parking.length) {
				System.out.println("Not valid");
			}
			else {
				selectedPos=pos-1;
				return get(pos);
			}
		}
	}
	
	public boolean isEmpty() {
		return cars==0;
	}
	
}