package factionscore.factionscore.guis.screens;

import factionscore.factionscore.guis.EldarionGui;
import factionscore.factionscore.guis.EldarionGuiEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class FactionlessScreen extends EldarionGuiEvent {
    public FactionlessScreen(Player player) {
        screenOwner = player;
        createGui();
    }

    private void createGui() {
        gui = new EldarionGui(9, "Factionless GUI", this);
        gui.addItem(Material.CYAN_BANNER, "List factions");
        gui.addItem(Material.DARK_OAK_DOOR, "Join a faction");
        gui.addItem(Material.NETHER_STAR, "Create a faction");
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
