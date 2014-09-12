package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import executableRMIclases.Server;

public class SerwerPanel extends JPanel {
	private JTextField textField;
	private SerwerFrame serwerFrame;
	private JLabel nameSerwer, ip, serwerWork;
	private Server serwer;

	public SerwerPanel(SerwerFrame serwerFrame) {
		setBackground(Color.ORANGE);
		setLayout(null);
		this.serwerFrame = serwerFrame;

		nameSerwer = new JLabel("Serwer");
		nameSerwer.setFont(new Font("SketchFlow Print", Font.PLAIN, 18));
		nameSerwer.setBounds(173, 24, 200, 50);
		add(nameSerwer);

		ip = new JLabel("TWOJE IP:");
		ip.setBounds(10, 85, 76, 50);
		add(ip);

		JLabel stanSerwera = new JLabel("STAN SERWERA:");
		stanSerwera.setBounds(10, 184, 132, 50);
		add(stanSerwera);

		serwerWork = new JLabel("Wy\u0142\u0105czony");
		serwerWork.setBounds(152, 184, 200, 50);
		add(serwerWork);

		JButton goSerwer = new JButton("Postaw");
		goSerwer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				serwerWork.setText("DZIA£A!");
				serwer = new Server();

			}
		});
		goSerwer.setBounds(310, 188, 111, 62);
		add(goSerwer);

		InetAddress iAddress = null;
		try {
			iAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentIp = iAddress.getHostAddress();

		textField = new JTextField();
		textField.setBounds(142, 100, 145, 20);
		add(textField);
		textField.setColumns(10);

		textField.setText(currentIp);

	}

}
