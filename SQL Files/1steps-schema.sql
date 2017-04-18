DROP SCHEMA IF EXISTS `softengineeringdb`;
CREATE SCHEMA `softengineeringdb` ;
USE `softengineeringdb`;

CREATE TABLE Administrator (
 AdminID INT NOT NULL,
 AdminName CHAR(50),
 AdminPhone VARCHAR(10)
);

ALTER TABLE Administrator ADD CONSTRAINT PK_Administrator PRIMARY KEY (AdminID);


CREATE TABLE Guest (
 GuestID INT NOT NULL,
 GuestEmail CHAR(50)
);

ALTER TABLE Guest ADD CONSTRAINT PK_Guest PRIMARY KEY (GuestID);


CREATE TABLE Sport (
 SportID INT NOT NULL,
 SportName CHAR(50),
 MinTeams INT,
 MaxTeams INT,
 DivisionTeams INT,
 MinTeamSize INT,
 MaxTeamSize INT,
 GameRules CHAR(200),
 IndoorOutdoor CHAR(7)
);

ALTER TABLE Sport ADD CONSTRAINT PK_Sport PRIMARY KEY (SportID);


CREATE TABLE Tournament (
 TournamentID INT NOT NULL,
 TournName CHAR(50),
 BeginDate DATE,
 EndDate DATE,
 Address CHAR(100),
 AdminID INT,
 SportID INT
);

ALTER TABLE Tournament ADD CONSTRAINT PK_Tournament PRIMARY KEY (TournamentID);


CREATE TABLE Division (
 DivisionID INT NOT NULL,
 DivisionName CHAR(50),
 IndoorOutdoor CHAR(50),
 TeamMax INT,
 PlayerMax INT,
 WinningTeam CHAR(50),
 SeasonEndDate DATE,
 SportID INT
);

ALTER TABLE Division ADD CONSTRAINT PK_Division PRIMARY KEY (DivisionID);


CREATE TABLE Team (
 TeamID INT NOT NULL,
 TeamName CHAR(50),
 PlayerCount INT,
 Active CHAR(50),
 Wins INT,
 Losses INT,
 DivisionID INT
);

ALTER TABLE Team ADD CONSTRAINT PK_Team PRIMARY KEY (TeamID);


CREATE TABLE TournamentBrackets (
 RoundID INT NOT NULL,
 GameID INT NOT NULL,
 TournamentID INT NOT NULL,
 Venue CHAR(50),
 GameDate DATE,
 PlayoffGameWinner CHAR(50),
 Address CHAR(100),
 DivisionID INT,
 WinnerTeam1 CHAR(10),
 WinnerTeam2 CHAR(10)
);

ALTER TABLE TournamentBrackets ADD CONSTRAINT PK_TournamentBrackets PRIMARY KEY (RoundID,GameID,TournamentID);


CREATE TABLE Coach (
 CoachID INT NOT NULL,
 CoachName CHAR(50),
 CoachPhone VARCHAR(10),
 TeamID INT
);

ALTER TABLE Coach ADD CONSTRAINT PK_Coach PRIMARY KEY (CoachID);


CREATE TABLE Games (
 GameID INT NOT NULL,
 DivisionID INT,
 Team1 CHAR(50),
 Team2 CHAR(50),
 Venue CHAR(50),
 Date DATE,
 Coach1score INT,
 Coach2score INT,
 Winner CHAR(50),
 Address CHAR(50),
 TeamID INT
);

ALTER TABLE Games ADD CONSTRAINT PK_Games PRIMARY KEY (GameID);


CREATE TABLE Player (
 PlayerID INT NOT NULL,
 PlayerName CHAR(50),
 PlayerPhone VARCHAR(10),
 TeamID INT
);

ALTER TABLE Player ADD CONSTRAINT PK_Player PRIMARY KEY (PlayerID);


CREATE TABLE User (
 UserID INT NOT NULL,
 Name CHAR(50),
 Password CHAR(50),
 Email CHAR(50),
 Address CHAR(100),
 Privileges CHAR(50),
 AdminID INT,
 GuestID INT,
 CoachID INT,
 PlayerID INT
);

ALTER TABLE User ADD CONSTRAINT PK_User PRIMARY KEY (UserID);


ALTER TABLE Tournament ADD CONSTRAINT FK_Tournament_0 FOREIGN KEY (AdminID) REFERENCES Administrator (AdminID);
ALTER TABLE Tournament ADD CONSTRAINT FK_Tournament_1 FOREIGN KEY (SportID) REFERENCES Sport (SportID);


ALTER TABLE Division ADD CONSTRAINT FK_Division_0 FOREIGN KEY (SportID) REFERENCES Sport (SportID);


ALTER TABLE Team ADD CONSTRAINT FK_Team_0 FOREIGN KEY (DivisionID) REFERENCES Division (DivisionID);


ALTER TABLE TournamentBrackets ADD CONSTRAINT FK_TournamentBrackets_0 FOREIGN KEY (TournamentID) REFERENCES Tournament (TournamentID);
ALTER TABLE TournamentBrackets ADD CONSTRAINT FK_TournamentBrackets_1 FOREIGN KEY (DivisionID) REFERENCES Division (DivisionID);


ALTER TABLE Coach ADD CONSTRAINT FK_Coach_0 FOREIGN KEY (TeamID) REFERENCES Team (TeamID);


ALTER TABLE Games ADD CONSTRAINT FK_Games_0 FOREIGN KEY (TeamID) REFERENCES Team (TeamID);


ALTER TABLE Player ADD CONSTRAINT FK_Player_0 FOREIGN KEY (TeamID) REFERENCES Team (TeamID);


ALTER TABLE User ADD CONSTRAINT FK_User_0 FOREIGN KEY (AdminID) REFERENCES Administrator (AdminID);
ALTER TABLE User ADD CONSTRAINT FK_User_1 FOREIGN KEY (GuestID) REFERENCES Guest (GuestID);
ALTER TABLE User ADD CONSTRAINT FK_User_2 FOREIGN KEY (CoachID) REFERENCES Coach (CoachID);
ALTER TABLE User ADD CONSTRAINT FK_User_3 FOREIGN KEY (PlayerID) REFERENCES Player (PlayerID);


