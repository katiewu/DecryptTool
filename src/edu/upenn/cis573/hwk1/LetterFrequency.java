package edu.upenn.cis573.hwk1;

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

}
