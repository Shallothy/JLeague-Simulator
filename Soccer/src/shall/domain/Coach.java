package shall.domain;

import shall.domain.enums.Gender;
import shall.error.InvalidAge;
import shall.services.impl.Disciplinable;

import java.util.Random;

public class Coach extends Person implements Disciplinable {
    private String preferredFormation;
    private int experienceYears;
    private boolean isExpelled;
    private int yellowCard;

    public Coach() {
        this("Unnamed", 18, null, "4-4-2", 0);
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
        this.isExpelled =false;
        this.yellowCard =0;
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
    public boolean isExpelled(){ return this.isExpelled; }

    protected void receiveYellowCard() {
        this.yellowCard++;
        System.out.println("🟨 Coach took a card");
        if(this.yellowCard >1){
            System.out.println("🟥 Coach sent off! (Second Yellow Card)");
            this.isExpelled =true;
            return;
        }
        System.out.println("Coach can't take another card!.");
    }

    @Override
    public void madeMistake() {
        if(this.isExpelled){
            throw new IllegalStateException("INVALID ACTION! Coach " + this.getName() + " has already been sent off to the stands.");
        }
        Random random =new Random();
        int judgment = random.nextInt(100) + 1;

        System.out.printf("⏱️ Coach %s is complaining excessively to the referee! The referee is approaching...%n", this.getName());
        if(judgment <= 60 ) {
            System.out.println("➡️ Just a verbal warning. The coach must calm down.");

        } else if(judgment <= 90){
            receiveYellowCard();

        } else {
            System.out.println("🟥 DIRECT RED CARD! The coach is sent off to the stands!");
            this.yellowCard +=2;
            this.isExpelled =true;
        }
        System.out.println();
    }

    @Override
    public void setAge(int age){
        if(age<18){
            throw new InvalidAge("The coach " + this.getName() + " was denied. Minimum age is 18 years old.");
        } super.setAge(age);
    }

    @Override
    public void printData() {
        System.out.println("--- Printing teamData ---");
        System.out.println("name: " +getName());
        System.out.println("age: " +getAge());
        System.out.println("gender: " +getGender());
        System.out.printf("preferredFormation: %s%n", getPreferredFormation());
        System.out.printf("experienceYears: %d years%n", getExperienceYears());
        System.out.println("-------------------------");
    }
}
