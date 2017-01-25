package azias.game.dungeoncrawler;

import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.dataproxies.PlayerDatas;
import azias.game.dungeoncrawler.maps.*;

public class Map {
	
	public static void mapLoaderIndex(int par1) {
		switch(par1) {
			case 0: 
				new MapDebug(0);
				break;
			case 1: 
				new MapMercenaryCamp(1);
				break;
			case 2: 
				new MapMercenaryShooting(2);
				break;
			case 3: 
				new MapMercenaryPlains(2);
				break;
			default:
				new MapDebug(0);
				break;
		}
	}
	
	/**
	 * Load a map and place the player at a specific position.
	 * @param par1 = MapID
	 * @param par2 = X Position
	 * @param par3 = Y Position
	 */
	public static void loadMap(int par1, int par2, int par3) {
		createMap(par1);
		PlayerPlacer.placePlayer(par2, par3);
		try {
			TilesetDefiner.defineTiles();
		} catch (SlickException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Create the map with the ID in the Datas.
	 */
	static void createMap() {
		Map.mapLoaderIndex(PlayerDatas.playerMapID);
	}
	
	/**
	 * Create a specific map.
	 * @param par1 = MapID
	 */
	static void createMap(int par1) {
		Map.mapLoaderIndex(par1);
	}
}