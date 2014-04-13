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
		Scanner scanner = new Scanner(System.in);
		
		// String used to get input
		String input = new String();
		input = "0";
		
		// Provisions 4 GPIO Pins
		final GpioPinDigitalMultipurpose PinOne = 
				gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_00, PinMode.DIGITAL_INPUT);
		final GpioPinDigitalMultipurpose PinTwo = 
				gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, PinMode.DIGITAL_INPUT);
		final GpioPinDigitalMultipurpose PinThree = 
				gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, PinMode.DIGITAL_INPUT);
		final GpioPinDigitalMultipurpose PinFour = 
				gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_03, PinMode.DIGITAL_INPUT);
		
		System.out.println("");
		System.out.println("Charlieplexing Testing Program for Raspberry Pi with 4 Pins.");
		System.out.println("By Bentley Carr");
		System.out.println("");
		System.out.println("GPIO Pins 11, 12, 13 and 15 are going to be used to test the LEDs. To change these values, you must change the program's code.");
		System.out.println("");
		
		while (input.length() > 0) {
			
			int ledOn;
			
			System.out.print("LED to turn on (1-12):");
			input = scanner.nextLine();
			System.out.println("");
			
			ledOn = Integer.parseInt(input);
			
			PinOne.setMode(PinMode.DIGITAL_INPUT);
			PinTwo.setMode(PinMode.DIGITAL_INPUT);
			PinThree.setMode(PinMode.DIGITAL_INPUT);
			PinFour.setMode(PinMode.DIGITAL_INPUT);
			
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
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.high();
					
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.low();
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 10:
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.high();
					
					PinFour.setMode(PinMode.DIGITAL_OUTPUT);
					PinFour.low();
					
					PinOne.setMode(PinMode.DIGITAL_INPUT);
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 11:
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.high();
					
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.low();
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
					
				case 12:
					PinTwo.setMode(PinMode.DIGITAL_OUTPUT);
					PinTwo.high();
					
					PinOne.setMode(PinMode.DIGITAL_OUTPUT);
					PinOne.low();
					
					PinThree.setMode(PinMode.DIGITAL_INPUT);
					
					PinFour.setMode(PinMode.DIGITAL_INPUT);
							
					break;
				
			}
			
		}
		
	}

}
