package azias.game.dungeoncrawler;

import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;

public class NpcMover {

	//TODO: Fix the infinite loop bug
	public static void moveNpcs()
	{
		for(int y = 0; y < MapDatas.npcNumber; y++)
		{
			if(MapDatas.infoNpcs[y][4]=="y"){
				MiscDatas.npcMoveAllowed = false;
				int posX = Integer.parseInt(MapDatas.infoNpcs[y][2]);
				int posY = Integer.parseInt(MapDatas.infoNpcs[y][3]);
				String npcID = MapDatas.mapNpcs[posX][posY];
				int addPosX = 0,addPosY = 0;
				
				while(MiscDatas.npcMoveAllowed == false)
				{
					int direction = RandomGen.RandomPlacer(4);
					addPosX = getNewPosX(direction);
					addPosY = getNewPosY(direction);
					checkMapBounds(posX+addPosX, posY+addPosY);
				}
				MapDatas.mapNpcs[posX][posY] = "null";
				posX = posX+addPosX;posY = posY+addPosY;
				MapDatas.mapNpcs[posX][posY] = npcID;
				MapDatas.infoNpcs[y][2] = Integer.toString(posX);
				MapDatas.infoNpcs[y][3] = Integer.toString(posY);
			}
			else
			{}
		}
	}
	
	private static void checkMapBounds(int par1, int par2)
	{
		if(par1 < 0||par1 >= MapDatas.mapSizeX||par2 < 0||par2 >=MapDatas.mapSizeY)
		{}
		else
		{
			checkTiles(par1, par2);
		}
	}
	
	private static void checkTiles(int par1, int par2)
	{
		switch(MapDatas.mapTiles[par1][par2])
		{
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
		case "d":
			checkEntities(par1, par2);
			break;
		default:
			break;
		}
	}

	private static void checkEntities(int par1, int par2)
	{
		switch(MapDatas.mapEntities[par1][par2])
		{
			case "null":
				checkNpcs(par1, par2);
				break;
			default:
				break;
		}
	}

	private static void checkNpcs(int par1, int par2)
	{
		if(MapDatas.hasNpc==true)
		{
			switch(MapDatas.mapNpcs[par1][par2])
			{
			case "null":
				checkPlayer(par1, par2);
				break;
			default:
				break;
			}
		}
		else
		{
			checkPlayer(par1, par2);
		}
	}
	
	private static void checkPlayer(int par1, int par2)
	{
		if(par1==PlayerDatas.playerPosX&&par2==PlayerDatas.playerPosY)
		{}
		else
		{
			MiscDatas.npcMoveAllowed = true;
		}
	}

	//TODO: Make only one function
	public static int getNewPosX(int par1)
	{
		int addPosX = 0;
		switch(par1){
		case 1:
			addPosX = 1;
			break;
		case 3:
			addPosX = -1;
			break;
		}
		return addPosX;
	}


	public static int getNewPosY(int par1)
	{
		int addPosY = 0;
		switch(par1){
		case 0:
			addPosY = -1;
			break;
		case 2:
			addPosY = 1;
			break;
		}
		return addPosY;
	}
}