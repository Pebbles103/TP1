package org.ucm.tp1.view;

import org.ucm.tp1.logic.Game;
import org.ucm.tp1.objects.Slayer;
import org.ucm.tp1.objects.Vampire;
import org.ucm.tp1.utils.MyStringUtils;


public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public GamePrinter (Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
		this.board = new String[numCols][numRows];
	}
	
	private void encodeGame(Game game) {
		
		for(int i = 0; i < numCols; i++) {
			for(int j = 0; j < numRows; j++) {
				Vampire v = game.board.buscarVampire(i, j);
				Slayer s = game.board.buscarSlayer(i, j);
				if(v != null) {
					this.board[i][j] = "V ["+v.getHP()+"]";
				}
				else if(s != null) {
					this.board[i][j] = "S ["+s.getHP()+"]";
				}
				else {
					this.board[i][j] = "";
				}
			}
		}
	}
	
	 public String toString() {
		encodeGame(this.game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(this.board[j][i], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }
	 

}


