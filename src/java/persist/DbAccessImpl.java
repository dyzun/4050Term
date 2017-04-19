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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl extends DbAccessConfiguration implements DbAccessInterface {

    @Override
    public Connection connect() {
        Connection con = null;
        try {
            // load the driver
            Class.forName(DRIVER);

            // establish a connection
            con = DriverManager.getConnection(CON_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public ResultSet retrieve(Connection con, String query) {
        ResultSet rset = null;

        try {
            // create a JDBC statement
            Statement stm = con.createStatement();

            // execute a query
            rset = stm.executeQuery(query);
            return rset;
        } catch (SQLException e) {
            e.printStackTrace();
            return rset;
        }
    }

    @Override
    public int create(Connection con, String query) {
        int affected = 0;
        try {
            Statement stmt = con.createStatement();
            affected = stmt.executeUpdate(query);
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return affected;

    }

    @Override
    public int update(Connection con, String query) {
        Statement stmt;
        int affected = 0;
        try {
            stmt = con.createStatement();
            affected = stmt.executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return affected;
    }

    @Override
    public int delete(Connection con, String query) {

        Statement stmt;
        int rows = 0;
        try {
            stmt = con.createStatement();
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public void disconnect(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }//if

    }// disconnect

    ResultSet retrieve(Connection con, String pI, int player_id) {
        ResultSet rset = null;
        try {
            // create a JDBC statement
            PreparedStatement stm = con.prepareStatement(pI);
            stm.setInt(1, player_id);
            // execute a query
            rset = stm.executeQuery(pI);
            return rset;
        } catch (SQLException e) {
            e.printStackTrace();
            return rset;
        }
    }

    int update(Connection con, String newSport, int sportID, String sportName, int minTeams, int maxTeams, int divTeams, int minTeamSize, int maxTeamSize, String rules, String inOrOut) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(newSport);
            stmt.setInt(1, sportID);
            stmt.setString(2, sportName);
            stmt.setInt(3, minTeams);
            stmt.setInt(4, maxTeams);
            stmt.setInt(5, divTeams);
            stmt.setInt(6, minTeamSize);
            stmt.setInt(7, maxTeamSize);
            stmt.setString(8, rules);
            stmt.setString(9, inOrOut);

            affected = stmt.executeUpdate(newSport);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return affected;
    }

    int update(Connection con, String newDiv, int divID, String divName, String inOrOut, int teamMax, int playerMax, String winner, Date sed, int sportID) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(newDiv);
            stmt.setInt(1, divID);
            stmt.setString(2, divName);
            stmt.setString(3, inOrOut);
            stmt.setInt(4, teamMax);
            stmt.setInt(5, playerMax);
            stmt.setString(6, winner);
            stmt.setDate(7, sed);
            stmt.setInt(8, sportID);
            affected = stmt.executeUpdate(newDiv);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int update(Connection con, String rPfT, int playerID) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(rPfT);
            stmt.setInt(1, playerID);
            affected = stmt.executeUpdate(rPfT);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int update(Connection con, String aPtT, int teamID, int playerID) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(aPtT);
            stmt.setInt(1, teamID);
            stmt.setInt(2, playerID);
            affected = stmt.executeUpdate(aPtT);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int update(Connection con, String newTeam, int teamID, String teamName, int playerCount, String active, int wins, int loss, int divID) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(newTeam);
            stmt.setInt(1, teamID);
            stmt.setString(2, teamName);
            stmt.setInt(3, playerCount);
            stmt.setString(4, active);
            stmt.setInt(5, wins);
            stmt.setInt(6, loss);
            stmt.setInt(7, divID);
            affected = stmt.executeUpdate(newTeam);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int delete(Connection con, String removeSport, int sportID) {
        PreparedStatement stmt;
        int rows = 0;
        try {
            stmt = con.prepareStatement(removeSport);
            stmt.setInt(1, sportID);
            rows = stmt.executeUpdate(removeSport);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rows;
    }

    int update(Connection con, String newGame, int gameID, int divID, int team1ID, int team2ID, String venue, Date date, int score1, int score2, int winID, String address) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(newGame);
            stmt.setInt(1, gameID);
            stmt.setInt(2, divID);
            stmt.setInt(3, team1ID);
            stmt.setInt(4, team2ID);
            stmt.setString(5, venue);
            stmt.setDate(6, date);
            stmt.setInt(7, score1);
            stmt.setInt(8, score2);
            stmt.setInt(9, winID);
            stmt.setString(10, address);
            affected = stmt.executeUpdate(newGame);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int update(Connection con, String newBracket, int roundID, int gameID, int adminID,int sportID, int winID) {
        PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(newBracket);
            stmt.setInt(1, roundID);
            stmt.setInt(2, gameID);
            stmt.setInt(3, adminID);
            stmt.setInt(4, sportID);
            stmt.setInt(5, winID);
            affected = stmt.executeUpdate(newBracket);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

    int update(Connection con, String updateP, int playerID, String phone) {
 PreparedStatement stmt;
        int affected = 0;
        try {
            stmt = con.prepareStatement(updateP);
            stmt.setString(1, phone);
            stmt.setInt(2, playerID);
            affected = stmt.executeUpdate(updateP);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return affected;
    }

}
