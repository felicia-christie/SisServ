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
public class Room {
    public static User U1 = null;
    public static User U2 = null;
    
    public static void add (User U, int userN){
	if (userN == 1){
	    U1 = U;
	}
	else {
	    U2 = U;	    
	}
    }
    
    public static void exitRoom (int userN){
	if (userN == 1){
	    U1 = null;
	}
	else {
	    U2 = null;	    
	}
    }
}
