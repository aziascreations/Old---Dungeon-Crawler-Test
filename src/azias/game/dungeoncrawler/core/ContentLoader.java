package azias.game.dungeoncrawler.core;

import org.newdawn.slick.Music;
import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

import azias.game.dungeoncrawler.TilesetDefiner;
import azias.game.dungeoncrawler.dataproxies.GameDatas;
import azias.game.dungeoncrawler.dataproxies.MusicDatas;

public class ContentLoader {
	
	public static void loadMusic() throws SlickException {
		MusicDatas.songMenu = new Music("res/Title_Theme.ogg", true);
		MusicDatas.songGame = new Music("res/Hobbiton_Theme.ogg", true);
	}

	public static void loadSounds() throws SlickException {
		try {Thread.sleep(800);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public static void loadGraphics() throws SlickException {
		TilesetDefiner.defineChars();
		TilesetDefiner.defineEnt();
	}
	
	public static void loadOptions() throws SlickException {
		SavedState state;
		int debug, music;
		int save1, save2, save3;

		state = new SavedState("DCOptions");
		debug = (int) state.getNumber("debugmode",0);
		music = (int) state.getNumber("music",1);
		save1 = (int) state.getNumber("save1created",0);
		save2 = (int) state.getNumber("save2created",0);
		save3 = (int) state.getNumber("save3created",0);

		if(debug==0) {
			GameDatas.debugMode = false;
		} else {
			GameDatas.debugMode = true;
		}
		if(music==0) {
			GameDatas.musicEnabled = false;
		} else {
			GameDatas.musicEnabled = true;
		}
		if(save1==0) {
			GameDatas.saveFile1Created = false;
		} else {
			GameDatas.saveFile1Created = true;
		}
		if(save2==0) {
			GameDatas.saveFile2Created = false;
		} else {
			GameDatas.saveFile2Created = true;
		}
		if(save3==0) {
			GameDatas.saveFile3Created = false;
		} else {
			GameDatas.saveFile3Created = true;
		}

		System.out.println(GameDatas.debugMode);
		System.out.println(GameDatas.musicEnabled);
		System.out.println(GameDatas.saveFile1Created);
		System.out.println(GameDatas.saveFile2Created);
		System.out.println(GameDatas.saveFile3Created);
		
		try {
			state.save();
		} catch (Exception e) {
			System.out.println("Failed to save game options");
		}
	}
}