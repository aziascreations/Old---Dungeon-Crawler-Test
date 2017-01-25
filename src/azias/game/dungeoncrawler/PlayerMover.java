package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

public class PlayerMover {
	static int maxPosX = MapDatas.mapSizeX - 1;
	static int maxPosY = MapDatas.mapSizeY - 1;
	
	public static void movePlayer(int par1, int par2) {	
		switch(MapDatas.mapTiles[PlayerDatas.playerPosX+par1][PlayerDatas.playerPosY+par2]) {
			case "_":
				checkEntities(par1, par2);
				break;
			case "G":
				checkEntities(par1, par2);
				break;
			case "P":
				checkEntities(par1, par2);
				break;
			case "F":
				checkEntities(par1, par2);
				break;
			case "D":
				changePlayerPos(par1, par2);
				MapDatas.mapTiles[PlayerDatas.playerPosX][PlayerDatas.playerPosY] = "d";
				break;
			case "d":
				checkEntities(par1, par2);
				break;
			default:
				break;
		}
	}
	
	public static void checkEntities(int par1, int par2) {
		switch(MapDatas.mapEntities[PlayerDatas.playerPosX+par1][PlayerDatas.playerPosY+par2]) {
			case "null":
				checkNpcs(par1, par2);
				break;
			case "portal":
				changePlayerPos(par1, par2);
				break;
			default:
				break;
		}
	}
	
	public static void checkNpcs(int par1, int par2) {
		if(MapDatas.hasNpc==true) {
			switch(MapDatas.mapNpcs[PlayerDatas.playerPosX+par1][PlayerDatas.playerPosY+par2]) {
			case "null":
				checkMonsters(par1, par2);
				break;
			default:
				String touchedNpcID = MapDatas.mapNpcs[PlayerDatas.playerPosX+par1][PlayerDatas.playerPosY+par2];
				//System.out.println("You Touched: " + touchedNpcID);
				for(int y = 0; y < MapDatas.npcNumber; y++) {
					String checkedNpcID = MapDatas.infoNpcs[y][0];
					if(checkedNpcID == touchedNpcID) {
						int encounteredNpc = y;
						NpcFunctions.getNpcInformations(encounteredNpc, MapDatas.infoNpcs[y][8], y);
						y = MapDatas.npcNumber;
					} else {
					}
				}
				break;
			}
		} else {
			checkMonsters(par1, par2);
		}
	}
	
	public static void checkMonsters(int par1, int par2) {
		if(MapDatas.hasMonster==true) {
			
		} else {
			changePlayerPos(par1, par2);
			NpcMover.moveNpcs();
			Monster.moveMonster();
		}
	}
	
	public static void changePlayerPos(int par1, int par2) {
		MapDatas.mapEntities[PlayerDatas.playerPosX][PlayerDatas.playerPosY] = "null";
		PlayerDatas.playerPosX = PlayerDatas.playerPosX + par1;
		PlayerDatas.playerPosY = PlayerDatas.playerPosY + par2;
		MapDatas.mapEntities[PlayerDatas.playerPosX][PlayerDatas.playerPosY] = "P";
		PlayerDatas.hasMoved = true;
	}
}