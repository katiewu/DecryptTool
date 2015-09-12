package edu.upenn.cis573.FrequencyModel;

import edu.upenn.cis573.Input.Input;

public class InputAnalysis {
	private FrequencyResult result;
	
	public InputAnalysis(FrequencyResult result){
		this.result = result;
	}
	
	public void analyzeInput(Input input){
		String line;
		while((line = input.readLine()) != null){
			line = line.toLowerCase();
			char[] charArray = line.toCharArray();
			for(char c:charArray){
				if(Character.isLetter(c)){
					result.increCount(c);
				}
			}
		}
	}

}
