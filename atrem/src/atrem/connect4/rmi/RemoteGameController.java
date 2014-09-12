package atrem.connect4.rmi;

import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import atrem.connect4.game.GameState;
import atrem.connect4.game.Logic;
import atrem.connect4.game.Move;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public interface RemoteGameController extends Remote {

	public abstract int move(int slot) throws RemoteException;

	public abstract void startNewGame() throws RemoteException;

	public abstract void connectPlayer() throws RemoteException;

	public abstract void endPlayerInit() throws RemoteException;

	public abstract void analyseDecision() throws RemoteException;

	public abstract void run() throws RemoteException;

	public abstract void startGameLoop() throws RemoteException;

	public abstract void backToMenu() throws RemoteException;

	public abstract void wakeUp() throws RemoteException;

	public abstract HoleState getHoleState(int rows, int slots)
			throws RemoteException;

	public abstract void setResult(ResultState result) throws RemoteException;

	public abstract PlayerId getPlayerTurn() throws RemoteException;

	public abstract void setPlayerTurn(PlayerId playerTurn)
			throws RemoteException;

	public abstract int getEmptySpot() throws RemoteException;

	public abstract ResultState getResult() throws RemoteException;

	public abstract Board getBoard() throws RemoteException;

	public abstract void setBoard(Board board) throws RemoteException;

	public abstract PlayerController getPlayer1() throws RemoteException;

	public abstract void setPlayer1(PlayerController player1)
			throws RemoteException;

	public abstract PlayerController getPlayer2() throws RemoteException;

	public abstract void setPlayer2(PlayerController player2)
			throws RemoteException;

	public abstract GameState getGamestate() throws RemoteException;

	public abstract PlayerController getCurrentPlayer() throws RemoteException;

	public abstract Move getLastMove() throws RemoteException;

	public abstract void setGamestate(GameState gamestate)
			throws RemoteException;

	public abstract Logic getLogic() throws RemoteException;

	public abstract List<Point> getWinningCoordinates() throws RemoteException;

	public void addPlayerController(
			RemotePlayerController remotePlayerController)
			throws RemoteException;

	public PlayerAttributes getPlayer1Attributes() throws RemoteException;

	public void setPlayer1Attributes(PlayerAttributes player1Attributes)
			throws RemoteException;

	public PlayerAttributes getPlayer2Attributes() throws RemoteException;

	public void setPlayer2Attributes(PlayerAttributes player2Attributes)
			throws RemoteException;
}
