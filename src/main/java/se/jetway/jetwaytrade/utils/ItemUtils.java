package se.jetway.jetwaytrade.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for creating and manipulating ItemStacks.
 */
public class ItemUtils {

    /**
     * Creates an ItemStack with the specified properties.
     *
     * @param material The material of the item.
     * @param title    The display name of the item.
     * @param amount   The amount of items in the stack. Must be greater than 0.
     * @param lore     The lore of the item. Each line is colorized using TextUtils.
     * @param glow     Whether the item should have a glowing effect.
     * @return The created ItemStack.
     * @throws IllegalArgumentException if material or title is null.
     */
    public static ItemStack createItem(Material material, String title, int amount, List<String> lore, boolean glow) {

        if (material == null || title == null) {
            throw new IllegalArgumentException("Material and title cannot be null.");
        }

        amount = amount <= 0 ? 1 : amount;
        lore = lore != null ? lore.stream().map(TextUtils::color).collect(Collectors.toList()) : null;

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(TextUtils.color(title));

        if (lore != null && !lore.isEmpty()) {
            itemMeta.setLore(lore);
        }

        if (glow) {
            itemMeta.addEnchant(Enchantment.LURE, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /**
     * Creates a player head ItemStack with the specified properties.
     *
     * @param name The name of the player whose head should be displayed.
     * @param lore The lore of the player head. Each line is colorized using TextUtils.
     * @param glow Whether the player head should have a glowing effect.
     * @return The created player head ItemStack.
     */
    public static ItemStack getPlayerHead(String name, List<String> lore, boolean glow) {
        ItemStack head = createItem(Material.PLAYER_HEAD, name,1, lore, glow);
        SkullMeta meta = (SkullMeta) head.getItemMeta();

        Player player = Bukkit.getPlayerExact(name);
        if (player != null) {
            meta.setOwningPlayer(player);
        }

        head.setItemMeta(meta);
        return head;
    }

}
