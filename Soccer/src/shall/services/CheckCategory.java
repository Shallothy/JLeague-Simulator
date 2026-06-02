package shall.services;

import org.jetbrains.annotations.NotNull;
import shall.domain.Player;

public class CheckCategory {
    public static void checkingSubCategory(int age){

        if(age >= 6 && age <= 7){
            System.out.println("Sub-7");

        } else if(age == 8) {
            System.out.println("Sub-8");

        } else if(age >= 8 && age <= 9){
            System.out.println("Sub-9");

        } else if (age >= 10 && age <= 11) {
            System.out.println("Sub-11");

        } else if (age >= 12 && age <= 13) {
            System.out.println("Sub-13");

        } else if (age >= 14 && age <= 15) {
            System.out.println("Sub-15");

        } else if (age >= 16 && age <= 17) {
            System.out.println("Sub-17");

        } else if(age >= 18 && age <= 20) {
            System.out.println("Sub-20");

        } else {
            System.out.println("Professional");

        }
    }

    public static void genderChecking(@NotNull Player p) {
        System.out.printf("PlayerName: %s; TeamName: %s%n",p.getName(), p.getTeam());
        if(p.getGender().getGender() == 'F'){
            System.out.println("Female category.");
        } else{
            System.out.println("Male category.");
        }
    }
}
