package factionscore.factionscore;

import factionscore.factionscore.factions.Faction;
import factionscore.factionscore.factions.FactionsContainer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class OnlinePlayer {
    public static void addOnlinePlayers() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            setTags(p);
            onlinePlayers.add(p);
        }
    }

    public static void addPlayer(Player player) {
        setTags(player);
        setTags(player);
        onlinePlayers.add(player);
    }

    public static void removePlayer(Player player) {
        onlinePlayers.remove(player);
    }

    private static void setTags (Player player) {
        for (Faction f : FactionsContainer.getFactions()) {
            if (f.hasMember(player.getUniqueId())) {
                player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, f.getFactionName());
                if (f.getLeader().equals(player.getUniqueId())) {
                    player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, "Owner");
                    Bukkit.getServer().broadcastMessage(ChatColor.RED + "Faction owner " + player.getDisplayName() +
                            ChatColor.WHITE + " has joined the server!");
                } else {
                    player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, "Member");
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Faction member " + player.getDisplayName() +
                            ChatColor.WHITE + " has joined the server!");
                }
                return;
            }
        }
        player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, "");
        player.getPersistentDataContainer().set(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING, "Player");
        Bukkit.getServer().broadcastMessage(ChatColor.BLACK + "Player " + player.getDisplayName() +
                ChatColor.WHITE + " has joined the server!");
    }

    private static List<Player> onlinePlayers = new ArrayList<>();
}
