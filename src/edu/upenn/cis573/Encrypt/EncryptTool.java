package edu.upenn.cis573.Encrypt;

import java.io.File;

import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Input.TextInput;
import edu.upenn.cis573.Output.Output;
import edu.upenn.cis573.Output.TextOutput;

public class EncryptTool {

	private static EncryptTool encryptTool = null;
	
	private EncryptTool(){
		
	}
	
	public EncryptTool getEncryptTool(){
		if(encryptTool == null){
			encryptTool = new EncryptTool();
		}
		return encryptTool;
	}
	
	public static void encrypt(Input input, Output output){
		String line = null;
		input.open();
		output.open();
		while((line = input.readLine()) != null){
			String encryptText = encryptLine(line);
			output.writeLine(encryptText);
		}
		input.close();
		output.close();
	}
	
	public static String encryptLine(String line){
		StringBuilder sb = new StringBuilder();
		line = line.toLowerCase();
		char[] charArray = line.toCharArray();
		for(char c:charArray){
			if(Character.isLetter(c)){
				char ct = (char) ((c - 'a' + 1)%26 + 'a');
				sb.append(ct);
			}
			else sb.append(c);
		}
		return new String(sb);
	}
	
	public static void main(String[] args){
		String input = "/Users/Jingyuan/Desktop/courses/CIS 573/Homework 1/corpus/allswell.txt";
		File inputFile = new File(input);
		Input textFile = new TextInput(inputFile);
		String output = "encryptFile.txt";
		Output outputFile = new TextOutput(output);
		encrypt(textFile, outputFile);
	}
}
