package edu.upenn.cis573.hwk1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.upenn.cis573.Compare.CompareResult;
import edu.upenn.cis573.Input.Corpus;
import edu.upenn.cis573.Input.Input;
import edu.upenn.cis573.Input.TextInput;

public class Main {
	
	public static List<Input> getFileList(File folderPath){
		File[] listOfFiles = folderPath.listFiles();
		List<Input> inputs = new ArrayList<Input>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {
				Input file = new TextInput(listOfFiles[i]);
				inputs.add(file);
			}
		}
		return inputs;
	}
	
	public static void test(List<Input> fileList){
		int correct = 0;
		int incorrect = 0;
		double accuracy = 0;
		for(int i=0;i<fileList.size();i++){
			Input testFile = fileList.get(i);
			Corpus<Input> corpus = new Corpus<Input>();
			for(int j=0;j<fileList.size();j++){
				if(j!=i){
					corpus.addInput(fileList.get(j));
				}
			}
			CrossValidation crossValidation = new CrossValidation(testFile, corpus);
			CompareResult result = crossValidation.run();
			correct += result.getCorrect();
			incorrect += result.getIncorrect();
		}
		accuracy = correct/(double)(correct+incorrect);
		System.out.println("Total: "+correct+" correct, "+incorrect+" incorrect");
		System.out.format("Accuracy: %.2f%%", accuracy*100);
	}
	
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("The number of arguments is wrong. Please input folder name!");
			return;
		}
		String folder = args[0];
		File folderPath = new File(folder);
		if(!folderPath.exists() || !folderPath.isDirectory()){
			System.out.println("The folder doesn't exist!");
			return;
		}
		if(!folderPath.canRead()){
			System.out.println("The folder cannot be read! Permission denied!");
			return;
		}
		
		List<Input> lst = getFileList(folderPath);
		test(lst);
	}

}
