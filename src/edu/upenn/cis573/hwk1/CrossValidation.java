package edu.upenn.cis573.hwk1;

import java.util.Iterator;

import edu.upenn.cis573.FrequencyModel.FrequencyResult;
import edu.upenn.cis573.FrequencyModel.InputAnalysis;
import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.Input;

public class CrossValidation {
	
	private Input testInput;
	private Corpus<Input> corpus;
	private FrequencyResult testResult;
	private FrequencyResult corpusResult;
	private char[] mapping;
	
	public CrossValidation(Input testInput, Corpus<Input> corpus){
		this.testInput = testInput;
		this.corpus = corpus;
		testResult = new FrequencyResult();
		corpusResult = new FrequencyResult();
	}
	
	public void generateTestResult(){
		InputAnalysis testAnalysis = new InputAnalysis(testResult);
		testAnalysis.analyzeInput(testInput);
		testResult.sort();
	}
	
	public void generateCorpusResult(){
		InputAnalysis corpusAnalysis = new InputAnalysis(corpusResult);
		Iterator<Input> iterator = corpus.iterator();
		while(iterator.hasNext()){
			Input input = iterator.next();
			corpusAnalysis.analyzeInput(input);
		}
		corpusResult.sort();
	}
	
	public void mappingResult(){
		mapping = corpusResult.mapping(testResult);
	}
	
}
