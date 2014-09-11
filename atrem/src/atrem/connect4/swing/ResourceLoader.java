package atrem.connect4.swing;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ResourceLoader {
	private String iconSource = "/icons/";
	private String[] imageName = {"Connect4.png", "C4Icon.png"};
	private static ImageIcon connect4, c4Icon;

	public ResourceLoader() {
		connect4 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[0])));
		c4Icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[1])));
	}

	public ImageIcon getIcon() {
		return c4Icon;
	}
}