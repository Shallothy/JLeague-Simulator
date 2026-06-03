package shall.domain;

public class Match {
    private final Team HOME_TEAM;
    private final Team VISITE_TEAM;
    private int homeScore;
    private int visitingScore;

    public Match(Team HOME_TEAM, Team VISITE_TEAM) {
        this.HOME_TEAM = HOME_TEAM;
        this.VISITE_TEAM = VISITE_TEAM;
        this.homeScore =0;
        this.visitingScore =0;
    }
    public void winnerMatch(){
        if(homeScore> visitingScore){
            System.out.printf("HOME_TEAM: %s, a total of: %d goal(s)%n" +
                    "VISITE_TEAM: %s, a total of: %d goal(s)%n%s winner!%n",
                    HOME_TEAM.getTeamName(), homeScore, VISITE_TEAM.getTeamName(), visitingScore, HOME_TEAM.getTeamName());
        } else if (homeScore< visitingScore) {
            System.out.printf("HOME_TEAM: %s, a total of: %d goal(s)%n" +
                    "VISITE_TEAM: %s, a total of: %d goal(s)%n%s winner!%n",
                    HOME_TEAM.getTeamName(), homeScore, VISITE_TEAM.getTeamName(), visitingScore, VISITE_TEAM.getTeamName());
        } else {
            System.out.printf("HOME_TEAM: %s, a total of: %d goal(s)%n" +
                    "VISITE_TEAM: %s, a total of: %d goal(s)%nDrawn!%n",
                    HOME_TEAM.getTeamName(), homeScore, VISITE_TEAM.getTeamName(), visitingScore);
        }
    }

    public String score(){
        return String.format("%s x %s\n\t%d \tx \t%d",
                HOME_TEAM.getTeamName(), VISITE_TEAM.getTeamName(), homeScore, visitingScore);
    }

    public void goalHome() {
        System.out.printf("%s scored a goal%n", HOME_TEAM.getTeamName());
        ++this.homeScore;
        System.out.println(score());

    }
    public void goalVisit(){
        System.out.printf("%s scored a goal%n", VISITE_TEAM.getTeamName());
        ++this.visitingScore;
        System.out.println(score());
    }
}
