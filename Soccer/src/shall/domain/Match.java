package shall.domain;

public class Match {
    private final Team homeTeam;
    private final Team visitingTeam;
    private int homeScore;
    private int visitingScore;

    public Match(Team homeTeam, Team visitingTeam) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homeScore =0;
        this.visitingScore =0;
    }
    public void winnerMatch(){
        if(homeScore> visitingScore){
            System.out.printf("homeTeam: %s, a total of: %d goal(s)%n" +
                    "visitingTeam: %s, a total of: %d goal(s)%n%s winner!%n",
                    homeTeam.getTeamName(), homeScore, visitingTeam.getTeamName(), visitingScore, homeTeam.getTeamName());
        } else if (homeScore< visitingScore) {
            System.out.printf("homeTeam: %s, a total of: %d goal(s)%n" +
                    "visitingTeam: %s, a total of: %d goal(s)%n%s winner!%n",
                    homeTeam.getTeamName(), homeScore, visitingTeam.getTeamName(), visitingScore, visitingTeam.getTeamName());
        } else {
            System.out.printf("homeTeam: %s, a total of: %d goal(s)%n" +
                    "visitingTeam: %s, a total of: %d goal(s)%nDrawn!%n",
                    homeTeam.getTeamName(), homeScore, visitingTeam.getTeamName(), visitingScore);
        }
    }

    public String score(){
        return String.format("%s x %s\n\t%d \tx \t%d",
                homeTeam.getTeamName(), visitingTeam.getTeamName(), homeScore, visitingScore);
    }

    public void goalHome() {
        System.out.printf("%s scored a goal%n", homeTeam.getTeamName());
        ++this.homeScore;
        System.out.println(score());

    }
    public void goalVisit(){
        System.out.printf("%s scored a goal%n", visitingTeam.getTeamName());
        ++this.visitingScore;
        System.out.println(score());
    }
}
