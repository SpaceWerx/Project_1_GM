package Service;

import java.util.List;
import java.util.Scanner;

import Models.Reimbursement;
import Models.Role;
import Models.Type;
import Models.User;

public class CLIMenuService {

UserService userService = new UserService();     
ReimbursementService reimbursementService = new ReimbursementService();   

Scanner scan = new Scanner(System.in); ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
public void displayMenu() {       
	boolean menuOptions = true; //Using this to let the menu continue after user input                  //Greetings for the user        
	System.out.println("-----------------------------------------------------------");         
	System.out.println("Welcome to the Revature Reimbursement System");         
	System.out.println("-----------------------------------------------------------");         
	System.out.println();
	
	//display the menu as long as the menuOptions boolean == true
	//display all my menu options until boolean == false
	while (menuOptions) {
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		System.out.println("1- Employee Portal");
		System.out.println("2- Finance Manager Portal");
		System.out.println("0- Exit Application");
		
		
	// The user choose a menu option and the scanner takes the input and put into an int variable
	// Calls the promptSelection() helper method to handle validation
	// The parameters list the valid options that the user must choose from
	int firstChoice = promptSelection(1,2,0);
	
	//Take the user input and the switch statement executes the appropriate code
	switch (firstChoice) {
	
	case 1: 
		handlePortal(Role.Employee);
		break;
	case 2: 
		handlePortal(Role.Manager);
		break;
	case 0:
		System.out.println("\nHAve a greate day! Goodbye. ");
		menuOptions=false;
		break;
	}
}//end of the while loop
	
		
}//end of displayMenu method
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void displayEmployeeMenu(User employee) {
	boolean employeePortal = true;
	
	System.out.println("--------------------------------------------------------------");
	System.out.println("Welcome to the Employee Portal, " + employee.getUsername());
	System.out.println("--------------------------------------------------------------");
	System.out.println();
	while (employeePortal) {
		
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		System.out.println("1-> View Previous Request");
		System.out.println("2-> Submit a Reimbursement");
		System.out.println("0-> Return to the Main Menu");
	
	//The user choose a menu option and the scanner takes the input and put  it into and int variable
	int firstChoice = promptSelection(1,2,0);
	
	switch (firstChoice) {
	case 1: 
		displayPreviousRequest(employee);
		break;
	case 2: 
		submitReimbursement(employee);
		break;
	case 0:
		System.out.println("Returning to Main Menu...");
		employeePortal= false;
		break;
	}
	
}

}

public void displayFinanceManagerMenu (User manager) {
	boolean managerPortal = true;
	
	System.out.println("--------------------------------------------------------");
	System.out.println("Welcome to the Manager Portal, " +manager.getUsername());
	System.out.println("--------------------------------------------------------");
	System.out.println();
	
	while (managerPortal) {
		
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		System.out.println("1-> View all pending reimbursements ");
		System.out.println("2 -> View all resolved reimbursement ");
		System.out.println("3-> Process a Reimbursement ");
		System.out.println("0-> Return to Main Menu ");
		
		int firstChoice = promptSelection(1,2,3,0);
		
		switch (firstChoice) {
		case 1:
			displayPendingReimbursements();
			break;
		case 2:
			displayResolvedReimbursements();
		case 3:
			submitReimbursement(manager);
			break;
		case 0:
			System.out.println("Returning to Main Menu...");
			managerPortal = false;
			break;
		}
	}
	
	
	
}
public String fetchInput() {
	return scan.nextLine().split("")[0];
	
}

public int promptSelection(int  ...validEntries) {
	int input;
	boolean valid = false;
	
	do {
		input = parseIntegerInput(fetchInput());
		
		for (int entry : validEntries) {
			if (entry == input) {
				// if it does, we activate the flag, which will end the do-while loop
				valid = true;
				break;
				
			}
			if (!valid) {
				System.out.println("Input received was not a valid option, please try again. ");
			}
		}
		
	}while(!valid);
	return input;
	
	
	
	
}

