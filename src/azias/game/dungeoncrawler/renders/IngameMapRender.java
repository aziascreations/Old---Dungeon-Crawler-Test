package azias.game.dungeoncrawler.renders;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;
import azias.game.dungeoncrawler.dataproxies.TilesetDatas;

public class IngameMapRender {

	public static void renderMap(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		for(int y = 0; y <= MapDatas.mapSizeY - 1; y++)
		{
			for(int x = 0; x <= MapDatas.mapSizeX - 1; x++)
			{
				switch(MapDatas.mapTiles[x][y])
				{
					case "_":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[0], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "G":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[0], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "P":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[4], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "W":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[10], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "F":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[11], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "D":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[12], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "d":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[13], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "T":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[1], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "B":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[9], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "1":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[2], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "2":
						ImageRender.renderCenteredImage(TilesetDatas.tileImages[3], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
				}
				switch(MapDatas.mapEntities[x][y])
				{
					case "P":
						ImageRender.renderCenteredImage(TilesetDatas.charImages[PlayerDatas.playerClass+1], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1));
						break;
					case "table":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[0], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "chair":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[1], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "sign":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[2], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "bibli":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[3], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "barrels":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[4], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "bedleft":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[5], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "bedright":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[6], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "boxt":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[7], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "fire":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[8], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "hole":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[9], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "chestclose":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[10], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "chestopen":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[11], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "dummy":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[12], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "target":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[13], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "targetl":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[14], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "loot":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[15], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "sewing":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[16], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "workbench":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[17], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
					case "tombstone":
						ImageRender.renderCenteredSizedImage(TilesetDatas.entImages[18], (x - PlayerDatas.playerPosX)*64, ((y - PlayerDatas.playerPosY)*64)*(-1), 8);
						break;
				}
			}
		}
		if(MapDatas.hasNpc==true&&MapDatas.hasMonster==false){
			renderNpcs();
		}
		else if(MapDatas.hasNpc==true&&MapDatas.hasMonster==true){
			renderNpcs();
			//renderMonsters();
		}
		else if(MapDatas.hasNpc==false&&MapDatas.hasMonster==true){
			//renderMonsters();
		}
		else
		{}
	}

	private static void renderNpcs()
	{
		for(int y = 0; y < MapDatas.npcNumber; y++)
		{
			if(MapDatas.infoNpcs[y][6]=="y")
			{
				int npcImageID = Integer.parseInt(MapDatas.infoNpcs[y][1]);
				int posX = Integer.parseInt(MapDatas.infoNpcs[y][2]);
				int posY = Integer.parseInt(MapDatas.infoNpcs[y][3]);
				ImageRender.renderCenteredImage(TilesetDatas.charImages[npcImageID], (posX - PlayerDatas.playerPosX)*64, ((posY - PlayerDatas.playerPosY)*64)*(-1));
			}
			else
			{}
		}
	}
}