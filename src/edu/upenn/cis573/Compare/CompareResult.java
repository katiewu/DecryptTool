package edu.upenn.cis573.Compare;

public class CompareResult {
	private String filename;
	private int correct;
	private int wrong;
	
	public CompareResult(String filename, int correct, int wrong){
		this.filename = filename;
		this.correct = correct;
		this.wrong = wrong;
	}

	@Override
	public String toString() {
		return filename+": "+correct+" correct, "+wrong+" incorrect";
	}
	
}
