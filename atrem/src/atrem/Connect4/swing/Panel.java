package atrem.Connect4.swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

class Panel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	int rows;
	int slots;
	JLabel[][] Plansza;
	JButton[] button;
	// private ResourceLoader iconResource;
	// ActionListener newMouve = new placeToken();
	ResourceLoader iconResource = new ResourceLoader();

	public Panel(Game game) {
		rows = game.getBoardRows();
		slots = game.getBoardSlots();
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
							Plansza[0][tempSlot].setIcon(iconResource.get(2));
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

	// void placeTokenInSlot(int slot) {
	// // Plansza[1][1].setIcon(iconResource.get(1));
	// Plansza[i][j].setText("chuj");
	// }
}