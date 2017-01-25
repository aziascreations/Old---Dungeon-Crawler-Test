package azias.game.dungeoncrawler.states;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.util.ResourceLoader;

import azias.game.dungeoncrawler.GameDatasChanger;
import azias.game.dungeoncrawler.MapLoader;
import azias.game.dungeoncrawler.MusicChanger;
import azias.game.dungeoncrawler.core.save.SaveCreator;
import azias.game.dungeoncrawler.core.save.SaveLoader;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.dataproxies.MusicDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;
import azias.game.dungeoncrawler.renders.ImageRender;

public class ClassChooserState extends BasicGameState implements ComponentListener, MusicListener
{
	private StateBasedGame game;
	@SuppressWarnings("unused")
	private TrueTypeFont font;
	private TrueTypeFont font2;
	private Image background;
	private Image classFrame;
	private Image textFrame;
	private MouseOverArea[]menuButton = new MouseOverArea[4];
	private int centerX = ImageRender.getCenteredRenderX();
	private int centerY = ImageRender.getCenteredRenderY();
	private Image[] classImage = new Image[4];
	private String buttonPath = "assets/gui/buttons/";
	private int choosedClass = 0;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("assets/fonts/04b03.ttf");
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f);
			font2 = new TrueTypeFont(awtFont2, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.game = game;
		background = new Image("assets/gui/background/BackForest_2.png");
		classFrame = new Image("assets/gui/menu/ClassFrame_1_2.png");
		textFrame = new Image("assets/gui/menu/TextFrame_2.png");
		classImage[0] = new Image("assets/gui/menu/Class_Warrior.png");
		classImage[1] = new Image("assets/gui/menu/Class_Mage.png");
		classImage[2] = new Image("assets/gui/menu/Class_Archer.png");
		classImage[3] = new Image("assets/gui/menu/Class_Rogue.png");
		menuButton[0] = new MouseOverArea(container, new Image(buttonPath+"ArrowLeft_2.png"), centerX-100-35-35, centerY-186, 69, 66, this);
		menuButton[1] = new MouseOverArea(container, new Image(buttonPath+"ArrowRight_2.png"), centerX+100-34+35, centerY-186, 69, 66, this);
		menuButton[2] = new MouseOverArea(container, new Image(buttonPath+"Button1_2.png"), centerX-(294/2), centerY+230, 294, 66, this);
		menuButton[3] = new MouseOverArea(container, new Image(buttonPath+"Button4_2.png"), centerX-(294/2), centerY+162, 234, 66, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		ImageRender.renderCenteredImage(background, 0, 0);
		ImageRender.renderCenteredImage(classFrame, 0, 160);
		ImageRender.renderCenteredImage(textFrame, 0, -80);
		ImageRender.renderCenteredImage(classImage[choosedClass], 0, 160);
		menuButton[0].render(container, g);
		menuButton[1].render(container, g);
		menuButton[2].render(container, g);
		switch(choosedClass)
		{
		case 0:
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2), "The Warrior is a melee character.", Color.black);
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2)+40, "Special Abilities:", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+65, "-Battle Stance: Boost stats for a short time.", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+90, "-Heroic Strike: An attack that deals 110% weapon damage", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+115, "-Parry: Gives a chance to parry an enemy melee attacks.", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+140, "You will learn more abilities during your advanture.", Color.black);
			break;
		case 1:
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2), "The Mage is a ranged magic character.", Color.black);
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2)+40, "Special Abilities:", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+65, "You won't start with any, but you will learn some.", Color.black);
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2)+105, "Spells:", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+130, "-Shot: Attack with an equipped wand.", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+155, "-Frostbite: Cast a little ice storm at your enemy.", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+180, "-Calm: Weak enemies will stop fighting you for 5 turns.", Color.black);
			font2.drawString(centerX-(870/2)+45, centerY-170+(270/2)+205, "You will learn more abilities during your advanture.", Color.black);
			break;
		case 2:
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2), "Archer Text", Color.black);
			break;
		case 3:
			font2.drawString(centerX-(870/2)+20, centerY-170+(270/2), "Rogue Text", Color.black);
			break;
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{}

	@Override
	public int getID() {
		return MiscDatas.ClassChooserStateID;
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		for (int i=0;i<4;i++) {
			if (source == menuButton[i]) {
				switch(i)
				{
				case 0:
					if(choosedClass <= 0) {
						choosedClass = 3;
					} else {
						choosedClass--;
					}
					break;
					
				case 1:
					if(choosedClass >= 3) {
						choosedClass = 0;
					} else {
						choosedClass++;
					}
					break;
					
				case 2:
					try {
						SaveCreator.createSave(MiscDatas.choosedSaveFile, choosedClass, "Azias");
						GameDatasChanger.changeSavesOptions(MiscDatas.choosedSaveFile);
						SaveLoader.loadSave(MiscDatas.choosedSaveFile);
						MapLoader.loadMap(PlayerDatas.playerMapID);
						MusicChanger.changeMusic(MusicDatas.songMenu,MusicDatas.songGame,this);
						game.enterState(MiscDatas.InGameStateID, new EmptyTransition(), new EmptyTransition());
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					break;
				}
			}
		}
	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			game.enterState(MiscDatas.NewGameStateID, new EmptyTransition(), new EmptyTransition());
		}
		if (key == Input.KEY_LEFT) {
			if(choosedClass <= 0) {
				choosedClass = 3;
			} else {
				choosedClass--;
			}
		}
		if (key == Input.KEY_RIGHT) {
			if(choosedClass >= 3) {
				choosedClass = 0;
			} else {
				choosedClass++;
			}
		}
		if (key == Input.KEY_ENTER) {
			try {
				SaveCreator.createSave(MiscDatas.choosedSaveFile, choosedClass, "Azias");
				GameDatasChanger.changeSavesOptions(MiscDatas.choosedSaveFile);
				SaveLoader.loadSave(MiscDatas.choosedSaveFile);
				MapLoader.loadMap(PlayerDatas.playerMapID);
				MusicChanger.changeMusic(MusicDatas.songMenu, MusicDatas.songGame, this);
				game.enterState(MiscDatas.InGameStateID, new EmptyTransition(), new EmptyTransition());
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		if (key == Input.KEY_F1) {
			try {
				SaveCreator.checkSave(MiscDatas.choosedSaveFile);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void musicEnded(Music music)
	{}

	@Override
	public void musicSwapped(Music music, Music newMusic)
	{}
}