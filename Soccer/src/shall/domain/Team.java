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
        this("Unnamed team", 25);
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

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player[] getPlayers(){ return Arrays.copyOf(this.players, this.size); }

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

    public void removePlayer(Player player){
        if(player==null){
            throw new NullPlayerException("Couldn't add a null player.");
        }

        boolean found =false;
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i] != null && this.players[i].getName().equals(player.getName())) {
                players[i] =null;
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

    public Player getTopScorer() {
        if(size==0){
            return null;
        }

        Player topScorer =this.players[0];

        for (int i = 1; i < size; i++) {
            if(topScorer.getGoalsScored() < this.players[i].getGoalsScored()){
                topScorer =this.players[i];
            }
        }
        topScorer.topScorer();
        return topScorer;
    }

    public void printTeamData() {
        System.out.println("Printing teamData...");
        System.out.printf("teamName: %s%n", this.getTeamName());
        if(this.coach!=null) {
            System.out.printf("Coach: %s%n", this.coach.getName());
        } else {
            System.out.println("Coach: no Coach assigned.");
        }

        if(this.size == 0){
            System.out.println("There is no one on the team");

        } else {
            System.out.println("players:");
            for (int i = 0; i < players.length; i++) {
                // CADEADO DE SEGURANÇA: Só imprime se a vaga NÃO estiver vazia!
                if (players[i] != null) {
                    players[i].printData();
                }
            }
        }
    }
}
