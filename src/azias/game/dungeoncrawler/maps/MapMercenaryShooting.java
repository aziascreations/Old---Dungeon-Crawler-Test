package azias.game.dungeoncrawler.maps;

import azias.game.dungeoncrawler.dataproxies.MapDatas;

public class MapMercenaryShooting {
	String[][] mapTiles;
	int SizeX; //22
	int SizeY; //16
	
	public MapMercenaryShooting(int i) {
		MapDatas.mapTilesetID = 0;
		createArrays();
	}

	private void createArrays() {
		MapDatas.hasNpc = true;
		MapDatas.hasMonster = false;
		String Map = MapDatas.mapMercenaryShooting.replaceAll("_", "G");
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
		MapDatas.mapEntities[8][3] = "dummy";
		MapDatas.mapEntities[2][8] = "target";
		MapDatas.mapEntities[2][10] = "target";
		MapDatas.mapEntities[13][6] = "bibli";
		MapDatas.mapEntities[14][6] = "sewing";
		MapDatas.mapEntities[16][6] = "workbench";
		MapDatas.mapEntities[10][3] = "dummy";
		MapDatas.mapEntities[13][8] = "barrels";
		MapDatas.mapEntities[20][11] = "sign";
		addNpc();
	}

	private void addNpc() {
		MapDatas.npcNumber = 2;
		MapDatas.infoNpcs = new String[][] {
				{ "mercenary1", "6", "10", "10", "y", "n", "y", "Jaques", "", "", "", ""},
				{ "portal1", "13", "21", "10", "n", "n", "y", "Portal", "p", "1", "1", "15"}
		};
		MapDatas.mapNpcs[10][10] = "mercenary1";
		MapDatas.mapNpcs[21][10] = "portal1";
	}
}