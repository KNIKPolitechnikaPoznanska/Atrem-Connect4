package atrem.connect4.swing;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import atrem.connect4.game.board.HoleState;

public class ResourceLoader {
	private String iconSource = "/icons/";
	private String[] imageName = {"empty.png", "token1.png", "token2.png",
			"Connect4.png", "C4Icon.png"};
	private static ImageIcon connect4, c4Icon;

	public ResourceLoader() {

		connect4 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[3])));
		c4Icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[4])));
	}

	public Icon get(HoleState holeState) {
		switch (holeState) {

			default :
				System.out.println("Plik nie znaleziony!");
				return null;
		}
	}

	public ImageIcon getIcon() {
		return c4Icon;
	}
}