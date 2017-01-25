package azias.game.dungeoncrawler.core.options;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import azias.game.dungeoncrawler.core.options.states.*;

public class Options extends StateBasedGame {

	public Options() {
		super("Options Test");
	}
	
	public void initStatesList(GameContainer container) {
		addState(new MainOptionsState());
	}
	
	public static void launch() {
		try {
			AppGameContainer container = new AppGameContainer(new Options());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}