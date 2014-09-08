package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

public class SwingHole extends JLabel {
	public SwingHole() {
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(0, 0, 0, 0);
		// g2d.setColor(Color.CYAN);
		// g2d.fill(rectangle);
		g2d.setColor(Color.BLACK);
		g2d.fill(circle);

		/*
		 * 
		 * try { // retrieve image BufferedImage b = (); File outputfile = new
		 * File("saved.png"); ImageIO.write(bi, "png", outputfile);
		 * 
		 * } catch (IOException e) { }
		 */

	}

}