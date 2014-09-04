package atrem.Connect4.Game.player.ai;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.swing.DialogInformationBoxes;

public class MediumPC implements PlayerController {

	private Logic logic;

	private PlayerAttributes playerAttributes;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private Board board;
	private Random rand;
	private GameController gameController;
	private DialogInformationBoxes informationBoxes;

	public MediumPC(GameController gameController, String name,
			PlayerId playerId, Logic logic) {
		playerAttributes = new PlayerAttributes();
		playerAttributes.setName(name);
		playerAttributes.setPlayerId(playerId);
		this.gameController = gameController;
		this.logic = logic;
		board = gameController.getBoard();
		rand = new Random();
		gameController.endInitPlayer();
		informationBoxes = new DialogInformationBoxes();
	}

	public int simulatedGo(int slot) {

		int emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return -1;
		} else
			return emptySpot;

	}

	public int findSlotToMove() {
		logic.setCPUwin(false);
		int simulatedRow;
		HoleState opp;

		if (board.playerIdtoHoleState(playerAttributes.getPlayerId()) == HoleState.PLAYER1)
			opp = HoleState.PLAYER2;
		else
			opp = HoleState.PLAYER1;
		// wywakic ^^
		for (int i = 0; i < board.getSlots(); i++) {// tu mamy x
			simulatedRow = simulatedGo(i);// a tu y
			if (simulatedRow == -1)
				continue;
			else {

				board.setHoleState(simulatedRow, i,
						playerAttributes.getPlayerId());

				if (logic.checkIfWinPC()) {// wiem ze mozna lepiej
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
				if (logic.checkIfWinPC()) {// wiem ze mozna lepiej
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
		if (resultGame == resultGame.Player1Win)
			informationBoxes.winMessage(playerAttributes.getName());
		if (resultGame == resultGame.Player2Win)
			informationBoxes.winMessage(gameController.getPlayer2().getName());
		if (resultGame == resultGame.Draw)
			informationBoxes.drawMessage();
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

}
