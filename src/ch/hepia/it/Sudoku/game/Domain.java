package ch.hepia.it.Sudoku.game;

import java.util.HashSet;

public class Domain {
	HashSet<Integer> values;

	public Domain(){
		this.values = new HashSet<>();
		initDomain();
	}

	private void initDomain () {
		for (int i = 0; i < 9; i++) {
			values.add(i+1);
		}
	}

	public void remove(Integer x){
		this.values.remove(x);
	}

	public boolean contains(Integer x){
		return this.values.contains(x);
	}

	@Override
	public String toString () {
		return values.toString();
	}
}