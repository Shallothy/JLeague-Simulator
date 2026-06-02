package shall.test;

import shall.domain.Match;
import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;

public class Test04 {
    static void main() {
        Player player1 = new Player("Rebeca",21, Gender.GENDER_FEMALE,7);
        Player player2 = new Player("Rodrigo",22,Gender.GENDER_MALE,12);
        Player player3 = new Player("Márcio", 32,Gender.GENDER_MALE, 3);
        Player player4 = new Player("Exmerralda", 31,Gender.GENDER_FEMALE, 9);

        Team team1 = new Team("Monteiro");
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        player1.setTeam(team1.getTeamName());
        player2.setTeam(team1.getTeamName());

        Team team2 = new Team("Montenegro");
        player3.setTeam(team2.getTeamName());
        player4.setTeam(team2.getTeamName());
        team2.addPlayer(player3);
        team2.addPlayer(player4);

//        player1.tookLetter();
//        player1.tookLetter();

        Match match = new Match(team1, team2);
        match.score();
        match.goalHome();
//        match.winnerMatch();
        match.score();
        match.goalVisit();
        match.score();
        match.winnerMatch();
    }
}
