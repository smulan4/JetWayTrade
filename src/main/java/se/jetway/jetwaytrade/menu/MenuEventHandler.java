package se.jetway.jetwaytrade.menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.Set;

public class MenuEventHandler implements Listener {

    /**
     * Handles click events for classes extending Menu.
     *
     * @param event Type of event.
     */
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Menu) {
            Menu menu = (Menu) holder;
            menu.handleClick(event);
        }
    }

    /**
     * Handles drag events for classes extending Menu.
     *
     * @param event Type of event.
     */
    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Menu) {
            Menu menu = (Menu) holder;

            Set<Integer> draggedSlots = event.getRawSlots();
            for (int draggedSlot : draggedSlots) {
                if (!menu.getAllowedSlots().contains(draggedSlot)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
