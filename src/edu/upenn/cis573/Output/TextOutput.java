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
	
	public static void main(String[] args) throws IOException{
		String text = "Hello world";
        BufferedWriter output = null;
        try {
            File file = new File("example.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) output.close();
        }
	}

}
