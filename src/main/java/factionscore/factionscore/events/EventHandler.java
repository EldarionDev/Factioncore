package factionscore.factionscore.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandler implements Listener {
    @org.bukkit.event.EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        OnPlayerJoin.handle(event);
    }

    @org.bukkit.event.EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        OnInventoryClick.handle(event);
    }

    @org.bukkit.event.EventHandler
    public void onInventoryDrag(final InventoryDragEvent event) {
        OnInventoryDrag.handle(event);
        Bukkit.getServer().broadcastMessage("Event noticed.");
    }
}
