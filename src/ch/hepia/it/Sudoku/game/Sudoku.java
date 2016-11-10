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

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.domains[i][j] = new Domain();
			}
		}

		String line;
		int lineCnt = 0;
		while ((line=reader.readLine())!=null){
			String[] strArray = line.split(" ");

			for (int i = 0; i < strArray.length; i++) {
				this.board[lineCnt][i] = strArray[i].equals("-") ? 0 : Integer.valueOf(strArray[i]);
				if (this.board[lineCnt][i]!=0){
					emptyCases--;
					addConstraint(this.board[lineCnt][i],lineCnt,i);
				}
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

	public void addConstraint(int value, int line, int column){
		for (int i = 0; i < this.domains.length; i++) {
			for (int j = 0; j < this.domains[i].length; j++) {
				if (i == line || j == column || (i / 3 == line / 3 && j / 3 == column /3))
					domains[i][j].remove(value);
			}
		}
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

	public Position getMostConstrainedCase(){
		int smallest = Integer.MAX_VALUE;
		Position boardCase = new Position(0,0);
		for (int i = 0; i < this.domains.length; i++) {
			for (int j = 0; j < this.domains[i].length; j++) {
				if (this.domains[i][j].size() < smallest && this.board[i][j] == 0){
					boardCase.setLine(i);
					boardCase.setColumn(j);
					smallest = this.domains[i][j].size();
				}
			}
		}
		return boardCase;
	}

	public boolean fillCase(int line, int column, int value){
		//TODO check if we should return the copy here, or make the copy and call this
		this.board[line][column] = value;
		addConstraint(value, line, column);
		return isValid();
	}

	public Domain getDomainOfCase(int line, int column){
		return this.domains[line][column];
	}
}
