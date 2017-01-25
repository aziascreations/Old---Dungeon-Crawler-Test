package azias.game.dungeoncrawler;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;

public class MusicChanger implements MusicListener {

	/**
	 * @param par1 = Started Music.
	 * @param par2 = MusicListener.
	 */
	public static void startMusic(Music par1, MusicListener par2) {
		par1.addListener(par2);
		par1.loop();
		par1.play(1.0F,0.15F);
	}
	
	/**
	 * @param par1 = Stopped Music.
	 * @param par2 = Started Music.
	 * @param par3 = MusicListener.
	 */
	public static void changeMusic(Music par1, Music par2, MusicListener par3) {
		par1.stop();
		par1.removeListener(par3);
		par2.addListener(par3);
		par2.loop();
		par2.play(1.0F,0.15F);
	}
	
	/**
	 * @param par1 = Stopped Music.
	 * @param par2 = MusicListener.
	 */
	public static void stopMusic(Music par1, MusicListener par2) {
		par1.stop();
		par1.removeListener(par2);
	}
	
	@Override
	public void musicEnded(Music music)
	{}
	
	@Override
	public void musicSwapped(Music music, Music newMusic)
	{}
}