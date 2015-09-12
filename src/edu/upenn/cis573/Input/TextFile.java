package edu.upenn.cis573.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFile implements Input {

	private String filename;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public TextFile(String filename) {
		this.filename = filename;

	}

	@Override
	public void open() {
		try {
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String readLine() {
		String line;
		try {
			line = bufferedReader.readLine();
			return line;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void close() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
