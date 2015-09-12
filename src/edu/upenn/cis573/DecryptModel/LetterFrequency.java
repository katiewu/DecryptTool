package edu.upenn.cis573.DecryptModel;

public class LetterFrequency {
	private char c;
	private int count;
	
	public LetterFrequency(char c){
		this.c = c;
		this.count = 0;
	}
	
	public void increCount(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
	
	public char getChar(){
		return c;
	}

}
