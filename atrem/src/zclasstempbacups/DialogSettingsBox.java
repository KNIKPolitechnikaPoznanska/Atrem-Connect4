package zclasstempbacups;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import atrem.connect4.Connect4Swing;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameFactory;

public class DialogSettingsBox extends JDialog {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 973461278407448042L;
	private final JPanel contentPanel = new JPanel();
	private static DialogSettingsBox dialog;
	private JTextField pl2Txt, pl1Txt, TxtSlots, TxtRows;
	private JButton startButton, btnDefault, cancelButton;
	private JPanel buttonPane;
	private JLabel pl1NameLab, pl2NameLab, LabelSlotSet, LabelRowSet,
			labSpacer, LabelsetBoard, LabelSetPlayers, PlayerLbl1, playerLbl2;;
	private JCheckBox CPUmark;
	private final String DEF_PL1_NAME = "Gracz 1", DEF_PL2_NAME = "Gracz 2";
	private final int DEF_SLOTS = 7, DEF_ROWS = 6;
	private String pl1Name, pl2Name;
	private int slots, rows;
	private boolean CPU;
	private String pl1GameType, pl2GameType;
	private GameConfig swingConfig;
	private JRadioButton rdbtnConsole1, rdbtnSwing1, rdbtnNet1, rdbtnConsole2,
			rdbtnSwing2, rdbtnNet2;
	private ButtonGroup pl1BoardType, pl2BoardType;
	private GameFactory gameFactory;

	public String getPl1GameType() {
		return pl1GameType;
	}

	public void setPl1GameType(String pl1GameType) {
		this.pl1GameType = pl1GameType;
	}

	public String getPl2GameType() {
		return pl2GameType;
	}

	public void setPl2GameType(String pl2GameType) {
		this.pl2GameType = pl2GameType;
	}

