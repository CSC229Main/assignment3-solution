import java.util.Scanner;
	
public class Program {

	public static void main(String[] args) {		
		Calculator calc = new Calculator(); // Calculator object
		Calculator calc2 = new Calculator(12); // Calculator object (argument constructor)
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter one of the following commands to the calculator"); // Prompt for input
		System.out.println(); // This outputs a line break
		System.out.println("END to exit the program");
		System.out.println("SET <number> to set/reset the value stored in the calculator");
		System.out.println("CLEAR to set the value stored in the calculator to 0");
		System.out.println("PRINT to print the current value stored in the calculator");
		System.out.println("ADD <number>");
		System.out.println("SUBTRACT <number>");
		System.out.println("MULTIPLY <number>");
		System.out.println("DIVIDE <number>");
		
		boolean end = false; // This boolean will be used to break the loop when the user enters the end command
		
		while (!end) {
			String input= scnr.nextLine(); // Read the next line as input
			String[] params = input.split(" "); // Split the string on whitespace, store in an array			
			String command = params[0].toUpperCase(); // Store the command value as uppercase to ignore case

			double value = 0; // This will store the value input, if necessary
			if (command.equals("SET") || command.equals("ADD") || command.equals("SUBTRACT") || command.equals("MULTIPLY") || command.equals("DIVIDE")) { 
				// "END", "CLEAR", and "PRINT" commands do not require a value, so only get the value if the command entered is none of those three
				try {
					value = Double.parseDouble(params[1]); // Take the second parameter, attempt to read it as a double
				} catch (Exception e) { // If the input cannot be read as a double, we handle the exception that is thrown
					System.out.println("Input is invalid! Enter another command"); // Yell at the user
					continue; // Continue looping
				}
			}
			
			// The following check could be put in the divide method on the calculator class or the switch block below
			// I chose to put it here for the sake of readability
			if (command.equals("DIVIDE") && value == 0) { // Attempt to divide by zero
				System.out.println("Cannot divide by zero! Enter another command"); // Yell at the user
				continue; // Continue looping
			}
			
			switch (command) { // Switch statement to handle commands
				case "END": // Command is END
					System.out.println("Bye!"); 
					end = true; // End the loop
					break;
				case "SET": // Command is SET
					calc.setValue(value); // Set the value
					break;
				case "CLEAR": // Command is CLEAR
					calc.clear(); // Clear the value
					break;
				case "ADD": // Command is ADD
					calc.add(value); // Add the value
					break;
				case "SUBTRACT": // Command is SUBTRACT
					calc.subtract(value); // Subtract the value
					break; 
				case "MULTIPLY": // Command is MULTIPLY
					calc.multiply(value); // Multiply the value
					break;
				case "DIVIDE": // Command is DIVIDE
					calc.divide(value); // Divide the value
					break;
				case "PRINT": // Command is PRINT
					System.out.println("Value = " + calc.getValue()); // Output the value
					break;
				default: // Command is none of the above, so the command is invalid
					System.out.println("Command is invalid! Enter another command"); // Yell at the user	
			}
		
		}
		scnr.close();
	}
}
