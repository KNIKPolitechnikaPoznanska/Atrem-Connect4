package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {

	int rows = 6;
	int slots = 7;
	int chosenSlot;
	JLabel[][] Plansza = new JLabel[rows][slots];
	JButton[] button = new JButton[slots];
    ResourceLoader iconResource = new ResourceLoader();
	// private ResourceLoader iconResource;
	// ActionListener newMouve = new placeToken();
	

	public Panel() {

		setLayout(new GridLayout(rows + 1, slots));

		for (int tempSlot = 0; tempSlot < slots; tempSlot++) {
			button[tempSlot] = new JButton("" + (tempSlot + 1));
			add(button[tempSlot]);

			button[tempSlot].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent TokenPlaced) {
					Object s = TokenPlaced.getSource();
					for (int tempSlot = 0; tempSlot < slots; tempSlot++) {
						if (s == button[tempSlot]) {
							chosenSlot = tempSlot;
							int PlayerID = 1;
							int freeRow = 4;
							// Plansza[freeRow][tempSlot].setIcon(iconResource
							// .get(PlayerID));
							// w miejsce 0 - method nextFreeRow()
						}
					}
				}
			});
		}
		/**
		 * rowsy z slotsami zamienione miejscami na potrzebe jlabela
		 */
		for (int tempRow = 0; tempRow < rows; tempRow++) {
			for (int tempSlot = 0; tempSlot < slots; tempSlot++) {
				// Plansza[tempRow][tempSlot] = new JLabel("" + tempRow + ", "
				// + tempSlot);
				Plansza[tempRow][tempSlot] = new JLabel();
				add(Plansza[tempRow][tempSlot]);
				// iconResource.setLabelH((int) Plansza[tempRow][tempSlot]
				// .getSize().getHeight());
				// iconResource.setLabelW((int) Plansza[tempRow][tempSlot]
				// .getSize().getWidth());
				Plansza[tempRow][tempSlot].setIcon(iconResource.get(0));
			}
		}

		// int changeIconInSlot(int slots, int rows, int iconNumber)
		// {
		//
		// }
	}

	// void placeTokenInSlot(int slot) {
	// // Plansza[1][1].setIcon(iconResource.get(1));
	// Plansza[i][j].setText("chuj");
	// }

	public int getGUISlot() {
		return chosenSlot;
	}
}

/*
 * int PlayerID; switch(PlayerID){ case 0:
 * Plansza[0][tempSlot].setIcon(iconResource.get(0)); return; case 1:
 * Plansza[0][tempSlot].setIcon(iconResource.get(1)); return; case 2:
 * Plansza[0][tempSlot].setIcon(iconResource.get(2)); return; default:
 * System.out.println("Tu nie powinniœmy siê nigdy znaleŸæ..."); return;
 */