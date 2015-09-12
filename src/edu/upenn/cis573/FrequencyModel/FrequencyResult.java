package edu.upenn.cis573.FrequencyModel;

import java.util.Arrays;
import java.util.Comparator;

import edu.upenn.cis573.Input.Input;

public class FrequencyResult {
	private LetterFrequency[] result;
	
	public FrequencyResult(){
		result = new LetterFrequency[26];
		for(int i=0;i<26;i++){
			char c = (char) ('a' + i);
			result[i] = new LetterFrequency(c);
		}
	}
	
	public char getLetter(int i){
		LetterFrequency lf = result[i];
		return lf.getChar();
	}
	
	public void increCount(char c){
		int index = c - 'a';
		result[index].increCount();
	}
	
	public void analyzeInput(Input input){
		String line;
		while((line = input.readLine()) != null){
			line = line.toLowerCase();
			char[] charArray = line.toCharArray();
			for(char c:charArray){
				if(Character.isLetter(c)){
					increCount(c);
				}
			}
		}
	}
	
	public void sort(){
		Arrays.sort(result, new Comparator<LetterFrequency>(){

			@Override
			public int compare(LetterFrequency o1, LetterFrequency o2) {
				return o1.getCount() - o2.getCount();
			}
			
		});
	}
	
	public char[] mapping(FrequencyResult testResult){
		char[] match = new char[26];
		for(int i=0;i<26;i++){
			char tc = testResult.getLetter(i);
			char cc = this.getLetter(i);
			int index = tc - 'a';
			match[index] = cc;
		}
		return match;
	}
	
	

}
