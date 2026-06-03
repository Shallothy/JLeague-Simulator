package shall.domain;

import shall.error.FullTeam;
import shall.error.NullPlayerException;

import java.util.Arrays;

public class Team {
    private String teamName;
    private final Player[] PLAYERS;
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
            this.PLAYERS = new Player[capacity];
        } else {
            this.PLAYERS =new Player[25];
        }
        this.size =0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player[] getPlayers(){ return Arrays.copyOf(this.PLAYERS, this.size); }

    public void addPlayer(Player player) {
        if(player==null){
            throw new NullPlayerException("Couldn't add a null player.");
        }

        if(size>=this.PLAYERS.length){
            throw new FullTeam("The team is full.");
        }

        this.PLAYERS[size] =player;
        size++;
    }

    public void removePlayer(Player player){
        if(player==null){
            throw new NullPlayerException("Couldn't add a null player.");
        }

        boolean found =false;
        for (int i = 0; i < this.PLAYERS.length; i++) {
            if(this.PLAYERS[i] != null && this.PLAYERS[i].getName().equals(player.getName())) {
                PLAYERS[i] =null;
                found =true;
                System.out.println("✅ " +player.getName() +" left " + this.getTeamName() +".");
                this.size--;
                break;
            }
        }

        if(!found) {
            throw new IllegalArgumentException("Player " +player.getName() +" isn't in team " +this.getTeamName());
        }
    }

    public Player getTopScored() {
        if(size==0){
            return null;
        }

        Player topScored =this.PLAYERS[0];

        for (int i = 1; i < size; i++) {
            if(topScored.getGoalsScored() < this.PLAYERS[i].getGoalsScored()){
                topScored =this.PLAYERS[i];
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

        if(this.size == 0){
            System.out.println("There is no one on the team");

        } else {
            System.out.println("PLAYERS:");
            for (int i = 0; i < PLAYERS.length; i++) {
                // CADEADO DE SEGURANÇA: Só imprime se a vaga NÃO estiver vazia!
                if (PLAYERS[i] != null) {
                    PLAYERS[i].printData();
                }
            }
        }
    }
}
