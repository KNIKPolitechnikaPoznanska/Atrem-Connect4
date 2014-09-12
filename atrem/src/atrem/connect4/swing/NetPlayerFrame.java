package atrem.connect4.swing;

import java.awt.Container;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class NetPlayerFrame extends JFrame {
	private Image c4Icon = new ResourceLoader().getIcon().getImage();
	private NetPlayerPanel netPlayerPanel;

	public NetPlayerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIconImage(c4Icon);
		Container mainContainer = getContentPane();
		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		netPlayerPanel = new NetPlayerPanel(this);
		getContentPane().add(netPlayerPanel);
		setBounds(200, 200, 470, 350);
		setResizable(false);
	}

}
