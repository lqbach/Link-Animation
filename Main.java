

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public static void main(String [] args){
		JFrame j = new JFrame("Link Animation");
		j.setBounds(500, 200, 800, 600);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimplePanel pnl = new SimplePanel();
		pnl.setFocusable(true);
		j.add(pnl);
		j.setVisible(true);
		
		while(true){
			pnl.animate();
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
				System.out.println("Exception in sleep thread: " + e.toString());
			}
		}
		
		
	}
		
	

}
