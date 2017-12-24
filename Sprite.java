import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite {
	
	private static BufferedImage spriteSheet;
	private static final int TILE_WIDTH = 80;
	private static final int TILE_LENGTH = 80;
	
	public static BufferedImage loadSprite(String file)
	{
		BufferedImage sprite = null;
		try{
			sprite = ImageIO.read(new File(file));
		} catch (IOException e){
			e.printStackTrace();
		}
		return sprite;
	}
	
	public static BufferedImage getSprite(int x, int y){
		
		if(spriteSheet == null){
			spriteSheet = loadSprite("C:\\Users\\long_\\workspace\\Intro Animation\\images\\LinkSpriteSheet.png");
		}
		
		return spriteSheet.getSubimage(x * TILE_WIDTH, y * TILE_LENGTH, TILE_WIDTH, TILE_LENGTH);
	}
	
	

}
