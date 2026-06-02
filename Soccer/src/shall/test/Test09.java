package shall.test;

import shall.domain.Coach;
import shall.domain.Match;
import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;
import shall.error.FullTeam;
import shall.error.InvalidAge;
import shall.error.NullPlayerException;

public class Test09 {
    static void main() {
        System.out.println("=== PREPARING THE TEAMS ===\n");

        Team brazil = new Team("Brazil", 3);
        Team argentina = new Team("Argentina", 3);

        Coach dorival = new Coach("Dorival Júnior", 61, Gender.GENDER_MALE, "4-3-3", 20);
        Coach scaloni = new Coach("Lionel Scaloni", 46, Gender.GENDER_MALE, "4-4-2", 6);

        brazil.setCoach(dorival);
        argentina.setCoach(scaloni);

        try {
            Player vini = new Player("Vini Jr", 23, Gender.GENDER_MALE, 7);
            Player rodrygo = new Player("Rodrygo", 23, Gender.GENDER_MALE, 10);
            Player endrick = new Player("Endrick", 17, Gender.GENDER_MALE, 9);

            brazil.addPlayer(vini);
            brazil.addPlayer(rodrygo);
            brazil.addPlayer(endrick);

            Player messi = new Player("Messi", 36, Gender.GENDER_MALE, 10);
            Player diMaria = new Player("Di Maria", 36, Gender.GENDER_MALE, 11);

            argentina.addPlayer(messi);
            argentina.addPlayer(diMaria);

            brazil.printDataTeam();
            System.out.println();
            argentina.printDataTeam();

            System.out.println("\n==================================\n");

            System.out.println("=== KICK-OFF! THE BALL IS ROLLING! ===\n");
            Match worldCupFinal = new Match(brazil, argentina);

            vini.scoreGoal();
            worldCupFinal.goalHome();

            messi.scoreGoal();
            worldCupFinal.goalVisit();

            rodrygo.scoreGoal();
            worldCupFinal.goalHome();

            vini.scoreGoal();
            worldCupFinal.goalHome();

            System.out.println("\n=== FULL TIME ===");
            worldCupFinal.winnerMatch();

            System.out.println("\n=== MATCH HIGHLIGHTS ===");
            System.out.println("Top scorer for " + brazil.getTeamName() + ":");
            brazil.getTopScored();

        } catch (InvalidAge | FullTeam e) {
            System.out.println("\nLINEUP ERROR: " + e.getMessage());
        } catch (NullPlayerException e) {
            System.out.println("\nDATA ERROR: " + e.getMessage());
        }
    }
}