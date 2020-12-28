package factionscore.factionscore;

import org.bukkit.NamespacedKey;

public class KeyContainer {
    public static void initKeys () {
        /* Indicates the faction name */
        factionKey = new NamespacedKey(Factionscore.getPluginInstance(), "faction");
        /* Can be Owner, Member or Player */
        playerTypeKey = new NamespacedKey(Factionscore.getPluginInstance(), "playerType");
    }

    public static NamespacedKey getFactionKey() {
        return factionKey;
    }

    public static NamespacedKey getPlayerTypeKey() {
        return playerTypeKey;
    }

    private static NamespacedKey factionKey;
    private static NamespacedKey playerTypeKey;
}
