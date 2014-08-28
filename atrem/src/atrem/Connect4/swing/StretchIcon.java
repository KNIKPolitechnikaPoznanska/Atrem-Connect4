package atrem.Connect4.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.swing.ImageIcon;

public class StretchIcon extends ImageIcon {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8654204823969367762L;
	protected boolean proportionate = true;

	public StretchIcon(byte[] imageData) {
		super(imageData);
	}

	public StretchIcon(byte[] imageData, boolean proportionate) {
		super(imageData);
		this.proportionate = proportionate;
	}

	public StretchIcon(byte[] imageData, String description) {
		super(imageData, description);
	}

	public StretchIcon(byte[] imageData, String description,
			boolean proportionate) {
		super(imageData, description);
		this.proportionate = proportionate;
	}

	public StretchIcon(Image image) {
		super(image);
	}

	public StretchIcon(Image image, boolean proportionate) {
		super(image);
		this.proportionate = proportionate;
	}

	public StretchIcon(Image image, String description) {
		super(image, description);
	}

	public StretchIcon(Image image, String description, boolean proportionate) {
		super(image, description);
		this.proportionate = proportionate;
	}

	public StretchIcon(String filename) {
		super(filename);
	}

	public StretchIcon(String filename, boolean proportionate) {
		super(filename);
		this.proportionate = proportionate;
	}

	public StretchIcon(String filename, String description) {
		super(filename, description);
	}

	public StretchIcon(String filename, String description,
			boolean proportionate) {
		super(filename, description);
		this.proportionate = proportionate;
	}

	public StretchIcon(URL location) {
		super(location);
	}

	public StretchIcon(URL location, boolean proportionate) {
		super(location);
		this.proportionate = proportionate;
	}

	public StretchIcon(URL location, String description) {
		super(location, description);
	}

	public StretchIcon(URL location, String description, boolean proportionate) {
		super(location, description);
		this.proportionate = proportionate;
	}

	@Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
		Image image = getImage();
		if (image == null) {
			return;
		}

		Insets insets = ((Container) c).getInsets();
		x = insets.left;
		y = insets.top;
		int w = c.getWidth() - x - insets.right;
		int h = c.getHeight() - y - insets.bottom;

		if (proportionate) {
			int iw = image.getWidth(c);
			int ih = image.getHeight(c);

			if (iw * h < ih * w) {
				iw = (h * iw) / ih;
				x += (w - iw) / 2;
				w = iw;
			} else {
				ih = (w * ih) / iw;
				y += (h - ih) / 2;
				h = ih;
			}
		}

		ImageObserver io = getImageObserver();
		g.drawImage(image, x, y, w, h, io == null ? c : io);
	}

	@Override
	public int getIconWidth() {
		return 0;
	}

	@Override
	public int getIconHeight() {
		return 0;
	}
}