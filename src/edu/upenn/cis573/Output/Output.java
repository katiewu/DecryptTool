package edu.upenn.cis573.Output;

public interface Output {
	
	public void open();
	
	public void writeLine(String line);
	
	public void close();
}
