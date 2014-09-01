/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisserv;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author SPM
 */


public class UserThread extends Thread {
    public User U;
    public Socket S;
    public ObjectOutputStream outStream;
    public ObjectInputStream inStream;
    
    public UserThread(Socket inSock){
	S = inSock;
	start();
    }
    
    @Override
    public void run(){
	try{
	    outStream = new ObjectOutputStream(S.getOutputStream()); 
	    inStream = new ObjectInputStream(S.getInputStream());
	    
	}
	catch (IOException ex){}
    }
}
