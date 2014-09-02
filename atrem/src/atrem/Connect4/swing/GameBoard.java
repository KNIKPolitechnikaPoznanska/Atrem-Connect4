package atrem.Connect4.swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.board.HoleState;

public class GameBoard extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	private int rows;
	private int slots;
	private JLabel[][] swingBoard;
	private JButton[] button;

	private SwingPresenter swingPresenter;
	private int chosenSlot = 1;
	private ResourceLoader iconResource = new ResourceLoader();
	private int freeRow;
	private HoleState holeState;

	public GameBoard(SwingPresenter swingPresenter) {
		rows = 6;
		slots = 7;
		// this.rows = swingPresenter.getRows();
		// this.slots = swingPresenter.getSlots();
		this.swingPresenter = swingPresenter;

		setLayout(new GridLayout(rows + 1, slots));

		swingBoard = new JLabel[rows][slots];
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
							sendGUISlot();

							swingBoard[freeRow][tempSlot].setIcon(iconResource
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
				swingBoard[tempRow][tempSlot] = new JLabel();
				add(swingBoard[tempRow][tempSlot]);
				// iconResource.setLabelH((int) Plansza[tempRow][tempSlot]
				// .getSize().getHeight());
				// iconResource.setLabelW((int) Plansza[tempRow][tempSlot]
				// .getSize().getWidth());
				swingBoard[tempRow][tempSlot].setIcon(iconResource
						.get(holeState.EMPTY));
			}
		}

		// int changeIconInSlot(int slots, int rows, int iconNumber)
		// {
		//
		// }
	}

	public void sendGUISlot() {
		swingPresenter.getSlotFromView(chosenSlot);
	}

	public void setFreeRow(int row, int slot, HoleState holeState) {
		this.freeRow = row;
		this.holeState = holeState;
	}

	public void setBoardSize(int rows, int slots) {
		this.rows = rows;
		this.slots = slots;

		// void placeTokenInSlot(int slot) {
		// // Plansza[1][1].setIcon(iconResource.get(1));
		// Plansza[i][j].setText("chuj");
		// }
	}

	public void disableButtons(boolean parameter) {
		for (int tempSlot = 0; tempSlot < slots; tempSlot++)
			button[tempSlot].setEnabled(parameter);
	}

	public void changeTokenVisibility() {

	}
}
