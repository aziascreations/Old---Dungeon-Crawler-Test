package azias.game.dungeoncrawler.core.save;

import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.dataproxies.GameDatas;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

public class SaveLoader {
	/**
	 * Load all the info about one save.
	 * @param par1 = Save File ID
	 * @throws SlickException
	 */
	public static void loadSave(int par1) throws SlickException {
		SavedState state;
		state = new SavedState("DCSave"+par1);
		
		PlayerDatas.playerName = state.getString("name");
		PlayerDatas.playerClass = (int) state.getNumber("class");
		PlayerDatas.playerMapID = (int) state.getNumber("mapid");
		PlayerDatas.playerPosX = (int) state.getNumber("posx");
		PlayerDatas.playerPosY = (int) state.getNumber("posy");
	}
	
	/**
	 * Load all the basic infos about one save.
	 * @throws SlickException
	 */
	public static void loadBasicSave(int par1) throws SlickException {
		switch(par1) {
		case 1:
			break;
		case 2:
			if(GameDatas.saveFile2Created == true) {
				SavedState state;
				state = new SavedState("DCSave"+par1);
				
				MiscDatas.save2Name = state.getString("name");
				MiscDatas.save2Class = (int) state.getNumber("class");
			} else {
				MiscDatas.save2Name = "";
				MiscDatas.save2Class = -1;
			}
			break;
		case 3:
			if(GameDatas.saveFile3Created == true) {
				SavedState state;
				state = new SavedState("DCSave"+par1);
				
				MiscDatas.save3Name = state.getString("name");
				MiscDatas.save3Class = (int) state.getNumber("class");
			} else {
				MiscDatas.save3Name = "";
				MiscDatas.save3Class = -1;
			}
			break;
		}
	}
}