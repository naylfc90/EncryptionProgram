/* Nathan Horne 200587413 */
/* Assignment 8 - Encryption Matrix */


//Public class called Matrix
public class Matrix 
{
	//createMatrix method will form the user's matrix
	protected static String[][] createMatrix (String letter, String key, String message)
	{
		//Creating a new 5x5 matrix array which will store the keyword 
		//and remaining letters (minus chosen unencoded letter) 
		String[][] matrix = new String[5][5];
		
		//Converting letter and key to upper case to maintain anonymity 
		letter = letter.toUpperCase();
		key = key.toUpperCase();
		message = message.toUpperCase();
		
		//Applying key and letters of alphabet as keyword
		//- which will be displayed in array
		String keyString = key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Initialising the array with empty string values firstly which will
		//be overwritten with keyword and remaining letters
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
		        matrix[i][j] = "";
		
		//Nested for loop to enter keyString into array - overwriting empty strings
		for(int k = 0; k < keyString.length(); k++)
		{
			//Two boolean values to indicate whether a letter has been repeated and used
			//improved efficiency if repeated letters are marked off
			boolean repeat = false;
			boolean used = false;
			
			//'i' represents one dimension of array [5]
			for(int i = 0; i < 5; i++)
			{
				//'j' represents the other dimension [5]
				for(int j = 0; j < 5; j++)
				{
					//Error message prompt if the user tries to use keyword which contains 
					//chosen unencoded letter. This will result in the program ending.
					if(key.charAt(i) == letter.charAt(0))
					{
						System.out.println("You cannot use a keyword which contains your chosen unencoded letter");
						System.out.println("-----" + "\n" + "Program ended!");
						System.exit(0);
					}
					
					//'if' statement automatically marks off chosen unencoded letter
					//achieved by marking it off as used. This is not included in array.
					if(letter.charAt(0) == (keyString.charAt(k)))
					{
						used = true;
					}
					
					//'if' statement detects if any letters are repeated. This speeds up process
					//by skipping any potential future repeat attempts.
					if(matrix[i][j].equals("" + keyString.charAt(k)))
					{
						repeat = true;
					}
					
					//'if' statement automatically flags any letters once they have been used.
					//achieved by comparing whether they have already been repeated or used.
					else if(matrix[i][j].equals("") && !repeat && !used)
					{
						matrix[i][j] = "" + keyString.charAt(k);
						used = true;
					}
				}
			}
		}
		//createMatrix() ends by calling the printTable() method with matrix data as input
		printMatrix(matrix, key, letter, message);
		return matrix;
	}
	
	//printTable() method responsible for printing 5x5 array
	private static String[][] printMatrix(String[][] matrix, String key, String letter, String message)
	{ 
		//'for' statement loops through and
		//prints each array element individually
		for(int i = 0; i < 5; i++)
		{
		  	for(int j = 0; j < 5; j++)
		   	{
		   		System.out.print(matrix[i][j]+" ");
		   	}
		  	System.out.println();
		}
		System.out.println();
		    
		Matrix.sortMessage(message, letter, matrix);
		    
		return matrix;
	}
	
	//sortMessage() method will be responsible for preparing the strings prior to encryption.
	//The user's message and letter are taken as inputs.
	private static String[] sortMessage(String message, String letter, String[][] matrix)
	{
		//Changing message and letter to upper case for accurate comparisons
		message = message.toUpperCase();
		letter = letter.toUpperCase();
		
		//'for' loop will cycle through the length of the message. This will detect 
		//any errors regarding unencoded letters.
		for (int i = 0; i < message.length(); i++)
		{
			//'if' statement handles errors where the user has tried to encrypt a message which contains
			//the chosen unencoded letter. This will result in the program ending.
			if(message.charAt(i) == letter.charAt(0))
			{
				System.out.println("You cannot use a message which contains your chosen unencoded letter");
				System.out.println("-----" + "\n" + "Program ended!");
				System.exit(0);
			}
		}
			
		//Created new array called splitMessage[] which will store pairs of characters from user's message.
		//This is achieved by a 'for' loop which creates substrings after every two characters which is 
		//determined by the 'count' increment.
		//For example, message = "computer" is converted to splitMessage[co, mp, ut, er].
		//These pairs of characters will be used for the actual encryption.
		String splitMessage[] = new String[message.length()/2];
		int count = 0;
		for (int j = 0; j < message.length()/2; j++)
		{
			splitMessage[j] = message.substring(count, count + 2);
			count = count + 2;
		}
		
		//Preparation is finished and now the encryption method is called!
		Encryption.encryptMessage(matrix, splitMessage, message);
		
		return splitMessage;
	}
}