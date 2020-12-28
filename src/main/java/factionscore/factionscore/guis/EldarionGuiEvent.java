package factionscore.factionscore.guis;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class EldarionGuiEvent {
    public void inventoryClicked(final InventoryClickEvent event) {
        return;
    }

    public void inventoryDragged(final InventoryDragEvent event) {
        Bukkit.getServer().broadcastMessage("Wrong command executed.");
        return;
    }
}
