package ch.hepia.it.Sudoku.gui;

import ch.hepia.it.Sudoku.game.Sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuPanel extends JPanel {
	private Sudoku sudoku;
	private final int CASE_SIZE = 80;

	public SudokuPanel (Sudoku sudoku) {
		super();
		this.sudoku = sudoku;
		this.setPreferredSize(new Dimension(780, 780));
	}
	public void setSudoku (Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	@Override
	protected void paintComponent (Graphics g) {
		int[][] board = sudoku.getBoard();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int shiftH = i / 3 * 20;
				int shiftV = j / 3 * 20;
				g.drawRect(i * CASE_SIZE + shiftH, j * CASE_SIZE + shiftV, CASE_SIZE, CASE_SIZE);
				int temp = board[i][j];
				if (temp != 0) {
					g.drawString(String.valueOf(temp), i * CASE_SIZE + CASE_SIZE / 2 + shiftH, j * CASE_SIZE + CASE_SIZE / 2 + shiftV);
				}
			}
		}
	}
}
