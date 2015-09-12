package edu.upenn.cis573.hwk1;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1){
			System.out.println("The number of arguments is wrong. Please input folder name!");
		}
		String folder = args[0];
		File folderPath = new File(folder);
		if(!folderPath.exists() || !folderPath.isDirectory()){
			System.out.println("The folder doesn't exist!");
		}
		if(!folderPath.canRead()){
			System.out.println("The folder cannot be read! Permission denied!");
		}
		
	}

}
