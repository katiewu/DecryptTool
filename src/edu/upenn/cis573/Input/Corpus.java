package edu.upenn.cis573.Input;

import java.util.Iterator;
import java.util.List;

public class Corpus<Input> implements Iterable<Input> {
	private List<Input> corpus;
	private int size;
	
	public Corpus(List<Input> corpus){
		this.corpus = corpus;
		this.size = corpus.size();
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
