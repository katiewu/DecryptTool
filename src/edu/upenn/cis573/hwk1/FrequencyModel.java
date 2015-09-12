package edu.upenn.cis573.hwk1;

import java.util.Iterator;

import edu.upenn.cis573.FrequencyModel.FrequencyResult;
import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.Input;

public class FrequencyModel {
	
	private Corpus<Input> corpus;
	private FrequencyResult corpusResult;
	
	public FrequencyModel(Corpus<Input> corpus){
		this.corpus = corpus;
		corpusResult = new FrequencyResult();
	}
	
	public FrequencyResult buildModel(){
		Iterator<Input> iterator = corpus.iterator();
		while(iterator.hasNext()){
			Input input = iterator.next();
			analyzeInput(input);
		}
		corpusResult.sort();
		return corpusResult;
	}
	
	private void analyzeInput(Input input){
		String line;
		while((line = input.readLine()) != null){
			line = line.toLowerCase();
			char[] charArray = line.toCharArray();
			for(char c:charArray){
				if(Character.isLetter(c)){
					corpusResult.increCount(c);
				}
			}
		}
	}

}
