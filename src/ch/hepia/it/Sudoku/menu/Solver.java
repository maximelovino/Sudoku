package ch.hepia.it.Sudoku.menu;

import ch.hepia.it.Sudoku.game.Domain;
import ch.hepia.it.Sudoku.game.Position;
import ch.hepia.it.Sudoku.game.Sudoku;

import java.io.IOException;
import java.util.Iterator;

public class Solver {

	public static void main (String[] args) {
		try {
			final long startTime = System.nanoTime();
			Sudoku game = new Sudoku("data/test2.txt");
			System.out.println(game);
			Sudoku solved = backtrackingSearch(game);
			System.out.println(solved);
			final long endTime = System.nanoTime();
			System.out.println(((endTime - startTime) / Math.pow(10, 9)) + " seconds to solve");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Sudoku backtrackingSearch (Sudoku game) {

		if (game.getEmptyCases() == 0) {
			return game;
		}

		Position bestCase = game.getMostConstrainedCase();

		if (bestCase != null) {
			Domain domain = game.getDomainOfCase(bestCase.getLine(), bestCase.getColumn());
			Iterator<Integer> iterator = domain.getValues().iterator();

			while (iterator.hasNext()) {
				Integer value = iterator.next();
				Sudoku current = new Sudoku(game);
				//System.out.println("insertion of "+value+" in cell"+bestCase.getLine()+","+bestCase.getColumn());
				current.fillCase(bestCase.getLine(), bestCase.getColumn(), value);
				Sudoku result = backtrackingSearch(current);
				if (result != null) {
					return result;
				}
			}
		}

		return null;
	}

}
