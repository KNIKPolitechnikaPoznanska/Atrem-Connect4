package atrem.connect4.game;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public interface GameController {

	// TODO wyrzucic to co niepotrzebne
	// Metody specjalne
	public abstract int move(int slot);

	public abstract void startNewGame();

	public abstract void connectPlayer();

	public abstract void analyseDecision();

	public abstract void startGameLoop();

	public abstract void backToMenu();

	// Gettery
	public abstract HoleState getHoleState(int rows, int slots);

	public abstract PlayerId getPlayerTurn();

	public abstract int getEmptySpot();

	public abstract Board getBoard();

	public abstract PlayerController getPlayer1();

	public abstract PlayerController getPlayer2();

	public abstract GameState getGamestate();

	public abstract LastMove getLastMove();

	public abstract PlayerAttributes getPlayer1Attributes();

	public PlayerAttributes getPlayer2Attributes();

	public abstract PlayerController getCurrentPlayer();

	public abstract ResultState getResult();

	public abstract Color getOpponentColor(PlayerId playerId);

	// Settery
	public abstract void setResult(ResultState result);

	public abstract void setPlayerTurn(PlayerId playerTurn);

	public abstract void setBoard(Board board);

	public abstract void setPlayer1(PlayerController player1);

	public abstract void setPlayer2(PlayerController player2);

	public abstract void setGamestate(GameState gamestate);

	public abstract List<Point> getWinningCoordinates();

	public void setPlayer1Attributes(PlayerAttributes player1Attributes);

	public void setPlayer2Attributes(PlayerAttributes player2Attributes);

}