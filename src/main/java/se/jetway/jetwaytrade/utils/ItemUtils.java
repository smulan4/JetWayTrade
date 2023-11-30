package se.jetway.jetwaytrade.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class ItemUtils {

    public static ItemStack createItem(Material material, String title, int amount, List<String> lore, boolean glow) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(TextUtils.color(title));

        if (lore != null) {
            lore.replaceAll(TextUtils::color);
        }
        itemMeta.setLore(lore);

        if (glow) {
            itemMeta.addEnchant(Enchantment.LURE, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

       itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getPlayerHead(Player player, String name, List<String> lore, boolean glow) {
        ItemStack head = createItem(Material.PLAYER_HEAD, name,1, lore, glow);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(player);
        head.setItemMeta(meta);
        return head;
    }

}
