package atrem.connect4.swing;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import atrem.connect4.game.board.HoleState;

public class ResourceLoader {
	private String iconSource = "/icons/";
	private String[] imageName = {"empty.png", "token1.png", "token2.png",
			"Connect4.png", "C4Icon.png"};
	public static StretchIcon iconPl1, iconPl2, iconEmpty;
	private static ImageIcon connect4, c4Icon;
	private int labelH, labelW;

	// private HoleState holeState;

	public ResourceLoader() {

		iconEmpty = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[0]));
		// iconEmpty.getImage().s
		iconPl1 = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[1]));
		iconPl2 = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[2]));
		connect4 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[3])));
		c4Icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(iconSource + imageName[4])));
	}

	public Icon get(HoleState holeState) {
		switch (holeState) {
			case EMPTY :
				return iconEmpty;
			case PLAYER1 :
				return iconPl1;
			case PLAYER2 :
				return iconPl2;
			default :
				System.out.println("Plik nie znaleziony!");
				return null;
		}
	}

	public ImageIcon getIcon() {
		return c4Icon;
	}

	public int getLabelH() {
		return labelH;
	}

	public void setLabelH(int labelH) {
		this.labelH = labelH;
	}

	public int getLabelW() {
		return labelW;
	}

	public void setLabelW(int labelW) {
		this.labelW = labelW;
	}
}

/*
 * ImageIcon zwracany;
 * 
 * public Icon get(int numb) { switch (numb) { case 0: zwracany =
 * stworzIconEmpty(); return zwracany; case 1: return iconPl1; // case 2: //
 * return iconPl2; default: System.out.println("Plik nie znaleziony!"); return
 * null; } }
 * 
 * public ImageIcon stworzIconEmpty() { iconEmpty = new
 * ImageIcon(C4gui.class.getResource(iconSource + imageName[0])); Image tmpimg =
 * iconEmpty.getImage(); // tmpimg.getScaledInstance(labelW, labelH,
 * Image.SCALE_DEFAULT); iconEmpty.setImage(tmpimg); return iconEmpty; }
 */