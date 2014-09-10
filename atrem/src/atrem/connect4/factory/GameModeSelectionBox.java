package atrem.connect4.factory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import atrem.connect4.Connect4;

public class GameModeSelectionBox extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private final JRadioButton online;
	private final JRadioButton offline;

	/**
	 * Create the dialog.
	 */
	public GameModeSelectionBox() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel
				.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel label = new JLabel("Wybierz tryb gry:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));

		ButtonGroup buttonGroup = new ButtonGroup();
		online = new JRadioButton("online", true);
		online.setFont(new Font("Tahoma", Font.PLAIN, 20));
		offline = new JRadioButton("offline", true);
		offline.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(online);
		buttonGroup.add(offline);

		contentPanel.add(label);
		contentPanel.add(online);
		contentPanel.add(offline);

		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (online.isSelected()) {
						try {
							new Connect4().createOnlineBox();
						} catch (RemoteException | NotBoundException e) {
						}
					} else if (offline.isSelected()) {
						new Connect4().createOfflineBox();
					}
					dispose();
				}
			});
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonPane.add(cancelButton);
		}
		pack();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
