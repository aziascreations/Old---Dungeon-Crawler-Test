package azias.game.dungeoncrawler.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;

import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.renders.ImageRender;

public class NewGameMenuState extends BasicGameState implements ComponentListener
{
	private StateBasedGame game;
	private Image background;
	private MouseOverArea[]menuButton = new MouseOverArea[4];
	private int centerX = ImageRender.getCenteredRenderX();
	private int centerY = ImageRender.getCenteredRenderY();
	private String buttonPath = "assets/gui/buttons/";
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.game = game;
		background = new Image("assets/gui/background/BackForest_2.png");
		menuButton[0] = new MouseOverArea(container, new Image(buttonPath+"Button1_2.png"), centerX-147, centerY-192, 294, 66, this);
		menuButton[1] = new MouseOverArea(container, new Image(buttonPath+"Button2_2.png"), centerX-147, centerY-96, 294, 66, this);
		menuButton[2] = new MouseOverArea(container, new Image(buttonPath+"Button3_2.png"), centerX-147, centerY+66, 294, 66, this);
		menuButton[3] = new MouseOverArea(container, new Image(buttonPath+"Button4_2.png"), centerX-117, centerY+162, 234, 66, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		ImageRender.renderCenteredImage(background, 0, 0);
		menuButton[0].render(container, g);
		menuButton[1].render(container, g);
		menuButton[2].render(container, g);
		menuButton[3].render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{}

	@Override
	public int getID() {
		return MiscDatas.NewGameStateID;
	}
	
	@Override
	public void componentActivated(AbstractComponent source) {
		for (int i=0;i<4;i++) {
			if (source == menuButton[i]) {
				switch(i)
				{
				case 0:
					MiscDatas.choosedSaveFile = 1;
					game.enterState(MiscDatas.ClassChooserStateID, new EmptyTransition(), new EmptyTransition());
					break;
				case 1:
					MiscDatas.choosedSaveFile = 2;
					game.enterState(MiscDatas.ClassChooserStateID, new EmptyTransition(), new EmptyTransition());
					break;
				case 2:
					MiscDatas.choosedSaveFile = 3;
					game.enterState(MiscDatas.ClassChooserStateID, new EmptyTransition(), new EmptyTransition());
					break;
				case 3:
					System.out.println("Main Menu Pressed");
					game.enterState(MiscDatas.MainMenuStateID, new EmptyTransition(), new EmptyTransition());
					break;
				}
				System.out.println("Option "+(i+1)+" pressed!");
			}
		}
	}
}