package AI_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gamemode extends JPanel {
	JPanel modegame, up, down, up1, up11, up12, up2, up3;
	JLabel computer, human, computergame, humangame;
	JButton buttons[][] = new JButton[10][10], back, refresh;
	int mat[][] = new int[11][11];
	int human_tern = 0;
	int computer_tern = 0;
	int par[][] = new int[11][11];
	int x[] = { 0, 0, 1, -1 };
	int y[] = { 1, -1, 0, 0 };
	int X[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	int Y[] = {1, 1, 1, 0, 0, -1, -1, -1};
	int firex = 0, firey = 0;
	Queue<Integer> queue = new LinkedList<Integer>();

	public gamemode(JPanel parent, int mode, JPanel child) {
		modegame = new JPanel();
		modegame.setPreferredSize(new Dimension(500, 500));
		modegame.setBackground(Color.yellow);

		up = new JPanel();
		up.setPreferredSize(new Dimension(480, 100));
		up.setLayout(new FlowLayout());
		up.setBackground(Color.white);

		up1 = new JPanel();
		up1.setBackground(Color.green);
		up1.setLayout(new GridLayout(2, 1));
		up1.setPreferredSize(new Dimension(130, 90));
		up11 = new JPanel();
		up11.setBackground(Color.green);
		back = new JButton("BACK");
		back.setPreferredSize(new Dimension(100, 30));
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
		up11.add(back);
		up1.add(up11);

		up12 = new JPanel();
		up12.setBackground(Color.green);
		refresh = new JButton("REFRESH");
		refresh.setBackground(Color.white);
		refresh.setPreferredSize(new Dimension(100, 30));
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i <= 9; i++) {
						for (int j = 0; j <= 9; j++) {
							buttons[i][j].setBackground(Color.white);
							mat[i][j] = 0;
							par[i][j] = 0;
						}
					}
					initial l = new initial();
					int pos = l.getrendom();
					firex = pos / 10;
					firey = pos % 10;

					mat[firex][firey] = 1;
					buttons[firex][firey].setBackground(Color.red);
				} catch (Exception exx) {

				}

			}
		});
		up12.add(refresh);
		up1.add(up12);

		up.add(up1);

		up2 = new JPanel();
		up2.setBackground(Color.yellow);
		JLabel heading = new JLabel("!!! FIRE !!!");
		heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		heading.setPreferredSize(new Dimension(150, 70));
		up2.add(heading);
		up2.setPreferredSize(new Dimension(200, 90));
		up.add(up2);

		up3 = new JPanel();
		up3.setBackground(Color.green);
		up3.setLayout(new GridLayout( 2, 2));
		computer = new JLabel("  MACHINE");
		up3.add(computer);
		computergame = new JLabel("" + computer_tern);
		up3.add(computergame);
		human = new JLabel("   HUMAN");
		up3.add(human);
		humangame = new JLabel("" + human_tern);
		up3.add(humangame);
		up3.setPreferredSize(new Dimension(130, 90));
		up.add(up3);

		modegame.add(up, BorderLayout.NORTH);

		down = new JPanel();
		down.setPreferredSize(new Dimension(480, 340));
		down.setBackground(Color.lightGray);
		down.setLayout(new GridLayout(10, 10));
		setButton();
		algorithm(mode);
		modegame.add(down, BorderLayout.SOUTH);
		parent.removeAll();
		parent.add(modegame);
		parent.revalidate();
		parent.repaint();

	}

	/*
 * 
 * 
 * 
 */
	private void algorithm(int mode) {
		int cou = 0;
		initial l = new initial();
		int pos = l.getrendom();
		firex = pos / 10;
		firey = pos % 10;

		mat[firex][firey] = 1;
		buttons[firex][firey].setBackground(Color.red);
		boundarycheck bounadryc = new boundarycheck();

		buttons[0][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][0] == 0) {
						mat[0][0] = 1;
						buttons[0][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][1] == 0) {
						mat[0][1] = 1;
						buttons[0][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][2] == 0) {
						mat[0][2] = 1;
						buttons[0][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][3] == 0) {
						mat[0][3] = 1;
						buttons[0][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][4] == 0) {
						mat[0][4] = 1;
						buttons[0][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][5] == 0) {
						mat[0][5] = 1;
						buttons[0][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[0][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][6] == 0) {
						mat[0][6] = 1;
						buttons[0][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][7] == 0) {
						mat[0][7] = 1;
						buttons[0][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][8] == 0) {
						mat[0][8] = 1;
						buttons[0][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[0][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[0][9] == 0) {
						mat[0][9] = 1;
						buttons[0][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[1][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][0] == 0) {
						mat[1][0] = 1;
						buttons[1][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[1][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][1] == 0) {
						mat[1][1] = 1;
						buttons[1][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][2] == 0) {
						System.out.println(firex + "" + firey);
						mat[1][2] = 1;
						buttons[1][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][3] == 0) {
						System.out.println(firex + "" + firey);
						mat[1][3] = 1;
						buttons[1][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][4] == 0) {
						mat[1][4] = 1;
						buttons[1][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"The Button is Already pressed");
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][5] == 0) {
						mat[1][5] = 1;
						buttons[1][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][6] == 0) {
						mat[1][6] = 1;
						buttons[1][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][7] == 0) {
						mat[1][7] = 1;
						buttons[1][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[1][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][8] == 0) {
						mat[1][8] = 1;
						buttons[1][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[1][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[1][9] == 0) {
						mat[1][9] = 1;
						buttons[1][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][0] == 0) {
						mat[2][0] = 1;
						buttons[2][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[2][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][1] == 0) {
						mat[2][1] = 1;
						buttons[2][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][2] == 0) {
						mat[2][2] = 1;
						buttons[2][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][3] == 0) {
						mat[2][3] = 1;
						buttons[2][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][4] == 0) {
						mat[2][4] = 1;
						buttons[2][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][5] == 0) {
						mat[2][5] = 1;
						buttons[2][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][6] == 0) {
						mat[2][6] = 1;
						buttons[2][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][7] == 0) {
						mat[2][7] = 1;
						buttons[2][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][8] == 0) {
						mat[2][8] = 1;
						buttons[2][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[2][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[2][9] == 0) {
						mat[2][9] = 1;
						buttons[2][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][0] == 0) {
						mat[3][0] = 1;
						buttons[3][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[3][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][1] == 0) {
						mat[3][1] = 1;
						buttons[3][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][2] == 0) {
						mat[3][2] = 1;
						buttons[3][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][3] == 0) {
						mat[3][3] = 1;
						buttons[3][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText("" + computer_tern);
							for (int i = 0; i <= 9; i++) {
								for (int j = 0; j <= 9; j++) {
									mat[i][j] = 1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][4] == 0) {
						mat[3][4] = 1;
						buttons[3][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[3][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][5] == 0) {
						mat[3][5] = 1;
						buttons[3][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[3][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][6] == 0) {
						mat[3][6] = 1;
						buttons[3][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][7] == 0) {
						mat[3][7] = 1;
						buttons[3][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][8] == 0) {
						mat[3][8] = 1;
						buttons[3][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[3][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[3][9] == 0) {
						mat[3][9] = 1;
						buttons[3][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][0] == 0) {
						mat[4][0] = 1;
						buttons[4][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}
		});

		buttons[4][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][1] == 0) {
						mat[4][1] = 1;
						buttons[4][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][2] == 0) {
						mat[4][2] = 1;
						buttons[4][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][3] == 0) {
						mat[4][3] = 1;
						buttons[4][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][4] == 0) {
						mat[4][4] = 1;
						buttons[4][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][5] == 0) {
						mat[4][5] = 1;
						buttons[4][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][6] == 0) {
						mat[4][6] = 1;
						buttons[4][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][7] == 0) {
						mat[4][7] = 1;
						buttons[4][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][8] == 0) {
						mat[4][8] = 1;
						buttons[4][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[4][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[4][9] == 0) {
						mat[4][9] = 1;
						buttons[4][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][0] == 0) {
						mat[5][0] = 1;
						buttons[5][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[5][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][1] == 0) {
						mat[5][1] = 1;
						buttons[5][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][2] == 0) {
						mat[5][2] = 1;
						buttons[5][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][3] == 0) {
						mat[5][3] = 1;
						buttons[5][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][4] == 0) {
						mat[5][4] = 1;
						buttons[5][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[5][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][5] == 0) {
						mat[5][5] = 1;
						buttons[5][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][6] == 0) {
						mat[5][6] = 1;
						buttons[5][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][7] == 0) {
						mat[5][7] = 1;
						buttons[5][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][8] == 0) {
						mat[5][8] = 1;
						buttons[5][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[5][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[5][9] == 0) {
						mat[5][9] = 1;
						buttons[5][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[6][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][0] == 0) {
						mat[6][0] = 1;
						buttons[6][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[6][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][1] == 0) {
						mat[6][1] = 1;
						buttons[6][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][2] == 0) {
						mat[6][2] = 1;
						buttons[6][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {

					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][3] == 0) {
						mat[6][3] = 1;
						buttons[6][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][4] == 0) {
						mat[6][4] = 1;
						buttons[6][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
				
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][5] == 0) {
						mat[6][5] = 1;
						buttons[6][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][6] == 0) {
						mat[6][6] = 1;
						buttons[6][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][7] == 0) {
						mat[6][7] = 1;
						buttons[6][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][8] == 0) {
						mat[6][8] = 1;
						buttons[6][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[6][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[6][9] == 0) {
						mat[6][9] = 1;
						buttons[6][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][0] == 0) {
						mat[7][0] = 1;
						buttons[7][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[7][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][1] == 0) {
						mat[7][1] = 1;
						buttons[7][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][2] == 0) {
						mat[7][2] = 1;
						buttons[7][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[7][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][3] == 0) {
						mat[7][3] = 1;
						buttons[7][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[7][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][4] == 0) {
						mat[7][4] = 1;
						buttons[7][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][5] == 0) {
						mat[7][5] = 1;
						buttons[7][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][6] == 0) {
						mat[7][6] = 1;
						buttons[7][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][7] == 0) {
						mat[7][7] = 1;
						buttons[7][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][8] == 0) {
						mat[7][8] = 1;
						buttons[7][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[7][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[7][9] == 0) {
						mat[7][9] = 1;
						buttons[7][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][0] == 0) {
						mat[8][0] = 1;
						buttons[8][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[8][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][1] == 0) {
						mat[8][1] = 1;
						buttons[8][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[8][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][2] == 0) {
						mat[8][2] = 1;
						buttons[8][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][3] == 0) {
						mat[8][3] = 1;
						buttons[8][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][4] == 0) {
						mat[8][4] = 1;
						buttons[8][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][5] == 0) {
						mat[8][5] = 1;
						buttons[8][5].setBackground(Color.gray);
					 	bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][6] == 0) {
						mat[8][6] = 1;
						buttons[8][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][7] == 0) {
						mat[8][7] = 1;
						buttons[8][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[8][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][8] == 0) {
						mat[8][8] = 1;
						buttons[8][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});
		buttons[8][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[8][9] == 0) {
						mat[8][9] = 1;
						buttons[8][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][0] == 0) {
						mat[9][0] = 1;
						buttons[9][0].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}
		});
		buttons[9][1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][1] == 0) {
						mat[9][1] = 1;
						buttons[9][1].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][2] == 0) {
						mat[9][2] = 1;
						buttons[9][2].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][3] == 0) {
						mat[9][3] = 1;
						buttons[9][3].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][4] == 0) {
						mat[9][4] = 1;
						buttons[9][4].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][5] == 0) {
						mat[9][5] = 1;
						buttons[9][5].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][6] == 0) {
						mat[9][6] = 1;
						buttons[9][6].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][7] == 0) {
						mat[9][7] = 1;
						buttons[9][7].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
						
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][8] == 0) {
						mat[9][8] = 1;
						buttons[9][8].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

		buttons[9][9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (mat[9][9] == 0) {
						mat[9][9] = 1;
						buttons[9][9].setBackground(Color.gray);
						bfs(mode);
						int boundary = bounadryc.checkBoundary(firex, firey);
						if (boundary == 1) {
							JOptionPane.showMessageDialog(null, "Computer Win");
							++computer_tern;
							computergame.setText(""+computer_tern);
							for(int i=0;i<=9;i++)
							{
								for(int j=0;j<=9;j++)
								{
									mat[i][j]=1;
								}
							}
						}
					} else {
					
					}
				} catch (Exception ex) {

				}
			}

		});

	}

	/*
 * 
 * 
 * 
 */
	private void bfs(int mode) {
		int boundary = 0;
		Integer ux = firex;
		Integer uy = firey;
		Integer vx, vy;
		int color[][] = new int[11][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				par[i][j] = 0;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(ux);
		q.add(uy);
		par[ux][uy] = 0;
		color[ux][uy] = 1;
		while (!q.isEmpty()) {
			ux = q.remove();
			uy = q.remove();
			if (mode == 1) {

				for (int i = 0; i < 4; i++) {
					vx = ux + x[i];
					vy = uy + y[i];
					if ((vx >= 0 && vx <= 9) && (vy >= 0 && vy <= 9)) {

						if (color[vx][vy] == 0 && mat[vx][vy] == 0) {
							int xx = ux * 10 + uy;
							par[vx][vy] = xx;
							color[vx][vy] = 1;
							q.add(vx);
							q.add(vy);
							boundary = boundary_check(vx, vy);

							if (boundary == 1) {

								printpath(vx, vy);
								int queuetag = 0;
								while (!queue.isEmpty()) {
									++queuetag;

									int pp = queue.remove();
									int py = queue.remove();
									if (queuetag == 2) {
										mat[firex][firey] = 0;
										buttons[firex][firey]
												.setBackground(Color.white);
										firex = pp;
										firey = py;
										buttons[firex][firey]
												.setBackground(Color.red);
										mat[firex][firey] = 1;
									}

								}
								break;
							}
						}

					}
				}
			} else if (mode == 2) {
				for (int i = 0; i < 8; i++) {
					

					vx = ux + X[i]; 
					vy = uy + Y[i];
					if ((vx >= 0 && vx <= 9) && (vy >= 0 && vy <= 9)) {

						if (color[vx][vy] == 0 && mat[vx][vy] == 0) {
							int xx = ux * 10 + uy;
							par[vx][vy] = xx;
							color[vx][vy] = 1;
							q.add(vx);
							q.add(vy);
							boundary = boundary_check(vx, vy);

							if (boundary == 1) {

								printpath(vx, vy);
								int queuetag = 0;
								while (!queue.isEmpty()) {
									++queuetag;

									int pp = queue.remove();
									int py = queue.remove();
									if (queuetag == 2) {
										mat[firex][firey] = 0;
										buttons[firex][firey]
												.setBackground(Color.white);
										firex = pp;
										firey = py;
										buttons[firex][firey]
												.setBackground(Color.red);
										mat[firex][firey] = 1;
									}

								}
								break;
							}
						}

					}
				

				}
			}
			if (boundary == 1)
				break;

		}
		if (boundary == 0) {
			JOptionPane.showMessageDialog(null, "Human Wins");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					mat[i][j] = 1;
				}
			}
			++human_tern;
			humangame.setText("" + human_tern);
		}
	}

	/*
 * 
 * 
 */
	private void printpath(Integer vx, Integer vy) {

		if (firex == vx && firey == vy) {

			return;
		} else {
			int x, y;
			x = par[vx][vy] / 10;
			y = par[vx][vy] % 10;
			printpath(x, y);
			queue.add(x);
			queue.add(y);

		}
		queue.add(vx);
		queue.add(vy);
	}

	/*
 * 
 * 
 * 
 * 
 */

	private int boundary_check(Integer vx, Integer vy) {
		int boundary = 0;
		for (int i = 0; i <= 9; i++) {
			if (vx == 0 && vy == i || vx == i && vy == 0 || vx == 9 && vy == i
					|| vx == i && vy == 9) {
				boundary = 1;
			}
		}
		return boundary;
	}

	private void setButton() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].setBackground(Color.white);
				down.add(buttons[i][j]);
				mat[i][j] = 0;
			}
		}

	}

}
