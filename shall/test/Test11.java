package shall.test;

import shall.domain.Player;
import shall.domain.Team;
import shall.domain.enums.Gender;
import shall.services.TransferService;

public class Test11 {
    // ⬇️ A correção está exatemente nesta linha abaixo ⬇️
    public static void main(String[] args) {
        System.out.println("=== TRANSFER MARKET TEST ===\n");

        Team brazil = new Team("Brazil", 3); // O Brasil tem 3 vagas
        Team argentina = new Team("Argentina", 2); // A Argentina tem apenas 2 vagas

        Player vini = new Player("Vini Jr", 23, Gender.GENDER_MALE, 7);
        Player rodrygo = new Player("Rodrygo", 23, Gender.GENDER_MALE, 10);

        Player messi = new Player("Messi", 36, Gender.GENDER_MALE, 10);
        Player diMaria = new Player("Di Maria", 36, Gender.GENDER_MALE, 11);

        // Escalando os times iniciais
        brazil.addPlayer(vini);
        brazil.addPlayer(rodrygo); // Sobra 1 vaga no Brasil

        argentina.addPlayer(messi);
        argentina.addPlayer(diMaria); // A Argentina fica LOTADA (2/2)

        brazil.printDataTeam();
        System.out.println();
        argentina.printDataTeam();
        System.out.println("---------------------------");

        TransferService market = new TransferService();

        System.out.println("\n--- SCENARIO 1: SUCCESSFUL TRANSFER ---");
        // Tentando transferir Messi para o Brasil (Vai dar certo porque o Brasil tem 1 vaga)
        market.transferPlayer(messi, argentina, brazil);

        System.out.println("--- SCENARIO 2: FAILED TRANSFER (NO SPACE) ---");
        // A vaga do Messi na Argentina ficou vazia, então vamos preencher para lotar a Argentina de novo
        Player alvarez = new Player("Julian Alvarez", 24, Gender.GENDER_MALE, 9);
        argentina.addPlayer(alvarez);

        // Agora tentamos transferir o Vini Jr para a Argentina (Vai FALHAR porque a Argentina está lotada)
        market.transferPlayer(vini, brazil, argentina);

        System.out.println("=== FINAL ROSTERS ===");
        brazil.printDataTeam();
        System.out.println();
        argentina.printDataTeam();
    }
}