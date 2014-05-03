package com.bentleycarr.piLedTest;

import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.RaspiPin;

public class Main {
	
	public static void main(String[] args) {
		
		// Creates GPIO Controller Instance
		final GpioController gpio = GpioFactory.getInstance();
		
		// Creates a Scanner Instance
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// String used to get input
		String input = new String();
		input = "0";
		
		// Creates variables for Pins
		GpioPinDigitalMultipurpose PinOne;
		GpioPinDigitalMultipurpose PinTwo;
		GpioPinDigitalMultipurpose PinThree;
		GpioPinDigitalMultipurpose PinFour;
		
		System.out.println("");
		System.out.println("Charlieplexing Testing Program for Raspberry Pi with 4 Pins.");
		System.out.println("By Bentley Carr");
		
		String ledType = new String();
		
		// Loops until the user inputs "1" or "2"
		while ( !(ledType.equals("1") || ledType.equals("2")) ) {
			
			System.out.println("");
			System.out.println("Use Hour LEDs or Minute LEDs? Hour LEDs will use ports 11, 12, 13 and 15; Minute LEDs will use ports 16, 18, 22 and 7.");
			System.out.println("1 for Hour LEDs;");
			System.out.print("2 for Minute LEDs: ");
	
			ledType = scanner.nextLine();
			ledType = ledType.trim();
			
			System.out.println("");
				
		}
		
		// Provisions 4 GPIO Pins
		switch (ledType) {
		
			case "1":
				// Hour Pins
				PinOne = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_00, PinMode.DIGITAL_INPUT);
				PinTwo = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, PinMode.DIGITAL_INPUT);
				PinThree = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, PinMode.DIGITAL_INPUT);
				PinFour = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_03, PinMode.DIGITAL_INPUT);
				break;
			default:
				// Minute Pins
				PinOne = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_04, PinMode.DIGITAL_INPUT);
				PinTwo = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_05, PinMode.DIGITAL_INPUT);
				PinThree = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_06, PinMode.DIGITAL_INPUT);
				PinFour = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_07, PinMode.DIGITAL_INPUT);
				break;
				
		}

		System.out.println("");
		
		PinOne.setMode(PinMode.DIGITAL_INPUT);
		PinTwo.setMode(PinMode.DIGITAL_INPUT);
		PinThree.setMode(PinMode.DIGITAL_INPUT);
		PinFour.setMode(PinMode.DIGITAL_INPUT);
		
		while (input.length() > 0) {
			
			int ledOn;
			
			System.out.print("LED to turn on (1-12):");
			input = scanner.nextLine();
			
			if (input.equals("")) {
				System.out.println("Exiting...");
				break;
			}
			
			ledOn = Integer.parseInt(input);
			
			if (!(0 <= ledOn && ledOn <= 12)) {
				System.out.println("Can't turn on LED #" + ledOn + ".");
			}
			
			System.out.println("");
			
			switch (ledOn) {
				case 1:
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.high();
					
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.low();
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 2:
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.high();
					
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.low();
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
							
					break;
				
				case 3:
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.high();
					
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.low();
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 4:
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.high();
					
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 5:
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.high();
					
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.low();
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 6:
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.high();
					
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 7:
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.high();
					
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 8:
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.high();
					
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
							
					break;
				
				case 9:
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.high();
					
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 10:
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.high();
					
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 11:
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.high();
					
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.low();
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 12:
					PinThree.setMode(PinMode.DIGITAL_OUTPUT);
					PinThree.high();
					
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.low();
					
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				default:
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					PinTwo.setMode(PinMode.DIGITAL_INPUT);
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					PinFour.setMode(PinMode.DIGITAL_INPUT);
				
			}
			
		}
		
	}

}
