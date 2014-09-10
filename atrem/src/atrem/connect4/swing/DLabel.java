package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import atrem.connect4.game.player.PlayerId;

/**
 * Draws a JLabel with PaintObject.
 */
public class DLabel extends JLabel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6083513754064591557L;
	int dim = 50;
	Dimension size = new Dimension(dim, dim);
	private Color color, myColor, oppColor, colorEmpty = new Color(200, 200,
			200, 100), colorBrighter;
	private Dimension minSize = new Dimension(dim / 2, dim / 2);
	private PlayerId playerId;

	public DLabel(PlayerId playerID, Color myColor, Color oppColor) {
		this.playerId = playerID;
		this.myColor = myColor;
		this.oppColor = oppColor;
		this.color = colorEmpty;
		this.setPreferredSize(size);
		this.setMinimumSize(minSize);
		this.setBorder(BorderFactory.createBevelBorder(TOP, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		colorBrighter = color.darker();
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(0, 0, color, w, h, colorBrighter);
		g2d.setPaint(gp);
		g2d.fillOval(0, 0, w, h);
	}

	public void changeTokenColor(PlayerId holeState) {
		if (playerId == PlayerId.PLAYER1)
			switch (holeState) {
			case PLAYER1:
				color = myColor;
				break;
			case PLAYER2:
				color = oppColor;
				break;
			default:
				color = colorEmpty;
			}
		if (playerId == PlayerId.PLAYER2)
			switch (holeState) {
			case PLAYER1:
				color = oppColor;
				break;
			case PLAYER2:
				color = myColor;
				break;
			default:
				color = colorEmpty;
			}
		this.paintComponent(getGraphics());
	}

	public void changeTo(Color color) {
		this.color = color;
		this.setBorder(null);
		this.paintComponent(getGraphics());
	}

	public void setEmpty() {
		this.color = colorEmpty;
		this.paintComponent(getGraphics());
	}
}