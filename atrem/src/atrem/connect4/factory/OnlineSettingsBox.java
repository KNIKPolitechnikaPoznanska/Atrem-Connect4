package atrem.connect4.factory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import atrem.connect4.Connect4;

public class OnlineSettingsBox extends JDialog {
	private Color color = new Color(255, 0, 0);
	private final JPanel contentPanel = new JPanel();
	private final JButton buttonColor;
	private GameConfig gameConfig;
	private String playerName;
	private Color playerColor;
	private String adress;
	private int port;
	private String guiType;
	private JTextField nameTextField, adressTextField, portField;
	private JRadioButton swingButton, consoleButton;
	private ButtonGroup bGroup;

	/**
	 * ActionPerformed on Connect Buttton Press.
	 */
	private void connectButtonPressed() {
		if (saveSettings()) {
			gameConfig.setupOnlineClientSettings();
			dispose();
			new Connect4().createOnlineClientGame(gameConfig);
		}
	}

	/**
	 * Saves all settings from swing to it's fields.
	 * 
	 * @return true if success
	 */
	private boolean saveSettings() {
		setPlayerName(nameTextField.getText());
		setAdress(adressTextField.getText());
		setPort(Integer.parseInt(portField.getText()));
		if (swingButton.isSelected())
			guiType = "swing";
		else
			guiType = "console";
		return true;
	}

	/**
	 * Create the dialog.
	 * 
	 * @param gameFactory
	 * @param gameConfig
	 */
	public OnlineSettingsBox(GameConfig gameConfig) {
		setTitle("Connect 4 Online Settings");
		this.gameConfig = gameConfig;

		setBounds(100, 100, 239, 311);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel imieLabel = new JLabel("imie:");
		imieLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameTextField.setText("Gracz");
		Container imieContainer = new Container();
		imieContainer.setLayout(new GridLayout(0, 2, 0, 0));
		imieContainer.add(imieLabel);
		imieContainer.add(nameTextField);

		JLabel adresIPLabel = new JLabel("adres IP:");
		adresIPLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		adressTextField = new JTextField();
		adressTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adressTextField.setText("localhost");
		Container adresIPContainer = new Container();
		adresIPContainer.setLayout(new GridLayout(0, 2, 0, 0));
		adresIPContainer.add(adresIPLabel);
		adresIPContainer.add(adressTextField);

		buttonColor = new JButton("Wybierz kolor");
		buttonColor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonColor.setBackground(color);
		buttonColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = buttonColor.getBackground();
				color = JColorChooser.showDialog(null, "Wybierz kolor ¿etonu.",
						initialBackground);
				if (color != null) {
					buttonColor.setBackground(color);
				}
			}
		});
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));

		contentPanel.add(imieContainer);
		contentPanel.add(adresIPContainer);

		Container portContainer = new Container();
		contentPanel.add(portContainer);
		portContainer.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel portLabel = new JLabel("port:");
		portLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		portContainer.add(portLabel);

		portField = new JTextField();
		portField.setText("1234");
		portField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		portContainer.add(portField);

		Container guiModeContainer = new Container();
		contentPanel.add(guiModeContainer);
		guiModeContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel guiTypeLabel = new JLabel("Wygl\u0105d:");
		guiTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		guiModeContainer.add(guiTypeLabel);

		bGroup = new ButtonGroup();

		swingButton = new JRadioButton("Okno");
		swingButton.setSelected(true);
		guiModeContainer.add(swingButton);
		bGroup.add(swingButton);

		consoleButton = new JRadioButton("Konsola");
		guiModeContainer.add(consoleButton);
		contentPanel.add(buttonColor);
		bGroup.add(consoleButton);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton connentButton = new JButton("Connect");
				connentButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
				connentButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						connectButtonPressed();
					}
				});
				buttonPane.add(connentButton);
				getRootPane().setDefaultButton(connentButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		pack();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getGuiType() {
		return guiType;
	}

	public void setGuiType(String guiType) {
		this.guiType = guiType;
	}
}
