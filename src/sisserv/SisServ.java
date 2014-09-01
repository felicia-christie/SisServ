/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisserv;

/**
 *
 * @author SPM
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class SisServ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	ServerSocket Serv;
	ObjectOutputStream out;
	ObjectInputStream in;
	ObjectOutputStream out2;
	ObjectInputStream in2;
	try{
	    if (args.length != 1){
		Serv = new ServerSocket(46464);
	    }
	    else {
	        Serv = new ServerSocket(Integer.parseInt(args[0]));
	    }
	    
	    ArrayList Clients = new ArrayList();
	    while (true){
		Socket tempClient = Serv.accept();
		out = new ObjectOutputStream(tempClient.getOutputStream());
		in = new ObjectInputStream(tempClient.getInputStream());
		System.out.println(tempClient.getInetAddress() + " is connected.");
		System.out.println("Username confirmed : " + in.readObject().toString());
		out.writeChars("conmade1");
		
		Socket tempClient2 = Serv.accept();
		out2 = new ObjectOutputStream(tempClient2.getOutputStream());
		in2 = new ObjectInputStream(tempClient2.getInputStream());
		System.out.println(tempClient2.getInetAddress() + " is connected.");
		System.out.println("Username confirmed : " + in2.readObject().toString());
		out2.writeChars("conmade2");
		
		
	    }
	    
	    
	    /*
	    */
	    
	    
	}
	catch (Exception ex){
	    
	}
    }
    
}
