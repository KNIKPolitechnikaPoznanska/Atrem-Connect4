package atrem.connect4.factory;

import java.awt.Color;

import atrem.connect4.console.PlayerConsole;
import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.game.player.ai.EasyPC;
import atrem.connect4.game.player.ai.MediumPC;
import atrem.connect4.swing.SwingPresenter;

public class PlayerFactory {
	private GameController gameController;
	private PlayerController player1;
	private PlayerController player2;
	private PlayerAttributes player1Attributes;
	private PlayerAttributes player2Attributes;
	private String player2Name;
	private String player1Name;
	private String player1Type;
	private String player2Type;
	private String gamePl1Type;
	private String gamePl2Type;
	private Color player1Color;
	private Color player2Color;

	public PlayerFactory() {
	}

	/**
	 * Tworzy dla ka¿dego gracza w³asnego prezentera
	 * 
	 * @param gameController
	 */
	public void createPlayers(GameController gameController) {
		this.gameController = gameController;

		player1Attributes = new PlayerAttributes(player1Name, PlayerId.PLAYER1,
				0, player1Color);
		player2Attributes = new PlayerAttributes(player2Name, PlayerId.PLAYER2,
				0, player2Color);
		switch (player1Type) {
			case GameConfig.CHuman :
				player1 = createHumanPlayer(1);
				break;
			case GameConfig.CcpuEasy :
				player1 = new EasyPC(gameController, player1Attributes, 0);
				break;
			case GameConfig.CcpuMedium :
				player1 = new MediumPC(gameController, player1Attributes, 0);
		}

		switch (player2Type) {
			case GameConfig.CHuman :
				player2 = createHumanPlayer(2);
				break;
			case GameConfig.CcpuEasy :
				player2 = new EasyPC(gameController, player2Attributes, 0);
				break;
			case GameConfig.CcpuMedium :
				player2 = new MediumPC(gameController, player2Attributes, 0);
		}
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
				case "console" :
					humanPlayer = new PlayerConsole(gameController,
							player1Attributes);
					break;
				case "swing" :
					humanPlayer = new SwingPresenter(gameController,
							player1Attributes, player2Color, 0, true);
					break;
				default :
					System.out.println("Brak typu gry!");
			}
		}

		if (playerNmb == 2) {
			switch (gamePl2Type) {
				case "console" :
					humanPlayer = new PlayerConsole(gameController,
							player2Attributes);
					break;
				case "swing" :
					humanPlayer = new SwingPresenter(gameController,
							player2Attributes, player1Color, 0, true);
					break;
				default :
					humanPlayer = null;
					System.out.println("Brak typu gry!");
			}
		}
		return humanPlayer;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public String getPlayer1Name() {
		return player1Name;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public String getPlayer2Name() {
		return player2Name;
	}

	public PlayerAttributes getPlayer1Attributes() {
		return player1Attributes;
	}

	public PlayerAttributes getPlayer2Attributes() {
		return player2Attributes;
	}

	public void setGamePl1Type(String gamePl1Type) {
		this.gamePl1Type = gamePl1Type;
	}

	public void setGamePl2Type(String gamePl2Type) {
		this.gamePl2Type = gamePl2Type;
	}

	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}

	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
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

	public void setToken1Color(Color token1Color) {
		this.player1Color = token1Color;
	}

	public void setToken2Color(Color token2Color) {
		this.player2Color = token2Color;
	}
}
