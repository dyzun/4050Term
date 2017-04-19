/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

/**
 *
 * @author dyzun
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Owner
 */
public class PersistImpl {
	//open connection
	DbAccessImpl access= new DbAccessImpl();
	Connection con = access.connect();
	
        
    public ResultSet getTeams(){
        String teams = "SELECT * FROM team";
        ResultSet rs = access.retrieve(con, teams);
        return rs;
    }
    
    public ResultSet getBrackets(){
        String bracket = "SELECT * FROM tournamentbrackets";
        ResultSet rs = access.retrieve(con, bracket);
        return rs;
    }
    
    public ResultSet getSports(){
        String sports = "SELECT * FROM sport";
        ResultSet rs = access.retrieve(con,sports);
        return rs;
    }
    
    public ResultSet getDivisions(){
        String divisions = "SELECT * FROM division";
        ResultSet rs = access.retrieve(con,divisions);
        return rs;
    }
    
    public ResultSet getPlayerInfo(int player_id){
        String pI = "SELECT * FROM player JOIN user ON player.PlayerID = ? AND user.PlayerID= ?";
        ResultSet rs = access.retrieve(con, pI,player_id);
        return rs;
    }
    
    public void addSport(int sportID,String sportName,int minTeams,int maxTeams, int divTeams, int minTeamSize, int maxTeamSize,
            String rules, String inOrOut){
            String newSport ="INSERT INTO `sport' (`SportID`, `SportName`, `MinTeams`, `MaxTeams`," +
"`DivisionTeams`, `MinTeamSize`,`MaxTeamSize`,`GameRules`,`IndoorOutdoor`) VALUES (?,?,?,?,?,?,?,?,?);";
            int update = access.update(con,newSport,sportID,sportName,minTeams,maxTeams,divTeams,minTeamSize,maxTeamSize,rules,inOrOut);
    }
    
    public void addDivision(int divID,String divName,String inOrOut,int teamMax,int playerMax,String winner,Date sed,int sportID){
        String newDiv = "INSERT INTO `division` (`DivisionID`,`DivisionName`,`IndoorOutdoor`," +
"`TeamMax`,`PlayerMax`,`WinningTeam`,`SeasonEndDate`,`SportID`) VALUES (?,?,?,?,?,?,?,?);";
        int update = access.update(con,newDiv,divID,divName,inOrOut,teamMax,playerMax,winner,sed,sportID);
    }
    
    //TODO addTeam(
    
    public void addPlayerToTeam(int teamID, int playerID){
        String aPtT = "UPDATE player SET teamID=? WHERE playerID = ?";
        int update = access.update(con, aPtT,teamID,playerID);
    }
    
    public void removePlayerFromTeam(int playerID){
        String rPfT = "UPDATE player SET teamID=null WHERE playerID = ?";
        int update = access.update(con, rPfT,playerID);
    }
    
    //TODO removeSport
    
    //TODO removeDivision
    
    //TODO removeBracket
}