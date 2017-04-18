USE `softengineeringdb`;

/*Create two different sports:*/
INSERT IGNORE INTO `sport` (`SportID`, `SportName`, `MinTeams`, `MaxTeams`, `DivisionTeams`, `MinTeamSize`, `MaxTeamSize`, `GameRules`, `IndoorOutdoor`) VALUES ('1', 'Basketball', '2', '18', '4', '5', '12', 'Ball cannot go out of bounds.', 'Indoor');

INSERT IGNORE INTO `sport` (`SportID`, `SportName`, `MinTeams`, `MaxTeams`, `DivisionTeams`, `MinTeamSize`, `MaxTeamSize`, `GameRules`, `IndoorOutdoor`) VALUES ('2', 'Tennis', '2', '18', '4', '1', '2', 'Serve must go over the net.', 'Outdoor');

#Create 2 different administrators, one for each sport:
INSERT IGNORE INTO `administrator` (`AdminID`, `AdminName`, `AdminPhone`) VALUES ('1', 'Paul Redmond', '7894561234');

INSERT IGNORE INTO `administrator` (`AdminID`, `AdminName`, `AdminPhone`) VALUES ('2', 'Richard Walters', '9876543219');

#Create 2 divisions within each sport:
INSERT IGNORE INTO `division` (`DivisionID`, `DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('1', 'East', 'Indoor', '8', '80', 'Miami Heat', '2017-06-23', '1');

INSERT IGNORE INTO `division` (`DivisionID`, `DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('2', 'West', 'Indoor', '8', '80', 'Los Angeles Lakers', '2017-06-23', '1');

INSERT IGNORE INTO `division` (`DivisionID`, `DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('3', 'North', 'Outdoor', '4', '8', 'Washington Kastles', '2017-08-28', '2');

INSERT IGNORE INTO `division` (`DivisionID`, `DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('4', 'South', 'Outdoor', '4', '8', 'San Diego Aviators', '2017-08-28', '2');

#Create 2+ teams for each divisions:
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('1', 'Viginia Vols', '16', 'Active','10','5','1');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('2', 'Kentucky Kats', '16', 'Active','5','10','1');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('3', 'California Condors', '32', 'Active','12','6','2');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('4', 'Washington Wagons', '32', 'Active','6','12','2');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('5', 'Vermont Syrupers', '20', 'Active','11','8','3');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('6', 'Maine Mountaineers', '20', 'Active','8','11','3');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('7', 'Texas Texans', '24', 'Active','4','0','4');
INSERT IGNORE INTO `team` (`TeamID`,`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('8', 'Missouri Misery', '24', 'Active','0','4','4');

#Create 2+ players for each team:

INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('1', 'Richard Richmond', '6788675309', '1');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('2', 'Tom Cruise', '6781234756', '1');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('3', 'John Hamilton', '4041234568', '2');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('4', 'John Snow', '4044856912', '2');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('5', 'Scott Ryder', '6385237891', '3');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('6', 'John Shepherd', '6385565785', '3');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('7', 'Donald Trump', '6375824565', '4');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('8', 'Leroy Jenkins', '5864555895', '4');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('9', 'Ryan Renolds', '5864722612', '5');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('10', 'Ryan Seacrest', '5869645565', '5');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('11', 'John Abrams', '6864758642', '6');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('12', 'Tommy Twotone', '7078675309', '6');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('13', 'John Wick', '5658925358', '7');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('14', 'Clint Eastwood', '8586976248', '7');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('15', 'Frodo Baggens', '6965785245', '8');
INSERT IGNORE INTO `player` (`PlayerID`, `PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('16', 'Gandalf the Grey', '8985465352', '8');

#Create 1 guest for each sport:
INSERT IGNORE INTO `guest` (`GuestID`, `GuestEmail`) VALUES ('1', 'guest@guestmail.com');
INSERT IGNORE INTO `user`(`UserID`,`Name`,`Password`,`Email`,`Address`,`Privileges`,`GuestID`) VALUES ('6','guest','P@ssW00d','guest@guestmail.com','1234 Main St, Louisville, LA', 'GUEST', '1');
INSERT IGNORE INTO `guest` (`GuestID`, `GuestEmail`) VALUES ('2', 'guest1@guestmail.com');
INSERT IGNORE INTO `user`(`UserID`,`Name`,`Password`,`Email`,`Address`,`Privileges`,`GuestID`) VALUES ('7','Mickey Johns','123Pass','guest1@guestmail.com','1234 2nd St, Athens, GA', 'GUEST', '2');

#Create 2 different tournaments:
INSERT IGNORE INTO `tournament` (`TournamentID`, `TournName`, `BeginDate`, `EndDate`, `Address`, `AdminID`, `SportID`) VALUES ('1', 'basketballtourn', '2017-04-16', '2017-05-16', '10 Main St, Athens, GA', '1', '1');

INSERT IGNORE INTO `tournament` (`TournamentID`, `TournName`, `BeginDate`, `EndDate`, `Address`, `AdminID`, `SportID`) VALUES ('2', 'tennistourn', '2017-05-17', '2017-06-17', '4 Bush St, Buford, GA', '2', '2');

#Create 2 different playoff brackets:
INSERT IGNORE INTO `tournamentbrackets` (`RoundID`, `GameID`, `TournamentID`, `Venue`, `GameDate`, `PlayoffGameWinner`, `Address`, `DivisionID`, `WinnerTeam1`, `WinnerTeam2`) VALUES ('1', '1', '1', 'Mulberry Park', '2017-04-16', 'Kentucky Kats', '10 Main St, Athens, GA', '1', 'Texas', 'Kentucky');

INSERT IGNORE INTO `tournamentbrackets` (`RoundID`, `GameID`, `TournamentID`, `Venue`, `GameDate`, `PlayoffGameWinner`, `Address`, `DivisionID`, `WinnerTeam1`, `WinnerTeam2`) VALUES ('2', '2', '2', 'Botanical Garden', '2017-05-16', 'Vermont Syrupers', '99 Baldwin St, Athens, GA', '2', 'Vermont', 'Maine');


#Create 2 coaches for each division:
INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('3', 'John John', '7451236548', '3');

INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('4', 'Bob Smith', '8546251395', '4');

INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('5', 'Daniel Maxwell', '9653215402', '5');

INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('6', 'Mark Rile', '5426153284', '6');

INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('7', 'Janet Garcia', '8759624352', '7');

INSERT IGNORE INTO `coach` (`CoachID`, `CoachName`, `CoachPhone`, `TeamID`) VALUES ('8', 'Oprah Han', '1542658459', '8');