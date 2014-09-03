package atrem.Connect4.swing;

import javax.swing.JOptionPane;

import atrem.Connect4.Game.PlayerId;

public class DialogInformationBoxes {
	
	public void winMessage(PlayerId playerTurn){
		
		JOptionPane.showMessageDialog(null,"WYGRANA!");
	}
	
	public void drawMessage(){
		JOptionPane.showMessageDialog(null,"REMIS!");	
	}
	
	public void fullSlotMessage(){

	}

}
