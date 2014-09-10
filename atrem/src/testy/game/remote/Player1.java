package testy.game.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.swing.SwingPresenter;

public class Player1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// TODO Auto-generated method stub
		Registry r = LocateRegistry.getRegistry(1234);
		GameController Connect4 = (GameController) r.lookup("Connect4");

		PlayerController player1 = new SwingPresenter(null, null, null, 0);

	}

}
