package ch.hepia.it.Sudoku.menu;

import ch.hepia.it.Sudoku.game.Domain;
import ch.hepia.it.Sudoku.game.Position;
import ch.hepia.it.Sudoku.game.Sudoku;

import java.util.Iterator;

public class Solver {
	private static boolean firstBestCaseOutputDone = false;

	public static void main (String[] args) {
		try {
			if (args.length < 1)
				throw new RuntimeException("No path of sudoku file specified");
			final String FILEPATH = args[0];
			final long startTime = System.nanoTime();
			Sudoku game = new Sudoku(FILEPATH);
			System.out.println(game);
			Sudoku solved = backtrackingSearch(game);
			System.out.println(solved);
			final long endTime = System.nanoTime();
			System.out.println(((endTime - startTime) / Math.pow(10, 9)) + " seconds to solve");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Sudoku backtrackingSearch (Sudoku game) {

		if (game.getEmptyCases() == 0) {
			return game;
		}

		Position bestCase = game.getMostConstrainedCase();

		if (!firstBestCaseOutputDone) {
			System.out.println("The first most constrained case is: " + bestCase);
			System.out.println();
			firstBestCaseOutputDone = true;
		}

		if (bestCase != null) {
			Domain domain = game.getDomainOfCase(bestCase.getLine(), bestCase.getColumn());
			Iterator<Integer> iterator = domain.getValues().iterator();

			while (iterator.hasNext()) {
				Integer value = iterator.next();
				Sudoku current = new Sudoku(game);
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
