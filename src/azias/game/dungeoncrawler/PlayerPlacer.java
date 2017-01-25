package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

/**
 * Contains all the functions to place the player on the map. 
 * @author Azias
 */
public class PlayerPlacer {
	/**
	 * Place the player at a random position on the map.
	 */
	static void placePlayer() {
		boolean playerPlaced = false;
		while(playerPlaced != true) {
			int x = RandomGen.RandomPlacer(MapDatas.mapSizeX);
			int y = RandomGen.RandomPlacer(MapDatas.mapSizeY);
			if(MapDatas.mapTiles[x][y] == "_" || MapDatas.mapTiles[x][y] == "G") {
				MapDatas.mapEntities[x][y] = "P";
				System.out.println("Player Placed At X:" + x + " Y:" + y);
				PlayerDatas.playerPosX = x;
				PlayerDatas.playerPosY = y;
				playerPlaced = true;
			} else {
				System.out.println("Failed To Place Player At X:" + x + " Y:" + y);
				playerPlaced = false;
			}
		}
	}
	
	/**
	 * Debug Version
	 */
	@Deprecated
	static void placePlayer(boolean par1) {
		boolean playerPlaced = false;
		while(playerPlaced != true) {
			int x = RandomGen.RandomPlacer(MapDatas.mapSizeX);
			int y = RandomGen.RandomPlacer(MapDatas.mapSizeY);
			if(MapDatas.mapTiles[x][y] == "_") {
				MapDatas.mapEntities[x][y] = "P";
				System.out.println("Player Placed At X:" + x + " Y:" + y);
				PlayerDatas.playerPosX = x;
				PlayerDatas.playerPosY = y;
				playerPlaced = true;
			} else {
				System.out.println("Failed To Place Player At X:" + x + " Y:" + y);
				playerPlaced = false;
			}
		}
	}
	
	/**
	 * Place the player at a position set by the previous MapID.
	 * @param par1 = Previous MapID
	 */
	static void placePlayer(int par1)
	{}
	
	/**
	 * Place the player at a given position.
	 * @param par1 = X Position
	 * @param par2 = Y Position
	 */
	static void placePlayer(int par1, int par2) {
		System.out.println("CHARACTER AT: " + par1 + ";" + par2 + " THERE IS: "+ MapDatas.mapTiles[par1][par2]);
		
		switch(MapDatas.mapTiles[par1][par2]) {
		case "_":
			MapDatas.mapEntities[par1][par2] = "P";
			System.out.println("Player Placed At X:" + par1 + " Y:" + par2);
			PlayerDatas.playerPosX = par1;
			PlayerDatas.playerPosY = par2;
			break;
		case "G":
			MapDatas.mapEntities[par1][par2] = "P";
			System.out.println("Player Placed At X:" + par1 + " Y:" + par2);
			PlayerDatas.playerPosX = par1;
			PlayerDatas.playerPosY = par2;
			break;
		case "P":
			MapDatas.mapEntities[par1][par2] = "P";
			System.out.println("Player Placed At X:" + par1 + " Y:" + par2);
			PlayerDatas.playerPosX = par1;
			PlayerDatas.playerPosY = par2;
			break;
		default:
			System.out.println("Failed To Place Player At X:" + par1 + " Y:" + par2);
			break;
		}
	}
}