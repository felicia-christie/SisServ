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
		
		Socket tempClient2 = Serv.accept();
		out2 = new ObjectOutputStream(tempClient2.getOutputStream());
		in2 = new ObjectInputStream(tempClient2.getInputStream());
		System.out.println(tempClient2.getInetAddress() + " is connected.");
		System.out.println("Username confirmed : " + in2.readObject().toString());
		
		int no1 = Integer.parseInt(in.readObject().toString());
		//System.out.println(no1);
		
		int no2 = Integer.parseInt(in2.readObject().toString());
		//System.out.println(no2);
		while(true){
		    if (no1 == no2){
			out.writeObject("DRAW");
			out2.writeObject("DRAW");
		    }
		    else if ((no1 == 1 && no2 == 2) || (no1 == 2 && no2 == 3) || (no1 == 3 && no2 == 1)){
			out.writeObject("LOSE");
			out2.writeObject("WIN");
		    }
		    else if ((no1 == 2 && no2 == 1) || (no1 == 3 && no2 == 2) || (no1 == 1 && no2 == 3)){
			out.writeObject("WIN");
			out2.writeObject("LOSE");
		    }
		    else {
			out.writeObject("fail");
			out2.writeObject("fail");
		    }
		    
		    out.flush(); out2.flush();
		}
		
	    }
	    
	    
	    /*
	    */
	    
	    
	}
	catch (Exception ex){
	    
	}
    }
    
}
