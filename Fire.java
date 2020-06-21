package AI_Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fire extends JFrame {
	JPanel parent, child, easypanel, hardpanel;
	JButton easy, hard,exit,instruction;
    JLabel l2,l3,l4,l5;
	Fire() {
		parent = new JPanel();
		parent.setBackground(Color.YELLOW);
		add(parent);

		child = new JPanel();
		child.setPreferredSize(new Dimension(500, 300));
		child.setBackground(Color.YELLOW);

		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout l = new GridBagLayout();
		child.setLayout(l);

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel l1 = new JLabel("   !!! FIRE !!!");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		l1.setPreferredSize(new Dimension(250, 70));
		child.add(l1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		
		JLabel l2 = new JLabel();
		l2.setPreferredSize(new Dimension(220, 5));
		child.add(l2, gbc);
 
		gbc.gridx = 0;
		gbc.gridy = 2;
		easy = new JButton("EASY");
		easy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		easy.setPreferredSize(new Dimension(130, 30));
		easy.setBackground(Color.white);
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				gamemode p = new gamemode(parent,1,child);

			}
		});
		child.add(easy, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		l3= new JLabel();
		l3.setPreferredSize(new Dimension(220, 5));
		child.add(l3, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		hard = new JButton("HARD");
		hard.setFont(new Font("Times New Roman", Font.BOLD, 14));
		hard.setPreferredSize(new Dimension(130, 30));
		hard.setBackground(Color.white);
		hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gamemode p = new gamemode(parent,2,child);
			}
		});
		child.add(hard, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		l4= new JLabel();
		l4.setPreferredSize(new Dimension(220,5));
		child.add(l4, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		instruction = new JButton("Instruction");
		instruction.setFont(new Font("Times New Roman", Font.BOLD, 14));
		instruction.setPreferredSize(new Dimension(130, 30));
		instruction.setBackground(Color.white);
		instruction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Instruction inst = new Instruction(parent,child);
			}
		});
		child.add(instruction, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		l5 = new JLabel();
		l5.setPreferredSize(new Dimension(220, 5));
		child.add(l5, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		exit = new JButton("EXIT");
		exit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		exit.setPreferredSize(new Dimension(130, 30));
		exit.setBackground(Color.white);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		child.add(exit, gbc);
		

		parent.add(child);
	}
}
