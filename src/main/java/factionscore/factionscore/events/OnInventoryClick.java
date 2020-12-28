package factionscore.factionscore.events;

import factionscore.factionscore.guis.EldarionGuiEvent;
import factionscore.factionscore.guis.InventoryEventContainer;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnInventoryClick {
    public static void handle(InventoryClickEvent event) {
        for(EldarionGuiEvent event1: InventoryEventContainer.getHandlers()) {
            event1.inventoryClicked(event);
        }
    }
}
