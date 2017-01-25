package azias.game.dungeoncrawler.core.save;

import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.dataproxies.MiscDatas;

public class SaveCreator {

	/**
	 * @param par1 = Save Number
	 * @param par2 = Class Type
	 * @param par3 = Name
	 * @throws SlickException
	 */
	public static void createSave(int par1, int par2, String par3) throws SlickException 
	{
		SavedState state;
		String nameValue;
		int classValue;
		int mapIDValue;
		int posXValue, posYValue;
		
		state = new SavedState("DCSave"+par1);
		state.clear();

		nameValue = state.getString("name","DefaultName");
		classValue = (int) state.getNumber("class",64);
		mapIDValue = (int) state.getNumber("mapid",0);
		posXValue = (int) state.getNumber("posx",0);
		posYValue = (int) state.getNumber("posy",0);

		nameValue = par3;
		classValue = par2;
		state.setString("name", nameValue);
		state.setNumber("class", classValue);
		
		switch(par2)
		{
		case 0:
			mapIDValue = MiscDatas.warriorMapID;
			posXValue = 12;
			posYValue = 16;
			state.setNumber("mapid",mapIDValue);
			state.setNumber("posx",posXValue);
			state.setNumber("posy",posYValue);
			break;
		case 1:
			mapIDValue = MiscDatas.mageMapID;
			posXValue = 12;
			posYValue = 14;
			state.setNumber("mapid",mapIDValue);
			state.setNumber("posx",posXValue);
			state.setNumber("posy",posYValue);
			break;
		case 2:
			mapIDValue = MiscDatas.archerMapID;
			posXValue = 9;
			posYValue = 8;
			state.setNumber("mapid",mapIDValue);
			state.setNumber("posx",posXValue);
			state.setNumber("posy",posYValue);
			break;
		case 3:
			mapIDValue = MiscDatas.rogueMapID;
			posXValue = 9;
			posYValue = 6;
			state.setNumber("mapid",mapIDValue);
			state.setNumber("posx",posXValue);
			state.setNumber("posy",posYValue);
			break;
		}
		
		System.out.println(nameValue);
		System.out.println(classValue);
		System.out.println(mapIDValue);
		System.out.println(posXValue);
		System.out.println(posYValue);
		
		try {
			state.save();
		} catch (Exception e) {
			System.out.println("Failed to save state");
		}
	}
	
	/**
	 * Debug Function to see what's inside the actual save file.
	 * @param par1 = Save Number
	 * @throws SlickException
	 */
	public static void checkSave(int par1) throws SlickException
	{
		SavedState state;
		String nameValue;
		int classValue;
		int mapIDValue;
		int posXValue, posYValue;
		
		state = new SavedState("DCSaveTest"+par1);

		nameValue = state.getString("name");
		classValue = (int) state.getNumber("class");
		mapIDValue = (int) state.getNumber("mapid");
		posXValue = (int) state.getNumber("posx");
		posYValue = (int) state.getNumber("posy");

		System.out.println(nameValue);
		System.out.println(classValue);
		System.out.println(mapIDValue);
		System.out.println(posXValue);
		System.out.println(posYValue);
	}
}