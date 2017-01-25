package azias.game.dungeoncrawler.core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.states.*;

public class GameLauncher extends StateBasedGame {

	public GameLauncher() {
		super(MiscDatas.mainTitle);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new SplashScreenState());
		this.addState(new MainMenuState());
		this.addState(new NewGameMenuState());
		this.addState(new ClassChooserState());
		this.addState(new LoadSaveMenuState());
		this.addState(new OptionsMenuState());
		this.addState(new InGameState());
		this.enterState(MiscDatas.SplashScreenStateID);
	}
	
	public static void launch() {
		try {
			AppGameContainer container = new AppGameContainer(new GameLauncher());
			container.setDisplayMode(MiscDatas.windowSizeX, MiscDatas.windowSizeY, MiscDatas.windowFS);
			container.setIcon("assets/icons/icon16x.tga");
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}