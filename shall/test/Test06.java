package shall.test;

import shall.domain.Player;
import shall.domain.Team;

public class Test06 {
    static void main(String[] args) {
        Player rodrigo = new Player("Rodrigo",22);
        Player rebeca = new Player("Rebeca",21);
        Team teamFull = new Team("Monteiro",3);

        teamFull.addPlayer(rodrigo);
        teamFull.addPlayer(rebeca);
        teamFull.addPlayer(null);

        Player eustacio = new Player("Eustácio", 56);
        teamFull.addPlayer(eustacio);

        for (int i = 0; i < teamFull.getPlayers().length; i++) {
            System.out.println(teamFull.getPlayers()[i].getName());
        }

        System.out.println("END!");

        teamFull.printTeamData();

    }
}
