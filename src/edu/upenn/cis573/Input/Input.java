package edu.upenn.cis573.Input;

public interface Input {
	
	public String getName();

	public void open();
	
	public String readLine();
	
	public void close();
}
