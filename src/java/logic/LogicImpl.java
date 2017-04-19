/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author dyzun
 */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.PersistImpl;

/**
 *
 * @author Owner
 */
public class LogicImpl {

	HttpServletRequest request=null;
	HttpServletResponse response=null;
	PersistImpl persist= null;
	//ArrayList<Game> gameList = new ArrayList<>();
	//ArrayList<Review> reviewList = new ArrayList<>();
	//ArrayList<User> userList = new ArrayList<>();
        //ArrayList<String> consoleList = new ArrayList<>();

    /**
     *
     * @param req
     * @param res
     */
    public LogicImpl(HttpServletRequest req, HttpServletResponse res){
		request = req;
		response= res;
		persist = new PersistImpl();
	} //constructor
            
    public void createSport(String name, int minT, int maxT,int divS, int minP, int maxP,String rules,String in ){
        persist.addSport(name, minT, maxT, divS, minP, maxP, rules, in);
    }
    public void createDivision(String divName, String in, int maxT, int maxP,String win,Date sed,int sportID){
        persist.addDivision(divName, in, maxP, maxP, win, sed, sportID);
    }
    public void createTournament(int adminID,int sportID,String name){
        persist.addTournament(adminID, sportID, name);
    }
    public void createGame(int divID,int team1ID, int team2ID,String venue,Date date, int t1Score,int t2score,int winID,String address){
        persist.addGame(divID, team1ID, team2ID, venue, date, t2score, t2score, winID, address); 
    }
    public void createTeam(String teamName,int maxP,String active, int wins, int losses, int divID ){
        persist.addTeam(teamName, losses, active, wins, losses, divID);
    }
    public void addPlayerToTeam(int teamID, int playerID){
        persist.addPlayerToTeam(teamID, playerID);
    }
    public void createBracket(int gameID,int tournID, int winID){
        persist.addBracket(gameID, tournID, winID);
    }
    public void updateProfile(int playerID, String phone){
        persist.updatePlayer(playerID, phone);
    }
    public void deleteBracket(int bracketID){
        persist.removeBracket(bracketID);
    }
    public void deleteSport(int sportID){
        persist.removeSport(sportID);
    }
    public void deleteDivision(int divID){
        persist.removeDivision(divID);
    }
    public void removePlayer(int playerID){
        persist.removePlayerFromTeam(playerID);
    }
}
