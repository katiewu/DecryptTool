package edu.upenn.cis573.Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextInput implements Input {

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public TextInput(String filename){
		this.file = new File(filename);
	}
	
	public TextInput(File file) {
		this.file = file;
	}
	
	public String getName(){
		return file.getName();
	}

	@Override
	public void open() {
		try {
			fileReader = new FileReader(file);
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
