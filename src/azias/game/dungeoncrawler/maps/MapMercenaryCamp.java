package azias.game.dungeoncrawler.maps;

import azias.game.dungeoncrawler.dataproxies.MapDatas;

public class MapMercenaryCamp
{
	String[][] mapTiles;
	int SizeX; //30
	int SizeY; //34
	
	public MapMercenaryCamp(int i) {
		MapDatas.mapTilesetID = 0;
		createArrays();
	}
	
	private void createArrays()
	{
		MapDatas.hasNpc = true;
		MapDatas.hasMonster = false;
		String Map = MapDatas.mapMercenaryCamp.replaceAll("_", "G");
		String[] parts = Map.split(";");
		SizeX = parts[0].length();
		SizeY = parts.length;
		MapDatas.mapTiles = new String [SizeX] [SizeY];
		MapDatas.mapEntities = new String [SizeX] [SizeY];
		MapDatas.mapNpcs = new String [SizeX] [SizeY];
		MapDatas.mapMonster = new String [SizeX] [SizeY];
		MapDatas.mapSizeX = SizeX; MapDatas.mapSizeY = SizeY;
		System.out.println("Map Size: " + SizeX + ";" + SizeY);
		
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

	private void decorateMap()
	{
		//House_1
		MapDatas.mapEntities[3][6] = "sewing";
		MapDatas.mapEntities[4][6] = "bibli";
		MapDatas.mapEntities[6][6] = "chair";
		MapDatas.mapEntities[6][7] = "table";
		MapDatas.mapEntities[6][9] = "boxt";
		MapDatas.mapEntities[3][12] = "bedleft";
		//House_2
		MapDatas.mapEntities[17][7] = "bedright";
		MapDatas.mapEntities[17][10] = "sewing";
		MapDatas.mapEntities[15][10] = "chair";
		MapDatas.mapEntities[14][10] = "bibli";
		//House_3
		MapDatas.mapEntities[5][18] = "sewing";
		MapDatas.mapEntities[3][19] = "chair";
		MapDatas.mapEntities[3][20] = "table";
		MapDatas.mapEntities[8][19] = "boxt";
		MapDatas.mapEntities[8][20] = "bedright";
		//House_4
		MapDatas.mapEntities[4][24] = "barrels";
		MapDatas.mapEntities[9][24] = "workbench";
		MapDatas.mapEntities[4][25] = "barrels";
		MapDatas.mapEntities[5][25] = "boxt";
		MapDatas.mapEntities[8][26] = "table";
		//House_5
		MapDatas.mapEntities[19][26] = "bibli";
		MapDatas.mapEntities[19][29] = "chestclose";
		MapDatas.mapEntities[16][29] = "table";
		//Other Objects
		MapDatas.mapEntities[10][1] = "sign";
		MapDatas.mapEntities[12][20] = "hole";
		MapDatas.mapEntities[21][22] = "fire";
		MapDatas.mapEntities[4][22] = "barrels";
		MapDatas.mapEntities[17][15] = "barrels";
		MapDatas.mapEntities[19][14] = "barrels";
		MapDatas.mapEntities[21][16] = "barrels";
		MapDatas.mapEntities[22][15] = "barrels";
		MapDatas.mapEntities[23][15] = "barrels";
		MapDatas.mapEntities[24][15] = "barrels";
		MapDatas.mapEntities[23][16] = "barrels";
		MapDatas.mapEntities[24][16] = "barrels";
		MapDatas.mapEntities[22][18] = "barrels";
		MapDatas.mapEntities[23][18] = "barrels";
		MapDatas.mapEntities[21][8] = "tombstone";
		MapDatas.mapEntities[23][8] = "tombstone";
		MapDatas.mapEntities[25][8] = "tombstone";
		MapDatas.mapEntities[23][11] = "tombstone";
		MapDatas.mapEntities[25][11] = "tombstone";
		addNpc();
	}
	
	private void addNpc()
	{
		//The Exiles NPCs
		MapDatas.npcNumber = 9;
		MapDatas.infoNpcs = new String[][] {
			{ "mercenary1", "5", "9", "14", "y", "n", "y", "Taylor", "", "", "", ""},
			{ "mercenary2", "6", "24", "9", "y", "n", "y", "Jacobs", "", "", "", ""},
			{ "mercenary3", "6", "20", "22", "n", "n", "y", "Devlin", "", "", "", ""},
			{ "mercenary4", "6", "16", "12", "n", "n", "y", "Mui", "", "", "", "", ""},
			{ "mercenary5", "10", "16", "28", "n", "n", "y", "Nilsson", "", "", "", "", ""},
			{ "mercenary6", "8", "7", "26", "n", "n", "y", "Chris", "", "", "", "", ""},
			{ "mercenary7", "6", "4", "8", "n", "n", "y", "Samuel", "", "", "", "", ""},
			{ "portal1", "13", "0", "15", "n", "n", "y", "Portal", "p", "2", "20", "10"},
			{ "portal2", "13", "11", "0", "n", "n", "y", "Portal", "p", "3", "15", "30"}
		};
		MapDatas.mapNpcs[9][14] = "mercenary1";
		MapDatas.mapNpcs[24][9] = "mercenary2";
		MapDatas.mapNpcs[20][22] = "mercenary3";
		MapDatas.mapNpcs[16][12] = "mercenary4";
		MapDatas.mapNpcs[16][28] = "mercenary5";
		MapDatas.mapNpcs[7][26] = "mercenary6";
		MapDatas.mapNpcs[4][8] = "mercenary7";
		MapDatas.mapNpcs[0][15] = "portal1";
		MapDatas.mapNpcs[11][0] = "portal2";
	}
}