	/**
	 * Create the settings dialog.
	 * 
	 * @param swingConfig
	 */
	public DialogSettingsBox(GameConfig swingConfig, GameFactory gameFactory) {
		this.swingConfig = swingConfig;
		this.gameFactory = gameFactory;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Connect4 Settings");
		setBounds(100, 100, 400, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			LabelSetPlayers = new JLabel("     Ustawienia graczy      ");
			LabelSetPlayers.setFont(new Font("Tahoma", Font.PLAIN, 24));
			contentPanel.add(LabelSetPlayers);
		}
		{
			pl1NameLab = new JLabel("Imi\u0119 Gracza 1");
			pl1NameLab.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(pl1NameLab);
		}
		{
			pl1Txt = new JTextField();
			pl1Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			pl1Txt.setText(DEF_PL1_NAME);
			contentPanel.add(pl1Txt);
			pl1Txt.setColumns(10);
		}
		{
			pl2NameLab = new JLabel("Imi\u0119 Gracza 2");
			pl2NameLab.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(pl2NameLab);
		}
		{
			pl2Txt = new JTextField();
			pl2Txt.setText(DEF_PL2_NAME);
			pl2Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(pl2Txt);
			pl2Txt.setColumns(10);
		}
		{
			CPUmark = new JCheckBox("Gracz 2 - CPU");
			CPUmark.setFont(new Font("Tahoma", Font.PLAIN, 20));
			CPUmark.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cpuCheckBoxCheck();
				}
			});
			CPUmark.setActionCommand("markCPU");
			contentPanel.add(CPUmark);
		}
		{
			labSpacer = new JLabel("                      ");
			contentPanel.add(labSpacer);
		}
		{
			LabelsetBoard = new JLabel(
					"         Ustawienia planszy            ");
			LabelsetBoard.setFont(new Font("Tahoma", Font.PLAIN, 24));
			contentPanel.add(LabelsetBoard);
		}
		{
			LabelSlotSet = new JLabel("Ilo\u015B\u0107 slot\u00F3w (> 4):");
			LabelSlotSet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(LabelSlotSet);
		}
		{
			TxtSlots = new JTextField();
			TxtSlots.setFont(new Font("Tahoma", Font.PLAIN, 20));
			TxtSlots.setText(Integer.toString(DEF_SLOTS));
			contentPanel.add(TxtSlots);
			TxtSlots.setColumns(10);
		}
		{
			LabelRowSet = new JLabel("Ilo\u015B\u0107 wierszy (> 4):");
			LabelRowSet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(LabelRowSet);
		}
		{
			TxtRows = new JTextField();
			TxtRows.setFont(new Font("Tahoma", Font.PLAIN, 20));
			TxtRows.setText(Integer.toString(DEF_ROWS));
			contentPanel.add(TxtRows);
			TxtRows.setColumns(10);
		}
		{
			PlayerLbl1 = new JLabel("Gracz 1: ");
			contentPanel.add(PlayerLbl1);
		}
		{
			rdbtnConsole1 = new JRadioButton("Console");
			contentPanel.add(rdbtnConsole1);
		}
		{
			rdbtnSwing1 = new JRadioButton("Swing");
			contentPanel.add(rdbtnSwing1);
			rdbtnSwing1.setSelected(true);
		}
		{
			rdbtnNet1 = new JRadioButton("Multiplayer");
			contentPanel.add(rdbtnNet1);
		}
		{
			playerLbl2 = new JLabel("Gracz 2: ");
			contentPanel.add(playerLbl2);
		}
		{
			rdbtnConsole2 = new JRadioButton("Console");
			contentPanel.add(rdbtnConsole2);
		}
		{
			rdbtnSwing2 = new JRadioButton("Swing");
			contentPanel.add(rdbtnSwing2);
			rdbtnSwing2.setSelected(true);
		}
		{
			rdbtnNet2 = new JRadioButton("Multiplayer");
			contentPanel.add(rdbtnNet2);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				startButton = new JButton("Start");
				startButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						startButtonPressed();
					}
				});
				startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

				buttonPane.add(startButton);
				getRootPane().setDefaultButton(startButton);
			}
			{
				btnDefault = new JButton("Default");
				btnDefault.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						defalutButtonPressed();
					}
				});
				btnDefault.setFont(new Font("Tahoma", Font.PLAIN, 20));
				buttonPane.add(btnDefault);
			}
			{
				cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cancelButtonPressed();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

				buttonPane.add(cancelButton);
			}
			{
				pl1BoardType = new ButtonGroup();
				pl2BoardType = new ButtonGroup();
			}
			{
				pl1BoardType.add(rdbtnConsole1);
				pl1BoardType.add(rdbtnSwing1);
				pl1BoardType.add(rdbtnNet1);
			}
			{
				pl2BoardType.add(rdbtnConsole2);
				pl2BoardType.add(rdbtnSwing2);
				pl2BoardType.add(rdbtnNet2);
			}
			this.setVisible(true);
		}
	}

	/**
	 * Klikniêcie guzika "Start"
	 */
	private void startButtonPressed() {
		if (saveSettings()) {
			swingConfig.setupSettings();
			dispose();
			new Connect4Swing().init(swingConfig, gameFactory);
		}
	}

	/**
	 * Zapisuje wartoœci pól z okna dialogowego i przypisuje do GameConfig
	 * 
	 * @return true je¿eli zapis siê powiedzie
	 */
	protected boolean saveSettings() {
		setPl1Name(pl1Txt.getText());
		setPl2Name(pl2Txt.getText());

		// mo¿na bez wyj¹tku? PAWE£&BARTEK
		try {
			setSlots(Integer.parseInt(TxtSlots.getText()));
			setRows(Integer.parseInt(TxtRows.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(dialog,
					"Wpisz poprawn¹ wartoœæ pola!");
			return false;
		}

		if (getSlots() < 4 || getRows() < 4) {
			JOptionPane.showMessageDialog(dialog, "Sloty i Wiersze > 4!");
			return false;
		}

		if (rdbtnConsole1.isSelected())
			setPl1GameType("console");
		if (rdbtnConsole2.isSelected())
			setPl2GameType("console");
		if (rdbtnSwing1.isSelected())
			setPl1GameType("swing");
		if (rdbtnSwing2.isSelected())
			setPl2GameType("swing");

		return true;
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
	 * Ustawia wartoœci domyœlne gry
	 */
	protected void setDefaults() {
		pl1Txt.setText(DEF_PL1_NAME);
		pl2Txt.setText(DEF_PL2_NAME);
		TxtSlots.setText(Integer.toString(DEF_SLOTS));
		TxtRows.setText(Integer.toString(DEF_ROWS));
	}

	public JCheckBox getIsCPU() {
		return CPUmark;
	}

	private void cpuCheckBoxCheck() {
		setCPU(CPUmark.getModel().isSelected());
	}

	public String getPl1Name() {
		return pl1Name;
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

	public boolean isCPU() {
		return CPU;
	}

	public void setCPU(boolean cPU) {
		CPU = cPU;
	}

	public void setIsCPU(JCheckBox isCPU) {
		this.CPUmark = isCPU;
	}

	public void setPl1Name(String pl1Name) {
		this.pl1Name = pl1Name;
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
}