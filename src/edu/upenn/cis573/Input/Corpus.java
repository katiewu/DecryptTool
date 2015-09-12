package edu.upenn.cis573.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corpus<Input> implements Iterable<Input> {
	private List<Input> corpus;
	private int size;
	
	public Corpus(){
		this.corpus = new ArrayList<Input>();
		this.size = corpus.size();
	}
	
	public void addInput(Input input){
		corpus.add(input);
	}

	@Override
	public Iterator<Input> iterator() {
		Iterator<Input> it = new Iterator<Input>(){
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				if(currentIndex < size) return true;
				return false;
			}

			@Override
			public Input next() {
				return corpus.get(currentIndex++);
			}
			
		};
		return it;
	}
	
}
