package shall.domain;

import shall.domain.enums.Gender;
import shall.domain.enums.SubCategory;
import shall.error.InvalidAge;
import shall.services.Check;
import shall.services.impl.Disciplinable;

import java.util.Random;

public class Player extends Person implements Disciplinable {
    private int shirtNumber;
    private String team;
    private SubCategory category;
    private int yellowCard;
    private int goalsScored;
    private boolean isExpelled;

    public Player(){this("Unnamed",6, null, 0);}

    public Player(String name, int age) {
        super(name, age);
    }

    public Player(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public Player(String name, int age, Gender gender, int shirtNumber) {
        super(name, age, gender);
        if(age<6){
            throw new InvalidAge("The player " +name +" was denied. Minimum age is 6 years old.");
        } this.shirtNumber = shirtNumber;
        this.isExpelled =false;
        this.category = Check.checkingSubCategory(age);
    }

    protected void topScored(){
        System.out.printf("The player soccer: %s is the topScored on the team. with %d goal%n",
                this.getName(), this.getGoalsScored());
        System.out.print("Category: \t");
        checkingCategory();
    }

    protected void receiveYellowCard() {
        this.yellowCard++;
        System.out.println("🟨 Player took a card");
        if(this.yellowCard >1){
            System.out.println("🟥 Player sent off! (Second Yellow Card)");
            this.isExpelled =true;
            return;
        }
        System.out.println("Player can't take another card!.");
    }

    @Override
    public void madeMistake() {
        if(this.isExpelled){
            throw new IllegalStateException("Invalid action, the " +this.getName()  +" has already been sent off and cannot commit fouls");
        }
        Random random =new Random();
        int judgment = random.nextInt(100) + 1;

        System.out.printf("⏱️ %s committed a foul! The referee is evaluating...%n", this.getName());
        if(judgment <= 60 ) {
            System.out.println("➡️ Just a warning. No card given.");

        } else if(judgment <= 90){
            receiveYellowCard();

        } else {
            System.out.println("🟥 DIRECT RED CARD! The player is sent off!");
            this.yellowCard +=2;
            this.isExpelled =true;
        }
        System.out.println();
    }

    public int getGoalsScored(){ return this.goalsScored; }

    public void scoreGoal() {
        if(this.isExpelled) {
            throw new IllegalStateException("GOAL DISALLOWED! The player is sent off and out of the pitch.");
        }
        this.goalsScored++;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public SubCategory getCategory() {
        return category;
    }

    @Override
    public boolean isExpelled() { return this.isExpelled; }

    public void checkingCategory(){
        Check.checkingSubCategory(this.getAge());
    }

    @Override
    public void setAge(int age){
        if(age<6){
            throw new InvalidAge("The player " +this.getName() +"was denied. Minimum age is 6 years old.");
        } this.setAge(age);
    }

    @Override
    public void printData() {
        System.out.println("--- Printing dataPlayer... ---");
        System.out.println("name: " +this.getName());
        System.out.println("age: " +this.getAge());
        System.out.println("gender: " +this.getGender());
        System.out.println("category: " +category);
        System.out.println("shirtNumber: " +this.getShirtNumber());
        System.out.println("yellowCard: " +this.yellowCard);
        System.out.println("isExpelled? " +this.isExpelled);
        System.out.println("------------------------------");
    }
}
