package AI_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Instruction extends JPanel {

	JPanel instruction_panel, up, down, up1, up11, up12, up2, up3;;
	JButton back;
	JTextArea tx;

	public Instruction(JPanel parent, JPanel child) {
		instruction_panel = new JPanel();
		instruction_panel.setPreferredSize(new Dimension(500, 500));
		instruction_panel.setBackground(Color.yellow);
    
		up = new JPanel();
		up.setPreferredSize(new Dimension(480, 100));
		up.setLayout(new FlowLayout());
		up.setBackground(Color.white);

		up1 = new JPanel();
		up1.setBackground(Color.green);
		up1.setPreferredSize(new Dimension(130, 90));
		GridBagConstraints g = new GridBagConstraints();
		GridBagLayout ll = new GridBagLayout();
		up1.setLayout(ll);

		g.gridx = 0;
		g.gridy = 0;
		back = new JButton("BACK");

		back.setBackground(Color.white);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				parent.removeAll();
				parent.add(child);
				parent.revalidate();
				parent.repaint();
			}
		});
		up1.add(back,g);
		up.add(up1);

		up2 = new JPanel();
		up2.setBackground(Color.YELLOW);
		JLabel heading = new JLabel("!!! FIRE !!!");
		heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		heading.setPreferredSize(new Dimension(150, 70));
		up2.add(heading);
		up2.setPreferredSize(new Dimension(200, 90));
		up.add(up2);

		up3 = new JPanel();
		up3.setBackground(Color.green);
		up3.setPreferredSize(new Dimension(130, 90));
		up.add(up3);

		instruction_panel.add(up, BorderLayout.NORTH);

		down = new JPanel();
		down.setPreferredSize(new Dimension(480, 340));
		down.setBackground(Color.white);
		tx= new JTextArea();
		tx.setPreferredSize(new Dimension(470, 330));
		tx.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tx.setBackground(Color.cyan);
		tx.setText("\n Its a simple 2 player Artificial Intelligence game where one \n is Human intellegence and another is Computer Intellegen\n -ce. The computer Intelligence always try to move out the \n board where Human Intelligence try to keep the computer\n intellegence on  the bord. If the  computer Intellegence can\n not moves  out the  board the Human intellegence  will win \n or If the  Computer Intellegence move  out of the  bord ie\n that it reach on the boundary line then the Computer Intell\n -egence will win");
		tx.setEditable(false);
		down.add(tx);
		instruction_panel.add(down, BorderLayout.SOUTH);

		parent.removeAll();
		parent.add(instruction_panel);
		parent.revalidate();
		parent.repaint();
	}

}
