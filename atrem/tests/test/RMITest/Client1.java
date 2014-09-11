package test.RMITest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		Registry r = LocateRegistry.getRegistry("127.0.0.1", 1234);
		ServerIterface server = (ServerIterface) r.lookup("server");
		PlayerInterface player1 = new PlayerImpl();

	}

}
