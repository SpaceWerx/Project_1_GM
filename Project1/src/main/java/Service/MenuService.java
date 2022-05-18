package Service;

public class MenuService {
	package Utilities;

import Models.Role;
import Models.User;

public void displayMenu() {
	
	
				boolean menuOptions = true; // Using this to let the menu continue after user input
				// Greetings for the user
				System.out.println("---------------------------------------------------------");
				System.out.println("Welcome to the Revature Reimbursement System");
				System.out.println("---------------------------------------------------------");
				System.out.println();
				// display the menu as long as the menuoptions boolean == true // display all my menu options until boolean == false
				while (menuOptions) {
				// menu options
				System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
				System.out.println("1-> Employee Portal");
				System.out.println("2 →> Finance Manager Portal");
				System.out.println("0> Exit Application");
				// The user chooses a menu option and the scanner takes the input and put it into an int variable // calls the promptSelection () helper method to handle validation
				// The parameters list the valid options that the user must choose from
				int firstChoice = promptSelection(1,2,0);
				
				// Takes the user input and the switch statement executes the appropriate code 
				// A break in each case block so that the other cases will not run c
				switch (firstChoice) {
				case 1:
				handlePortal(Role.Employee);
				break;
				case 2:
				handlePortal(Role.Manager);
				break;
				System.out.println("\nHave a great day! Goodbye.");
				case 0:
				menuOptions = false;
				
				break;
		}
	 }
				// end of while loop
	} // end of displayMenu method

			public void displayEmployeeMenu (User employee) { 
			boolean employeePortal = true;
			System.out.println("--------------------------------------------------------");
			System.out.println("Welcome to the Employee Portal, " + employee.getUsername());
			System.out.println("--------------------------------------------------------");
			System.out.println();
			
			while (employeePortal) {
				
			System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE"); System.out.println("1 →> View Previous Requests");
			System.out.println("2 - -> Submit a Reimbursement");
			System.out.println("0 -> Return to Main Menu");
			// The user chooses a menu option and the scanner takes the input and put it into a int variable 
			int firstChoice = promptSelection(1,2,0);
			switch (firstChoice) {
			case 1:
					displayPrevious Requests (employee);
					break;
			case 2:
			submitReimbursement (employee);
			break;
			case 0:
			System.out.println("Returning to Main Menu...");
			employeePortal = false;
		
			break;
			");
		
			}
		}
	}
}
