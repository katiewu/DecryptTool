package edu.upenn.cis573.Compare;

import edu.upenn.cis573.Input.Input;

public class CipherComparator {
	
	CipherComparator comparator = null;
	
	private CipherComparator(){
		
	}
	
	public CipherComparator getCipherComparator(){
		return comparator;
	}
	
	public void compare(Input input1, Input input2){
		String line1 = null;
		String line2 = null;
		int correct = 0;
		int wrong = 0;
		while((line1 = input1.readLine()) != null && (line2 = input2.readLine()) != null){
			char[] charArray1 = line1.toCharArray();
			char[] charArray2 = line2.toCharArray();
			for(int i=0;i<charArray1.length;i++){
				if(Character.isLetter(charArray1[i])){
					if(charArray1[i] == charArray2[i]){
						correct++;
					}
					else{
						wrong++;
					}
				}
			}
		}
	}
	
}
