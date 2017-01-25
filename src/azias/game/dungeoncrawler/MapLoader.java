package azias.game.dungeoncrawler;

import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

/**
 * Contains all the different ways to load a new map.
 * @author Azias
 */
public class MapLoader
{
	@Deprecated
	public static void loadMap()
	{
		System.out.println("Loading Map...");
		MapCreator.createMap();
		PlayerPlacer.placePlayer();
		try {
			TilesetDefiner.defineTiles();
		} catch (SlickException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Map Loaded !");
	}
	
	/**
	 * Load a map at the debug position or a random one.
	 * @param par1 = MapID
	 */
	public static void loadMap(int par1)
	{
		System.out.println("Loading Map...");
		MapCreator.createMap(par1);
		PlayerPlacer.placePlayer(PlayerDatas.playerPosX, PlayerDatas.playerPosY);
		try {
			TilesetDefiner.defineTiles();
		} catch (SlickException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Map Loaded !");
	}
	
	/**
	 * Load a new map when changing with a portal.
	 * @param par1 = MapID
	 * @param par2 = X Position
	 * @param par3 = Y Position
	 */
	public static void loadMap(int par1, int par2, int par3)
	{
		System.out.println("Changing Map...");
		System.out.println("Loadind Map "+par1+"...");
		MapCreator.createMap(par1);
		System.out.println("Place Player at: "+par2+":"+par3);
		PlayerPlacer.placePlayer(par2, par3);
		try {
			TilesetDefiner.defineTiles();
		} catch (SlickException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Map Changed !");
	}
	
	/**
	 * Create the map with the ID in the Datas.
	 */
	static void createMap()
	{
		Map.mapLoaderIndex(PlayerDatas.playerMapID);
	}
	
	/**
	 * Create a specific map.
	 * @param par1 = MapID
	 */
	static void createMap(int par1)
	{
		Map.mapLoaderIndex(par1);
	}
}