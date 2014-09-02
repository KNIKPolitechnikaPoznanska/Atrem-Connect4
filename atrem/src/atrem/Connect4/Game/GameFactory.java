package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.Game.player.ai.MediumPC;
import atrem.Connect4.console.Menu;
import atrem.Connect4.swing.SwingConfig;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {

	private Board board;
	private PlayerController player1, player2;
	private Menu menu; // console opt
	private SwingConfig swingconfig; // swing opt
	private String im2, im1; // niejasna nazwa PAWE£
	private String opponent;
	private int slot, row;
	private GameController gameController;

	public void createGame(String gameType) {
		if (gameType == "console")
			this.readInfoMenu(); // niejasna nazwa PAWE£
		else if (gameType == "swing")
			this.readInfoConfig(); // niejasna nazwa PAWE£
	}

	public void loadGameController() {
		gameController = new GameController();
		gameController.setBoard(board);
		gameController.setPlayer1(player1);
		gameController.setPlayer2(player2);

	}

	public void readInfoMenu() {
		this.board = new Board(menu.getRows(), menu.getSlots());
		im1 = menu.getPlayer1name();
		im2 = menu.getPlayer2name();
		opponent = menu.getOpponent();
		slot = menu.getSlots();
		row = menu.getRows();
	}

	public void readInfoConfig() { // swing
		this.board = new Board(swingconfig.getRows(), swingconfig.getSlots());
		im1 = swingconfig.getPlayer1name();
		im2 = swingconfig.getPlayer2name();
		opponent = swingconfig.getOpponent();
		slot = swingconfig.getSlots();
		row = swingconfig.getRows();
		// nie lepiej "wypelnic" row i slot i z tego utworzyc plansze zamiast
		// get ze swinga 2 razy?
	}

	public void createPlayerGame() { // nigdzie nie jest wywolywane dlatego
										// pleyer 1 null MIELOCH

		if (opponent.equalsIgnoreCase("K")) // pytanie czy jak to dizala i czy
											// dziala z DialogBoxem MIELOCH
			player2 = new MediumPC(im2, HoleState.PLAYER2, gameController,
					gameController.getLogic());
		else
			player2 = new SwingPresenter(swingconfig.getPlayer2name(),
					HoleState.PLAYER2);
		player1 = new SwingPresenter(swingconfig.getPlayer1name(),
				HoleState.PLAYER1);
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public GameController getGame() { // niejasna nazwa PAWE£
		return gameController;
	}

	public GameController getGameController() { // po co drugi getter do
												// powyzej?
		return gameController;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public SwingConfig getSwingconfig() {
		return swingconfig;
	}

	public void setSwingconfig(SwingConfig swingconfig) {
		this.swingconfig = swingconfig;
	}

}
