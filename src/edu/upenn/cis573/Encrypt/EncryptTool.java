package edu.upenn.cis573.Encrypt;

import edu.upenn.cis573.Input.Input;

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
	
	public void encrypt(Input input){
		String line = null;
		while((line = input.readLine()) != null){
			String encryptText = encryptLine(line);
			
		}
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
		String line = "Shakespeare homepage | All's Well That Ends Well | Entire play";
		System.out.println(line.toLowerCase());
		System.out.println(encryptLine(line));
	}
}
