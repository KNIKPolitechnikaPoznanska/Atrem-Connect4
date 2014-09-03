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
	private int rows, slots, chosenSlot = 1, freeRow, slot;
	private JLabel[][] swingBoard;
	private JButton[] button;
	private SwingPresenter swingPresenter;
	private ResourceLoader iconResource = new ResourceLoader();
	private HoleState holeState;

	public GameBoard(SwingPresenter swingPresenter) {
		rows = 6;
		slots = 7;
		this.swingPresenter = swingPresenter;
		setLayout(new GridLayout(rows + 1, slots));
		swingBoard = new JLabel[rows][slots];
		button = new JButton[slots];
		createButtons();
		createHoles();
	}

	/**
	 * Tworzy guziki nad slotami
	 */
	private void createButtons() {
		for (int tempSlot = 0; tempSlot < slots; tempSlot++) {
			button[tempSlot] = new JButton("" + (tempSlot + 1));

			button[tempSlot].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent TokenPlaced) {
					Object s = TokenPlaced.getSource();
					for (int tempSlot = 0; tempSlot < slots; tempSlot++) {
						if (s == button[tempSlot]) {
							chosenSlot = tempSlot;
							sendGUINbSlot();
						}
					}
				}
			});
			add(button[tempSlot]);
		}
	}

	/**
	 * Tworzy Labele w swing pokazuj¹ce 'dziury'. !!! rowsy z slotsami
	 * zamienione miejscami na potrzebe jlabela !!!
	 */
	private void createHoles() {
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
	}

	// int changeIconInSlot(int slots, int rows, int iconNumber)
	// {}

	public void setFreeRow(int row, int slot, HoleState holeState) {
		this.freeRow = row;
		this.holeState = holeState;
		swingBoard[row][slot].setIcon(iconResource.get(holeState));
	}

	// void placeTokenInSlot(int slot) {
	// Plansza[1][1].setIcon(iconResource.get(1));
	// }

	public void disableButtons(boolean parameter) {
		for (int tempSlot = 0; tempSlot < slots; tempSlot++)
			button[tempSlot].setEnabled(parameter);
	}

	public void placeOpponentToken(HoleState i, int oppRow, int oppSlot) {
		swingBoard[oppRow][oppSlot].setIcon(iconResource.get(i));
	}

	/**
	 * Wysy³a, który guzik(slot) zosta³ klikniêty.
	 */
	public void sendGUINbSlot() {
		swingPresenter.getSlotFromView(chosenSlot);
	}

	public void setBoardSize(int rows, int slots) {
		this.rows = rows;
		this.slots = slots;
	}

	// void placeTokenInSlot(int slot) {
	// Plansza[1][1].setIcon(iconResource.get(1));
	// }

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
}
