package ch.hepia.it.Sudoku.game;

/**
 * Exception that will be generated in case of problem with the sudoku file
 */
public class FileFormatException extends Exception {
	public FileFormatException () {
		super("The sudoku file was not formatted correctly");
	}

	public FileFormatException (String message) {
		super(message);
	}
}
