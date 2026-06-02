package shall.services;

import shall.domain.Player;
import shall.domain.Team;

public class TransferService {
    public static void transferPlayer(Player player, Team origin, Team destination){
        System.out.printf("🔄 STARTING THE TRANSFER: %s", player.getName());
        System.out.printf("From: %s | to: %s", origin.getTeamName(), destination.getTeamName());

        if(player ==null || origin ==null || destination ==null){
            System.out.println("Transfer failed: Player, Origin or Destination is null");
        } if(origin.getTeamName().equals(destination.getTeamName())) {
            System.out.println("Transfer failed: Origin and Destination teams are the same");
        }
        try {
            origin.removePlayer(player);
            destination.addPlayer(player);
            System.out.println("⚽ Transfer completed successfully");
        } catch (Exception err) {
            System.out.println("❌ Transfer aborted " +err.getMessage() +"\n");
        }
    }
}
