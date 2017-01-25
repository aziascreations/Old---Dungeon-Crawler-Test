package azias.game.dungeoncrawler.states;

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

import azias.game.dungeoncrawler.core.save.SaveLoader;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.renders.ImageRender;

public class MainMenuState extends BasicGameState implements ComponentListener, MusicListener
{
	private StateBasedGame game;
	private Image background, title;
	private MouseOverArea[]menuButton = new MouseOverArea[4];
	private String buttonPath = "assets/gui/buttons/";
	private int centerX = ImageRender.getCenteredRenderX();
	private int centerY = ImageRender.getCenteredRenderY();

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		//container.setVSync(true);
		this.game = game;
		background = new Image("assets/gui/background/BackForest_2.png");
		title = new Image("assets/gui/menu/Title07.png");
		menuButton[0] = new MouseOverArea(container, new Image(buttonPath+"Button1_2.png"), centerX-147, centerY-192+70, 294, 66, this);
		menuButton[1] = new MouseOverArea(container, new Image(buttonPath+"Button2_2.png"), centerX-147, centerY-96+70, 294, 66, this);
		menuButton[2] = new MouseOverArea(container, new Image(buttonPath+"Button3_2.png"), centerX-147, centerY+66+70, 294, 66, this);
		menuButton[3] = new MouseOverArea(container, new Image(buttonPath+"Button4_2.png"), centerX-117, centerY+162+70, 234, 66, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		ImageRender.renderCenteredImage(background, 0, 0);
		ImageRender.renderCenteredSizedImage(title, 0, 250, 1);
		menuButton[0].render(container, g);
		menuButton[1].render(container, g);
		menuButton[2].render(container, g);
		menuButton[3].render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}

	@Override
	public int getID() {
		return MiscDatas.MainMenuStateID;
	}
	
	public void componentActivated(AbstractComponent source) {
		System.out.println("ACTIVL : "+source);
		for (int i=0;i<4;i++) {
			if (source == menuButton[i]) {
				switch(i)
				{
				case 0:
					game.enterState(MiscDatas.NewGameStateID, new EmptyTransition(), new EmptyTransition());
					break;
				case 1:
					try {
						//SaveLoader.loadBasicSave(1);
						SaveLoader.loadBasicSave(2);
						SaveLoader.loadBasicSave(3);
						game.enterState(MiscDatas.LoadGameStateID, new EmptyTransition(), new EmptyTransition());
					} catch (SlickException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					game.enterState(MiscDatas.OptionsMenuStateID, new EmptyTransition(), new EmptyTransition());
					break;
				case 3:
					System.exit(0);
					break;
				}
				System.out.println("Option "+(i+1)+" pressed!");
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