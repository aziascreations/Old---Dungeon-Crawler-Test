package azias.game.dungeoncrawler;

import java.util.Random;

public class RandomGen {
	/**
	 * Generate a random number in a given range.
	 * @param par1 = Maximum generable number
	 * @return A random generated number.
	 */
	public static int RandomPlacer(int par1) {
		Random randomPlacer = new Random();
		int generatedNum = randomPlacer.nextInt(par1);
		return generatedNum;
	}
	
	public static int RandomNpcMover(int par1) {
		Random randomMover = new Random();
		int generatedNum = randomMover.nextInt(par1);
		return generatedNum;
	}
}