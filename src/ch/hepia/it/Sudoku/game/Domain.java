package ch.hepia.it.Sudoku.game;

import java.util.HashSet;

public class Domain {
	HashSet<Integer> values;

	public Domain(){
		this.values = new HashSet<>();
		initDomain();
	}

	public Domain(Domain domain){
		this.values = new HashSet<>(domain.getValues());
	}

	private void initDomain () {
		for (int i = 0; i < 9; i++) {
			values.add(i+1);
		}
	}

	public void remove(Integer x){
		this.values.remove(x);
	}

	public void clearAll(){
		this.values.clear();
	}

	public boolean contains(Integer x){
		return this.values.contains(x);
	}

	public int size(){
		return this.values.size();
	}

	@Override
	public String toString () {
		return values.toString();
	}

	public HashSet<Integer> getValues () {
		return values;
	}
}
