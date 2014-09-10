package testy.game.remote;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.LastMove;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class LocalGameController implements GameController {
	private RemoteGameController remoteGameController;

	public LocalGameController(RemoteGameController remoteGameController) {
		this.remoteGameController = remoteGameController;
	}

	@Override
	public int move(int slot) {
		int spot = 0;
		try {
			spot = remoteGameController.move(slot);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return spot;
	}

	@Override
	public void startNewGame() {
		try {
			remoteGameController.startNewGame();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void connectPlayer() {
		try {
			remoteGameController.connectPlayer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void analyseDecision() {
		try {
			remoteGameController.analyseDecision();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void startGameLoop() {
		try {
			remoteGameController.startGameLoop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void backToMenu() {
		try {
			remoteGameController.backToMenu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public HoleState getHoleState(int rows, int slots) {
		HoleState holeState = null;
		try {
			holeState = remoteGameController.getHoleState(rows, slots);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return holeState;
	}

	@Override
	public void setResult(ResultState result) {
		try {
			remoteGameController.setResult(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PlayerId getPlayerTurn() {
		PlayerId playerId = null;
		try {
			playerId = remoteGameController.getPlayerTurn();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playerId;
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) {
		try {
			remoteGameController.setPlayerTurn(playerTurn);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getEmptySpot() {
		int spot = 0;
		try {
			spot = remoteGameController.getEmptySpot();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spot;
	}

	@Override
	public ResultState getResult() {
		ResultState resultState = null;
		try {
			resultState = remoteGameController.getResult();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultState;
	}

	@Override
	public Board getBoard() {
		Board board = null;
		try {
			board = remoteGameController.getBoard();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void setBoard(Board board) {
	}

	@Override
	public PlayerController getPlayer1() {
		PlayerController player = null;
		try {
			player = remoteGameController.getPlayer1();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public void setPlayer1(PlayerController player1) {
		try {
			remoteGameController.setPlayer1(player1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PlayerController getPlayer2() {
		PlayerController player = null;
		try {
			player = remoteGameController.getPlayer2();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public void setPlayer2(PlayerController player2) {
		try {
			remoteGameController.setPlayer2(player2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public GameState getGamestate() {
		GameState gameState = null;
		try {
			remoteGameController.getGamestate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameState;
	}

	@Override
	public PlayerController getCurrentPlayer() {
		PlayerController player = null;
		try {
			player = remoteGameController.getCurrentPlayer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public LastMove getLastMove() {
		LastMove lastMove = null;
		try {
			lastMove = remoteGameController.getLastMove();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastMove;
	}

	@Override
	public void setGamestate(GameState gamestate) {
		try {
			remoteGameController.setGamestate(gamestate);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Point> getWinningCoordinates() {
		List<Point> list = null;
		try {
			list = remoteGameController.getWinningCoordinates();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
