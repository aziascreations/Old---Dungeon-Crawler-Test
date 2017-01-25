package azias.game.dungeoncrawler;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import azias.game.dungeoncrawler.dataproxies.MiscDatas;

public class FontCreator {
	
	public static void createFonts(){
		Font awtFont_24 = new Font("Times New Roman", Font.BOLD, 24);
		MiscDatas.font_24 = new TrueTypeFont(awtFont_24, false);
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("assets/fonts/04b03.ttf");
			Font awtFont2_24 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2_24 = awtFont2_24.deriveFont(24f);
			MiscDatas.font_24 = new TrueTypeFont(awtFont2_24, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Font awtFont_48 = new Font("Times New Roman", Font.BOLD, 48);
		MiscDatas.font_48 = new TrueTypeFont(awtFont_48, false);
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("assets/fonts/04b03.ttf");
			Font awtFont2_48 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2_48 = awtFont2_48.deriveFont(48f);
			MiscDatas.font2_48 = new TrueTypeFont(awtFont2_48, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}