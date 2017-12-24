import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ActionListener extends KeyAdapter{
	public void keyPressed(KeyEvent e){
		int KeyCode = e.getKeyCode();
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
		
	}
	public void keyTyped(KeyEvent e){
		
	}
	
}
