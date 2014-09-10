package atrem.connect4.game;

import java.awt.Point;
import java.util.List;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public interface GameController {

<<<<<<< HEAD
	// TODO wyrzucic to co niepotrzebne
	public abstract int move(int slot);

	public abstract void startNewGame();

	public abstract void wakeUpGCr();
=======
	/**
	 * Sprawdza którego z graczy jest kolej
	 * 
	 * @return player1 lub player2
	 */
	private PlayerController currentPlayer() {
		switch (playerTurn) {
			case PLAYER1 :
				return player1;
			case PLAYER2 :
				return player2;
			default :
				return null; // player1
		}
	}
>>>>>>> branch 'RMI-Adm&Grz' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	public abstract void analyseDecision();

	public abstract void run();

	public abstract void startGameLoop();

	public abstract void backToMenu();

	public abstract void wakeUp();

	public abstract HoleState getHoleState(int rows, int slots);

<<<<<<< HEAD
	public abstract void setResult(ResultState result);
=======
	private synchronized void gameLoop() {// ma odczytywaæ GameState
		boolean endGame;
		logic = new Logic(this);
		lastMove = new LastMove();
		System.out.println("przed init");
		waitForInit();
		while (resultState == ResultState.NO_WIN) {
			currentPlayer = currentPlayer();
			try {
				this.wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentPlayer.yourTurn();
			gameState = GameState.WAITING_FOR_MOVE;
			waitForMove();
			doneMoves++;
			endGame = logic.getResultOfMove(lastMove.getLastRow(),
					lastMove.getLastSlot(), doneMoves);
>>>>>>> branch 'RMI-Adm&Grz' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	public abstract PlayerId getPlayerTurn();

	public abstract void setPlayerTurn(PlayerId playerTurn);

	public abstract int getEmptySpot();

	public abstract ResultState getResult();

<<<<<<< HEAD
	public abstract Board getBoard();
=======
	public synchronized void wakeUpGCr() {
		switch (gameState) {
			case PRE_INIT :
				gameState = GameState.END_INIT_1;
				break;
			case END_INIT_1 :
				gameState = GameState.END_INIT_ALL;
				this.notifyAll();
				break;
			default :
				break;
		}
	}
>>>>>>> branch 'RMI-Adm&Grz' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	public abstract void setBoard(Board board);

	public abstract PlayerController getPlayer1();

	public abstract void setPlayer1(PlayerController player1);

	public abstract PlayerController getPlayer2();

	public abstract void setPlayer2(PlayerController player2);

<<<<<<< HEAD
	public abstract GameState getGamestate();
=======
	public void backToMenu() {
		GameFactory gameFactory = new GameFactory();
		GameConfig config = new GameConfig(gameFactory);
		config.showClientDBox();
	}
>>>>>>> branch 'RMI-Adm&Grz' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	public abstract PlayerController getCurrentPlayer();

	public abstract LastMove getLastMove();

	public abstract void setGamestate(GameState gamestate);

	public abstract Logic getLogic();

	public abstract List<Point> getWinningCoordinates();

}
