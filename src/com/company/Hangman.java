/**
 * @author Joseph Newman
 * @since 2/8/20
 * discription:
 * Write a Java program called Hangman.java that reads a word (or a phrase)
 * from a user and plays the hangman game. In the assignment,
 * you can assume that the word (or a phrase) from a user is all
 * capitals in a single line.
 * The user will type only alphabet letters and blank spaces. As well as offer the user 2 hints and up to 5 Guesses.
 * Best of luck user;
 **/
package com.company;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		String Hangman_Word;
		Scanner input = new Scanner(System.in);

		System.out.println("- - - - - - - - - - Welcome to Hangman! - - - - - - - - - -");
		System.out.print("Please enter a word: ");

		Hangman_Word = input.nextLine();
		String newWord = Hangman_Word.replaceAll("\\S", "_");
		newWord = newWord.replaceAll("\\s", "#");
		int LastChar = newWord.length();
		char[] DisplayIntro = newWord.toCharArray();
		for(int g = 0; g < LastChar; g++){
			System.out.print(DisplayIntro[g] + " ");
		}

		HangMan(Hangman_Word);
	}
	public static void HangMan(String Word) {
		int Guesses = 5;
		int counter = 0;
		int hint = 2;
		//sets the word entered as a CAPITALS;
		String Hangman_Word = Word.toUpperCase();
		String newWord = Hangman_Word.replaceAll("\\S", "_");

		//Final word is the guessing input
		char[] FinalWord = newWord.toCharArray();
		Scanner input = new Scanner(System.in);
		int LastChar = Hangman_Word.length();
		int CheckHintUse;

		char Guess;
		//World list is the actual Char List; Compare it to final, but display neword;
		char[] WordList = new char[LastChar];
		for(int i = 0; i < LastChar; i++) {
			WordList[i] = Hangman_Word.charAt(i);
		}
		String comp2;
		boolean active = true;
		comp2 = Hangman_Word;
		String comp1 = new String(FinalWord);
		//hint array is set to the char array thats "correct" now do the same thing you did for checking if Guess is in the char array
		//that should let Hint work;
		char[] HintArray;
		HintArray = WordList;
		// begin hangman game loop
		while(active){
			//break if out of guesses;
			if(Guesses == -1) {
				break;
			}
			//break if word is == to each other( the guesses word and the actual word)
			if(comp1.equals(comp2)) {
				break;
			}
			//if guesses higher than the final guess exist; else last guess displayed;
			if(Guesses >= 1 || hint >= 1){
			System.out.println("you have " + Guesses +" Guesses" + " and " + hint + " hints left. Press 1 for a hint or guess the word");}
			else {
				System.out.println("Last guess Goodluck");
			}
			Guess = input.next().toUpperCase().charAt(0);
			//insert HINT ability right here;
			//if one is entered then displayed the first non guessed letter; IE: Di_ _ _ _; display the first _ as the Letter;
			if(Guess == '1'){
				while(true){
					for(int i = 0; i < LastChar; i++){
						if(FinalWord[i] != HintArray[i]){
							FinalWord[i] = HintArray[i];
							char temp = HintArray[i];
							for(int g = 0; g < LastChar; g++){
								if(temp == WordList[g]){
									(FinalWord[g]) = temp;
								}
							}
							for(int k = 0; k < LastChar; k++){
								System.out.print(FinalWord[k] + " ");
							}
							hint--;
							break;
						}
					}

					break;
				}
			}


			for(int i = 0; i < LastChar; i++){
				if(Guess == WordList[i]) {
					(FinalWord[i]) = Guess;
					for(int g = 0; g < LastChar; g++){
						System.out.print(FinalWord[g] + " ");
					}
					//System.out.println(FinalWord);
					counter++;
				}
			}
			if(counter > 0) {
				System.out.println("Nice! " + Guess + " Is in the word! ");
			}
			if(counter == 0) {
				if(Guess == '1'){
					System.out.println("You've used a Hint!");
				}else{
				System.out.println();
				System.out.println( Guess + " Is not in the word. Try again!");
				Guesses--;}
			}
			if(hint >= 0){
				System.out.println("You've used a hint!");

			}
			comp1 = new String(FinalWord);
			counter = 0;
		}
		System.out.println("The word was " + Hangman_Word);
		if(comp1.equals(comp2)){
		System.out.println("Congrats on Winning the game! GG");
		}else
		{
			System.out.println("Unfortunately you did not guess the word. :( GG");
		}
	}
}