package azias.game.dungeoncrawler;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Version;

public class GameController {

	public static void init() {
		System.out.println("JInput version: " + Version.getVersion());
		ControllerEnvironment ce = ControllerEnvironment.getDefaultEnvironment();
		Controller[] cs = ce.getControllers();
		for (int i = 0; i < cs.length; i++) {
			System.out.println(i + ". " + cs[i].getName() + ", " + cs[i].getType() );
		}
	}
}
