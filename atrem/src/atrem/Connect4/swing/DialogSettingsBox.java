package atrem.Connect4.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import atrem.Connect4.Connect4Swing;

public class DialogSettingsBox extends JDialog implements ActionListener {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 973461278407448042L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Okno dialgowe wyswietlajace "zle podana liczbe".
	 */
	private static DialogSettingsBox dialog;
	private JTextField pl2Txt, pl1Txt, TxtSlots, TxtRows;
	private JButton startButton, btnDefault, cancelButton;
	private JPanel buttonPane;
	private JLabel pl1NameLab, pl2NameLab, LabelSlotSet, LabelRowSet,
			labSpacer, LabelsetBoard, LabelSetPlayers;
	private JCheckBox CPUmark;
	private String defPl1Name = "Gracz 1", defPl2Name = "Gracz 2", pl1Name,
			pl2Name;
	private int defSlots = 7, defRows = 6, slots, rows;
	private boolean CPU;
	private SwingConfig swingConfig;

	/**
	 * Create the settings dialog.
	 * 
	 * @param swingConfig
	 */
	public DialogSettingsBox(SwingConfig swingConfig) {
		this.swingConfig = swingConfig;
		setTitle("Connect4 Settings");
		setBounds(100, 100, 404, 380);
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
			pl1Txt.setText(defPl1Name);
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
			pl2Txt.setText(defPl2Name);
			pl2Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(pl2Txt);
			pl2Txt.setColumns(10);
		}
		{
			CPUmark = new JCheckBox("Gracz 2 - CPU");
			CPUmark.setFont(new Font("Tahoma", Font.PLAIN, 20));
			CPUmark.addActionListener(this);
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
			TxtSlots.setText(Integer.toString(defSlots));
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
			TxtRows.setText(Integer.toString(defRows));
			contentPanel.add(TxtRows);
			TxtRows.setColumns(10);
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
				btnDefault.addActionListener(this);
				btnDefault.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnDefault.setActionCommand("default");
				buttonPane.add(btnDefault);
			}
			{
				cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(this);
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // zrobiæ w³asne listenrery
		String cmd = e.getActionCommand();
		switch (cmd) {

		case "default":
			setDefaults();
			break;
		case "Cancel":
			System.exit(0);
			break;
		// nie wiadomo czy po odznaczniu zmieni sie wartosc - sprawdzanie przy
		// kliknieciu start ?
		case "markCPU":
			setCPU(CPUmark.getModel().isSelected());
			break;
		}
	}

	private void startButtonPressed() {
		if (saveSettings()) {
			swingConfig.setSettings();
			new Connect4Swing().run();
			dispose();
		}
	}

	protected boolean saveSettings() {
		setPl1Name(pl1Txt.getText());
		setPl2Name(pl2Txt.getText());
		System.out.println(getPl1Name());
		// pytanie do Tomka/£ukasza
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
		} else
			return true;
	}

	protected void setDefaults() {
		pl1Txt.setText(defPl1Name);
		pl2Txt.setText(defPl2Name);
		TxtSlots.setText(Integer.toString(defSlots));
		TxtRows.setText(Integer.toString(defRows));
	}

	public JCheckBox getIsCPU() {
		return CPUmark;
	}

	public void setIsCPU(JCheckBox isCPU) {
		this.CPUmark = isCPU;
	}

	public String getPl1Name() {
		return pl1Name;
	}

	public void setPl1Name(String pl1Name) {
		this.pl1Name = pl1Name;
	}

	public String getPl2Name() {
		return pl2Name;
	}

	public void setPl2Name(String pl2Name) {
		this.pl2Name = pl2Name;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isCPU() {
		return CPU;
	}

	public void setCPU(boolean cPU) {
		CPU = cPU;
	}
}
