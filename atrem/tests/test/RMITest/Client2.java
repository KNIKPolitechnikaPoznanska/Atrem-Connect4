package test.RMITest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		Registry r = LocateRegistry.getRegistry("127.0.0.1", 1234);
		ServerIterface server = (ServerIterface) r.lookup("server");
		PlayerInterface player2 = new PlayerImpl();
		server.setPlayer(2, player2);
		Scanner input = new Scanner(System.in);
		Thread.sleep(5000);
		boolean done = false;
		int insert;
		while (!done) {
			// // insert = input.nextInt();
			// if (insert == 0)
			// done = true;
			// else
			System.out.println(server.getLastMove());
			// server.setLastMove(insert);

		}
	}

}
