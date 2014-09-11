package atrem.connect4.game;

import java.awt.Point;
import java.util.List;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public interface GameController {

	public abstract void connectPlayer();

	public abstract void analyseDecision();

	public abstract void backToMenu();

	public abstract Board getBoard();

	public abstract PlayerController getCurrentPlayer();

	public abstract int getEmptySpot();

	public abstract GameState getGamestate();

	public abstract HoleState getHoleState(int rows, int slots);

	public abstract LastMove getLastMove();

	public abstract PlayerController getPlayer1();

	public abstract PlayerAttributes getPlayer1Attributes();

	public abstract PlayerController getPlayer2();

	public abstract PlayerAttributes getPlayer2Attributes();

	public abstract PlayerId getPlayerTurn();

	public abstract ResultState getResult();

	public abstract List<Point> getWinningCoordinates();

	public abstract int move(int slot);

	public abstract void setBoard(Board board);

	public abstract void setGamestate(GameState gamestate);

	public abstract void setPlayer1(PlayerController player1);

	public abstract void setPlayer1Attributes(PlayerAttributes player1Attributes);

	public abstract void setPlayer2(PlayerController player2);

	public abstract void setPlayer2Attributes(PlayerAttributes player2Attributes);

	public abstract void setPlayerTurn(PlayerId playerTurn);

	public abstract void setResult(ResultState result);

	public abstract void startGameLoop();

	public abstract void startNewGame();
}