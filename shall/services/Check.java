package shall.services;

import org.jetbrains.annotations.NotNull;
import shall.domain.Player;
import shall.domain.enums.SubCategory;

public class Check {
    public static SubCategory checkingSubCategory(int age) {
        for(SubCategory category : SubCategory.values()) {
            if(category.isWithinCategory(age)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No category found: " +age);
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
