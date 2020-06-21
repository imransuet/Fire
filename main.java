package AI_Project;

import java.applet.AudioClip;

import javax.swing.JFrame;

public class main {
	public static void main(String args[])
	{
		Fire fire = new Fire();
		fire.setVisible(true);
		fire.setBounds(400, 100, 500, 490);
		fire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fire.setResizable(false);
	}
}
