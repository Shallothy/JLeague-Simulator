package shall.domain;

import java.util.Optional;

public class Match {
    private final Team homeTeam;
    private final Team visitingTeam;
    private int homeScore;
    private int visitingScore;

    public Match(Team homeTeam, Team visitingTeam) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homeScore = 0;
        this.visitingScore = 0;
    }

    public void addHomeGoal() {
        this.homeScore++;
    }

    public void addVisitingGoal() {
        this.visitingScore++;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getVisitingTeam() {
        return visitingTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getVisitingScore() {
        return visitingScore;
    }

    /**
     * Determina o vencedor da partida.
     *
     * @return um Optional contendo o time vencedor, ou um Optional vazio se for empate.
     */
    public Optional<Team> getWinner() {
        if (homeScore > visitingScore) {
            return Optional.of(homeTeam);
        } else if (visitingScore > homeScore) {
            return Optional.of(visitingTeam);
        } else {
            return Optional.empty(); // Representa um empate
        }
    }

    public boolean isDraw() {
        return homeScore == visitingScore;
    }

    public String getScoreboard() {
        return String.format("%s %d x %d %s",
                homeTeam.getTeamName(), homeScore,
                visitingScore, visitingTeam.getTeamName());
    }
}
