package azias.game.dungeoncrawler;

import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.dataproxies.GameDatas;

public class GameDatasChanger {

	public static void changeSavesOptions(int par1) throws SlickException 
	{
		SavedState state;
		state = new SavedState("DCOptions");
		
		switch(par1) {
		case 1:
			GameDatas.saveFile1Created = true;
			state.setNumber("save1created", 1);
			break;
		case 2:
			GameDatas.saveFile2Created = true;
			state.setNumber("save2created", 1);
			break;
		case 3:
			GameDatas.saveFile3Created = true;
			state.setNumber("save3created", 1);
			break;
		}
		try {
				state.save();
		} catch (Exception e) {
				System.out.println("Failed to save game options");
		}
	}
}