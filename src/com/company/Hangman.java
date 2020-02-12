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
		String Hangman_Word = Word;
		String newWord = Hangman_Word.replaceAll("\\S", "_");
		//Final word is the guessing input
		char[] FinalWord = newWord.toCharArray();
		Scanner input = new Scanner(System.in);
		int LastChar = Hangman_Word.length();
		System.err.println(LastChar);
		System.out.print("Guess a letter in the word! ");
		String temp = input.nextLine();
		//World list is the actual Char List; Compare it to final, but display neword;
		char[] WordList = new char[LastChar];
		for(int i = 0; i < LastChar; i++) {
			WordList[i] = Hangman_Word.charAt(i);
		}
		boolean active = true;
		char Guess = temp.charAt(0);
		while(active == true){
			if(Guesses != 0) {
				System.out.println("you have " + Guesses + " and " + hint + " hints left");
				System.out.print("Enter another Guess: ");

				Guess = input.next().charAt(0);
			}
			for(int i = 0; i < LastChar; i++){
				if(Guess == WordList[i]) {
					FinalWord[i] = Guess;
					System.out.println(FinalWord);
					counter++;

				}

			}
			if(counter > 0) {
				System.out.println("Nice! " + Guess + " Is in the word! ");
			}

				if(Guesses == 0) {
					active = false;
				}

		}
		System.out.println("Congrats on completing the game! GG");
	}
}