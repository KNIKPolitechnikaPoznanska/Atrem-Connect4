package atrem.Connect4.swing;

import javax.swing.Icon;

import atrem.Connect4.Game.board.HoleState;

public class ResourceLoader {
	String iconSource = "/icons/";
	String[] imageName = { "empty.png", "token1.png", "token2.png" };
	StretchIcon iconEmpty, iconPl1, iconPl2;
	private int labelH, labelW;
	private HoleState holeState;

	public ResourceLoader() {

		iconEmpty = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[0]));
		// iconEmpty.getImage().s
		iconPl1 = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[1]));
		iconPl2 = new StretchIcon(GameFrame.class.getResource(iconSource
				+ imageName[2]));
	}

	public Icon get(HoleState holeState) {
		switch (holeState) {
		case EMPTY:
			return iconEmpty;
		case PLAYER1:
			return iconPl1;
		case PLAYER2:
			return iconPl2;
		default:
			System.out.println("Plik nie znaleziony!");
			return null;
		}
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