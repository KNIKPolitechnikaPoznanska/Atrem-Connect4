package atrem.connect4.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import atrem.connect4.Connect4;

public class OfflineSettingsBox extends JDialog {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 973461278407448042L;
	private static OfflineSettingsBox dialog;
	private String pl1Name, pl2Name, pl1GameType, pl2GameType, pl1Type,
			pl2Type;
	private int slots, rows;
	private GameConfig gameConfig;
	private JPanel boardSetPanel, playerSetPanel, buttonPanel;
	private ButtonGroup buttonGroup1, buttonGroup2;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
			jLabel7;
	private JTabbedPane jTabbedPane;
	private JButton buttonStart, buttonDefault, buttonExit, buttonColor1,
			buttonColor2;
	private JTextField TFieldPl1Name, TFieldPl2Name, TFieldSlots, TFieldRows;
	private JRadioButton rBConsole1, rBSwing1, rBConsole2, rBSwing2;
	private JComboBox<String> plTypeBox1, plTypeBox2;
	private Color token1Color, token2Color;
	protected Color color1 = new Color(227, 252, 0), color2 = new Color(252, 0,
			67);

	/**
	 * Create the settings dialog.
	 * 
	 * @param swingConfig
	 */
	public OfflineSettingsBox(GameConfig swingConfig) {
		this.gameConfig = swingConfig;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		token1Color = color1;
		token2Color = color2;
		initComponents();
	}

	/**
	 * Klikniêcie guzika "Anuluj"
	 */
	private void cancelButtonPressed() {
		System.exit(0);
	}

	/**
	 * Klikniêcie guzika "Default"
	 */
	private void defalutButtonPressed() {
		setDefaults();
	}

	/**
	 * Klikniêcie guzika "Start"
	 */
	private void startButtonPressed() {
		if (saveSettings()) {
			gameConfig.setupOfflineSettings();
			dispose();
			new Connect4().createOfflineGame(gameConfig);
		}
	}

