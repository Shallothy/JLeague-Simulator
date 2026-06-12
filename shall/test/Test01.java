package shall.test;

import shall.domain.Player;
import shall.domain.enums.Gender;
import shall.error.InvalidAge;

public class Test01 {
    static void main(String[] args) {
        try {
            Player player1 = new Player("Rebeca",21);
            Player player2 = new Player("Rodrigo",22);
            player1.setGender(Gender.GENDER_FEMALE);
            player2.setGender(Gender.GENDER_MALE);
            player1.printData();
            player2.printData();
        } catch (InvalidAge erro){
            System.out.println("Warning to the customer: " +erro.getMessage());
        }

        Player inexistente = new Player();


        try {
            inexistente.setAge(-1);
        } catch (InvalidAge erro) {
            System.out.println("Warning to the customer: " +erro.getMessage());
        }
        inexistente.printData();
    }
}
