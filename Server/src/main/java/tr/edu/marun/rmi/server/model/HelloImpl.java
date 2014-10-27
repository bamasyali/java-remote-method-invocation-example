/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.marun.rmi.server.model;

import java.rmi.RemoteException;

/**
 *
 * @author bamasyali
 */
public class HelloImpl implements Hello {

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }

}
