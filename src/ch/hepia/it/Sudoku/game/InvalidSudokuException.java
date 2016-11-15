package ch.hepia.it.Sudoku.game;

/**
 * Exception for an invalid (in the game sense) sudoku
 */
public class InvalidSudokuException extends Exception {
	public InvalidSudokuException () {
		super("Your entered sudoku is not valid");
	}
}
