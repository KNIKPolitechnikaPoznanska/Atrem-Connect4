package atrem.connect4.factory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class OnlineDialogSettingsBox extends JDialog {

	private Color color = new Color(255, 0, 0);
	private final JPanel contentPanel = new JPanel();
	private final JButton buttonColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OnlineDialogSettingsBox dialog = new OnlineDialogSettingsBox();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OnlineDialogSettingsBox() {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel imieLabel = new JLabel("imie:");
		JTextArea imieTextArea = new JTextArea("wpisz imie");
		Container imieContainer = new Container();
		imieContainer.setLayout(new FlowLayout());
		imieContainer.add(imieLabel);
		imieContainer.add(imieTextArea);

		JLabel adresIPLabel = new JLabel("adres IP:");
		JTextArea adresIPTextArea = new JTextArea("wpisz adres IP");
		Container adresIPContainer = new Container();
		adresIPContainer.setLayout(new FlowLayout());
		adresIPContainer.add(adresIPLabel);
		adresIPContainer.add(adresIPTextArea);

		buttonColor = new JButton("Zmieñ kolor");
		buttonColor.setBackground(color);
		buttonColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = buttonColor.getBackground();
				color = JColorChooser.showDialog(null,
						"Gracz 1: Wybierz kolor ¿etonu.", initialBackground);
				if (color != null) {
					buttonColor.setBackground(color);
				}
			}
		});

		contentPanel.add(imieContainer, BorderLayout.NORTH);
		contentPanel.add(adresIPContainer, BorderLayout.CENTER);
		contentPanel.add(buttonColor, BorderLayout.SOUTH);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton connentButton = new JButton("Connect");
				connentButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				buttonPane.add(connentButton);
				getRootPane().setDefaultButton(connentButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		pack();
	}

}
