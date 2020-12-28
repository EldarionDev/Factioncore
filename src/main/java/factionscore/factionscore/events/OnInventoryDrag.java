package factionscore.factionscore.events;

import factionscore.factionscore.guis.EldarionGuiEvent;
import factionscore.factionscore.guis.InventoryEventContainer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryDragEvent;

public class OnInventoryDrag {
    public static void handle(InventoryDragEvent event) {
        for(EldarionGuiEvent event1: InventoryEventContainer.getHandlers()) {
            event1.inventoryDragged(event);
            Bukkit.getServer().broadcastMessage("Event noticed. Stage 3.");
        }
        Bukkit.getServer().broadcastMessage("Event noticed. Stage 2.");
    }
}
