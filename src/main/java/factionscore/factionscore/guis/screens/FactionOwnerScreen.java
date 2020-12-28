package factionscore.factionscore.guis.screens;

import factionscore.factionscore.guis.EldarionGui;
import factionscore.factionscore.guis.EldarionGuiEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class FactionOwnerScreen extends EldarionGuiEvent {
    public FactionOwnerScreen(Player player) {
        screenOwner = player;
        createGui();
    }

    private void createGui() {
        gui = new EldarionGui(18, "Faction Owner GUI", this);
        gui.addItem(Material.PLAYER_HEAD, "List players");
        gui.openInventory(screenOwner);
    }

    @Override
    public void inventoryClicked(InventoryClickEvent event) {
        super.inventoryClicked(event);
    }

    @Override
    public void inventoryDragged(InventoryDragEvent event) {
        if (event.getInventory() != gui.getMinecraftInventory()) return;
        event.setCancelled(true);
    }

    private Player screenOwner;
    private EldarionGui gui;
}
