package ch.hepia.it.Sudoku.game;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Sudoku {
	private final int SIZE = 9;
	private int[][] board = new int[SIZE][SIZE];
	private int emptyCases = (int) Math.pow(SIZE,2);
	private Domain[][] domains = new Domain[SIZE][SIZE];


	public Sudoku () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
	}

	public Sudoku (String filepath) throws IOException {
		//TODO add exception if file is not well done
		LineNumberReader reader = new LineNumberReader(new FileReader(filepath));

		String line;
		int lineCnt = 0;
		while ((line=reader.readLine())!=null){
			String[] strArray = line.split(" ");

			for (int i = 0; i < strArray.length; i++) {
				this.board[lineCnt][i] = strArray[i].equals("-") ? 0 : Integer.valueOf(strArray[i]);
				this.domains[lineCnt][i] = new Domain();
				if (this.board[lineCnt][i]!=0)
					emptyCases--;
					//TODO call function domainPropagation(int line, int col)
			}
			lineCnt++;
		}
		reader.close();
		//TODO check validity and throw exception if sudoku is not valid
	}

	public boolean isValid(){
		return false;
	}

	private boolean lineCheck(int line){
		return false;
	}

	private boolean colCheck(int column){
		return false;
	}

	private boolean subArrayCheck(int line, int column){
		return false;
	}

	public int getEmptyCases () {
		return emptyCases;
	}

	public boolean isFull(){
		return emptyCases == 0;
	}

	@Override
	public String toString () {
		String out = "";
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				out += this.board[i][j] == 0 ? "-" : String.valueOf(this.board[i][j]);
				out += j%3 == 2 ? "\t" : " ";
			}
			out += i%3 == 2 ? "\n\n" : "\n";
		}
		return out;
	}
}
