package azias.game.dungeoncrawler.maps;

import azias.game.dungeoncrawler.dataproxies.MapDatas;

public class MapMercenaryPlains {
	String[][] mapTiles;
	int SizeX;
	int SizeY;
	
	public MapMercenaryPlains(int i) {
		MapDatas.mapTilesetID = 0;
		createArrays();
	}

	private void createArrays() {
		MapDatas.hasNpc = true;
		MapDatas.hasMonster = false;
		String Map = MapDatas.mapMercenaryPlains.replaceAll("_", "G");
		String[] parts = Map.split(";");
		SizeX = parts[0].length();
		SizeY = parts.length;
		MapDatas.mapTiles = new String [SizeX] [SizeY];
		MapDatas.mapEntities = new String [SizeX] [SizeY];
		MapDatas.mapNpcs = new String [SizeX] [SizeY];
		MapDatas.mapMonster = new String [SizeX] [SizeY];
		MapDatas.mapSizeX = SizeX; MapDatas.mapSizeY = SizeY;
		
		for(int y = 0; y < SizeY; y++)
		{
			String[] tiles = parts[y].split("(?<!^)"); 
			
			for(int x = 0; x < SizeX; x++)
			{
				MapDatas.mapTiles[x][y] = tiles[x];
				MapDatas.mapEntities[x][y] = "null";
				MapDatas.mapNpcs[x][y] = "null";
				MapDatas.mapMonster[x][y] = "null";
			}
		}
		decorateMap();
	}

	private void decorateMap() {
		MapDatas.mapEntities[0][19] = "dummy";
		MapDatas.mapEntities[31][11] = "dummy";
		addNpc();
	}

	private void addNpc() {
		MapDatas.npcNumber = 1;
		MapDatas.infoNpcs = new String[][] {
				{ "portal1", "13", "14", "31", "n", "n", "y", "Portal", "p", "1", "11", "1"}
		};
		MapDatas.mapNpcs[14][31] = "portal1";
		addMonsters();
	}

	private void addMonsters() {
		//MapDatas.monsterNumber = 1;
		// 15,23
		
	}
}