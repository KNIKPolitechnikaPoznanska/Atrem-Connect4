package atrem.Connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import atrem.Connect4.Game.board.HoleState;
/**
 * Draws a JLabel with PaintObject.
 */
public class DLabel extends JLabel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6083513754064591557L;
	Dimension size = new Dimension(80, 80);
	private Color color, pl1Color, pl2Color, colorEmpty = new Color(200, 200,
			200), colorBrighter;

	public DLabel(Color pl1Color, Color pl2Color) {
		this.pl1Color = pl1Color;
		this.pl2Color = pl2Color;
		color = colorEmpty;
		this.setPreferredSize(size);
		this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white,
				Color.black));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		colorBrighter = color.brighter();
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(0, 0, color, 0, h, colorBrighter);
		g2d.setPaint(gp);
		g2d.fillOval(0, 0, w, h);
	}

	public void changeTokenColor(HoleState holeState) {
		switch (holeState) {
			case EMPTY :
				color = colorEmpty;
				break;
			case PLAYER1 :
				color = pl1Color;
				break;
			case PLAYER2 :
				color = pl2Color;
				break;
			default :
				System.out.println("Z³y kolor?");
		}
		this.paintComponent(getGraphics());
	}

	public void changeTo(Color color) {
		this.color = color;
		this.paintComponent(getGraphics());
	}
}