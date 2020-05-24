package tetris.engine.algorithm;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shape {
	
	private InGame inGame;
	private int[][] matrix;
	private BufferedImage block;
	private int color;
	private int x, y;
	//private int width, height;
	private int minX, minY, maxX, maxY;
	
	private int deltaX;
	
	private int normal = 600, fast = 50;
	private int delay;
	
	private long now, lastTime;
	
	private boolean collision = false;
	
	public Shape(int[][] matrix, BufferedImage block, InGame inGame, int color) {
		this.matrix = matrix;
		this.block = block;
		this.color = color;
		this.inGame = inGame;
		deltaX = 0;
		x = 3; y = 0;
		delay = normal;
		now = System.currentTimeMillis();
		lastTime = now;
		//width = 0; height = 0;
		minX = 0; minY = 0; maxX = 0; maxY = 0;
		//TODO
	}
	
	private void update() {
		//TODO
	}
	
	private void paint(Graphics g) {
		//TODO
	}
	
	private void setSizeShape(int[][] tmp) {
		
	}
	
	public void rotateShape() {
		int[][] rotatedShape = transposeMatrix(matrix);
		rotatedShape = reverseRows(rotatedShape);
		//TODO
	}
	private int[][] transposeMatrix(int[][] tmp) {
		//TODO
		return tmp;
	}
	private int[][] reverseRows(int[][] tmp){
		//TODO
		return tmp;
	}
	
	public void speedUp() {
		delay = fast;
	}
	
	public void speedDown() {
		delay = normal;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public BufferedImage getBlock() {
		return block;
	}

	public int getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

}
