package com.company;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		String Hangman_Word = "";
		int Guesses = 10;
		String newHangmanWord = "";
		Scanner input = new Scanner(System.in);
		System.out.println("----------Welcome to Hangman!----------");
		System.out.print("Please enter a word: ");
		Hangman_Word = input.nextLine();

		int CountOfWord = Hangman_Word.length() - 1;
		String newWord = Hangman_Word.replaceAll("\\S", "_");
		System.err.println(newWord); // check if the word is being displayed properly; Not needed to
		// always be displayed, for debugging;
		HangMan(Hangman_Word);

	}
	public static void HangMan(String Word) {
		int Guesses = 0;
		String Hangman_Word = Word;
		String newWord = Hangman_Word.replaceAll("\\S", "_");
		char[] FinalWord = newWord.toCharArray();
		Scanner input = new Scanner(System.in);
		int LastChar = Hangman_Word.length();

		System.out.print("Guess a letter in the word! ");
		String temp = input.nextLine();
		char[] WordList = new char[LastChar];
		for(int i = 0; i < LastChar; i++) {
			WordList[i] = Hangman_Word.charAt(i);
		}
		char Guess = temp.charAt(0);
		char tempLetter = Guess;
		int Current_Position;
		System.err.println(Guess);
		while(Guesses != LastChar){
			if(Guesses != 0) {
				System.out.print("Enter another Guess: ");
				temp = input.nextLine();
				Guess = temp.charAt(0);
			}
			for(int i = 0; i < LastChar; i++){
				if(Guess == WordList[i]) {
					System.out.println(Guess + " is in the word!");
					Current_Position = i;
					FinalWord[i] = Guess;
					System.out.println(FinalWord);
					System.out.println(FinalWord);
					System.out.print("Enter another Guess: ");
					Guesses++;
					//for loop to check if the word is completed out not.. (Check for _);

				}
			}

		}
	}
}