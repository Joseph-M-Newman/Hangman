/**
 * @author Joseph Newman
 * @since 2/8/20
 * discription:
 * Write a Java program called Hangman.java that reads a word (or a phrase)
 * from a user and plays the hangman game. In the assignment,
 * you can assume that the word (or a phrase) from a user is all
 * capitals in a single line.
 * The user will type only alphabet letters and blank spaces.
 */
package com.company;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		String Hangman_Word = "";
		int Guesses = 10;
		Scanner input = new Scanner(System.in);

		System.out.println("----------Welcome to Hangman!----------");
		System.out.print("Please enter a word: ");

		Hangman_Word = input.nextLine();
		String newWord = Hangman_Word.replaceAll("\\S", "_");

		System.out.println(newWord); // check if the word is being displayed properly; Not needed to
		// always be displayed, for debugging;

		HangMan(Hangman_Word + " ");
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
		System.err.println(LastChar);

		char Guess;
		//World list is the actual Char List; Compare it to final, but display neword;
		char[] WordList = new char[LastChar];
		for(int i = 0; i < LastChar; i++) {
			WordList[i] = Hangman_Word.charAt(i);
		}
		String comp2 = "";
		boolean active = true;
		comp2 = Hangman_Word;
		String comp1 = new String(FinalWord);

		while(active == true){
			//break if out of guesses;
			if(Guesses == -1) {
				break;
			}
			//break if word is == to each other( the guesses word and the actual word)
			if(comp1.equals(comp2)) {
				break;
			}
			if(Guesses >= 1){
			System.out.println("you have " + Guesses + " and " + hint + " hints left");}
			else {
				System.out.println("Last guess Goodluck");
			}
			System.out.print("Enter another Guess: ");
			Guess = input.next().toUpperCase().charAt(0);

			//insert HINT ability right here;


			System.err.println(comp1 + " " + comp2);

			for(int i = 0; i < LastChar; i++){
				if(Guess == WordList[i]) {
					(FinalWord[i]) = Guess;
					System.out.println(FinalWord);
					counter++;
				}
			}
			if(counter > 0) {
				System.out.println("Nice! " + Guess + " Is in the word! ");
			}
			if(counter == 0) {
				Guesses--;
			}
			comp1 = new String(FinalWord);
			counter = 0;
		}
		System.out.println("Congrats on completing the game! GG");
	}
}