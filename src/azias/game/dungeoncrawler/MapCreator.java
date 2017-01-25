package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

/**
 * Contains the function to create a new map.
 * @author Azias
 */
public class MapCreator
{
	/**
	 * @param par1 = MapID
	 */
	static void createMap()
	{
		Map.mapLoaderIndex(PlayerDatas.playerMapID);
	}
	
	static void createMap(int par1)
	{
		Map.mapLoaderIndex(par1);
	}
}