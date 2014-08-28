package atrem.Connect4.swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Panel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	private int Rows;
	private int Slots;
	private JLabel[][] Plansza;
	private JButton[] button;

	private SwingPresenter swingPresenter;
	private int chosenSlot;
	private ResourceLoader iconResource = new ResourceLoader();
	private int freeRow;

	public Panel(SwingPresenter swingPresenter) {
		this.Rows = swingPresenter.getRows();
		this.Slots = swingPresenter.getSlots();
		this.swingPresenter = swingPresenter;

		setLayout(new GridLayout(Rows + 1, Slots));

		Plansza = new JLabel[Rows][Slots];
		button = new JButton[Slots];

		for (int tempSlot = 0; tempSlot < Slots; tempSlot++) {
			button[tempSlot] = new JButton("" + (tempSlot + 1));
			add(button[tempSlot]);

			button[tempSlot].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent TokenPlaced) {
					Object s = TokenPlaced.getSource();
					for (int tempSlot = 0; tempSlot < Slots; tempSlot++) {
						if (s == button[tempSlot]) {
							chosenSlot = tempSlot;
							getGUISlot();
							int PlayerID = 1;
							// setFreeRow();
							Plansza[getFreeRow()][tempSlot]
									.setIcon(iconResource.get(PlayerID));
						}
					}
				}
			});
		}
		/**
		 * rowsy z slotsami zamienione miejscami na potrzebe jlabela
		 */
		for (int tempRow = 0; tempRow < Rows; tempRow++) {
			for (int tempSlot = 0; tempSlot < Slots; tempSlot++) {
				Plansza[tempRow][tempSlot] = new JLabel();
				add(Plansza[tempRow][tempSlot]);
				iconResource.setLabelH((int) Plansza[tempRow][tempSlot]
						.getSize().getHeight());
				iconResource.setLabelW((int) Plansza[tempRow][tempSlot]
						.getSize().getWidth());
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

	public void setFreeRow(int row, int slot) {

		this.freeRow = row;

	}

	public int getFreeRow() {
		int row = freeRow;
		return row;
	}

	// void placeTokenInSlot(int slot) {
	// // Plansza[1][1].setIcon(iconResource.get(1));
	// Plansza[i][j].setText("chuj");
	// }
}