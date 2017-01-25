package azias.game.dungeoncrawler.renders;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import azias.game.dungeoncrawler.dataproxies.MiscDatas;

/**
 * @author Azias
 */
public class ImageRender
{
	/** The game container */
	@SuppressWarnings("unused")
	private static GameContainer container;

	/**
	 * Render a background for menus and others GUIs.
	 * @param par1 = Type of background
	 * @param par2 = Image to use
	 */
	public static void renderBackground(int par1, Image par2)
	{
		if(par1==0) {
			for(int y = 0; y <= 512; y = y + 256) {
				for(int x = 0; x <= 1024; x = x + 256) {
					par2.draw(x, y, 256, 256);
				}
			}
		}
		else if(par1==1)
		{
			int imageSizeX = par2.getWidth()*2;
			int imageSizeY = par2.getHeight()*2;
			int windowSizeX = 1280;
			int windowSizeY = 720;
			par2.draw(((imageSizeX-windowSizeX)/2)*-1, ((imageSizeY-windowSizeY)/2)*-1, imageSizeX, imageSizeY);
		}
		else if(par1==2)
		{}
	}
	
	/**
	 * @param par1 = Image to use
	 * @param par2 = X Position
	 * @param par3 = Y Position
	 */
	public static void renderBasicImage(Image par1, int par2, int par3)
	{
		int imageSizeX = par1.getWidth();
		int imageSizeY = par1.getHeight();
		par1.draw(par2, par3, imageSizeX, imageSizeY);
	}
	
	public static void renderCenteredImage(Image par1, int par2, int par3)
	{
		int imageSizeX = par1.getWidth();
		int imageSizeY = par1.getHeight();
		par1.draw(((MiscDatas.windowSizeX/2)-(imageSizeX/2))+par2, ((MiscDatas.windowSizeY/2)-(imageSizeY/2))+(par3*-1), imageSizeX, imageSizeY);
	}
	
	public static void renderCenteredSizedImage(Image par1, int par2, int par3, int par4)
	{
		par1.setFilter(Image.FILTER_NEAREST);
		int imageSizeX = par1.getWidth();
		int imageSizeY = par1.getHeight();
		par1.draw((MiscDatas.windowSizeX/2)-((imageSizeX*par4)/2)+par2, (MiscDatas.windowSizeY/2)-((imageSizeY*par4)/2)+(par3*-1), imageSizeX*par4, imageSizeY*par4);
	}
	
	public static void renderCenteredImage(Image par1, int par2, int par3, int par4, int par5)
	{
		int imageSizeX = par4;
		int imageSizeY = par5;
		par1.draw(((MiscDatas.windowSizeX/2)-(imageSizeX/2))+par2, ((MiscDatas.windowSizeY/2)-(imageSizeY/2))+(par3*-1), imageSizeX, imageSizeY);
	}
	
	public static void renderBackgroundFill(Image par1)
	{
		par1.draw(0, 0, MiscDatas.windowSizeX, MiscDatas.windowSizeY);
	}
	
	public static int getCenteredRenderX()
	{
		int i = MiscDatas.windowSizeX/2;
		return i;
	}
	
	public static int getCenteredRenderY()
	{
		int j = MiscDatas.windowSizeY/2;
		return j;
	}
}