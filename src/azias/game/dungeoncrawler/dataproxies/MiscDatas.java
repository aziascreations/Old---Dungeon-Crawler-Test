package azias.game.dungeoncrawler.dataproxies;

import org.newdawn.slick.TrueTypeFont;

public class MiscDatas
{
	/* Window Informations */
	public static String mainTitle = "Looting Adventure";
	public static int windowSizeX;
	public static int windowSizeY;
	public static boolean windowFS;
	
	/* States IDs */
	public static int SplashScreenStateID = 0;
	public static int MainMenuStateID = 1;
	public static int NewGameStateID = 2;
	public static int ClassChooserStateID = 3;
	public static int LoadGameStateID = 4;
	public static int OptionsMenuStateID = 5;
	public static int InGameStateID = 6;
	public static int CreditsStateID = 7;
	
	/* Encountered NPC Informations */
	public static String npcName;
	public static boolean npcCanMove;
	public static boolean npcCanTalk;
	
	/* Moving NPC */
	public static boolean npcMoveAllowed;
	public static boolean npcMoveValidated;
	
	/* Others */
	public static int choosedSaveFile;
	public static TrueTypeFont font_24;
	public static TrueTypeFont font2_24;
	public static TrueTypeFont font_48;
	public static TrueTypeFont font2_48;
	
	/* New Player Datas */
	public static int warriorMapID = 1;
	public static int mageMapID = 1;
	public static int archerMapID = 2;
	public static int rogueMapID = 2;
	
	/* Load Menu Save 2 Informations */
	public static String save2Name;
	public static int save2Class;
	public static int save2Level;
	public static int save2HP;
	public static int save2MaxHP;
	public static int save2XP;
	public static int save2MaxXP;
	
	/* Load Menu Save 3 Informations */
	public static String save3Name;
	public static int save3Class;
	public static int save3Level;
	public static int save3HP;
	public static int save3MaxHP;
	public static int save3XP;
	public static int save3MaxXP;
	
}