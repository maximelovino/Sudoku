package ch.hepia.it.Sudoku.menu;

import ch.hepia.it.Sudoku.game.Sudoku;

import java.io.IOException;

public class Solver {

	public static void main (String[] args) {
		try {
			Sudoku game = new Sudoku("data/sudoku.txt");
			System.out.println(game);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
