package azias.game.dungeoncrawler.renders;

import azias.game.dungeoncrawler.dataproxies.MapDatas;

public class MapRenderer
{
	/**
	 * Renders the map and entities in the command prompt.
	 */
	public static void renderMap()
	{
		for(int y = 0; y <= MapDatas.mapSizeY - 1; y++)
		{
			for(int x = 0; x <= MapDatas.mapSizeX - 1; x++)
			{
				if(MapDatas.mapEntities[x][y] == "null")
				{
					System.out.print(MapDatas.mapTiles[x][y]);
				}
				else
				{
					System.out.print(MapDatas.mapEntities[x][y]);
				}
			}
			System.out.println("");
		}
	}
}