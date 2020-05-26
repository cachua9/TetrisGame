package tetris.engine.algorithm;

import java.awt.Graphics;

public class Board {
	
	private InGame inGame;
	
	private final int width = 10, heigth = 20;
	private int[][] matrix;
	
	public Board(InGame inGame) {
		this.inGame = inGame;
		matrix = new int[heigth][width];
	}	
	
	public void update() {
		//TODO
	}
	
	public void paint(Graphics g) {
		//TODO
	}
	
	public void setShapeToBoard(Shape shape) {
		//TODO
	}
	
	public int checkLine() {
		//TODO
		return 0;
	}

	public int[][] getMatrix() {
		return matrix;
	}

}
