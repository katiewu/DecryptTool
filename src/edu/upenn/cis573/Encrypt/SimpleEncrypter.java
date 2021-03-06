package edu.upenn.cis573.Encrypt;

import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Output.Output;

public class SimpleEncrypter implements Encrypter{

	@Override
	public void encrypt(Input input, Output output) {
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
	
	private String encryptLine(String line){
		StringBuilder sb = new StringBuilder();
		line = line.toLowerCase();
		char[] charArray = line.toCharArray();
		for(char c:charArray){
			if(Character.isLetter(c)){
				char ct = (char) ((c - 'a' + 2)%26 + 'a');
				sb.append(ct);
			}
			else sb.append(c);
		}
		return new String(sb);
	}

}
