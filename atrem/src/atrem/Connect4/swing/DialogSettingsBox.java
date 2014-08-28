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

public class DialogSettingsBox extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 973461278407448042L;
	private final JPanel contentPanel = new JPanel();
	private static DialogSettingsBox dialog;
	private JTextField pl2Txt, pl1Txt, TxtSlots, TxtRows;
	private JButton okButton, btnDefault, cancelButton;
	private JPanel buttonPane;
	private JLabel pl1NameLab, pl2NameLab, LabelSlotSet, LabelRowSet,
			labSpacer, LabelsetBoard, LabelSetPlayers;
	private JCheckBox isCPU;
	private String defPl1Name = "Gracz 1", defPl2Name = "Gracz 2", pl1Name,
			pl2Name;
	private int defSlots = 7, defRows = 6, slots, rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new DialogSettingsBox();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSettingsBox() {
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
			isCPU = new JCheckBox("Gracz 2 - CPU");
			isCPU.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(isCPU);
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
			LabelSlotSet = new JLabel("Ilo\u015B\u0107 slot\u00F3w:");
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
			LabelRowSet = new JLabel("Ilo\u015B\u0107 wierszy:");
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
				okButton = new JButton("Start");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (saveSettings()) {
							sendSettings();
						}
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				btnDefault = new JButton("Default");
				btnDefault.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setDefaults();
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
						System.exit(0);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void sendSettings() {

	}

	protected void setDefaults() {
		pl1Txt.setText(defPl1Name);
		pl2Txt.setText(defPl2Name);
		TxtSlots.setText(Integer.toString(defSlots));
		TxtRows.setText(Integer.toString(defRows));
	}

	protected boolean saveSettings() {
		pl1Name = pl1Txt.getText();
		pl2Name = pl2Txt.getText();
		try {
			slots = Integer.parseInt(TxtSlots.getText());
			rows = Integer.parseInt(TxtRows.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(dialog, "Wpisz poprawn¹ liczbê!");
			return false;
		}
		return true;

	}

}
