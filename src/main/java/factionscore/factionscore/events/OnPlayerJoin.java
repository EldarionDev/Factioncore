package factionscore.factionscore.events;

import factionscore.factionscore.OnlinePlayer;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void handle(PlayerJoinEvent event) {
        OnlinePlayer.addPlayer(event.getPlayer());
    }
}
