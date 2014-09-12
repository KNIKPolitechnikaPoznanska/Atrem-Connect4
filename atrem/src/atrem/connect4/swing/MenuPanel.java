package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.connect4.Connect4;

public class MenuPanel extends JPanel {
	Connect4 game;
	MenuFrame menuFrame;
	NetPlayerFrame netPlayerFrame;
	SerwerFrame serwerFrame;

	public MenuPanel(final MenuFrame menuFrame) {
		setBackground(Color.ORANGE);
		setLayout(null);
		this.menuFrame = menuFrame;

		JButton btnNewButton = new JButton("JEDEN KOMPUTER");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game = new Connect4();
				menuFrame.dispose();

			}
		});
		btnNewButton.setBounds(135, 108, 159, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DWA KOMPUTERY");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				netPlayerFrame = new NetPlayerFrame();
				netPlayerFrame.setVisible(true);
				menuFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(135, 157, 159, 23);
		add(btnNewButton_1);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnExit.setBounds(351, 266, 89, 23);
		add(btnExit);

		JLabel lblWitajWConnect = new JLabel("WITAJ W CONNECT 4");
		lblWitajWConnect.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblWitajWConnect.setBounds(113, 11, 271, 50);
		add(lblWitajWConnect);

		JButton btnNewButton_2 = new JButton("POSTAW SERWER");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				serwerFrame = new SerwerFrame();
				serwerFrame.setVisible(true);
				menuFrame.dispose();

			}
		});
		btnNewButton_2.setBounds(135, 203, 159, 23);
		add(btnNewButton_2);

	}
}
