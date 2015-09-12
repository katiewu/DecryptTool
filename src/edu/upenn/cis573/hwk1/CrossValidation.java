package edu.upenn.cis573.hwk1;

import java.util.Iterator;

import edu.upenn.cis573.Compare.CipherComparator;
import edu.upenn.cis573.Compare.CompareResult;
import edu.upenn.cis573.Decrypt.DecryptTool;
import edu.upenn.cis573.Decrypt.Decrypter;
import edu.upenn.cis573.DecryptModel.DecryptModel;
import edu.upenn.cis573.DecryptModel.FrequencyModel;
import edu.upenn.cis573.DecryptModel.FrequencyResult;
import edu.upenn.cis573.Encrypt.Encrypter;
import edu.upenn.cis573.Encrypt.SimpleEncrypter;
import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Input.TextInput;
import edu.upenn.cis573.Output.Output;
import edu.upenn.cis573.Output.TextOutput;

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
	
	public CompareResult run(){
		// encrypt
		Encrypter encrypter = new SimpleEncrypter();
		Output encryptFile = new TextOutput("Encrypt.txt");
		encrypter.encrypt(testInput, encryptFile);
		
		Input encryptInput = new TextInput("Encrypt.txt");
		Output decryptOutput = new TextOutput("Decrypt.txt");
		DecryptModel model = new FrequencyModel(encryptInput, corpus);
		
		Decrypter decrypter = Decrypter.getDecrypter();
		decrypter.decrypt(encryptInput, decryptOutput, model);

		
		Input testDecryptFile = new TextInput("Decrypt.txt");
		CipherComparator comparator = CipherComparator.getCipherComparator();
		CompareResult result = comparator.compare(testInput, testDecryptFile);
		return result;
	}
	
	private void generateEncryptResult(Input input){
		testResult.analyzeInput(input);
		testResult.sort();
//		System.out.println(testResult);
	}
	
	private void generateCorpusResult(){
		Iterator<Input> iterator = corpus.iterator();
		while(iterator.hasNext()){
			Input input = iterator.next();
			corpusResult.analyzeInput(input);
		}
		corpusResult.sort();
//		System.out.println(corpusResult);
	}
	
	private void mappingResult(){
		mapping = corpusResult.mapping(testResult);
//		System.out.println(mapping);
	}
	
}
