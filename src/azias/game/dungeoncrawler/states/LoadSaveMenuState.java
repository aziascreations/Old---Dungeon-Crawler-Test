package azias.game.dungeoncrawler.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;

import azias.game.dungeoncrawler.MapLoader;
import azias.game.dungeoncrawler.MusicChanger;
import azias.game.dungeoncrawler.core.save.SaveLoader;
import azias.game.dungeoncrawler.dataproxies.GameDatas;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.dataproxies.MusicDatas;
import azias.game.dungeoncrawler.dataproxies.PlayerDatas;
import azias.game.dungeoncrawler.dataproxies.TilesetDatas;
import azias.game.dungeoncrawler.renders.ImageRender;

public class LoadSaveMenuState extends BasicGameState implements ComponentListener, MusicListener
{
	private StateBasedGame game;
	private Image background;
	private Image playerFrame, saveFrame;
	private Image[]playerCharacter = new Image[3];
	private MouseOverArea[]menuButton = new MouseOverArea[4];
	private int centerX = ImageRender.getCenteredRenderX();
	private int centerY = ImageRender.getCenteredRenderY();
	private String buttonPath = "assets/gui/buttons/";
	private Color brown = new Color(45, 29, 16, 255);
	int var011 = 40;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.game = game;
		background = new Image("assets/gui/background/BackForest_2.png");
		playerFrame = new Image("assets/gui/menu/ClassFrame_1_2.png");
		saveFrame = new Image("assets/gui/menu/saveFrame_2.png");
		playerCharacter[0] = new Image("assets/gui/menu/Class_Warrior.png");
		menuButton[0] = new MouseOverArea(container, new Image(buttonPath+"Button5_2.png"), centerX+262, centerY-293, 234, 66, this);
		menuButton[1] = new MouseOverArea(container, new Image(buttonPath+"Button5_2.png"), centerX+262, centerY-83, 234, 66, this);
		menuButton[2] = new MouseOverArea(container, new Image(buttonPath+"Button5_2.png"), centerX+262, centerY+127, 234, 66, this);
		menuButton[3] = new MouseOverArea(container, new Image(buttonPath+"Button4_2.png"), centerX-117, centerY+270, 234, 66, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		ImageRender.renderCenteredImage(background, 0, 0);
		
		ImageRender.renderCenteredImage(saveFrame,-28,260);
		ImageRender.renderCenteredImage(playerFrame,-408,260);
		ImageRender.renderCenteredSizedImage(playerCharacter[0],-408,260,1);
		MiscDatas.font2_48.drawString(centerX-275, centerY-120-210, "Azias", brown);
		MiscDatas.font2_48.drawString(centerX-10, centerY-120-210, "Level: 112", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-75-210, "HP: 1243/1450", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-30-210, "XP: 1537/12385", brown);
		
		ImageRender.renderCenteredImage(saveFrame,-28,50);
		ImageRender.renderCenteredImage(playerFrame,-408,50);
		ImageRender.renderCenteredSizedImage(TilesetDatas.charImages[MiscDatas.save2Class+1],-408,50,2);
		MiscDatas.font2_48.drawString(centerX-275, centerY-120, MiscDatas.save2Name, brown);
		MiscDatas.font2_48.drawString(centerX-10, centerY-120, "Level: 112", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-75, "HP: 1243/1450", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-30, "XP: 1537/12385", brown);
		
		ImageRender.renderCenteredImage(saveFrame,-28,-160);
		ImageRender.renderCenteredImage(playerFrame,-408,-160);
		ImageRender.renderCenteredSizedImage(TilesetDatas.charImages[MiscDatas.save3Class+1],-408,-160,2);
		MiscDatas.font2_48.drawString(centerX-275, centerY-120+210, MiscDatas.save3Name, brown);
		MiscDatas.font2_48.drawString(centerX-10, centerY-120+210, "Level: 1", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-75+210, "HP: 43/43", brown);
		MiscDatas.font2_48.drawString(centerX-275, centerY-30+210, "XP: 0/456", brown);
		
		menuButton[0].render(container, g);menuButton[1].render(container, g);
		menuButton[2].render(container, g);menuButton[3].render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{}

	@Override
	public int getID() {
		return MiscDatas.LoadGameStateID;
	}
	
	public void componentActivated(AbstractComponent source) {
		for (int i=0;i<4;i++) {
			if (source == menuButton[i]) {
				switch(i) {
				case 0:
					if(GameDatas.saveFile1Created==true) {
						try {
							SaveLoader.loadSave(1);
							MapLoader.loadMap(PlayerDatas.playerMapID);
							MusicChanger.changeMusic(MusicDatas.songMenu, MusicDatas.songGame, this);
							game.enterState(MiscDatas.InGameStateID, new EmptyTransition(), new EmptyTransition());
						} catch (SlickException e) {
							e.printStackTrace();
						}
					}
					break;
				case 1:
					if(GameDatas.saveFile2Created==true) {
						try {
							SaveLoader.loadSave(2);
							MapLoader.loadMap(PlayerDatas.playerMapID);
							MusicChanger.changeMusic(MusicDatas.songMenu, MusicDatas.songGame, this);
							game.enterState(MiscDatas.InGameStateID, new EmptyTransition(), new EmptyTransition());
						} catch (SlickException e) {
							e.printStackTrace();
						}
					}
					break;
				case 2:
					if(GameDatas.saveFile3Created==true) {
						try {
							SaveLoader.loadSave(3);
							MapLoader.loadMap(PlayerDatas.playerMapID);
							MusicChanger.changeMusic(MusicDatas.songMenu, MusicDatas.songGame, this);
							game.enterState(MiscDatas.InGameStateID, new EmptyTransition(), new EmptyTransition());
						} catch (SlickException e) {
							e.printStackTrace();
						}
					}
					break;
				case 3:
					game.enterState(MiscDatas.MainMenuStateID, new EmptyTransition(), new EmptyTransition());
					break;
				}
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