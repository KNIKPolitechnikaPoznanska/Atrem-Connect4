package atrem.Connect4.swing;

import java.awt.EventQueue;

import javax.swing.JLabel;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerTurn;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class SwingPresenter implements PlayerController {

	private int Slots;
	private int Rows;
	private PlayerTurn playerTurn;
	private int LastRow;
	private int LastSlot;
	private int emptySpot;
	private ResultState result;
	private GameController gameController;
	private Panel panel;
	private StatsPanel statsPanel;
	private GameFrame gameFrame;
	private JLabel pl1Label, pl2Label;
	private PlayerAttributes playerAttributes;

	public SwingPresenter(String im, HoleState playerId) {
		playerAttributes = new PlayerAttributes(im, playerId);
	}

	public int getSlots() {
		return Slots;
	}

	public void setSlots(int slots) {
		Slots = slots;
	}

	public int getRows() {
		return Rows;
	}

	public void setRows(int rows) {
		Rows = rows;
	}

	public void setPresenter(GameController gameController) {

		this.gameController = gameController;
		setSettings();
	}

	public void setSettings() {
		Rows = gameController.getBoard().getRows();
		Slots = gameController.getBoard().getSlots();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame(SwingPresenter.this);
					frame.setTitle("Connect 4");
					frame.setVisible(true);
					playerTurn = gameController.getPlayerTurn();
					changeDispTurn(playerTurn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void goView(int Row, int Slot, int playerTurn) {
		changeDispTurn(playerTurn);
		panel.setFreeRow(Row, Slot, playerTurn);
	}

	public void setPanels() {
		panel = gameFrame.getPanel();
		statsPanel = gameFrame.getStatsPanel();
		pl1Label = statsPanel.getPl1Label();
		pl2Label = statsPanel.getPl2Label();
		setNames();
	}

	public void getFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setPanels();
	}

	public void changeDispTurn(int playerTurn) {
		if (playerTurn == 1) {
			pl1Label.setVisible(false);
			pl2Label.setVisible(true);
		} else if (playerTurn == 2) {
			pl2Label.setVisible(false);
			pl1Label.setVisible(true);
		}
	}

	public void setNames() {
		pl1Label.setText(game.getNamePlayer1());
		pl2Label.setText(game.getNamePlayer2());
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
	public HoleState getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public int loadSlotNumber() {
		return LastSlot;
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;

	}

	public void getSlotFromView(int LastSlot) {
		this.LastSlot = LastSlot;

	}

}
