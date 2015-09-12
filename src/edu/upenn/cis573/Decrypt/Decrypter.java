package edu.upenn.cis573.Decrypt;

import edu.upenn.cis573.DecryptModel.DecryptModel;
import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Output.Output;

public class Decrypter{
	
	private static Decrypter decrypter = null;
	
	private Decrypter(){
		
	}
	
	public static Decrypter getDecrypter(){
		if(decrypter == null){
			decrypter = new Decrypter();
		}
		return decrypter;
	}
	
	
	public void decrypt(Input input, Output output, DecryptModel model) {
		model.buildModel();
		model.decrypt(input, output);
	}
	
}
