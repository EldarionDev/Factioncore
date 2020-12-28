package factionscore.factionscore;

import factionscore.factionscore.commands.FactionCommandHandler;
import factionscore.factionscore.events.EventHandler;
import factionscore.factionscore.factions.FactionsContainer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Factionscore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        pluginInstance = this;
        logger = getLogger();

        FactionsContainer.loadFactions();
        KeyContainer.initKeys();
        OnlinePlayer.addOnlinePlayers();

        getServer().getPluginManager().registerEvents(new EventHandler(), this);
        this.getCommand("faction").setExecutor(new FactionCommandHandler());
    }

    public static Factionscore getPluginInstance() {
        return pluginInstance;
    }

    public static Logger getPluginLogger() {
        return logger;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        FactionsContainer.unloadFactions();
    }

    private static Factionscore pluginInstance;
    private static Logger logger;
}