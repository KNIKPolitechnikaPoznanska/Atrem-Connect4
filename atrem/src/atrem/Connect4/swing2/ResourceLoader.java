package atrem.Connect4.swing2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResourceLoader {
	String iconSource = "/icons/";
	String[] imageName = { "empty.png", "token1.png", "token2.png" };
	ImageIcon iconEmpty, iconPl1, iconPl2;

	public ResourceLoader() {
		iconEmpty = new ImageIcon(SlotPanel.class.getResource(iconSource
				+ imageName[0]));
		// iconPl1 = new ImageIcon(SlotPanel.class.getResource(iconSource
		// + imageName[1]));
		// iconPl2 = new ImageIcon(SlotPanel.class.getResource(iconSource
		// + imageName[2]));
	}

	public Icon get(int numb) {
		switch (numb) {
		case 0:
			return iconEmpty;
			// case 1:
			// return iconPl1;
			// case 2:
			// return iconPl2;
		default:
			System.out.println("Plik nie znaleziony!");
			return null;
		}
	}
}