	public int parseIntegerInput(String input) {

try {
	return Integer.parseInt(input);
}catch (NumberFormatException e) {
	System.out.println("The input received was not valid, please try again.");
	return -1;
}

}
	public Double parseDoubleInput(String input) {
		try {
			return Double.parseDouble(input);
			
		}catch (NumberFormatException e) {
			System.out.println("The input received was not valid, please try again.");
			return (double) -1;
		}
		
		
	}	
	public void handlePortal(Role role) {
		// get the List of employee from the repository layer
		List<User> users = userService.getUserByRole(role);
		
		int[] ids = new int [users.size() + 1];
		ids[users.size()] = 0;
		for (int i =0; i < users.size();i++) {
			ids[i] = users.get(i).getId();
		}
		
		// Ask for employee Id number to continue
		System.out.println("-------------------------------------------------------");
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		
		// enhanced for loop to print out all users one by one
		for (User u : users) {
			System.out.println(u.getId() + "->" + u.getUsername());
		}
		System.out.println("0 - Return to Main Menu");
		System.out.println();
		
		int userChoice = promptSelection(ids);
		
		if (userChoice == 0) {
			return;
		}
		User employee = userService.getUserById(userChoice);
		
		if (role == Role.Manager) {
			System.out.println("Opening Manager Portal for " + employee.getUsername());
			displayFinanceManagerMenu(employee);
		}else {
			System.out.println("Opening Employee Portal for " + employee.getUsername());
			displayEmployeeMenu(employee);
		}
		
			
	 }
	public void displayPreviousRequest(User Employee) {
		List<Reimbursement> reimbursements = reimbursementService.getReimbursementByAuthor(Employee.getId());
		
		if (reimbursements.isEmpty()) {
			System.out.println("No Previous Request...");
			System.out.println("Returning to Previous Menu...");
		}
		for (Reimbursement r : reimbursements) {
			System.out.println(r);
			System.out.println(r.getAuthor());
	        System.out.println(r.getID());
	        System.out.println(r.getAmount());
	        System.out.println(r.getStatus());
	        System.out.println(r.getDescription());
	        System.out.println(r.getResolver());
	        System.out.println(r.getType());
		}
			
		}
	public void submitReimbursement(User employee) {
		Reimbursement reimbursementToBeSubmitted = new Reimbursement();
		reimbursementToBeSubmitted.setAuthor(employee.getId());
		
		System.out.println("What type of reimbursement would you like to submit?");
		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
		System.out.println("1- Lodging");
		System.out.println("2- Travel");
		System.out.println("3- Food");
		System.out.println("4- Other");
		int typeDecision = promptSelection( 1,2,3,4);
		
		switch (typeDecision) {
		case 1:
			reimbursementToBeSubmitted.setType(Type.Lodging);
			break;
		case 2:
			reimbursementToBeSubmitted.setType(Type.Travel);
			break;
		case 3:
			reimbursementToBeSubmitted.setType(Type.Food);
			break;
		case 4:
			reimbursementToBeSubmitted.setType(Type.Other);
			break;
		
	}
		System.out.println("Please enter the dollar amount you are requesting to be reimbursed: ");
		System.out.println("$");
		
		reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
		if(reimbursementToBeSubmitted.getAmount()<=0) {
			System.out.println("Invalid Amount has been entered, please input a correct dollar amount. ");
			boolean valid = false;
			while(!valid) {
				reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
				if (reimbursementToBeSubmitted.getAmount() !=0) {
					valid = true;
				}
			}
		}
		System.out.println("Please enter a description/reason for your reimbursement rquest. ");
		
		reimbursementToBeSubmitted.setDescription(scan.nextLine());
		if(reimbursementToBeSubmitted.getDescription().trim().equals("")) {
			System.out.println("You cannot submit a request with an empty description, please explain the reason for your request.");
		boolean valid = false;
		while(!valid) {
		reimbursementToBeSubmitted.setDescription(scan.nextLine());
		if(!reimbursementToBeSubmitted.getDescription().trim().equals("")) {
			valid =true;
		}
		}
	}
reimbursementService.submitReimbursement(reimbursementToBeSubmitted);
}
	public void displayPendingReimbursements() {
	    List<Reimbursement> pendingReimbursements = reimbursementService.getPendingReimbursements();

	    if (pendingReimbursements.isEmpty()) {
	        System.out.println("No Pending Requests...");
	        System.out.println("Returning to Previous Menu...");
	    }
	    for (Reimbursement r : pendingReimbursements) {
	        System.out.println(r);
	    }
	}
	public void displayResolvedReimbursements() {
	    List<Reimbursement> resolvedReimbursements = reimbursementService.getResolvedReimbursements();

	    if(resolvedReimbursements.isEmpty()) {
	        System.out.println("No Resolved Requests...");
	        System.out.println("Returning to Previous Menu...");
	    }
	    for(Reimbursement r : resolvedReimbursements) {
	        System.out.println(r);
	    }

	}
}
