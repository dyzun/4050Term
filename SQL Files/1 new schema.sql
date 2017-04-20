DROP SCHEMA IF EXISTS `softengineeringdb`;
CREATE SCHEMA `softengineeringdb` ;
USE `softengineeringdb`;

CREATE TABLE Administrator (
 AdminID INT(11) NOT NULL AUTO_INCREMENT,
 AdminName CHAR(50),
 AdminPhone VARCHAR(10),
 primary key (AdminID)
);


CREATE TABLE Guest (
 GuestID INT NOT NULL AUTO_INCREMENT,
 GuestEmail CHAR(50),
 primary key (GuestID)
);


CREATE TABLE Sport (
 SportID INT NOT NULL AUTO_INCREMENT,
 SportName CHAR(50),
 MinTeams INT,
 MaxTeams INT,
 DivisionTeams INT,
 MinTeamSize INT,
 MaxTeamSize INT,
 GameRules CHAR(200),
 IndoorOutdoor CHAR(7),
 primary key (SportID)
);


CREATE TABLE Tournament (
 TournID INT(11) NOT NULL AUTO_INCREMENT,
 AdminID INT(11),
 SportID INT(11),
 Name VARCHAR(50),
 primary key (tournID)
);


CREATE TABLE Division (
 DivisionID INT NOT NULL AUTO_INCREMENT,
 DivisionName CHAR(50),
 IndoorOutdoor CHAR(50),
 TeamMax INT,
 PlayerMax INT,
 WinningTeam CHAR(50),
 SeasonEndDate DATE,
 SportID INT,
 primary key (DivisionID)
);


CREATE TABLE Team (
 TeamID INT NOT NULL AUTO_INCREMENT,
 TeamName CHAR(50),
 PlayerCount INT,
 Active CHAR(50),
 Wins INT,
 Losses INT,
 DivisionID INT,
 primary key (TeamID)
);


CREATE TABLE TournamentBrackets (
 RoundID INT(11) NOT NULL AUTO_INCREMENT,
 GameID INT(11) NOT NULL,
 TournID INT(11) NOT NULL,
 PlayoffGameWinner INT(11),
 PRIMARY KEY (roundID,gameID,tournID)
);


CREATE TABLE Coach (
 CoachID INT NOT NULL AUTO_INCREMENT,
 CoachName CHAR(50),
 CoachPhone VARCHAR(10),
 TeamID INT,
 PRIMARY KEY (CoachID)
);


CREATE TABLE Games (
 gameID INT(11) NOT NULL AUTO_INCREMENT,
 DivisionID INT(11),
 Team1 INT(11),
 Team2 INT(11),
 Venue VARCHAR(50),
 Date DATE,
 Coach1score INT(11),
 Coach2score INT(11),
 Winner INT(50),
 Address VARCHAR(100),
 PRIMARY KEY (gameID)
);


CREATE TABLE Player (
 PlayerID INT NOT NULL AUTO_INCREMENT,
 PlayerName CHAR(50),
 PlayerPhone VARCHAR(10),
 TeamID INT,
 PRIMARY KEY (PlayerID)
);


CREATE TABLE User (
 UserID INT NOT NULL AUTO_INCREMENT,
 Name CHAR(50),
 Password CHAR(50),
 Email CHAR(50),
 Address CHAR(100),
 Privileges CHAR(50),
 AdminID INT,
 GuestID INT,
 CoachID INT,
 PlayerID INT,
 PRIMARY KEY (UserID)
);


ALTER TABLE Tournament ADD CONSTRAINT FK_Tournament_0 FOREIGN KEY (AdminID) REFERENCES Administrator (AdminID);
ALTER TABLE Tournament ADD CONSTRAINT FK_Tournament_1 FOREIGN KEY (SportID) REFERENCES Sport (SportID);


ALTER TABLE Division ADD CONSTRAINT FK_Division_0 FOREIGN KEY (SportID) REFERENCES Sport (SportID);


ALTER TABLE Team ADD CONSTRAINT FK_Team_0 FOREIGN KEY (DivisionID) REFERENCES Division (DivisionID);


ALTER TABLE TournamentBrackets ADD CONSTRAINT FK_TournamentBrackets_0 FOREIGN KEY (tournID) REFERENCES Tournament (tournID);


ALTER TABLE Coach ADD CONSTRAINT FK_Coach_0 FOREIGN KEY (TeamID) REFERENCES Team (TeamID);


ALTER TABLE Games ADD CONSTRAINT FK_Games_0 FOREIGN KEY (Team1) REFERENCES Team (TeamID);
ALTER TABLE Games ADD CONSTRAINT FK_Games_1 FOREIGN KEY (Team2) REFERENCES Team (TeamID);


ALTER TABLE Player ADD CONSTRAINT FK_Player_0 FOREIGN KEY (TeamID) REFERENCES Team (TeamID);


ALTER TABLE User ADD CONSTRAINT FK_User_0 FOREIGN KEY (AdminID) REFERENCES Administrator (AdminID);
ALTER TABLE User ADD CONSTRAINT FK_User_1 FOREIGN KEY (GuestID) REFERENCES Guest (GuestID);
ALTER TABLE User ADD CONSTRAINT FK_User_2 FOREIGN KEY (CoachID) REFERENCES Coach (CoachID);
ALTER TABLE User ADD CONSTRAINT FK_User_3 FOREIGN KEY (PlayerID) REFERENCES Player (PlayerID);