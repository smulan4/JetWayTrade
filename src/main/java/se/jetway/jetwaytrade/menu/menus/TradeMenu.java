package se.jetway.jetwaytrade.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import se.jetway.jetwaytrade.menu.Menu;
import se.jetway.jetwaytrade.utils.ItemUtils;

import java.util.Arrays;

public class TradeMenu extends Menu {

    public TradeMenu() {
        super("Trade", 27);
    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        player.sendMessage("Din lilla jäkel!!!!!");
    }

    @Override
    public void decorateMenu(Inventory inventory) {
        ItemStack itemStack2 = ItemUtils.createItem(Material.COBBLESTONE, "Test", 1, null, false);
        inventory.setItem(2, itemStack2);
    }
}
