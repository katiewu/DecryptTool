package edu.upenn.cis573.Compare;

import edu.upenn.cis573.Input.Input;

public class CipherComparator {
	
	private static CipherComparator comparator = null;
	
	private CipherComparator(){
		
	}
	
	public static CipherComparator getCipherComparator(){
		if(comparator == null){
			comparator = new CipherComparator();
		}
		return comparator;
	}
	
	public CompareResult compare(Input input1, Input input2){
		String line1 = null;
		String line2 = null;
		int correct = 0;
		int incorrect = 0;
		input1.open();
		input2.open();
		while((line1 = input1.readLine()) != null && (line2 = input2.readLine()) != null){
			line1 = line1.toLowerCase();
			line2 = line2.toLowerCase();
			char[] charArray1 = line1.toCharArray();
			char[] charArray2 = line2.toCharArray();
			for(int i=0;i<charArray1.length;i++){
				if(Character.isLetter(charArray1[i])){
					if(charArray1[i] == charArray2[i]){
						correct++;
					}
					else{
						incorrect++;
					}
				}
			}
		}
		input1.close();
		input2.close();
		CompareResult result = new CompareResult(input1.getName(), correct, incorrect);
		System.out.println(result);
		return result;
	}
	
}
