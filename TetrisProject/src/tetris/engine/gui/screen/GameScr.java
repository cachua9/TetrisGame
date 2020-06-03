package tetris.engine.gui.screen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

import tetris.engine.FileLoader;
import tetris.engine.Game;
import tetris.engine.algorithm.InGame;
import tetris.engine.gui.MyButton;

public class GameScr extends Screen{
	
	
	private BufferedImage backGround;
	private BufferedImage gameOver;
	private BufferedImage backToMenu;
	private BufferedImage pause;
	private BufferedImage speaker;
	private BufferedImage menuSmall;
	private BufferedImage playContinue;
	private BufferedImage playNewGame;
	private BufferedImage quit;
	private Clip music;
	private InGame inGame;
	
	private ArrayList<MyButton> buttons = new ArrayList<MyButton>();
	private ArrayList<MyButton> buttons2 = new ArrayList<MyButton>();
	private MyButton btnBackToMenuButton;
	private MyButton btnSpeakButton;
	private MyButton btnPauseButton;
	private MyButton btnPlayContinueButton;
	private MyButton btnQuitButton;
	private MyButton btnPlayNewGameButton;
	
	private boolean isPause = false;
	private int isMute = 0;
	private boolean isBackToMenu = false;
	private int level = 1;
	

	public GameScr(Game game) {
		super(game);
		inGame = new InGame(this, level);
		backGround = FileLoader.loadImage("/backGround.png");
		gameOver = FileLoader.loadImage("/gameover.png");
		backToMenu = FileLoader.loadImage("/backToMenu.png");
		pause = FileLoader.loadImage("/pause.png");
		speaker = FileLoader.loadImage("/speaker.png");
		playContinue = FileLoader.loadImage("/playContinue.png");
		menuSmall = FileLoader.loadImage("/bgr1.png");
		quit = FileLoader.loadImage("/quit.jpeg");
		playNewGame = FileLoader.loadImage("/playNewGame.jpg");
		
		music = FileLoader.LoadSound("/alan1.wav");
		music.loop(Clip.LOOP_CONTINUOUSLY);
		
		
		
		btnBackToMenuButton = new MyButton(game, backToMenu, 350, 520, 50, 50);
		btnPauseButton = new MyButton(game,pause, 350, 360, 50, 50);
		btnSpeakButton = new MyButton(game, speaker.getSubimage(isMute * 512, 0, 512, 512), 350, 440, 50, 50);
		btnPlayContinueButton = new MyButton(game, playContinue, 60, 150, 200, 50);
		btnQuitButton = new MyButton(game, quit, 100, 250, 100, 50);
		btnPlayNewGameButton = new MyButton(game, playNewGame, 100, 200, 100, 50);
		
		buttons.add(btnBackToMenuButton);
		buttons.add(btnPauseButton);
		buttons.add(btnSpeakButton);
		
		
		buttons2.add(btnPlayContinueButton);
		buttons2.add(btnQuitButton);
		buttons2.add(btnPlayNewGameButton);
	}

	@Override
	public void update() {
		if(!inGame.isGameOver() && !isPause) {
			inGame.update();
		}
		if(buttons!=null) {
			for(MyButton button : buttons) {
				button.update();
			}
		}
		if(btnSpeakButton.isMouseDown()){
			isMute = 1 - isMute;
			btnSpeakButton.setImage(speaker.getSubimage(isMute * 512, 0,  512, 512));
			if(isMute == 1) {
				music.stop();
			}
			else {
				music.start();
				music.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}
		if(btnPauseButton.isMouseDown()) {
			isPause = !isPause;
		}
		if(btnBackToMenuButton.isMouseDown()) {
			isBackToMenu = true;
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(backGround, 0, 0, game.getWindow().getCanvas().getWidth(), game.getWindow().getCanvas().getHeight(), null);		
		
		//TODO anything paint
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(new Color(0, 0, 0, 100));
		for(int i =0; i<=inGame.getBoard().getHeigth(); i++) {
			g2d.drawLine(0,  i*inGame.getBlockSize(), inGame.getBoard().getWidth()*inGame.getBlockSize(), i*inGame.getBlockSize());
		}
		for(int j = 0; j <= inGame.getBoard().getWidth(); j++) {
			g2d.drawLine(j*inGame.getBlockSize(), 0, j*inGame.getBlockSize(), inGame.getBoard().getHeigth()*inGame.getBlockSize());
		}
		
		g.setFont(new Font("Georgia", Font.BOLD, 25));
		g.setColor(Color.WHITE);
		g.drawString("Level" + level, game.getWidth() - 125, 200);
		
		g.drawString("Score",  game.getWidth() - 125, 250);
		g.drawString(inGame.getScore() + "", game.getWidth() - 125, 280);
		
		inGame.paint(g);
		
		if(isPause) {
			g.drawImage(menuSmall, 10,  100,  300,  200,  null);
			if(buttons2 != null) {
				for(MyButton button: buttons2) {
					button.paint(g);
				}
			}
			if(btnPlayContinueButton.isMouseDown()) {
				isPause = !isPause;
				
			}
			if(btnPlayNewGameButton.isMouseDown()) {
				game.start();
			}
			if(btnQuitButton.isMouseDown()) {
				System.exit(0);
			}
		}
		
		if(isBackToMenu) {
			g.drawImage(gameOver,  20,  150,  267,  200,  null);
		}
		
		if(buttons != null) {
			for(MyButton button: buttons) {
				button.paint(g);
			}
		}
		if(inGame.isGameOver()) {
			g.drawImage(gameOver,  20,  150,  267,  200,  null);
		}
	
		
	
	}
	public void setNewGame(int level) {
		this.level = level;
		inGame = new InGame(this, level);
	}

}