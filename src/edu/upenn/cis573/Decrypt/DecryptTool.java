package edu.upenn.cis573.Decrypt;

import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Output.Output;

public class DecryptTool {

	private static DecryptTool decryptTool = null;
	
	private DecryptTool(){
		
	}
	
	public static DecryptTool getDecryptTool(){
		if(decryptTool == null){
			decryptTool = new DecryptTool();
		}
		return decryptTool;
	}
	
	public void decrypt(Input input, Output output, char[] mapping){
		input.open();
		output.open();
		String line = null;
		while((line = input.readLine()) != null){
			String decryptText = decryptLine(line, mapping);
			output.writeLine(decryptText);
		}
		input.close();
		output.close();
	}
	
	private String decryptLine(String line, char[] mapping){
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
