package atrem.connect4.game;

import java.awt.Point;
import java.util.List;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public interface GameController {

	// TODO wyrzucic to co niepotrzebne
	public abstract int move(int slot);

	public abstract void startNewGame();

	public abstract void connectPlayer();

	public abstract void endPlayerInit();

	public abstract void analyseDecision();

	public abstract void run();

	public abstract void startGameLoop();

	public abstract void backToMenu();

	public abstract void wakeUp();

	public abstract HoleState getHoleState(int rows, int slots);

	public abstract void setResult(ResultState result);

	public abstract PlayerId getPlayerTurn();

	public abstract void setPlayerTurn(PlayerId playerTurn);

	public abstract int getEmptySpot();

	public abstract ResultState getResult();

	public abstract Board getBoard();

	public abstract void setBoard(Board board);

	public abstract PlayerController getPlayer1();

	public abstract void setPlayer1(PlayerController player1);

	public abstract PlayerController getPlayer2();

	public abstract void setPlayer2(PlayerController player2);

	public abstract GameState getGameState();

	public abstract PlayerController getCurrentPlayer();

	public abstract Move getLastMove();

	public abstract void setGamestate(GameState gamestate);

	public abstract Logic getLogic();

	public abstract List<Point> getWinningCoordinates();

	public PlayerAttributes getPlayer1Attributes();

	public void setPlayer1Attributes(PlayerAttributes player1Attributes);

	public PlayerAttributes getPlayer2Attributes();

	public void setPlayer2Attributes(PlayerAttributes player2Attributes);
}