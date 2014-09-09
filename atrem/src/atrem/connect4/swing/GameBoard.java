package atrem.connect4.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerId;

public class GameBoard extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7328887218009010574L;
	private int rows, slots, chosenSlot = 1, freeRow, slot;
	private DLabel[][] swingBoard;
	private JButton[] button;
	private SwingPresenter swingPresenter;
	private HoleState holeState;
	private Color myTokenColor, opponentTokenColor;
	private PlayerId playerID;

	public GameBoard(SwingPresenter swingPresenter) {
		slots = swingPresenter.getSlots();
		rows = swingPresenter.getRows();
		playerID = swingPresenter.getPlayerId();
		myTokenColor = swingPresenter.getPlayerColor();
		opponentTokenColor = swingPresenter.getOpponentColor();
		this.swingPresenter = swingPresenter;
		setLayout(new GridLayout(rows + 1, slots));
		swingBoard = new DLabel[rows][slots];
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
				swingBoard[tempRow][tempSlot] = new DLabel(playerID,
						myTokenColor, opponentTokenColor);
				add(swingBoard[tempRow][tempSlot]);
			}
		}
	}

	public void setFreeRow(int row, int slot, HoleState holeState) {
		this.freeRow = row;
		this.holeState = holeState;
		swingBoard[row][slot].changeTokenColor(holeState);
	}

	public void enableButtons(boolean parameter) {
		for (int tempSlot = 0; tempSlot < slots; tempSlot++)
			button[tempSlot].setEnabled(parameter);
	}

	/**
	 * Wysy³a, który guzik(slot) zosta³ klikniêty.
	 */
	public void sendGUINbSlot() {
		swingPresenter.getSlotFromView(chosenSlot);
	}

	public void setColor(int row, int slot, Color color) {
		swingBoard[row][slot].changeTo(color);
	}

	public void setBoardSize(int rows, int slots) {
		this.rows = rows;
		this.slots = slots;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
}
