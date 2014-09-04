package atrem.Connect4.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stats extends JPanel {

	/**
	 * Create the panel.
	 */
	public Stats() {
		setBackground(new Color(255, 140, 0));
		setLayout(null);

		JLabel lblGracz = new JLabel("PUNKTACJA");
		lblGracz.setBackground(Color.CYAN);
		lblGracz.setBounds(92, 26, 102, 14);
		// lblGracz.setText("6969696");
		add(lblGracz);

		JLabel lblGracz_1 = new JLabel("Gracz 1");
		lblGracz_1.setBounds(40, 51, 83, 35);
		add(lblGracz_1);

		JLabel lblGracz_2 = new JLabel("Gracz 2");
		lblGracz_2.setBounds(161, 61, 46, 14);
		add(lblGracz_2);

		JLabel lblPkt = new JLabel("pkt1");
		lblPkt.setBounds(38, 89, 46, 14);
		add(lblPkt);

		JLabel lblPkt_1 = new JLabel("pkt2");
		lblPkt_1.setBounds(171, 89, 46, 14);
		add(lblPkt_1);

	}

}
