package shall.test;

import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;

public class Test05 {
    static void main() {
        Player player1 = new Player("Rebeca",21, Gender.GENDER_FEMALE,7);
        Player player2 = new Player("Rodrigo",22,Gender.GENDER_MALE,12);
        Player player3 = new Player("Aylla",9, Gender.GENDER_FEMALE,11);
        Player player4 = new Player("Jonathan",9,Gender.GENDER_MALE,6);

        player1.scoreGoal();
        player2.scoreGoal();
        player3.scoreGoal();
        player3.scoreGoal();
        player4.scoreGoal();

        Team team1 = new Team();
        team1.setTeamName("Monteiro");
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);

        player1.setTeam(team1.getTeamName());
        player2.setTeam(team1.getTeamName());
        player3.setTeam(team1.getTeamName());
        player4.setTeam(team1.getTeamName());


        System.out.print("Category of Mom: \t");player1.checkingCategory();
        System.out.print("Category of Dad: \t");player2.checkingCategory();
        System.out.print("Category of Daughter: \t");player3.checkingCategory();
        System.out.print("Category of Son: \t");player4.checkingCategory();

        Player topScored = team1.getTopScored();

        if(topScored!=null){
            System.out.printf("The topScored is %s with %d goal(s)%n",
                    topScored.getName(), topScored.getGoalsScored());
        }
    }
}
