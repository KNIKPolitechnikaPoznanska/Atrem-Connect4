package atrem.Connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
/**
 * Draws a JLabel with PaintObject.
 */
public class DLabel extends JLabel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6083513754064591557L;
	Dimension size = new Dimension(70, 80);

	public DLabel() {
		this.setPreferredSize(size);
		this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white,
				Color.black));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Color color1 = new Color(226, 218, 145);
		Color color2 = color1.brighter();
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}

}