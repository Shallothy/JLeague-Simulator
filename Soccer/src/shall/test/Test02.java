package shall.test;

import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;


public class Test02 {
    static void main() {
        Player player1 = new Player("Rebeca",21, Gender.GENDER_FEMALE,7);
        Player player2 = new Player("Rodrigo",22,Gender.GENDER_MALE,12);
        Player player3 = new Player("Márcio",32, Gender.GENDER_MALE, 36);
        Player player4 = new Player("Exmerralda",31,Gender.GENDER_FEMALE, 30);

        Team team1 = new Team();
        team1.setTeamName("Monteiro");
        team1.addPlayer(player1);
        team1.addPlayer(player2);

        team1.printDataTeam();

        System.out.println("------------");
        Team team2 = new Team();

        team2.setTeamName("Montenegro");
        team2.addPlayer(player3);
        team2.addPlayer(player4);
        team2.printDataTeam();

        System.out.println(player1.getGender());
        System.out.println(player2.getGender().getGender());
    }
}
