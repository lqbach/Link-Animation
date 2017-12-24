import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class SimplePanelKeyBinds extends JPanel {
	private BufferedImage img;
	final static String imgPath = "C:\\Users\\long_\\workspace\\Intro Animation\\images\\LinkSpriteSheet.png";
	final static int ROWS = 8;
	final static int COLS = 10;
	final static int WIDTH = 80;
	final static int HEIGHT = 80;
	int x, y;
	int posx, posy;
	int speed;
	int direction;
	
	boolean up, down, left, right;
	private boolean moving;
	
	BufferedImage[] walkingForward;
	BufferedImage[] walkingRight;
	BufferedImage[] walkingLeft;
	BufferedImage[] walkingBackward;
	BufferedImage[] standingForward;
	BufferedImage[] standingLeft;
	BufferedImage[] standingRight;
	BufferedImage[] standingBack;
	BufferedImage[] currentWalk; //current animation
	
	public SimplePanelKeyBinds(){
		standingForward = new BufferedImage[1];
		standingLeft = new BufferedImage[1];
		standingRight = new BufferedImage[1];
		standingBack = new BufferedImage[1];
		
		walkingForward = new BufferedImage[COLS];
		walkingRight = new BufferedImage[COLS];
		walkingLeft = new BufferedImage[COLS];
		walkingBackward = new BufferedImage[COLS];
		currentWalk = standingForward;
		this.addKeyListener(new AL());
		x = y = 0;
		speed = 10; //speed
		
		try{
			img = ImageIO.read(new File(imgPath));
			for(int i = 0; i < ROWS; i ++){
				
				switch(i){
					case 0:
						for(int j = 0; j < 1; j ++){
							standingForward[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 1:
						for(int j = 0; j < 1; j ++){
							standingLeft[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 2:
						for(int j = 0; j < 1; j ++){
							standingBack[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 3:
						for(int j = 0; j < 1; j ++){
							standingRight[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 4:
						for(int j = 0; j < COLS; j++){
							walkingForward[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 5:
						for(int j = 0; j < COLS; j++){
							walkingLeft[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 6:
						for(int j = 0; j < COLS; j++){
							walkingBackward[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
					case 7:
						for(int j = 0; j < COLS; j++){
							walkingRight[j] = img.getSubimage(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
						}
						break;
						
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception in loading image: " + e.toString());
		}
		System.out.println(this.getWidth() + " " + this.getHeight());
		posx = 0;
		posy = 0;
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("Use arrow keys to move Link", this.getWidth()/2 - 70, this.getHeight()/8);
		g.drawImage(currentWalk[y], posx, posy, null);
	}
	

	public void animate(){
		
		if(moving){ 
			speed = 20;
			if(up){
				currentWalk = walkingBackward;
				posy = posy - speed;
				if(posy <= 0){
					posy = 0;
				}
			}
			
			else if(right){
				currentWalk = walkingRight;
				posx = posx + speed;
				if(posx >= this.getWidth() - WIDTH){
					posx = this.getWidth() - WIDTH;
				}
			}
			
			else if(down){
				currentWalk = walkingForward;
				posy = posy + speed;
				if(posy >= this.getHeight() - HEIGHT){
					posy = this.getHeight() - HEIGHT;
				}
			}
			
			else if(left){
				currentWalk = walkingLeft;
				posx = posx - speed;
				if(posx <= 0){
					posx = 0;
				}
			}
		}//End of big if statement
		
		else{//the character isn't moving
			speed = 0;
			if(currentWalk == walkingForward){
				currentWalk = standingForward;
			}
			else if(currentWalk == walkingBackward){
				currentWalk = standingBack;
			}
			else if(currentWalk == walkingRight){
				currentWalk = standingRight;
			}
			else if(currentWalk == walkingLeft){
				currentWalk = standingLeft;
			}
		}
		y = (y+1)%(currentWalk.length);
		
		repaint();
	}
	
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
				case KeyEvent.VK_DOWN:
					down = true;
					break;
					
				case KeyEvent.VK_UP:
					up = true;
					break;
				
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
					
				case KeyEvent.VK_LEFT:
					left = true;
					break;
					
			}
		}
		public void keyReleased(KeyEvent e){
			switch(e.getKeyCode()){
				case KeyEvent.VK_DOWN:
					down = false;
					break;
					
				case KeyEvent.VK_UP:
					up = false;
					break;
				
				case KeyEvent.VK_RIGHT:
					right = false;
					break;
					
				case KeyEvent.VK_LEFT:
					left = false;
					break;
					
			}
		moving = false;
		}
		public void keyTyped(KeyEvent e){
			
		}
	}
	
	
	
	
}