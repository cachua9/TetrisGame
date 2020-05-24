package tetris.engine.algorithm;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tetris.engine.gui.screen.GameScr;

public class InGame {
	
	private GameScr gameScr;
	
	private Board board;
	private Shape[] shapes = new Shape[7];
	private Shape currentShape, nextShape;
	
	private BufferedImage blocks;
	private final int blockSize = 30;
	
	private int score;
	
	public InGame(GameScr gameScr) {
		
		this.gameScr = gameScr;
		
		//TODO
	}
	
	public void update() {
		//TODO
		keyUpdate();
	}
	
	public void paint(Graphics g) {
		//TODO
	}
	
	private void keyUpdate() {
		//TODO
	}
	
	private void setCurrentShape() {
		currentShape = nextShape;
		//TODO
		setNextShape();
	}
	private void setNextShape() {
		//TODO
	}

	public Board getBoard() {
		return board;
	}

	public BufferedImage getBlocks() {
		return blocks;
	}

	public int getBlockSize() {
		return blockSize;
	}

}
