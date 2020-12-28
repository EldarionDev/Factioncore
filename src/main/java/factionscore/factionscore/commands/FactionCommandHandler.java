package factionscore.factionscore.commands;

import factionscore.factionscore.KeyContainer;
import factionscore.factionscore.guis.screens.FactionMemberScreen;
import factionscore.factionscore.guis.screens.FactionOwnerScreen;
import factionscore.factionscore.guis.screens.FactionlessScreen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class FactionCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerType = player.getPersistentDataContainer().get(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING);
            assert playerType != null;
            if (playerType.equalsIgnoreCase("Player")) {
                new FactionlessScreen(player);
            } else if (playerType.equalsIgnoreCase("Member")) {
                new FactionMemberScreen(player);
            } else if (playerType.equalsIgnoreCase("Leader")) {
                new FactionOwnerScreen(player);
            }
        }
        return true;
    }
}
