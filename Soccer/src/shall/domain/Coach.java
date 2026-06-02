package shall.domain;

import shall.domain.enums.Gender;
import shall.error.InvalidAge;

public class Coach extends Person {
    private String preferredFormation;
    private int experienceYears;

    public Coach() {
        this("Unnamed Coach", 18, null, "4-4-2", 0);
    }

    public Coach(String name, int age) {
        this(name, age, null, "Unknown", 0);
    }

    public Coach(String name, int age, Gender gender) {
        this(name, age, gender, "Unknown", 0);
    }

    public Coach(String name, int age, Gender gender, String preferredFormation, int experienceYears) {
        super(name, age, gender);

        if (age < 18) {
            throw new InvalidAge("The coach " + name + " was denied. Minimum age is 18 years old.");
        }
        this.preferredFormation = preferredFormation;
        this.experienceYears = experienceYears;
    }

    public String getPreferredFormation() {
        return preferredFormation;
    }

    public void setPreferredFormation(String preferredFormation) {
        this.preferredFormation = preferredFormation;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public void setAge(int age){
        if(age<18){
            throw new InvalidAge("The coach " + this.getName() + " was denied. Minimum age is 18 years old.");
        } super.setAge(age);
    }

    @Override
    public void printData() {
        System.out.println("--- Printing dataTeam ---");
        System.out.println("name: " +getName());
        System.out.println("age: " +getAge());
        System.out.println("gender: " +getGender());
        System.out.printf("preferredFormation: %s%n", getPreferredFormation());
        System.out.printf("experienceYears: %d years%n", getExperienceYears());
        System.out.println("-------------------------");
    }
}
