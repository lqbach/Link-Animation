import java.awt.Graphics;


public abstract class Character {
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Character(int x, int y, int h, int w){
		this.x = x;
		this.y = y;
		height = h;
		width = w;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public abstract void draw(Graphics g);
	
	
	
	

}
