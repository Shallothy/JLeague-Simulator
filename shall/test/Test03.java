package shall.test;

import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;
import shall.services.Check;

public class Test03 {
    static void main(String[] args) {

        Player player1 = new Player("Rebeca",21,Gender.GENDER_FEMALE,7);
        Player player2 = new Player("Rodrigo",22,Gender.GENDER_MALE,12);
        Player player3 = new Player();
        Player player4 = new Player();

        Team team1 = new Team();
        team1.setTeamName("Monteiro");
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        player1.setTeam(team1.getTeamName());
        player2.setTeam(team1.getTeamName());


        Team team2 = new Team();
        player3.setName("Márcio");
        player3.setAge(32);
        player3.setShirtNumber(32);
        player3.setGender(Gender.GENDER_MALE);
        player4.setName("Exmerralda");
        player4.setAge(31);
        player4.setShirtNumber(31);
        player4.setGender(Gender.GENDER_FEMALE);
        team2.setTeamName("Montenegro");
        player3.setTeam(team2.getTeamName());
        player4.setTeam(team2.getTeamName());
        team2.addPlayer(player3);
        team2.addPlayer(player4);

        player1.checkingCategory();
        player2.checkingCategory();
        Check.checkingSubCategory(player3.getAge());
        Check.checkingSubCategory(player4.getAge());
        System.out.println("--------------------");
        Check.genderChecking(player1);
        Check.genderChecking(player2);
        Check.genderChecking(player3);
        Check.genderChecking(player4);
    }
}
