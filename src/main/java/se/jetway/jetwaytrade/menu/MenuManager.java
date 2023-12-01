package se.jetway.jetwaytrade.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import se.jetway.jetwaytrade.menu.menus.TradeMenu;
import se.jetway.jetwaytrade.menu.menus.TradePlayerMenu;

public class MenuManager {

    /**
     * Opens menu to chosen player based on MenuType.
     *
     * @param player That will open the menu.
     * @param menuType Type of Menu.
     */
    public static void openMenu(Player player, MenuTypes menuType) {
        if (player != null) {
            Menu menu = getMenu(menuType);
            Inventory inventory = menu.getInventory();
            player.openInventory(inventory);
        }
    }

    /**
     * Returns an object of a Menu based on MenuType.
     *
     * @param menuType of Menu.
     * @return Object based on MenyType.
     */
    public static Menu getMenu(MenuTypes menuType) {
        switch (menuType) {
            case Trade:
                return new TradeMenu();
            case TradePlayer:
                return new TradePlayerMenu();
            default: return null;
        }
    }

}
