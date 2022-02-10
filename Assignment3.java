//-----------------------------------------------------------------------------------
// Written by: Harinder Partap Singh
// For COMPUTER SCIENCE 
//-----------------------------------------------------------------------------------

/*
 * This program produces the calendar, dates of the month which are
 * not multiple of month and checks if the year is leap year or not.
 * Input: Year for which the calendar is to be printed
 * Output: Calendar is printed for each month. 
 */


import java.util.Scanner;

public class Assignment3 {
	
	//Declaring and initializing the scanner object and variable
	static Scanner input = new Scanner(System.in);
	static boolean leapYear;
	
	public static void main(String[] args) {
		
		//Displaying the welcome message
		System.out.println("-------****-------****-------****-------****-------" + 
				"\n      Welcome to Calendar Program!\n"
				+ "-------****-------****-------****-------****-------\n");
			
		readInput();
		
		//Scanner is closed
		input.close();
	
	}//end of main method

	//This method reads the input entered by user 
	static void readInput() {
		
		String requestYear = "Please enter a 4-digit year:";
		System.out.println(requestYear);
		
		//Initializing the value entered by user
		int year = input.nextInt();
		
		//If the year entered is not correct then recurssion will occur
		//Else the calendar method will be invoked
		if (!isYearCorrect(year)) {
			readInput();
		} 
		
		else {
			
			printCalendar();
			
			//Displaying the closing banner
			System.out.print("\nThankyou for using this program!!");
		}
	}

	//This method is called to check if the year entered is valid or not
	static boolean isYearCorrect(int year) {
		if (year >= 1000 && year <= 9999) {
			leapYear = isLeapYear(year);
			return true;
		}		
		else {
			return false;
		}
	}
	
	//This method is called to check if the year entered is leap year or not
	static boolean isLeapYear(int year) {
		
		boolean itIsLeapYear = false;
		
		if (year % 4 == 0) {
			itIsLeapYear = true;

			if ( (year % 100 == 0)) {				
				
					if((year % 400 == 0) ) {
						return itIsLeapYear;
					}
					else {				
						return itIsLeapYear = false;
					}
			}
			
		}
		return itIsLeapYear;
	}

	//This method prints the calendar 
	static void printCalendar() {
		
		//Nested loop is used to print the different dates of month
		for (int monthNumber = 1; monthNumber <= 12; monthNumber++) {
			int counter = 0;
			
			//The method is called to print the month names 
			displayMonthNames(monthNumber);
			
			//The dates will be printed based upon the month number
			switch (monthNumber) {
			
			case 3: case 5: case 7: case 8: case 10: case 12:
				
				for (int dateOfMonth = 1; dateOfMonth <= 31; dateOfMonth++) {

					if (dateOfMonth % monthNumber != 0) {

						//This outputs the dates of the month which are not multiple of month
						System.out.print(dateOfMonth + ", ");
						counter++;
						if (counter == 15) {
							System.out.println("");
						}
					}
				}
				
				System.out.println();
				break;

			case 2: case 4: case 6: case 9: case 11: {

				for (int dateOfMonth = 1; dateOfMonth <= 30; dateOfMonth++) {

					if (dateOfMonth % monthNumber != 0) {

						System.out.print(dateOfMonth + ", ");
						counter++;
						if (counter == 15 && monthNumber !=2) {
							System.out.println("");
						}
					}
					if (monthNumber == 2) {
						if (leapYear && dateOfMonth == 30) {
							
							break;
							
						} else if (!leapYear && dateOfMonth == 28) {

							break;
						}
					}
				}
				System.out.println();
				break;
			}
		  }
		}
	}

	//This method output the name of month and month order
	static void displayMonthNames(int month) {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		if (leapYear && month == 2) {
			System.out.println("\nIn February in a leap year, the dates are not multiple of 2 are:");
		} 
		else if (!leapYear && month == 2) {
			System.out.println("\nIn February in a common year, the dates are not multiple of 2 are:");
		} 
	
		else {
			System.out.println("\nIn " + monthName[month - 1] + ", the dates are not multiple of " + month + " are:");
		}
		if(month==1){
			System.out.println("No dates are found in this month!");
		}		
	}	
}//end of Assignment3 class
