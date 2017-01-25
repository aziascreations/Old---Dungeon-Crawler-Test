package azias.game.dungeoncrawler.core.options.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.states.TestState2;

import azias.game.dungeoncrawler.NpcMover;
import azias.game.dungeoncrawler.PlayerMover;
import azias.game.dungeoncrawler.core.options.Options;
import azias.game.dungeoncrawler.renders.ImageRender;

public class MainOptionsState extends BasicGameState implements ComponentListener
{
	@SuppressWarnings("unused")
	private StateBasedGame game;
	private Image background;
	//private Image testImage;
	//private String imagePath = "src/assets/gui/buttons/";

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		/*Image spriteSheet = new Image("assets/tilesSheet.png");
		SpriteSheet s = new SpriteSheet(spriteSheet, 8, 8);
		tile1 = s.getSubImage(1,0);*/
		this.game = game;
		background = new Image("assets/gui/background/BackForest_2.png");
		//centered = new Image("assets/gui/menu/Class_Rogue.png");
		//centeredalt = new Image("assets/gui/menu/Class_Archer.png");
		//centeredsec = new Image("assets/gui/menu/Class_Mage.png");
		//background = new Image("assets/gui/background/BackStone_6_4x.png");
		//testImage = new Image(imagePath+"ItemsButton.png"); 
		//background = new Image("src/assets/gui/background/BackStone_2_4x.png");
		//menuTitle = new Image("src/assets/gui/menu/TitleTest1_1.png");
		//menuBorder = new Image("src/assets/gui/menu/Menu1_2.png");
		//menuButton[0] = new MouseOverArea(container, new Image(imagePath+"Button1_2.png"), centerX-147, centerY-192, 294, 66, this);
		//menuButton[1] = new MouseOverArea(container, new Image(imagePath+"Button2_2.png"), centerX-147, centerY-96, 294, 66, this);
		//menuButton[2] = new MouseOverArea(container, new Image(imagePath+"Button3_2.png"), centerX-147, centerY+66, 294, 66, this);
		//menuButton[3] = new MouseOverArea(container, new Image(imagePath+"Button4_2.png"), centerX-117, centerY+162, 234, 66, this);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		ImageRender.renderCenteredImage(background, 0, 0);
		//ImageRender.renderCenteredSizedImage(tile1, 0, 0, 8);
		/*ImageRender.renderCenteredSizedImage(centeredsec, 200, -100, 3);
		ImageRender.renderCenteredSizedImage(centeredalt, 200, -100, 2);
		ImageRender.renderCenteredSizedImage(centered, 200, -100, 1);
		ImageRender.renderBackground(0, background);
		ImageRender.renderBackground(0, background);
		ImageRender.renderCenteredImage(menuTitle, 0, 280);
		ImageRender.renderCenteredImage(menuBorder, 0, -60);
		menuButton[0].render(container, g);
		menuButton[1].render(container, g);
		menuButton[2].render(container, g);
		menuButton[3].render(container, g);*/
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void componentActivated(AbstractComponent arg0) {
	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			
		}
	}
}