package edu.upenn.cis573.DecryptModel;

import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Output.Output;

public interface DecryptModel {
	
	public void buildModel();
	
	public void decrypt(Input input, Output output);

}
