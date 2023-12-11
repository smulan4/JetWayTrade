package se.jetway.jetwaytrade.menu;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import se.jetway.jetwaytrade.util.TextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that provides information about a menu.
 * This class can be extended by classes representing menus.
 */
public abstract class Menu implements InventoryHolder {

    private String title;
    private int rows;

    private Inventory inventory;
    private List<Integer> allowedSlots;

    /**
     * Constructor that sets the title and number of rows in the menu.
     *
     * @param title        Title of the menu.
     * @param rows         Number of rows in the menu.
     * @param allowedSlots List of allowed slots in the menu.
     */
    public Menu(String title, int rows, List<Integer> allowedSlots) {
        this.title = title;
        this.rows = rows;
        this.allowedSlots = new ArrayList<>(allowedSlots);

        inventory = Bukkit.createInventory(
                this,
                rows * 9,
                TextUtil.colorComponent(Component.text(title))
        );

        decorateMenu(inventory);
    }

    /**
     * Abstract method that handles click events in menus.
     *
     * @param event InventoryClickEvent.
     */
    public abstract void handleClick(InventoryClickEvent event);

    /**
     * Abstract method designated to decorate the menu.
     *
     * @param inventory Menu that will be decorated.
     */
    public abstract void decorateMenu(Inventory inventory);

    /**
     * Gets the list of allowed slots in the menu.
     *
     * @return List of allowed slots.
     */
    public List<Integer> getAllowedSlots() {
        return allowedSlots;
    }

    /**
     * Gets the title of the menu.
     *
     * @return Title of the menu.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the menu.
     *
     * @param title New title for the menu.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the number of rows in the menu.
     *
     * @return Number of rows in the menu.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Sets the number of rows in the menu.
     *
     * @param rows New number of rows for the menu.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Gets the inventory associated with the menu.
     *
     * @return Inventory of the menu.
     */
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
