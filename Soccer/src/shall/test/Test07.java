package shall.test;

import shall.domain.Coach;
import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;
import shall.error.FullTeam;

public class Test07 {
    static void main(String[] args) {
        Team franca = new Team("França",1);

        try {
            franca.setCoach(new Coach("Clara",32,Gender.GENDER_FEMALE));
            franca.setCoach(new Coach("Marinette",51,Gender.GENDER_FEMALE));
            franca.addPlayer( new Player("Clara",28, Gender.GENDER_FEMALE,10));
            franca.addPlayer( new Player("Marie",27, Gender.GENDER_FEMALE,12));
        } catch (FullTeam erro){
            System.out.println("Warning to the customer: " +erro.getMessage());
        }
        franca.printTeamData();
    }
}
