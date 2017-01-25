package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;

/** TODO: Find a better name */
public class NpcFunctions {
	
	public static void getNpcInformations(int par1)
	{
		MiscDatas.npcName = MapDatas.infoNpcs[par1][7];

		if(MapDatas.infoNpcs[par1][4]=="y"){
			MiscDatas.npcCanMove = true;
		}else{
			MiscDatas.npcCanMove = false;
		}
		
		if(MapDatas.infoNpcs[par1][5]=="y"){
			MiscDatas.npcCanTalk = true;
		}else{
			MiscDatas.npcCanTalk = false;
		}
		
		System.out.println(MiscDatas.npcName);
	}

	public static void getNpcInformations(int encounteredNpc, String string, int y)
	{
		switch(string) {
		case "p":
			int mapID = Integer.parseInt(MapDatas.infoNpcs[y][9]);
			int posX = Integer.parseInt(MapDatas.infoNpcs[y][10]);
			int posY = Integer.parseInt(MapDatas.infoNpcs[y][11]);
			MapLoader.loadMap(mapID, posX, posY);
			break;
		}
	}
}