package atrem.connect4.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GameModeSelectionBox extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GameModeSelectionBox dialog = new GameModeSelectionBox();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GameModeSelectionBox() {
		setBounds(100, 100, 140, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Wybierz tryb gry:");
			contentPanel.add(lblNewLabel);
		}
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Online");
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(rdbtnNewRadioButton_1);
		}
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Offline");
			rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(rdbtnNewRadioButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
