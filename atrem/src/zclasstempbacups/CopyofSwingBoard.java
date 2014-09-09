package zclasstempbacups;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.connect4.game.board.HoleState;
import atrem.connect4.swing.ResourceLoader;
import atrem.connect4.swing.SwingPresenter;

public class CopyofSwingBoard extends JPanel { // nazwa niejasna PAWE£

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	private int rows, slots, chosenSlot, freeRow;
	private JLabel[][] Plansza;
	private JButton[] button;
	private int PlayerID;
	private SwingPresenter swingPresenter;
	private ResourceLoader iconResource = new ResourceLoader();
	private HoleState holeState;

	public CopyofSwingBoard(SwingPresenter swingPresenter) {
		rows = 6;
		slots = 7;// SZTYWNE.
					// ZAMIENIC/DOKONCZYC
					// PAWE£
		// this.rows = gameController.getRows();
		// this.slots = gameController.getSlots();
		this.swingPresenter = swingPresenter;

		setLayout(new GridLayout(rows + 1, slots));

		Plansza = new JLabel[rows][slots];
		button = new JButton[slots];

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
							getGUISlot(); // zmieniæ na send
							Plansza[freeRow][tempSlot].setIcon(iconResource
									.get(holeState));
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
				Plansza[tempRow][tempSlot] = new JLabel();// SZTYWNE.
															// ZAMIENIC/DOKONCZYC
															// PAWE£
				add(Plansza[tempRow][tempSlot]);
				// iconResource.setLabelH((int) Plansza[tempRow][tempSlot]
				// .getSize().getHeight());
				// iconResource.setLabelW((int) Plansza[tempRow][tempSlot]
				// .getSize().getWidth());
				Plansza[tempRow][tempSlot].setIcon(iconResource
						.get(holeState.EMPTY));
			}
		}

		// int changeIconInSlot(int slots, int rows, int iconNumber)
		// {
		//
		// }
	}

	public void getGUISlot() {
		swingPresenter.getSlotFromView(chosenSlot);
	}

	public void setFreeRow(int row, int slot, int ID) {
		this.freeRow = row;
		this.PlayerID = ID;
	}

	// void placeTokenInSlot(int slot) {
	// // Plansza[1][1].setIcon(iconResource.get(1));
	// Plansza[i][j].setText("chuj");
	// }
}
