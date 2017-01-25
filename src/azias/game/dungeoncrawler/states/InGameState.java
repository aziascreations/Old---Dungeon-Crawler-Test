package azias.game.dungeoncrawler.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import azias.game.dungeoncrawler.NpcMover;
import azias.game.dungeoncrawler.PlayerMover;
import azias.game.dungeoncrawler.dataproxies.MiscDatas;
import azias.game.dungeoncrawler.renders.IngameMapRender;
import azias.game.dungeoncrawler.renders.ImageRender;

public class InGameState extends BasicGameState
{
	@SuppressWarnings("unused")
	private StateBasedGame game;
	int centerX = ImageRender.getCenteredRenderX();
	int centerY = ImageRender.getCenteredRenderY();
	Image statsbar;

	//private String imagePath = "src/assets/gui/buttons/";

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.game = game;
		statsbar = new Image("assets/gui/menu/ClassFrame_0.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		IngameMapRender.renderMap(container, game, g);
		//statsbar.draw(20, 20, statsbar.getWidth(), statsbar.getHeight());
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			//Menu
		}
		
		if (key == Input.KEY_UP) {
			PlayerMover.movePlayer(0, -1);
		}
		
		if (key == Input.KEY_LEFT) {
			PlayerMover.movePlayer(-1, 0);
		}
		
		if (key == Input.KEY_RIGHT) {
			PlayerMover.movePlayer(1, 0);
		}
		
		if (key == Input.KEY_DOWN) {
			PlayerMover.movePlayer(0, 1);
		}
		
		if (key == Input.KEY_ENTER) {
			NpcMover.moveNpcs();
		}
		
		if (key == Input.KEY_F1) {
			//Hide Interface
		}
		
		if (key == Input.KEY_I) {
			//game.enterState(MiscDatas.InventoryID, new EmptyTransition(), new EmptyTransition());
		}
	}

	@Override
	public int getID() {
		return MiscDatas.InGameStateID;
	}
}