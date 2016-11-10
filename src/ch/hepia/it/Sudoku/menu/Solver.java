package ch.hepia.it.Sudoku.menu;

import ch.hepia.it.Sudoku.game.Position;
import ch.hepia.it.Sudoku.game.Sudoku;

import java.io.IOException;

public class Solver {

	public static void main (String[] args) {
		try {
			Sudoku game = new Sudoku("data/sudoku.txt");
			System.out.println(game);
			System.out.println("Empty cases: "+game.getEmptyCases());
			Position constrained = game.getMostConstrainedCase();
			System.out.println(constrained);
			System.out.println(game.getDomainOfCase(constrained.getLine(),constrained.getColumn()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
