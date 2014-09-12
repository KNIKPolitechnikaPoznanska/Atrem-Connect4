package atrem.connect4.swing;

import java.awt.Container;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class SerwerFrame extends JFrame {
	private Image c4Icon = new ResourceLoader().getIcon().getImage();
	private SerwerPanel serwerPanel;

	public SerwerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIconImage(c4Icon);
		Container mainContainer = getContentPane();
		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		serwerPanel = new SerwerPanel(this);
		getContentPane().add(serwerPanel);
		setBounds(200, 200, 470, 350);
		setResizable(false);
	}

}
