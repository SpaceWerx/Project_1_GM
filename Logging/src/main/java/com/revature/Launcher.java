package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
	public static void main(String[] args) {
		//This is our boolean to keep our program running so we can use the CLI
		boolean displayMenu = true;
		
		//This is our Scanner object to take user inputs
		Scanner scan = new Scanner(System.in);
		
		//This is our logger object, that will allows us to Log things
		Logger log = LogManager.getLogger(Launcher.class);
		
		while(displayMenu) {
			
			System.out.println("Hello VIP Shopper! Welcome to the Login Menu!");
			System.out.println("---------- Please log in ----------");
			//This is a logging tag that when executed will put this message in our logs file
			log.info("/User accessed login prompt");
			
			//This is to take in our username and password
			System.out.println("Username: ");
			String username = scan.nextLine();
			System.out.println("Password: ");
			String password = scan.nextLine();
			
			//This will log us in
			if(username.equals("user") && password.equals("password")) {
				log.info("/User successfully logged in/");
				
				System.out.println("Are you interested in trying our BOGO discount on shoes today?");
				System.out.println("  Yes   |   No   ");
				String input1 = scan.nextLine();
				//Lets log what they entered
				log.info("/User's answer was: " + input1 + "/");
		
				if(input1.equals("Yes")) {
					System.out.println("What would you like to order?");
					String order = scan.nextLine();
					log.info("/User's order is: " + order + "/");
				}
				else if(input1.equals("No")) {
					System.out.println("Thank you and we hope you find what you like on our website!");
					log.info("/User declined BOGO/");
				}
				else {
					System.out.println("How did you mess up a yes or no question? You will now be sent back to kindergarten, upon certificate of completion, you may try again");
					log.fatal("/User has a Wisdom score of 3/");
				}
				
				System.out.println("Would you like the items to be shipped to your 'Home' or a nearby 'Drop-off' location?");
				String input2 = scan.nextLine();
				log.info("/User wishes to have items shipped to: " + input2 + "/");
				
				if(input2.equals("Home")) {
					System.out.println("You will recieve your item within 3-5 business months");
					log.fatal("/User requested to-home delivery, even though they have no home");
					
				}
				else if(input2.equals("Drop-off")) {
					System.out.println("Good luck finding it!");
					log.info("/User failed a DC15 perception role and never recieved their package/");
					
				}
//				else if(input2.equals("Gaming")) {
//					System.out.println("Get Gud Scrub");
//					log.info("/User got Rektd/");
//				}
				else {
					System.out.println("Well that's nice");
					log.info("/User plans on never receiving product through method: " + input2 + "/");
				}
				displayMenu = false;
		}
		else{
			//This will log a warning that a user failed to log in
			log.warn("/User failed to log in");
			displayMenu = false;
		}
	}
}
}
