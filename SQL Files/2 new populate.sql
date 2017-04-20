USE `softengineeringdb`;

/*Create two different sports:*/
INSERT IGNORE INTO `sport` (`SportName`, `MinTeams`, `MaxTeams`, `DivisionTeams`, `MinTeamSize`, `MaxTeamSize`, `GameRules`, `IndoorOutdoor`) VALUES ('Basketball', '2', '18', '4', '5', '12', 'Ball cannot go out of bounds.', 'Indoor');

INSERT IGNORE INTO `sport` (`SportName`, `MinTeams`, `MaxTeams`, `DivisionTeams`, `MinTeamSize`, `MaxTeamSize`, `GameRules`, `IndoorOutdoor`) VALUES ('Tennis', '2', '18', '4', '1', '2', 'Serve must go over the net.', 'Outdoor');

#Create 2 different administrators, one for each sport:
INSERT IGNORE INTO `administrator` (`AdminID`, `AdminName`, `AdminPhone`) VALUES ('1', 'Paul Redmond', '7894561234');

INSERT IGNORE INTO `administrator` (`AdminID`, `AdminName`, `AdminPhone`) VALUES ('2', 'Richard Walters', '9876543219');

#Create 2 divisions within each sport:
INSERT IGNORE INTO `division` (`DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('East', 'Indoor', '8', '80', 'Miami Heat', '2017-06-23', '1');

INSERT IGNORE INTO `division` (`DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('West', 'Indoor', '8', '80', 'Los Angeles Lakers', '2017-06-23', '1');

INSERT IGNORE INTO `division` (`DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('North', 'Outdoor', '4', '8', 'Washington Kastles', '2017-08-28', '2');

INSERT IGNORE INTO `division` (`DivisionName`, `IndoorOutdoor`, `TeamMax`, `PlayerMax`, `WinningTeam`, `SeasonEndDate`, `SportID`) VALUES ('South', 'Outdoor', '4', '8', 'San Diego Aviators', '2017-08-28', '2');

#Create 2+ teams for each divisions:
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Viginia Vols', '16', 'Active','10','5','1');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Kentucky Kats', '16', 'Active','5','10','1');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('California Condors', '32', 'Active','12','6','2');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Washington Wagons', '32', 'Active','6','12','2');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Vermont Syrupers', '20', 'Active','11','8','3');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Maine Mountaineers', '20', 'Active','8','11','3');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Texas Texans', '24', 'Active','4','0','4');
INSERT IGNORE INTO `team` (`TeamName`,`PlayerCount`,`Active`,`Wins`,`Losses`,`DivisionID`) VALUES ('Missouri Misery', '24', 'Active','0','4','4');

#Create 2+ players for each team:

INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Richard Richmond', '6788675309', '1');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Tom Cruise', '6781234756', '1');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('John Hamilton', '4041234568', '2');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('John Snow', '4044856912', '2');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Scott Ryder', '6385237891', '3');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('John Shepherd', '6385565785', '3');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Donald Trump', '6375824565', '4');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Leroy Jenkins', '5864555895', '4');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Ryan Renolds', '5864722612', '5');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Ryan Seacrest', '5869645565', '5');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('John Abrams', '6864758642', '6');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Tommy Twotone', '7078675309', '6');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('John Wick', '5658925358', '7');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Clint Eastwood', '8586976248', '7');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Frodo Baggens', '6965785245', '8');
INSERT IGNORE INTO `player` (`PlayerName`, `PlayerPhone`, `TeamID`) VALUES ('Gandalf the Grey', '8985465352', '8');

#Create 1 guest for each sport:
INSERT IGNORE INTO `guest` (`GuestEmail`) VALUES ('guest@guestmail.com');
INSERT IGNORE INTO `user`(`Name`,`Password`,`Email`,`Address`,`Privileges`,`GuestID`) VALUES ('guest','P@ssW00d','guest@guestmail.com','1234 Main St, Louisville, LA', 'GUEST', '1');
INSERT IGNORE INTO `guest` (`GuestEmail`) VALUES ('guest1@guestmail.com');
INSERT IGNORE INTO `user`(`Name`,`Password`,`Email`,`Address`,`Privileges`,`GuestID`) VALUES ('Mickey Johns','123Pass','guest1@guestmail.com','1234 2nd St, Athens, GA', 'GUEST', '2');

#Create 2 different tournaments:
INSERT IGNORE INTO `tournament` (`AdminID`, `SportID`, `Name`) VALUES ('1', '1', 'basketballtourn');

INSERT IGNORE INTO `tournament` (`AdminID`, `SportID`, `Name`) VALUES ('2', '2', 'tennistourn');

#Create 2 different playoff brackets:
INSERT IGNORE INTO `tournamentbrackets` (`gameID`, `tournID`, `PlayoffGameWinner`) VALUES ('1', '1', '1');

INSERT IGNORE INTO `tournamentbrackets` (`gameID`, `tournID`, `PlayoffGameWinner`) VALUES ('2', '2', '2');


#Create 2 coaches for each division:
INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('John John', '7451236548', '3');

INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('Bob Smith', '8546251395', '4');

INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('Daniel Maxwell', '9653215402', '5');

INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('Mark Rile', '5426153284', '6');

INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('Janet Garcia', '8759624352', '7');

INSERT IGNORE INTO `coach` (`CoachName`, `CoachPhone`, `TeamID`) VALUES ('Oprah Han', '1542658459', '8');