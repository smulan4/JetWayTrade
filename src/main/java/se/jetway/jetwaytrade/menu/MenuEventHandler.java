package se.jetway.jetwaytrade.menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuEventHandler implements Listener {

    /**
     * Handles click events for classes extending Menu.
     *
     * @param event Type of event.
     */
    @EventHandler
    public void onClick(InventoryClickEvent event) {

        InventoryHolder holder = (InventoryHolder) event.getInventory();
        if (holder instanceof Menu) {
            Menu menu = (Menu) holder;
            menu.handleClick(event);
        }

    }

}
