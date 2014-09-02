package atrem.Connect4.swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	private int rows;
	private int slots;
	private JLabel[][] Plansza;
	private JButton[] button;
	private int PlayerID;
	private SwingPresenter swingPresenter;
	private int chosenSlot = 1;
	private ResourceLoader iconResource = new ResourceLoader();
	private int freeRow;

	public Panel(SwingPresenter swingPresenter) {
		rows = 6;
		slots = 7;
		// this.rows = swingPresenter.getRows();
		// this.slots = swingPresenter.getSlots();
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
							// getGUISlot(); // zmieniæ na send
							
							Plansza[freeRow][tempSlot].setIcon(iconResource
									.get(PlayerID));
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

	public void getGUISlot() {
		swingPresenter.getSlotFromView(chosenSlot);
	}

	public int giveSlot() {
		return chosenSlot;
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
