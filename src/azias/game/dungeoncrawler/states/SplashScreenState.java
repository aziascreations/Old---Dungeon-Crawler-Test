package azias.game.dungeoncrawler.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import azias.game.dungeoncrawler.FontCreator;
import azias.game.dungeoncrawler.MusicChanger;
import azias.game.dungeoncrawler.core.ContentLoader;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.dataproxies.MusicDatas;
import azias.game.dungeoncrawler.renders.ImageRender;

public class SplashScreenState extends BasicGameState implements MusicListener
{
	private Image splash, background;
	private int SizeY = MiscDatas.windowSizeY;
	private final int stepDelay = 200;
	private int elapsedTime;
	private int step = 0;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("assets/gui/splash/Splash_Back.png");
		splash = new Image("assets/gui/splash/Splash_2.png");
		FontCreator.createFonts();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ImageRender.renderBackgroundFill(background);
		ImageRender.renderCenteredImage(splash, 0, 0);
		switch(step)
		{
		case 0:
			MiscDatas.font_24.drawString(10, SizeY-30, "Loading Music...", Color.black);
			break;
		case 1:
			MiscDatas.font_24.drawString(10, SizeY-30, "Loading Sounds...", Color.black);
			break;
		case 2:
			MiscDatas.font_24.drawString(10, SizeY-30, "Loading Graphics...", Color.black);
			break;
		case 3:
			MiscDatas.font_24.drawString(10, SizeY-30, "Loading Game Options...", Color.black);
			break;
		case 4:
			MiscDatas.font_24.drawString(10, SizeY-30, "Starting Game...", Color.black);
			break;
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		elapsedTime += delta;
		
		if(elapsedTime >= stepDelay) {
			switch(step)
			{
				case 0:
					ContentLoader.loadMusic();
					step++;
					break;
				case 1:
					ContentLoader.loadSounds();
					step++;
					break;
				case 2:
					ContentLoader.loadGraphics();
					step++;
					break;
				case 3:
					ContentLoader.loadOptions();
					step++;
					break;
				case 4:
					MusicChanger.startMusic(MusicDatas.songMenu, this);
					game.enterState(MiscDatas.MainMenuStateID);
					break;
			}
		}
	}

	@Override
	public int getID() {
		return MiscDatas.SplashScreenStateID;
	}

	@Override
	public void musicEnded(Music music)
	{}

	@Override
	public void musicSwapped(Music music, Music newMusic)
	{}
}