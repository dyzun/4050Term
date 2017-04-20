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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class PersistImpl {
    //open connection

    DbAccessImpl access = new DbAccessImpl();
    Connection con = access.connect();

    public int checkLogin(String username, String password) throws SQLException {
        int value = 1; // 1 means successfull login
        String loginquery = "SELECT * FROM user WHERE name='" + username + "' AND password='" + password + "'";
        PreparedStatement ps = con.prepareStatement(loginquery);
        ResultSet results = ps.executeQuery(loginquery);

        if (!results.next()) {
            // No results in rs
            value = 0;
            return value;
        }
        // found login credentials, return 1 success
        return value;
    }

    public ResultSet getTeams() {
        String teams = "SELECT * FROM team";
        ResultSet rs = access.retrieve(con, teams);
        return rs;
    }

    public ResultSet getBrackets() {
        String bracket = "SELECT * FROM tournamentbrackets";
        ResultSet rs = access.retrieve(con, bracket);
        return rs;
    }

    public ResultSet getSports() {
        String sports = "SELECT * FROM sport";
        ResultSet rs = access.retrieve(con, sports);
        return rs;
    }

    public ResultSet getDivisions() {
        String divisions = "SELECT * FROM division";
        ResultSet rs = access.retrieve(con, divisions);
        return rs;
    }

    public ResultSet getPlayerInfo(int player_id) {
        String pI = "SELECT * FROM player JOIN user ON player.PlayerID = ? AND user.PlayerID= ?";
        ResultSet rs = access.retrieve(con, pI, player_id);
        return rs;
    }

    public void addSport(String sportName, int minTeams, int maxTeams, int divTeams, int minTeamSize, int maxTeamSize,
            String rules, String inOrOut) {
        String newSport = "INSERT INTO `sport' ( `SportName`, `MinTeams`, `MaxTeams`,"
                + "`DivisionTeams`, `MinTeamSize`,`MaxTeamSize`,`GameRules`,`IndoorOutdoor`) VALUES (?,?,?,?,?,?,?,?);";
        int update = access.update(con, newSport, sportName, minTeams, maxTeams, divTeams, minTeamSize, maxTeamSize, rules, inOrOut);
    }

    public void addDivision(String divName, String inOrOut, int teamMax, int playerMax, String winner, Date sed, int sportID) {
        String newDiv = "INSERT INTO `division` (`DivisionName`,`IndoorOutdoor`,"
                + "`TeamMax`,`PlayerMax`,`WinningTeam`,`SeasonEndDate`,`SportID`) VALUES (?,?,?,?,?,?,?);";
        int update = access.update(con, newDiv, divName, inOrOut, teamMax, playerMax, winner, sed, sportID);
    }

    public void addTeam(String teamName, int playerCount, String active, int wins, int loss, int divID) {
        String newTeam = "INSERT INTO `team`(`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`)"
                + "VALUES (?,?,?,?,?,?);";
        int update = access.update(con, newTeam, teamName, playerCount, active, wins, loss, divID);
    }

    public void addPlayerToTeam(int teamID, int playerID) {
        String aPtT = "UPDATE player SET teamID=? WHERE playerID = ?";
        int update = access.update(con, aPtT, teamID, playerID);
    }

    public void removePlayerFromTeam(int playerID) {
        String rPfT = "UPDATE player SET teamID=null WHERE playerID = ?";
        int update = access.update(con, rPfT, playerID);
    }

    public void removeSport(int sportID) {
        String removeSport = "DELETE FROM sport WHERE sportID = ?";
        int delete = access.delete(con, removeSport, sportID);
    }

    public void removeDivision(int divID) {
        String removeDiv = "DELETE FROM division WHERE divisionID = ?";
        int delete = access.delete(con, removeDiv, divID);
    }

    public void addGame(int divID, int team1ID, int team2ID, String venue,
            Date date, int score1, int score2, int winID, String address) {
        String newGame = "INSERT INTO `games`(`DivisionID`,`Team1`,`Team2"
                + "`,`Venue`,`Date`,`Coach1score`,`Coach2score`,`Winner`,`Address`) "
                + "VALUES (?,?,?,?,?,?,?,?,?);";
        int update = access.update(con, newGame, divID, team1ID, team2ID, venue, date, score1, score2, winID, address);
    }

    public void removeBracket(int roundID) {
        String removeBracket = "DELETE FROM tournamentbrackets WHERE RoundID = ?;";
        int delete = access.delete(con, removeBracket, roundID);
    }

    public void addTournament(int adminID, int sportID, String name) {
        String newTourn = "INSERT INTO 'tournament' ('AdminID','SportID','Name') "
                + "VALUES (?,?,?);";
        int update = access.update(con, newTourn, adminID, sportID, name);
    }

    public void addBracket(int gameID, int tournID, int winID) {
        String newBracket = "INSERT INTO `tournamentbrackets` (`GameID`,`TournID`,`PlayoffGameWinner`)"
                + "VALUES (?,?,?);";
        int update = access.update(con, newBracket, gameID, tournID, winID);
    }

    public void updatePlayer(int playerID, String phone) {
        String updateP = "UPDATE player SET phone = ? WHERE PlayerID = ?";
        int update = access.update(con, updateP, playerID, phone);
    }
}
