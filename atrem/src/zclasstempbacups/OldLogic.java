package zclasstempbacups;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.HoleState;

/*
 * Logika gry
 */
public class OldLogic {
	private int maxRows;
	private int maxSlots;
	private GameController gameController;
	private HoleState token;
	private boolean hasWinner = false;
	private boolean cpuWin = false;
	private String human = "human", cpu = "cpu";

	public OldLogic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getRows();
	}

	/**
	 * Sprawdzenie u≥oøenia 4 w 4 wariantach
	 * 
	 * @return true jeøeli gracz wygra≥
	 */
	public boolean checkIfWin() {
		hasWinner = false;
		columnWin(human);
		rowWin(human);
		diagonalWin1(human);
		diagonalWin2(human);
		return hasWinner;
	}

	/**
	 * Funkcja sprawdza stan gry czy jest remis
	 * 
	 * @param doneMoves
	 *            - wykonane ruchy
	 * @return zwraca true jeøeli jest remis(wszystkie sloty pe≥ne)
	 */

	public boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.Draw);
			return true;
		}
		return false;
	}

	/**
	 * Sprawdü czy wygra≥ PC
	 * 
	 * @return true jeøeli wygra≥
	 */
	public boolean checkIfWinPC() {
		columnWin(cpu);
		rowWin(cpu);
		diagonalWin1(cpu);
		diagonalWin2(cpu);
		return cpuWin;
	}

	/**
	 * Sprawdzenie wyniku gry
	 * 
	 * @param doneMoves
	 *            wykonane ruchy
	 * @return true jeøeli win lub draw
	 */
	public boolean checkResult(int doneMoves) {
		checkIfWin();
		checkIfDraw(doneMoves);
		if (gameController.getResult() == ResultState.NO_WIN)
			return false;
		return true;
	}

	private void columnWin(String playerType) {
		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row, slot + 1)
						&& token == gameController.getHoleState(row, slot + 2)
						&& token == gameController.getHoleState(row, slot + 3)) {
					setPlayerWon(playerType);
				}
			}
		}
	}

	// potem zamieniÊ za warunki
	// private boolean checkNextHole(int row, int slot) {
	// return token == gameController.getHoleState(row, slot);
	// }

	private void diagonalWin1(String playerType) {
		for (int row = 0; row < maxRows - 3; row++) { // skos /
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row + 1,
								slot + 1)
						&& token == gameController.getHoleState(row + 2,
								slot + 2)
						&& token == gameController.getHoleState(row + 3,
								slot + 3))
					setPlayerWon(playerType);
			}
		}
	}

	private void diagonalWin2(String playerType) {
		for (int row = maxRows - 1; row >= 3; row--) { // skos \
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = gameController.getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row - 1,
								slot + 1)
						&& token == gameController.getHoleState(row - 2,
								slot + 2)
						&& token == gameController.getHoleState(row - 3,
								slot + 3))
					setPlayerWon(playerType);
			}
		}
	}

	private void rowWin(String playerType) {
		for (int slot = 0; slot < maxSlots; slot++) { // wiersz
			for (int row = 0; row < maxRows - 3; row++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row + 1, slot)
						&& token == gameController.getHoleState(row + 2, slot)
						&& token == gameController.getHoleState(row + 3, slot))
					setPlayerWon(playerType);
			}
		}
	}

	private void setPlayerWon(String playerType) {
		if (playerType == cpu) {
			cpuWin = true;
			return;
		}
		if (token == HoleState.PLAYER1) {
			gameController.setResult(ResultState.PLAYER_1_WIN);
		} else if (token == HoleState.PLAYER2) {
			gameController.setResult(ResultState.PLAYER_2_WIN);
		}
	}

	public boolean getCPUwin() {
		return cpuWin;
	}

	public void setCPUwin(boolean CPUwin) {
		this.cpuWin = CPUwin;
	}
}
