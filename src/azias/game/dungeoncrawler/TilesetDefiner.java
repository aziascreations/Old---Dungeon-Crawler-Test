package azias.game.dungeoncrawler;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import azias.game.dungeoncrawler.dataproxies.ImageDatas;
import azias.game.dungeoncrawler.dataproxies.MapDatas;
import azias.game.dungeoncrawler.dataproxies.TilesetDatas;

public class TilesetDefiner {

	public static void defineTiles() throws SlickException {
		TilesetDatas.tileImages = new Image [30];
		String tilePath = "assets/tiles/";
		
		switch(MapDatas.mapTilesetID) {
		case 0:
			TilesetDatas.tileImages[0] = new Image(tilePath + "Tile_00_Grass.png");
			TilesetDatas.tileImages[1] = new Image(tilePath + "Tile_00_Tree.png");
			TilesetDatas.tileImages[2] = new Image(tilePath + "Tile_00_RedFlower.png");
			TilesetDatas.tileImages[3] = new Image(tilePath + "Tile_00_WhiteFlower.png");
			TilesetDatas.tileImages[4] = new Image(tilePath + "Tile_00_Road.png");
			TilesetDatas.tileImages[9] = new Image(tilePath + "Tile_00_Fence.png");
			TilesetDatas.tileImages[10] = new Image(tilePath + "Tile_00_Wall.png");
			TilesetDatas.tileImages[11] = new Image(tilePath + "Tile_00_Ground.png");
			TilesetDatas.tileImages[12] = new Image(tilePath + "Tile_00_Door.png");
			TilesetDatas.tileImages[13] = new Image(tilePath + "Tile_00_Arch.png");
			break;
		}
	}

	public static void defineChars() throws SlickException {
		TilesetDatas.charImages = new Image [32];
		String charPath = "assets/chars/";
		//Player Images
		TilesetDatas.charImages[0] = new Image(charPath + "Char_00.png");
		TilesetDatas.charImages[1] = new Image(charPath + "Char_000.png");
		TilesetDatas.charImages[2] = new Image(charPath + "Char_001.png");
		TilesetDatas.charImages[3] = new Image(charPath + "Char_002.png");
		TilesetDatas.charImages[4] = new Image(charPath + "Char_003.png");
		//Others
		TilesetDatas.charImages[5] = new Image(charPath + "Char_004.png");
		TilesetDatas.charImages[6] = new Image(charPath + "Char_005.png");
		TilesetDatas.charImages[7] = new Image(charPath + "Char_006.png");
		TilesetDatas.charImages[8] = new Image(charPath + "Char_007.png");
		TilesetDatas.charImages[9] = new Image(charPath + "Char_008.png");
		TilesetDatas.charImages[10] = new Image(charPath + "Char_009.png");
		TilesetDatas.charImages[13] = new Image(charPath + "Char_Portal.png");
		TilesetDatas.charImages[14] = new Image(charPath + "Char_012.png");
	}

	public static void defineEnt() throws SlickException {
		TilesetDatas.entImages = new Image [32];
		ImageDatas.entitiesSheet = new Image("assets/entitiesSheet.png");
		SpriteSheet s = new SpriteSheet(ImageDatas.entitiesSheet, 8, 8);
		TilesetDatas.entImages[0] = s.getSubImage(7,0);//Table
		TilesetDatas.entImages[1] = s.getSubImage(6,0);//Chair
		TilesetDatas.entImages[2] = s.getSubImage(3,0);//Sign
		TilesetDatas.entImages[3] = s.getSubImage(8,0);//Biblio
		TilesetDatas.entImages[4] = s.getSubImage(9,0);//Barrels
		TilesetDatas.entImages[5] = s.getSubImage(2,1);//BedLeft
		TilesetDatas.entImages[6] = s.getSubImage(3,1);//BedRight
		TilesetDatas.entImages[7] = s.getSubImage(14,0);//BoxTiny
		TilesetDatas.entImages[8] = s.getSubImage(8,3);//CampFire
		TilesetDatas.entImages[9] = s.getSubImage(4,3);//RockHole
		TilesetDatas.entImages[10] = s.getSubImage(1,0);//ChestClosed
		TilesetDatas.entImages[11] = s.getSubImage(2,0);//ChestOpen
		TilesetDatas.entImages[12] = s.getSubImage(11,3);//Dummy
		TilesetDatas.entImages[13] = s.getSubImage(10,3);//TargetRight
		TilesetDatas.entImages[14] = s.getSubImage(10,3);//TargetLeft-WIP
		TilesetDatas.entImages[15] = s.getSubImage(0,0);//LootBag
		TilesetDatas.entImages[16] = s.getSubImage(4,1);//Sewing
		TilesetDatas.entImages[17] = s.getSubImage(5,1);//Workbench
		TilesetDatas.entImages[18] = s.getSubImage(0,3);//Tombstone
	}
}