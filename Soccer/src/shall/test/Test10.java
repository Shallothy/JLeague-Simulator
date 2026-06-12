package shall.test;

import shall.domain.Player;
import shall.domain.enums.Gender;

public class Test10 {
    static void main(String[] args) {
        System.out.println("=== CARD SYSTEM TEST (VAR) ===\n");

        Player felipeMelo = new Player("Felipe Melo", 40, Gender.GENDER_MALE, 30);

        System.out.println("The match has started and " + felipeMelo.getName() + " is on the pitch!\n");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("--- Minute " + (i * 15) + "' ---");

                felipeMelo.madeMistake();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Warning to the customer: " +e.getMessage());
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Warning to the customer: " +e.getMessage());
        }
        System.out.println("=== END OF SIMULATION ===");

        System.out.println("\nFinal player profile after the match:");
        felipeMelo.printData();
    }
}
