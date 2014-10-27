/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.marun.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import tr.edu.marun.rmi.server.model.Hello;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import tr.edu.marun.rmi.server.model.HelloImpl;
import static tr.edu.marun.rmi.server.util.Constants.NAME;
import static tr.edu.marun.rmi.server.util.Constants.PORT;

/**
 *
 * @author bamasyali
 */
public class Server {

    public static void main(String args[]) {

        try {
            Hello obj = new HelloImpl();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind(NAME, stub);

            System.out.println("Server ready");
        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}
