package edu.upenn.cis573.Output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextOutput implements Output{
	
	private String outputFile;
	private BufferedWriter output;
	
	public TextOutput(String outputFile){
		this.outputFile = outputFile;
	}

	@Override
	public void open() {
		File file = new File(outputFile);
		try {
			output = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeLine(String line) {
		try {
			output.write(line);
			output.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}

	@Override
	public void close() {
		if(output != null)
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
