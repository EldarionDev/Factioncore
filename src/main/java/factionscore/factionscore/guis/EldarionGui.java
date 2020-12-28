package factionscore.factionscore.guis;

import factionscore.factionscore.Factionscore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EldarionGui {
    public EldarionGui(int slots, String name, EldarionGuiEvent handler) {
        minecraftInventory = Bukkit.createInventory(null, slots, name);
        slotCount = slots;
        inventoryName = name;
        eventHandler = handler;
        InventoryEventContainer.registerHandler(this.eventHandler);
    }

    public boolean addItem(Material material, String name) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        item.setItemMeta(meta);

        if (currentPosition == (slotCount - 1)) {
            Factionscore.getPluginLogger().info("[WARNING] Attempting to add material to GUI, though GUI is full!");
            return false;
        }

        minecraftInventory.setItem(currentPosition, item);
        ++currentPosition;
        return true;
    }

    public void openInventory(Player player) {
        player.openInventory(minecraftInventory);
    }

    public Inventory getMinecraftInventory() {
        return  minecraftInventory;
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        eventHandler.inventoryClicked(event);
    }

    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent event) {
        eventHandler.inventoryDragged(event);
    }

    private final Inventory minecraftInventory;
    private final int slotCount;
    private final String inventoryName;
    private int currentPosition;
    private final EldarionGuiEvent eventHandler;
}
