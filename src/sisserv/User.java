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
public class User {
    public String uName;
    public int Hand;
    public boolean inRoom;
    public boolean isHost;
    
    //public int highScore;
    
    public User(String N){
	uName = N;
	Hand = 0;
    }
    public User(String N, boolean Host){
	uName = N;
	Hand = 0;
	isHost = Host;
	inRoom = Host;
    }
    public void SetHand(int newHand){
	Hand = newHand;
    }
    public void resetUser(){
	Hand = 0;
	inRoom = false;
	isHost = false;
    }
    public void enterRoom(){
	inRoom = true;
    }
    public void makeRoom(){
	isHost = true; inRoom = true;
    }
}
