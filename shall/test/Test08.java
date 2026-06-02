package shall.test;

import shall.domain.Coach;
import shall.domain.enums.Gender;
import shall.error.InvalidAge;

public class Test08 {
    static void main() {
        Coach lance = new Coach("Lance", 42, Gender.GENDER_MALE,"4-5-1",2);
        lance.printData();

        try {
            Coach coach = new Coach();
            coach.setName("Experient Trainer");
            coach.setAge(5);
            coach.setExperienceYears(1);
            coach.setPreferredFormation("8-1-1");
        } catch (InvalidAge err){
            System.out.println("Warning to the customer: " +err.getMessage());
        }
    }
}
