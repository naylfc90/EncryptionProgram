/* Nathan Horne 200587413 */
/* Assignment 8 - Encryption Matrix */


//importing Scanner for user input
import java.util.Scanner;

//public class called MatrixUser - used for user input
public class MatrixUser 
{
	//main begins
	public static void main (String args[])
	{
		//Print statement with title of program
		System.out.println("ENCRYPTION PROGRAM");
		System.out.println("-----");
		
		//Calling scanner constructor method and naming scanner as 's' for user input
		Scanner scanner = new Scanner(System.in);
		
		//Print statement to prompt user to enter their unencoded letter
		System.out.println("Please enter a letter which will remain unencoded: ");
		
		//Scanner to allow user input - called userLet as it will be passed to method
		String userLet = scanner.next();
		
		//Ignoring any whitespace and punctuation
		userLet = userLet.replaceAll("\\W", "");
		
		//error handling if user tries to input a word instead of letter
		//any error will re-prompt user for input
		while (userLet.length() != 1)
		{
			System.out.println("Error: Please enter a letter which will remain unencoded: ");
			userLet = scanner.next();
			userLet = userLet.replaceAll("\\W", "");
		}
		
		//Print statement to prompt user to enter their 5 letter keyword
		System.out.println("Please enter your 5 letter keyword: ");
		
		//Scanner to allow user input - called userKey as it will be passed to method
		String userKey = scanner.next();
		
		//Ignoring any whitespace and punctuation
		userKey = userKey.replaceAll("\\W", "");
		
		//Error handling if user tries to input a word which does not have a length of 5
		//any error will re-prompt user for input
		while(userKey.length() != 5)
		{
			System.out.println("Error: Please enter a 5 letter keyword: ");
			userKey = scanner.next();
			userKey = userKey.replaceAll("\\W", "");
		}
		
		//Print statement to prompt user to enter their message to be encrypted
		System.out.println("Enter your message to be encrypted: ");
		
		//Scanner to allow user input - called userMessage as it will be passed to method
		String userMessage = scanner.next();
		
		//Ignoring any whitespace and punctuation
		userMessage = userMessage.replaceAll("\\W", "");
		
		//Method call for createMatrix in Matrix class - providing user's letter and keyword
		Matrix.createMatrix(userLet, userKey, userMessage);
		
		//Closing scanner to stops Java error messages 
		scanner.close();
	}
}