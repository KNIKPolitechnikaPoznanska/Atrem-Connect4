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
	int dim = 50;
	Dimension size = new Dimension(dim, dim);
	private Color color, pl1Color, pl2Color, colorEmpty = new Color(200, 200,
			200, 100), colorBrighter;
	private Dimension minSize = new Dimension(dim / 2, dim / 2);

	public DLabel(Color pl1Color, Color pl2Color) {
		this.pl1Color = pl1Color;
		this.pl2Color = pl2Color;
		color = colorEmpty;
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
		this.setBorder(null);
		this.paintComponent(getGraphics());
	}
}