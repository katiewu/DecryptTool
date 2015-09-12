package edu.upenn.cis573.FrequencyModel;

import java.util.Arrays;
import java.util.Comparator;

public class FrequencyResult {
	private LetterFrequency[] result;
	
	public FrequencyResult(){
		result = new LetterFrequency[26];
		for(int i=0;i<26;i++){
			char c = 'a'+0;
			result[i] = new LetterFrequency(c);
		}
	}
	
	public void increCount(char c){
		int index = c - 'a';
		result[index].increCount();
	}
	
	public void sort(){
		Arrays.sort(result, new Comparator<LetterFrequency>(){

			@Override
			public int compare(LetterFrequency o1, LetterFrequency o2) {
				return o1.getCount() - o2.getCount();
			}
			
		});
	}

}
