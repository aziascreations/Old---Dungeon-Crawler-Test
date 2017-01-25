package azias.game.dungeoncrawler.maps;

import azias.game.dungeoncrawler.RandomGen;
import azias.game.dungeoncrawler.dataproxies.MapDatas;

public class MapDebug
{
	int SizeX = 40;
	int SizeY = 40;
	int wallNumber = 120;
	
	/**
	 * Map used for development and debug tests.
	 */
	public MapDebug(int par1)
	{
		MapDatas.mapTilesetID = 0;
		createArrays();
	}
	
	private void createArrays()
	{
		MapDatas.mapTiles = new String [SizeX] [SizeY];
		MapDatas.mapEntities = new String [SizeX] [SizeY];
		MapDatas.mapNpcs = new String [SizeX] [SizeY];
		MapDatas.mapMonster = new String [SizeX] [SizeY];
		MapDatas.mapSizeX = SizeX; MapDatas.mapSizeY = SizeY;
		decorateMap();
	}

	private void decorateMap() {
		int maxPosX = SizeX - 1;
		int maxPosY = SizeY - 1;
		
		System.out.println("Loading Debug Map...");
		for(int y = 0; y <= maxPosY; y++) {
			for(int x = 0; x <= maxPosX; x++) {
				MapDatas.mapTiles[x][y] = "_";
				MapDatas.mapEntities[x][y] = "null";
			}
		}
		int wallCreated = 0;
		while(wallCreated < wallNumber)
		{
			int x = RandomGen.RandomPlacer(SizeX);
			int y = RandomGen.RandomPlacer(SizeY);
			if(MapDatas.mapTiles[x][y] == "_")
			{
				MapDatas.mapTiles[x][y] = "T";
				System.out.println("Wall " + wallCreated + " Created At X:" + x + " Y:" + y);
				wallCreated++;
			} else {
				System.out.println("Failed To Create Wall " + wallCreated + " At X:" + x + " Y:" + y);
			}
		}
	}
}