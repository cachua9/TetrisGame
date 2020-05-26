package tetris.engine.gui.screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tetris.engine.FileLoader;
import tetris.engine.Game;
import tetris.engine.algorithm.InGame;

public class GameScr extends Screen{
	
	private BufferedImage backGround;
	private InGame inGame;
	
	private int level = 1;

	public GameScr(Game game) {
		super(game);
		inGame = new InGame(this, level);
		backGround = FileLoader.loadImage("/backGround.png");
	}

	@Override
	public void update() {
		inGame.update();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(backGround, 0, 0, game.getWindow().getCanvas().getWidth(), game.getWindow().getCanvas().getHeight(), null);		
		
		//TODO anything paint
		
		inGame.paint(g);
		
	}

}