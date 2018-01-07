/* Nathan Horne 200587413 */
/* Assignment 8 - Encryption Matrix */

//Public class called Encryption
public class Encryption 
{
		//encryptMessage method is responsible for encrypting the users message. This is achieved by comparing
		//the characters of each splitMessage index against the characters in the matrix[][]. If a match is found
		//the coordinates are manipulated for the encoded output.
		protected static void encryptMessage(String[][] matrix, String[] splitMessage, String message)
		{
			//4 variables listed will represent the coordinates to access position in matrix for encoded output.
			//StringBuilder used to append each character when a match is found.
			int i1 = 0;
			int j1 = 0;
			int i2 = 0;
			int j2 = 0;
			StringBuilder encode = new StringBuilder();
			

    		//inner 'for' loop to run through splitMessage[] which is using 'k' as reference
			//and compare char's in each index with the char's in 5x5 matrix. The nested 'if'
			//statement checks whether the characters match. If they match then [i][j] of char
			//is stored and appended to a string and output to the user.
    		for(int k = 0; k < splitMessage.length; k++)
    		{
    			for(int i = 0; i < 5; i++)
    			{
			    	for(int j = 0; j < 5; j++)
			    	{
			    		if(splitMessage[k].charAt(0) == (matrix[i][j].charAt(0)))
			    			{
			    				i1 = i;
			    				j1 = j;	
			    			}
			    			if(splitMessage[k].charAt(1) == (matrix[i][j].charAt(0)))
			    			{
			    				i2 = i;
			    				j2 = j;
			    			}
			    		}
			    	}
			    	encode.append(matrix[i1][j2]);
					encode.append(matrix[i2][j1]);
			    }
			
    		//print statement prints the encoded message, and in cases where the message has an odd number
    		//of characters the last character is appended. This is because the encryptor ignores the odd
    		//letter during the splitMessage method.
    		System.out.print("Your encoded message is: " + "\n" + encode);
    		if (message.length() % 2 != 0)
			{
    			System.out.print(message.charAt(message.length()-1));
			}
		}
}