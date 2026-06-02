package shall.domain;

import shall.error.FullTeam;
import shall.error.NullPlayerException;

import java.util.Arrays;

public class Team {
    private String teamName;
    private final Player[] players;
    private Coach coach;
    private int size;

    public Team(){
        this("Unamed team", 25);
    }

    public Team(String teamName){
        this(teamName, 25);
    }

    public Team(String teamName, int capacity){
        this.teamName =teamName;
        if(capacity <= 25) {
            this.players = new Player[capacity];
        } else {
            this.players =new Player[25];
        }
        this.size =0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayers(){ return Arrays.copyOf(this.players, this.size); }


    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void addPlayer(Player player) {
        if(player==null){
            throw new NullPlayerException("Couldn't add a null player.");
        }

        if(size>=this.players.length){
            throw new FullTeam("The team is full.");
        }

        this.players[size] =player;
        size++;
    }

    public Player getTopScored() {
        if(size==0){
            return null;
        }

        Player topScored =this.players[0];

        for (int i = 1; i < size; i++) {
            if(topScored.getGoalsScored() < this.players[i].getGoalsScored()){
                topScored =this.players[i];
            }
        }
        topScored.topScored();
        return topScored;
    }

    public void printDataTeam() {
        System.out.println("Printing dataTeam...");
        System.out.printf("teamName: %s%n", this.getTeamName());
        if(this.coach!=null) {
            System.out.printf("Coach: %s%n", this.coach.getName());
        } else {
            System.out.println("Coach: no Coach assigned.");
        }
        System.out.print("Players: ");

        if(this.size == 0){
            System.out.println("There is no one on the team");

        } else {

            for(int i=0; i<size; i++) {
                System.out.printf("%s (shirtNumber: %d)", this.players[i].getName(), this.players[i].getShirtNumber());
                if(i <size-1){
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
            }
        }
    }
}
