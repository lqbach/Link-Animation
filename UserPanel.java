import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserPanel extends JPanel implements KeyListener, ActionListener{
	
	private Hero hero;
	
	private javax.swing.Timer timer;
	
	public UserPanel(int width, int height){
		
		Color backColor = Color.white;
		
		int heroX = width/2;
		int heroY = height/2;
		
		hero = new Hero(heroX, heroY, 0, 0); //height and width set to 0 until we change this
		
		//timer = new javax.swing.Timer(50, this);
		
		addKeyListener(this);
		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setBackground(backColor);
		setPreferredSize(new Dimension(width, height));
		
		
		
	}
	
	
	public void actionPerformed (ActionEvent e){
		repaint();
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A:
				hero.goLeft();
				break;
			case KeyEvent.VK_W:
				hero.goForw();
				break;
			case KeyEvent.VK_S:
				hero.goBack();
				break;
			case KeyEvent.VK_D:
				hero.goRight();
				break;
			
			
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		hero.draw(g);
	}


}
