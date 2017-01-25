package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.core.GameLauncher;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;

/**
 * @author Azias
 * Copyright (c) AziasCreations 2014
 */
public class Start {	
	public static void main(String[] args) {
		//GameController.init();
		//Options.launch();
		MiscDatas.windowSizeX = 1280;
		MiscDatas.windowSizeY = 720;
		MiscDatas.windowFS = false;
		GameLauncher.launch();
	}
}