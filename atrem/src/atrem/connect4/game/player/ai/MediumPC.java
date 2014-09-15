package atrem.connect4.game.player.ai;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.Logic;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerDecision;
import atrem.connect4.game.player.PlayerId;

public class MediumPC implements PlayerController {
	private Logic logic;
	private PlayerAttributes playerAttributes;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private Board board;
	private Random rand;
	private GameController gameController;
	private PlayerId playerId;
	private int decision;

	public MediumPC(GameController gameController,
			PlayerAttributes playerAttributes, int playerPoints) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		this.logic = new Logic(gameController);
		board = gameController.getBoard();
		rand = new Random();
		gameController.wakeUpGCr();
	}

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		} else
			return emptySpot;
	}

	public int findSlotToMove() {
		board = gameController.getBoard();
		logic.setCPUwin(false);
		int simulatedRow;
		HoleState opp;

		if (board.playerIdtoHoleState(playerAttributes.getPlayerId()) == HoleState.PLAYER1)
			opp = HoleState.PLAYER2;
		else
			opp = HoleState.PLAYER1;
		// wywakic ^^
		if (gameController.getLastMove().getLastRow() == -1
				&& gameController.getLastMove().getLastSlot() == -1) {
			return 4;
		}
		for (int i = 0; i < board.getSlots(); i++) {// tu mamy x
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			else {

				board.setHoleState(simulatedRow, i,
						playerAttributes.getPlayerId());

				if (logic.checkIfWinPC(simulatedRow, i)) {// wiem ze mozna
															// lepiej
					board.cleanSpot(simulatedRow, i);
					return i;
				} else {
					board.cleanSpot(simulatedRow, i);
				}
			}
		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			else {
				board.setHoleState(simulatedRow, i, opp);
				if (logic.checkIfWinPC(simulatedRow, i)) {// wiem ze mozna
															// lepiej
					board.cleanSpot(simulatedRow, i);
					return i;
				} else
					board.cleanSpot(simulatedRow, i);
			}
		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			if (simulatedRow == board.getLastRow() // sprawdzanei ten sam level
					&& (i == board.getLastSlot() - 1 || i == board
							.getLastSlot() + 1)) {
				return i;
			}
		}
		for (int i = 0; i < board.getSlots(); i++) {
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			if (i == board.getLastSlot() - 1 || i == board.getLastSlot() + 1) {
				return i;
			}
		}
		int randomSlot;
		int choosenSpot;
		do {
			System.out.println("losowy ruch medium PC");
			randomSlot = rand.nextInt(board.getSlots());
			choosenSpot = board.findFreeSpot(randomSlot);
		} while (choosenSpot == -1);
		return randomSlot;

	}

	@Override
	public void yourTurn() {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println();
				gameController.move(findSlotToMove());
			}
		});
	}

	@Override
	public void endOfGame(ResultState resultGame) {
		decision = 0;
		if (resultGame == ResultState.PLAYER_1_WIN) {
			if (playerId == PlayerId.PLAYER1)
				playerAttributes.addPoints();
		}
		if (resultGame == ResultState.PLAYER_2_WIN) {
			if (playerId == PlayerId.PLAYER2)
				playerAttributes.addPoints();
		}

		makeDecision(decision);

	}

	public void makeDecision(int decision) {
		gameController.wakeUpGCr();

		playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);
		if (gameController.getGamestate() == GameState.END_INIT_ALL)
			gameController.analyseDecision();
	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public void setName(String name) {
		playerAttributes.setName(name);
	}

	@Override
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;
	}

	@Override
	public int getPlayerPoints() {
		return playerAttributes.getPlayerPoints();
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getOppColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerId(PlayerId playerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOppColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOppName(String name) {
		// TODO Auto-generated method stub

	}
}
