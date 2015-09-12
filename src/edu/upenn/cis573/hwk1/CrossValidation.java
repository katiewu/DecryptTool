package edu.upenn.cis573.hwk1;

import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.TextFile;

public class CrossValidation {
	
	private TextFile document;
	private Corpus corpus;
	
	public CrossValidation(TextFile document, Corpus corpus){
		this.document = document;
		this.corpus = corpus;
	}
}
