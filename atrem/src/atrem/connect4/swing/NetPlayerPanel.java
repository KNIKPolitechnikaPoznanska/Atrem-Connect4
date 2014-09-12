package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import executableRMIclases.Client;

public class NetPlayerPanel extends JPanel {
	private JTextField txtGracz;
	private JTextField txtIp;
	private NetPlayerFrame netPlayerFrame;
	private Color color;
	JLabel lblNewLabel, lblGraSieciowa, lblNewLabel_1, lblNewLabel_2,
			lblNewLabel_3;
	private Client client;

	public NetPlayerPanel(NetPlayerFrame netPlayerFrame) {
		setBackground(Color.ORANGE);
		setLayout(null);
		this.netPlayerFrame = netPlayerFrame;

		lblGraSieciowa = new JLabel("GRA SIECIOWA");
		lblGraSieciowa.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblGraSieciowa.setBounds(140, 27, 199, 37);
		add(lblGraSieciowa);

		txtGracz = new JTextField();
		txtGracz.setText("Gracz 1");
		txtGracz.setBounds(160, 93, 99, 20);
		add(txtGracz);
		txtGracz.setColumns(10);

		lblNewLabel = new JLabel("Imie gracza");
		lblNewLabel.setBounds(10, 78, 94, 50);
		add(lblNewLabel);

		final JButton btnKoloretonu = new JButton("Kolor \u017Cetonu");
		btnKoloretonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = btnKoloretonu.getBackground();
				color = JColorChooser.showDialog(null,
						"Gracz: Wybierz kolor ¿etonu.", initialBackground);
				btnKoloretonu.setBackground(color);

			}
		});
		btnKoloretonu.setBounds(160, 154, 99, 23);
		add(btnKoloretonu);

		lblNewLabel_1 = new JLabel("Wybierz sw\u00F3j kolor");
		lblNewLabel_1.setBounds(10, 140, 200, 50);
		add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Podaj IP serwera");
		lblNewLabel_2.setBounds(10, 201, 112, 50);
		add(lblNewLabel_2);

		txtIp = new JTextField();
		txtIp.setText("IP");
		txtIp.setBounds(160, 216, 99, 20);
		add(txtIp);
		txtIp.setColumns(10);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(240, 140, 68, 50);
		add(lblNewLabel_3);

		JButton btnNewButton = new JButton("GO!");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					client = new Client(txtGracz.getText(), color, txtIp
							.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		netPlayerFrame.dispose();
		btnNewButton.setBounds(292, 248, 89, 23);
		add(btnNewButton);
	}
}
