package RMITest;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import atrem.connect4.game.GameState;
import atrem.connect4.game.LastMove;
import atrem.connect4.game.Logic;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class GameControllerService extends UnicastRemoteObject
		implements
			RemoteGameController {

	RemoteGameController remoteGameController;

	public GameControllerService(RemoteGameController remoteGameController)
			throws RemoteException {
		this.remoteGameController = remoteGameController;
	}

	@Override
	public int move(int slot) {
		try {
			return remoteGameController.move(slot);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
		return 0;
	}

	@Override
	public void startNewGame() {
		try {
			remoteGameController.startNewGame();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void wakeUpGCr() {
		try {
			remoteGameController.wakeUpGCr();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public void analyseDecision() {
		try {
			remoteGameController.analyseDecision();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public void run() {
		try {
			remoteGameController.run();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public void startGameLoop() {
		try {
			remoteGameController.startGameLoop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public void backToMenu() {
		try {
			remoteGameController.backToMenu();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public void wakeUp() {
		try {
			remoteGameController.wakeUp();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public HoleState getHoleState(int rows, int slots) {
		try {
			return remoteGameController.getHoleState(rows, slots);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setResult(ResultState result) {
		try {
			remoteGameController.setResult(result);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
	}

	@Override
	public PlayerId getPlayerTurn() {
		try {
			return remoteGameController.getPlayerTurn();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setPlayerTurn(PlayerId playerTurn) {
		try {
			remoteGameController.setPlayerTurn(playerTurn);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public int getEmptySpot() {
		try {
			return remoteGameController.getEmptySpot();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return 0;
	}

	@Override
	public ResultState getResult() {
		try {
			return remoteGameController.getResult();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public Board getBoard() {
		try {
			return remoteGameController.getBoard();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setBoard(Board board) {
		try {
			remoteGameController.setBoard(board);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public PlayerController getPlayer1() {
		try {
			return remoteGameController.getPlayer1();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setPlayer1(PlayerController player1) {
		try {
			remoteGameController.setPlayer1(player1);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public PlayerController getPlayer2() {
		try {
			return remoteGameController.getPlayer2();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setPlayer2(PlayerController player2) {
		try {
			remoteGameController.setPlayer2(player2);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public GameState getGamestate() {
		try {
			return remoteGameController.getGamestate();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public PlayerController getCurrentPlayer() {
		try {
			return remoteGameController.getCurrentPlayer();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public LastMove getLastMove() {
		try {
			return remoteGameController.getLastMove();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void setGamestate(GameState gamestate) {
		try {
			remoteGameController.setGamestate(gamestate);
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}

	}

	@Override
	public Logic getLogic() {
		try {
			return remoteGameController.getLogic();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public List<Point> getWinningCoordinates() {
		try {
			return remoteGameController.getWinningCoordinates();
		} catch (RemoteException e) {
			System.out.println("wyjatek w remoteGameController");
		}
		return null;
	}

	@Override
	public void addRemotePlayer(RemotePlayerController rPCC)
			throws RemoteException {
		// PlayerController playerController = new PlayerControllerClient(rPCC);

		// switch (gamecontroller.getGamestate()) {
		// case PRE_INIT :
		// gamecontroller.setPlayer1(playerController);
		// break;
		// case END_INIT_1 :
		// gamecontroller.setPlayer2(playerController);
		// this.notifyAll();
		// break;
		// }
		// gamecontroller.connectPlayer();

	}
}
