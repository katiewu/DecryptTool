package edu.upenn.cis573.DecryptModel;

import java.util.Iterator;

import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Output.Output;

public class FrequencyModel implements DecryptModel{

	private Input testInput;
	private Corpus<Input> corpus;
	private FrequencyResult testResult;
	private FrequencyResult corpusResult;
	private char[] mapping;
	
	public FrequencyModel(Input testInput, Corpus<Input> corpus){
		this.testInput = testInput;
		this.corpus = corpus;
		testResult = new FrequencyResult();
		corpusResult = new FrequencyResult();
	}
	
	private void generateEncryptResult(Input input){
//		System.out.println(input.getName());
		testResult.analyzeInput(input);
		testResult.sort();
//		System.out.println(testResult);
	}
	
	private void generateCorpusResult(){
		Iterator<Input> iterator = corpus.iterator();
		while(iterator.hasNext()){
			Input input = iterator.next();
//			System.out.println(input.getName());
			corpusResult.analyzeInput(input);
		}
		corpusResult.sort();
//		System.out.println(corpusResult);
	}
	
	private void mappingResult(){
		mapping = corpusResult.mapping(testResult);
//		System.out.println(mapping);
	}

	@Override
	public void buildModel() {	
//		System.out.println("encrypt file frequency result");
		generateEncryptResult(testInput);		
//		System.out.println("corpus frequency result");
		generateCorpusResult();
		
		mappingResult();
	}

	@Override
	public void decrypt(Input input, Output output) {
		input.open();
		output.open();
		String line = null;
		while((line = input.readLine()) != null){
			String decryptText = decryptLine(line);
			output.writeLine(decryptText);
		}
		input.close();
		output.close();
	}
	
	private String decryptLine(String line){
		line = line.toLowerCase();
		char[] charArray = line.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c:charArray){
			if(Character.isLetter(c)){
				int index = c - 'a';
				char ct = mapping[index];
				sb.append(ct);
			}
			else sb.append(c);
		}
		return new String(sb);
	}
	
	
}
