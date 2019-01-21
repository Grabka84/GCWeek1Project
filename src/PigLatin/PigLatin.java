package PigLatin;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userWord = "";
		String anotherLine = "";
		String firstPart ="";
		String secondPart = "";
		
		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println("------------------------------------");
		
		do {
			// prompt user for word and store it in userWord
			System.out.print("Please enter a line to be translated into pig latin: ");
			userWord = scnr.nextLine();
			System.out.println();
			
			// convert the string to all lower case
			String userWordLowerCase = userWord.toLowerCase(); 
			
			// put each word of the string into an array of undefined size (0)
			String[] arrayOfString = userWordLowerCase.split(" ", 0); 
			
			// for each word in the array, do the program to check if the word contains a special character, then 
			// check each character in the word until it hits a vowel, then print the appropriate response
			for (String word : arrayOfString) {
			// isNotLetter checks if the word has a special character in it, and prints the word as is
			// otherwise, runs the vowel checking portion
				if (isNotLetter(word)) {
					System.out.print(word + " ");
				} else {
					for(int i = 0 ; i < word.length(); i++) {
						// if the first letter of the word is a vowel, do word + "way" and exit the loop with the break
						if(isVowel(0,word)) { 
							System.out.print(word + "way ");
							break;
							// since first letter is NOT vowel (since first if was false), 
							// get the substring of word from the vowel to the end as first part
							// get the substring of word from start to vowel as second part
						} else if (isVowel(i,word)) { 
							firstPart = word.substring(i); 
							secondPart = word.substring(0, i);
							System.out.print(firstPart + secondPart +"ay ");
							break;
						} 
					}
				}	
			}
			// ask if user wants to input another line
			System.out.println();
			System.out.println();
			System.out.print("Do you want to translate another line? (y/n) ");	
			anotherLine = scnr.nextLine();
			System.out.println();
		
		// if the user chooses, goes back up to do line
		} while (anotherLine.equals("y") || anotherLine.equals("Y")); 
		
		System.out.println("Thank you! Oodbyegay!");
		scnr.close(); // close the scanner
	}	
	
	// checks if a a character at string position i is a vowel
	public static boolean isVowel(int i, String word) { 
		if ((word.charAt(i) == 'a') || 
			(word.charAt(i) == 'e') ||
			(word.charAt(i) == 'i') || 
			(word.charAt(i) == 'o') ||
			(word.charAt(i) == 'u')) {
			return true;
		} else {
			return false;
		}
	}
	
	// checks if the word contains any of the special characters
	public static boolean isNotLetter(String word) {
		if(word.contains("@")||
				word.contains("1")||
				word.contains("2")||
				word.contains("3")||
				word.contains("4")||
				word.contains("5")||
				word.contains("6")||
				word.contains("7")||
				word.contains("8")||
				word.contains("9")||
				word.contains("0")) {
			return true;
		} else {
			return false;
		}
	}
}
