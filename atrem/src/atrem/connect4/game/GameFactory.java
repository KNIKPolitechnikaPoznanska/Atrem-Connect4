package atrem.connect4.game;

import java.awt.Color;
import java.util.Random;

import atrem.connect4.console.PlayerConsole;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.ai.EasyPC;
import atrem.connect4.game.player.ai.MediumPC;
import atrem.connect4.swing.SwingPresenter;

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
	private Color token1Color, token2Color;

	/**
	 * £aduje GameController (all settings)
	 */
	public PlayerId randomFirstTurn() {
		Random rand = new Random();
		if (rand.nextInt() % 2 == 0)
			return PlayerId.PLAYER1;
		else
			return PlayerId.PLAYER2;
	}

	/**
	 * Tworzy GameController.
	 */
	public void createGameController() {
		gameController = new GameController();
		gameController.setBoard(board);
		createPlayerGame();
		gameController.setPlayer1(player1);
		gameController.setPlayer2(player2);
		gameController.setPlayerTurn(randomFirstTurn());
		gameController.setPl1Color(token1Color);
		gameController.setPl2Color(token2Color);
	}

	/**
	 * Tworzy dla ka¿dego gracza w³asnego prezentera
	 */
	public void createPlayerGame() {
		switch (player1Type) {
		case GameConfig.CHuman:
			player1 = createHumanPlayer(1);
			break;
		case GameConfig.CcpuEasy:
			player1 = createCpuEasyPlayer(PlayerId.PLAYER1);
			break;
		case GameConfig.CcpuMedium:
			player1 = createCpuMediumPlayer(PlayerId.PLAYER1);
		}

		switch (player2Type) {
		case GameConfig.CHuman:
			player2 = createHumanPlayer(2);
			break;
		case GameConfig.CcpuEasy:
			player2 = createCpuEasyPlayer(PlayerId.PLAYER2);
			break;
		case GameConfig.CcpuMedium:
			player2 = createCpuMediumPlayer(PlayerId.PLAYER2);
		}

	}

	/**
	 * Tworzy CPU Medium.
	 * 
	 * @param playerID
	 * @return MediumPC
	 */
	private PlayerController createCpuMediumPlayer(PlayerId playerID) {
		return new MediumPC(gameController, player2name, playerID, new Logic(
				gameController));
	}

	/**
	 * Tworzy CPU Easy
	 * 
	 * @param playerID
	 * @return EasyPC
	 */
	private PlayerController createCpuEasyPlayer(PlayerId playerID) {
		return new EasyPC(gameController, player2name, playerID);
	}

	/**
	 * Tworzy Kontroler gracza.
	 * 
	 * @param playerNmb
	 *            Numer gracza [1,2]
	 * @return humanPlayer
	 */
	private PlayerController createHumanPlayer(int playerNmb) {
		PlayerController humanPlayer = null;
		if (playerNmb == 1) {
			switch (gamePl1Type) {
			case "console":
				humanPlayer = new PlayerConsole(gameController, player1name,
						PlayerId.PLAYER1);
				break;
			case "swing":
				humanPlayer = new SwingPresenter(gameController, player1name,
						PlayerId.PLAYER1, token1Color, token2Color, true, 0);
				break;
			default:
				System.out.println("Brak typu gry!");
			}
		}
		if (playerNmb == 2) {
			switch (gamePl2Type) {
			case "console":
				humanPlayer = new PlayerConsole(gameController, player2name,
						PlayerId.PLAYER2);
				break;
			case "swing":
				humanPlayer = new SwingPresenter(gameController, player2name,
						PlayerId.PLAYER2, token1Color, token2Color, false, 0);
				break;
			default:
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

	public void setToken1Color(Color token1Color) {
		this.token1Color = token1Color;
	}

	public void setToken2Color(Color token2Color) {
		this.token2Color = token2Color;
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
