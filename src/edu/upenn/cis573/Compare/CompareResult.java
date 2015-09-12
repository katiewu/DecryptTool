package edu.upenn.cis573.Compare;

public class CompareResult {
	private String filename;
	private int correct;
	private int incorrect;
	private double accuracy;
	
	public CompareResult(String filename, int correct, int incorrect){
		this.filename = filename;
		this.correct = correct;
		this.incorrect = incorrect;
		this.accuracy = correct/(double)(correct+incorrect);
	}
	
	public int getCorrect(){
		return correct;
	}
	
	public int getIncorrect(){
		return incorrect;
	}

	@Override
	public String toString() {
		return filename+": "+correct+" correct, "+incorrect+" incorrect ";
	}
	
}
