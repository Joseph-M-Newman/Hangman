package com.company;

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
	    String Hangman_Word = "";
	    String newHangmanWord = "";
	    Scanner input = new Scanner(System.in);
	    System.out.println("----------Welcome to Hangman!----------");
	    System.out.print("Please enter a word: ");
	    Hangman_Word = input.nextLine();
	    System.err.println(Hangman_Word);
	    int forloop = 1;
	    int CountOfWord = Hangman_Word.length()-1;
	    for(int i = 0; i < CountOfWord;i++) {
	    	if(i <= CountOfWord) {
	    		if(Hangman_Word.equals(" ")) {

				}



			}

		}
	    System.err.println(newHangmanWord);

	    while(true)
		{

		}
    }
}
