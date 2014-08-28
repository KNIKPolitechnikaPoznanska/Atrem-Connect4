package atrem.Connect4.swing;

import java.awt.EventQueue;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.ResultState;

public class SwingPresenter {
	private Game game;
	private int Slots;
	private int Rows;
	private int PlayerTurn;
	private int LastRow;
	private int LastSlot;
	private ResultState result;
	private GameController gameController;
	private Panel panel;
	private GameFrame gameFrame;

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

	public void setPresenter(Game game, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
		setSettings();
	}

	public void runSettingsView() { // wywowlujemy okno dialogowe z ustawieniamy
									// row slot

	}

	public void setSettings() {
		Rows = game.getBoardRows();
		Slots = game.getBoardSlots();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame(SwingPresenter.this);
					frame.setTitle("Connect 4");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void goView(int LastRow, int LastSlot, ResultState result) {

	}

	public void getSlotFromView(int LastSlot) {
		gameController.setChoosedSlot(LastSlot);
	}

	public void setpanel() {
		panel = gameFrame.getPanel();
	}

	public void getFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setpanel();
	}

}
