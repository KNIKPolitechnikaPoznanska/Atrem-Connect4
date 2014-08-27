package atrem.Connect4.swing;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResourceLoader {
	String iconSource = "/icons/";
	String[] imageName = { "empty.png", "token1.png", "token2.png" };
	ImageIcon iconEmpty, iconPl1, iconPl2;
	private int labelH, labelW;

	public ResourceLoader() {

		iconEmpty = new ImageIcon(GameFrame.class.getResource(iconSource
				+ imageName[0]));
		// iconEmpty.getImage().s
		iconPl1 = new ImageIcon(GameFrame.class.getResource(iconSource
				+ imageName[1]));
		iconPl2 = new ImageIcon(GameFrame.class.getResource(iconSource
				+ imageName[2]));
	}

	public Icon get(int numb) {
		switch (numb) {
		case 0:
			return iconEmpty;
		case 1:
			return iconPl1;
		case 2:
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