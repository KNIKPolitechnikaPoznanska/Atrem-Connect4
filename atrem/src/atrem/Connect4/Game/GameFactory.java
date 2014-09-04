package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.Game.player.ai.EasyPC;
import atrem.Connect4.Game.player.ai.MediumPC;
import atrem.Connect4.console.PlayerConsole;
import atrem.Connect4.swing.GameConfig;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa tworz¹ca planszê (Board)
 */
public class GameFactory {
	private Board board;
	private PlayerController player1, player2;
	private GameController gameController;
	private String player2name, player1name, player1Type, player2Type,
			gamePl1Type, gamePl2Type;
	private int slots, rows;

	/**
	 * £aduje GameController (all settings)
	 */
	public void createGameController() {
		gameController = new GameController();
		gameController.setBoard(board);
		createPlayerGame();
		gameController.setPlayer1(player1);
		gameController.setPlayer2(player2);
		gameController.setPlayerTurn(PlayerId.Player1);
	}

	/**
	 * Tworzy dla ka¿dego gracza w³asnego prezentera
	 */
	public void createPlayerGame() {
		switch (player1Type) {
			case GameConfig.CHuman :
				player1 = createHumanPlayer(1);
				break;
			case GameConfig.CcpuEasy :
				player1 = createCpuEasyPlayer();
				break;
			case GameConfig.CcpuMedium :
				player1 = createCpuMediumPlayer();
		}

		switch (player2Type) {
			case GameConfig.CHuman :
				player2 = createHumanPlayer(2);
				break;
			case GameConfig.CcpuEasy :
				player2 = createCpuEasyPlayer();
				break;
			case GameConfig.CcpuMedium :
				player2 = createCpuMediumPlayer();
		}

	}
	private PlayerController createCpuMediumPlayer() {
		return new MediumPC(gameController, player2name, PlayerId.Player2,
				new Logic(gameController));
	}

	private PlayerController createCpuEasyPlayer() {
		return new EasyPC(gameController, player2name, PlayerId.Player2);
	}

	private PlayerController createHumanPlayer(int playerNmb) {
		PlayerController humanPlayer = null;
		if (playerNmb == 1) {
			switch (gamePl1Type) {
				case "console" :
					humanPlayer = new PlayerConsole(gameController,
							player1name, PlayerId.Player1);
					break;
				case "swing" :
					humanPlayer = new SwingPresenter(player1name,
							PlayerId.Player1, gameController, true);
					break;
				default :
					System.out.println("Brak typu gry!");
			}
		}
		if (playerNmb == 2) {
			switch (gamePl2Type) {
				case "console" :
					humanPlayer = new PlayerConsole(gameController,
							player2name, PlayerId.Player2);
					break;
				case "swing" :
					humanPlayer = new SwingPresenter(player2name,
							PlayerId.Player2, gameController, true);
					break;
				default :
					humanPlayer = null;
					System.out.println("Brak typu gry!");
			}
		}
		return humanPlayer;
	}
	public Board getBoard() {
		return board;
	}

	public GameController getGameController() {
		return gameController;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public String getPlayer1Name() {
		return player1name;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public String getPlayer2Name() {
		return player2name;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setBoard() {
		board = new Board(rows, slots);
	}

	public void setGamePl1Type(String gamePl1Type) {
		this.gamePl1Type = gamePl1Type;
	}

	public void setGamePl2Type(String gamePl2Type) {
		this.gamePl2Type = gamePl2Type;
	}

	public void setPlayer1Name(String player1Name) {
		this.player1name = player1Name;
	}

	public void setPlayer2Name(String player2Name) {
		this.player2name = player2Name;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getPlayer1Type() {
		return player1Type;
	}

	public void setPlayer1Type(String player1Type) {
		this.player1Type = player1Type;
	}

	public String getPlayer2Type() {
		return player2Type;
	}

	public void setPlayer2Type(String player2Type) {
		this.player2Type = player2Type;
	}
}
