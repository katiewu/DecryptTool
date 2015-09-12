package edu.upenn.cis573.hwk1;

import java.util.Iterator;

import edu.upenn.cis573.Compare.CipherComparator;
import edu.upenn.cis573.Compare.CompareResult;
import edu.upenn.cis573.Decrypt.DecryptTool;
import edu.upenn.cis573.Encrypt.EncryptTool;
import edu.upenn.cis573.FrequencyModel.FrequencyResult;
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
		EncryptTool encryptTool = EncryptTool.getEncryptTool();
		String testInputName = testInput.getName();
		testInputName = testInputName.substring(0, testInputName.length()-4);
		String encryptFileName = testInputName + "Encrypt.txt";
		Output encryptFile = new TextOutput(encryptFileName);
		encryptTool.encrypt(testInput, encryptFile);
		
		Input testEncryptFile = new TextInput(encryptFileName);
		
//		System.out.println("encrypt file frequency result");
		generateEncryptResult(testEncryptFile);
		
//		System.out.println("corpus frequency result");
		generateCorpusResult();
		
		mappingResult();
		
		String decryptFileName = testInputName + "Decrypt.txt";
		Output decryptFile = new TextOutput(decryptFileName);
		DecryptTool decryptTool = DecryptTool.getDecryptTool();
		decryptTool.decrypt(testEncryptFile, decryptFile, mapping);
		
		Input testDecryptFile = new TextInput(decryptFileName);
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