	/**
	 * Zapisuje wartoœci pól z okna dialogowego i przypisuje do GameConfig
	 * 
	 * @return true je¿eli zapis siê powiedzie
	 */
	private boolean saveSettings() {
		setPl1Name(TFieldPl1Name.getText());
		setPl2Name(TFieldPl2Name.getText());

		if (!setSlotsAndRows())
			return false;

		if (rBConsole1.isSelected())
			setPl1GameType("console");
		if (rBSwing1.isSelected())
			setPl1GameType("swing");

		if (rBSwing2.isSelected())
			setPl2GameType("swing");
		if (rBConsole2.isSelected())
			setPl2GameType("console");

		setPl1Type(plTypeBox1.getSelectedItem().toString());
		setPl2Type(plTypeBox2.getSelectedItem().toString());

		return true;
	}
	/**
	 * Ustawia sprawdzone wartoœci z pól TxtField
	 * 
	 * @return true jak siê powiedzie
	 */
	private boolean setSlotsAndRows() {
		try {
			setSlots(Integer.parseInt(TFieldSlots.getText()));
			setRows(Integer.parseInt(TFieldRows.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(dialog,
					"Wpisz poprawn¹ wartoœæ pola!");
			return false;
		}
		if (getSlots() < 4 || getRows() < 4) {
			JOptionPane.showMessageDialog(dialog, "Sloty i Wiersze > 4!");
			return false;
		}
		return true;
	}

	/**
	 * Ustawia wartoœci domyœlne gry
	 */
	private void setDefaults() {
		TFieldPl1Name.setText(GameConfig.DEF_PL1_NAME);
		TFieldPl2Name.setText(GameConfig.DEF_PL2_NAME);
		TFieldSlots.setText(Integer.toString(GameConfig.DEF_SLOTS));
		TFieldRows.setText(Integer.toString(GameConfig.DEF_ROWS));
	}

	private void disableGameTypeBoxes(JComboBox<String> item, int Nmb) {
		String selItem = (String) item.getSelectedItem();
		if (selItem == GameConfig.CcpuEasy || selItem == GameConfig.CcpuMedium
				|| selItem == GameConfig.CcpuHard) {
			if (Nmb == 1) {
				rBConsole1.setEnabled(false);
				rBSwing1.setEnabled(false);
			} else {
				rBConsole2.setEnabled(false);
				rBSwing2.setEnabled(false);
			}
		} else if (selItem == GameConfig.CHuman) {
			if (Nmb == 1) {
				rBConsole1.setEnabled(true);
				rBSwing1.setEnabled(true);
			} else {
				rBConsole2.setEnabled(true);
				rBSwing2.setEnabled(true);
			}
		}

	}

	private void initComponents() {
		buttonGroup1 = new ButtonGroup();
		buttonGroup2 = new ButtonGroup();
		buttonPanel = new JPanel();
		buttonStart = new JButton();
		buttonDefault = new JButton();
		buttonExit = new JButton();
		jTabbedPane = new JTabbedPane();
		playerSetPanel = new JPanel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		TFieldPl1Name = new JTextField();
		TFieldPl2Name = new JTextField();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		buttonColor1 = new JButton();
		buttonColor2 = new JButton();
		rBConsole1 = new JRadioButton();
		rBSwing1 = new JRadioButton();
		rBConsole2 = new JRadioButton();
		rBSwing2 = new JRadioButton();
		plTypeBox1 = new JComboBox<String>();
		plTypeBox2 = new JComboBox<String>();
		boardSetPanel = new JPanel();
		jLabel1 = new JLabel();
		jLabel7 = new JLabel();
		TFieldSlots = new JTextField();
		TFieldRows = new JTextField();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Connect4 Offline Settings");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setResizable(false);

		buttonPanel.setBorder(BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		buttonStart.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		buttonStart.setMnemonic('s');
		buttonStart.setText("Start");
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonPressed();
			}
		});

		buttonDefault.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		buttonDefault.setMnemonic('d');
		buttonDefault.setText("Default");
		buttonDefault.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				defalutButtonPressed();
			}
		});

		buttonExit.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		buttonExit.setMnemonic('e');
		buttonExit.setText("Exit");
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelButtonPressed();
			}
		});

		GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						buttonPanelLayout
								.createSequentialGroup()
								.addGap(23, 23, 23)
								.addComponent(buttonStart,
										GroupLayout.PREFERRED_SIZE, 183,
										GroupLayout.PREFERRED_SIZE)
								.addGap(176, 176, 176)
								.addComponent(buttonDefault,
										GroupLayout.PREFERRED_SIZE, 154,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED,
										62, Short.MAX_VALUE)
								.addComponent(buttonExit,
										GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)));
		buttonPanelLayout
				.setVerticalGroup(buttonPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								buttonPanelLayout
										.createSequentialGroup()
										.addGap(8, 8, 8)
										.addGroup(
												buttonPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																buttonStart,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																buttonDefault,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																buttonExit,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(8, 8, 8)));

		jTabbedPane.setBackground(new java.awt.Color(51, 200, 250));
		jTabbedPane.setBorder(BorderFactory.createEtchedBorder());
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jTabbedPane.setFont(new Font("Tahoma", 0, 20)); // NOI18N

		playerSetPanel.setBackground(new java.awt.Color(51, 204, 255));
		playerSetPanel.setFont(new Font("Tahoma", 0, 20)); // NOI18N

		jLabel2.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		jLabel2.setText("Imiê");

		jLabel3.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		jLabel3.setText("Imiê");

		TFieldPl1Name.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		TFieldPl1Name.setText("Gracz 1");

		TFieldPl2Name.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		TFieldPl2Name.setText("Gracz 2");

		jLabel4.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		jLabel4.setText("Kolory ¿etonów");

		jLabel5.setFont(new Font("Tahoma", 0, 22)); // NOI18N
		jLabel5.setText("Gracz 1");

		jLabel6.setFont(new Font("Tahoma", 0, 22)); // NOI18N
		jLabel6.setText("Gracz 2");

		buttonColor1.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		buttonColor1.setText("Zmieñ");
		buttonColor1.setBackground(color1);
		buttonColor1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = buttonColor1.getBackground();
				color1 = JColorChooser.showDialog(null,
						"Gracz 1: Wybierz kolor ¿etonu.", initialBackground);
				if (color1 != null) {
					buttonColor1.setBackground(color1);
				}
				token1Color = color1;
			}
		});

		buttonColor2.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		buttonColor2.setText("Zmieñ");
		buttonColor2.setBackground(color2);
		buttonColor2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = buttonColor2.getBackground();
				color2 = JColorChooser.showDialog(null,
						"Gracz 2: Wybierz kolor ¿etonu.", initialBackground);
				if (color2 != null) {
					buttonColor2.setBackground(color2);
				}
				token2Color = color2;
			}
		});

		buttonGroup1.add(rBConsole1);
		rBConsole1.setFont(new Font("Tahoma", 0, 19)); // NOI18N
		rBConsole1.setText("Konsola");

		buttonGroup1.add(rBSwing1);
		rBSwing1.setFont(new Font("Tahoma", 0, 19)); // NOI18N
		rBSwing1.setText("Okno Graficzne");
		rBSwing1.setSelected(true);

		buttonGroup2.add(rBConsole2);
		rBConsole2.setFont(new Font("Tahoma", 0, 19)); // NOI18N
		rBConsole2.setText("Konsola");

		buttonGroup2.add(rBSwing2);
		rBSwing2.setFont(new Font("Tahoma", 0, 19)); // NOI18N
		rBSwing2.setText("Okno Graficzne");
		rBSwing2.setSelected(true);

		plTypeBox1.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		plTypeBox1.setModel(new DefaultComboBoxModel<String>(
				GameConfig.playerTypeItems));
		plTypeBox1.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> item = (JComboBox<String>) e.getSource();
				disableGameTypeBoxes(item, 1);
			}
		});

		plTypeBox2.setFont(new Font("Tahoma", 0, 20)); // NOI18N
		plTypeBox2.setModel(new DefaultComboBoxModel<String>(
				GameConfig.playerTypeItems));
		plTypeBox2.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> item = (JComboBox<String>) e.getSource();
				disableGameTypeBoxes(item, 2);
			}
		});

		GroupLayout playerSetPanelLayout = new GroupLayout(playerSetPanel);
		playerSetPanelLayout
				.setHorizontalGroup(playerSetPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								playerSetPanelLayout
										.createSequentialGroup()
										.addGap(32)
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				playerSetPanelLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								playerSetPanelLayout
																										.createSequentialGroup()
																										.addGroup(
																												playerSetPanelLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																jLabel5)
																														.addGroup(
																																playerSetPanelLayout
																																		.createParallelGroup(
																																				Alignment.LEADING,
																																				false)
																																		.addComponent(
																																				TFieldPl1Name,
																																				GroupLayout.DEFAULT_SIZE,
																																				149,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				jLabel2,
																																				Alignment.TRAILING,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												357,
																												Short.MAX_VALUE)
																										.addGroup(
																												playerSetPanelLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																jLabel3,
																																GroupLayout.PREFERRED_SIZE,
																																59,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																TFieldPl2Name,
																																GroupLayout.PREFERRED_SIZE,
																																153,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																plTypeBox2,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel6)))
																						.addGroup(
																								playerSetPanelLayout
																										.createSequentialGroup()
																										.addGap(14)
																										.addGroup(
																												playerSetPanelLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																rBSwing1)
																														.addComponent(
																																rBConsole1)
																														.addGroup(
																																playerSetPanelLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				buttonColor1,
																																				GroupLayout.PREFERRED_SIZE,
																																				97,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(149)
																																		.addComponent(
																																				jLabel4,
																																				GroupLayout.PREFERRED_SIZE,
																																				140,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												118,
																												Short.MAX_VALUE)
																										.addGroup(
																												playerSetPanelLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																rBConsole2)
																														.addComponent(
																																rBSwing2)
																														.addComponent(
																																buttonColor2,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(44)))
																		.addGap(35))
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				plTypeBox1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				545,
																				Short.MAX_VALUE)))));
		playerSetPanelLayout
				.setVerticalGroup(playerSetPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								playerSetPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(jLabel6))
										.addGap(18)
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				TFieldPl1Name,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				TFieldPl2Name,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																plTypeBox1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																plTypeBox2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(27)
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLabel4,
																GroupLayout.PREFERRED_SIZE,
																33,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																buttonColor2)
														.addComponent(
																buttonColor1,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(34)
										.addGroup(
												playerSetPanelLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				rBConsole1)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				rBSwing1))
														.addGroup(
																playerSetPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				rBConsole2)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				rBSwing2)))
										.addContainerGap(74, Short.MAX_VALUE)));
		playerSetPanel.setLayout(playerSetPanelLayout);

		jTabbedPane.addTab("Ustawienia graczy", playerSetPanel);

		boardSetPanel.setBackground(new java.awt.Color(51, 240, 240));

		jLabel1.setFont(new Font("Tahoma", 0, 21)); // NOI18N
		jLabel1.setText("Sloty: ");

		jLabel7.setFont(new Font("Tahoma", 0, 21)); // NOI18N
		jLabel7.setText("Wiersze: ");

		TFieldSlots.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		TFieldSlots.setText("" + GameConfig.DEF_SLOTS);

		TFieldRows.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		TFieldRows.setText("" + GameConfig.DEF_ROWS);

		GroupLayout boardSetPanelLayout = new GroupLayout(boardSetPanel);
		boardSetPanel.setLayout(boardSetPanelLayout);
		boardSetPanelLayout
				.setHorizontalGroup(boardSetPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								boardSetPanelLayout
										.createSequentialGroup()
										.addContainerGap(360, Short.MAX_VALUE)
										.addGroup(
												boardSetPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel7)
														.addComponent(jLabel1))
										.addGap(18, 18, 18)
										.addGroup(
												boardSetPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																TFieldRows)
														.addComponent(
																TFieldSlots,
																GroupLayout.PREFERRED_SIZE,
																64,
																GroupLayout.PREFERRED_SIZE))
										.addGap(198, 198, 198)));
		boardSetPanelLayout
				.setVerticalGroup(boardSetPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								boardSetPanelLayout
										.createSequentialGroup()
										.addGap(72, 72, 72)
										.addGroup(
												boardSetPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																TFieldSlots,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												boardSetPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																TFieldRows,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(242, Short.MAX_VALUE)));

		jTabbedPane.addTab("Ustawienia planszy", boardSetPanel);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(buttonPanel,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jTabbedPane)
										.addContainerGap())));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(478, Short.MAX_VALUE)
								.addComponent(buttonPanel,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addGroup(
										layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(
														jTabbedPane,
														GroupLayout.PREFERRED_SIZE,
														443,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(90,
														Short.MAX_VALUE))));
		pack();
	}

	public String getPl1GameType() {
		return pl1GameType;
	}

	public String getPl1Name() {
		return pl1Name;
	}

	public String getPl2GameType() {
		return pl2GameType;
	}

	public Color getToken1Color() {
		return token1Color;
	}

	public Color getToken2Color() {
		return token2Color;
	}

	public String getPl2Name() {
		return pl2Name;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setPl1GameType(String pl1GameType) {
		this.pl1GameType = pl1GameType;
	}

	public void setPl1Name(String pl1Name) {
		this.pl1Name = pl1Name;
	}

	public void setPl2GameType(String pl2GameType) {
		this.pl2GameType = pl2GameType;
	}

	public void setPl2Name(String pl2Name) {
		this.pl2Name = pl2Name;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getPl1Type() {
		return pl1Type;
	}

	public void setPl1Type(String pl1Type) {
		this.pl1Type = pl1Type;
	}

	public String getPl2Type() {
		return pl2Type;
	}

	public void setPl2Type(String pl2Type) {
		this.pl2Type = pl2Type;
	}
}