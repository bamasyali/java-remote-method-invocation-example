/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.marun.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import tr.edu.marun.rmi.server.model.Hello;
import tr.edu.marun.rmi.server.util.Constants;

/**
 *
 * @author bamasyali
 */
public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(Constants.PORT);
            Hello stub = (Hello) registry.lookup(Constants.NAME);
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
}
