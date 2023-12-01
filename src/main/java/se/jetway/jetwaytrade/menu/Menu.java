package se.jetway.jetwaytrade.menu;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import se.jetway.jetwaytrade.utils.TextUtils;

/**
 * Abstract class that will provide information about menu.
 * This class can be applied to classes representing menus.
 */
public abstract class Menu implements InventoryHolder {

    private String title;
    private int rows;

    private Inventory inventory;

    /**
     * Constructor that sets title and amount of rows in the menu.
     *
     * @param title Of the menu.
     * @param rows In the menu.
     */
    public Menu(String title, int rows) {
        this.title = title;
        this.rows = rows;

        inventory = Bukkit.createInventory(this, rows, TextUtils.color(title));
        decorateMenu(inventory);
    }

    /**
     * Abstract method that will handle click events in menus.
     *
     * @param event InventoryClickEvent.
     */
    public abstract void handleClick(InventoryClickEvent event);

    /**
     * Abstract method designated to decorate the menu.
     *
     * @param inventory That will be decorated.
     */
    public abstract void decorateMenu(Inventory inventory);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
