import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Hero extends Character{
	
	private BufferedImage[] walkingforward = {Sprite.getSprite(0, 4), Sprite.getSprite(1, 4), Sprite.getSprite(2, 4), Sprite.getSprite(3, 4), Sprite.getSprite(4, 4),  
			Sprite.getSprite(5, 4), Sprite.getSprite(6, 4), Sprite.getSprite(7, 4), Sprite.getSprite(8, 4), Sprite.getSprite(9, 4)};
	
	private BufferedImage[] walkingleft = {Sprite.getSprite(0, 5), Sprite.getSprite(1, 5), Sprite.getSprite(2, 5), Sprite.getSprite(3, 5), Sprite.getSprite(4, 5),  
			Sprite.getSprite(5, 5), Sprite.getSprite(6, 5), Sprite.getSprite(7, 5), Sprite.getSprite(8, 5), Sprite.getSprite(9, 5)};
	
	private BufferedImage[] walkingbackward = {Sprite.getSprite(0, 6), Sprite.getSprite(1, 6), Sprite.getSprite(2, 6), Sprite.getSprite(3, 6), Sprite.getSprite(4, 6),  
			Sprite.getSprite(5, 6), Sprite.getSprite(6, 6), Sprite.getSprite(7, 6), Sprite.getSprite(8, 6), Sprite.getSprite(9, 6)};
	
	private BufferedImage[] walkingright = {Sprite.getSprite(0, 7), Sprite.getSprite(1, 7), Sprite.getSprite(2, 7), Sprite.getSprite(3, 7), Sprite.getSprite(4, 7),  
			Sprite.getSprite(5, 7), Sprite.getSprite(6, 7), Sprite.getSprite(7, 7), Sprite.getSprite(8, 7), Sprite.getSprite(9, 7)};
	
	private BufferedImage[] standingforward = {Sprite.getSprite(0, 0), Sprite.getSprite(1, 0), Sprite.getSprite(2, 0)};
	
	private BufferedImage[] standingleft = {Sprite.getSprite(0, 1), Sprite.getSprite(1, 1), Sprite.getSprite(2, 1)};
	
	private BufferedImage[] standingbackward = {Sprite.getSprite(0, 2)};
	
	private BufferedImage[] standingright = {Sprite.getSprite(0, 3), Sprite.getSprite(1, 3), Sprite.getSprite(2, 3)};
	
	private Animation walkLeft = new Animation(walkingleft, 10);
	
	private Animation walkRight = new Animation(walkingright, 10);
	
	private Animation walkBack = new Animation(walkingbackward, 10);
	
	private Animation walkForw = new Animation(walkingforward, 10);
	
	private Animation standLeft = new Animation (standingleft, 10);
	
	private Animation standRight = new Animation (standingright, 10);
	
	private Animation standForw = new Animation (standingforward, 10);
	
	private Animation standBack = new Animation (standingbackward, 10);
	
	private Animation animation = standForw;
	
	
	public Hero(int x, int y, int h, int w){
		super(x, y, h, w);
	}
	
	public void start(){
		animation.start();
	}
	
	public void faceLeft(){
		animation = standLeft;
	}
	
	public void faceRight(){
		animation = standRight;
	}
	
	public void faceForw(){
		animation = standForw;
	}
	
	public void faceBack(){
		animation = standBack;
	}
	
	public void goLeft(){
		animation = walkLeft;
	}
	
	public void goRight(){
		animation = walkRight;
	}
	
	public void goForw(){
		animation = walkForw;
	}
	
	public void goBack(){
		animation = walkBack;
	}
	
	
	public void draw(Graphics g){
		g.drawImage(animation.getSprite(), getX(), getY(), null);
	}

}
