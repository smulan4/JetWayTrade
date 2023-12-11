package se.jetway.jetwaytrade.util;

import net.kyori.adventure.text.Component;
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
 * Builder class for creating ItemStacks with additional properties.
 */
public class ItemBuilder {

    private final Material material;
    private Component title;
    private int amount;
    private List<Component> lore;
    private Player owner;
    private boolean glow;

    /**
     * Constructs an ItemBuilder with the specified material.
     *
     * @param material The material of the item.
     */
    public ItemBuilder(Material material) {
        this.material = material;
        this.title = Component.text(" ");
        this.amount = 1;
    }

    /**
     * Sets the title of the item.
     *
     * @param title The title to set.
     * @return The ItemBuilder instance for method chaining.
     */
    public ItemBuilder withTitle(String title) {
        this.title = TextUtil.colorComponent(Component.text(title));
        return this;
    }

    /**
     * Sets the amount of items in the stack.
     *
     * @param amount The amount to set.
     * @return The ItemBuilder instance for method chaining.
     */
    public ItemBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the lore of the item.
     *
     * @param lore The lore to set.
     * @return The ItemBuilder instance for method chaining.
     */
    public ItemBuilder withList(List<String> lore) {
        this.lore = lore.stream()
                .map(string -> TextUtil.colorComponent(Component.text(string)))
                .collect(Collectors.toList());
        return this;
    }

    /**
     * Sets the owner of the item (applicable for player heads).
     *
     * @param owner The owner to set.
     * @return The ItemBuilder instance for method chaining.
     */
    public ItemBuilder withOwner(Player owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Sets whether the item should glow.
     *
     * @param glow True if the item should glow, false otherwise.
     * @return The ItemBuilder instance for method chaining.
     */
    public ItemBuilder withGlow(boolean glow) {
        this.glow = glow;
        return this;
    }

    /**
     * Builds the ItemStack based on the configured properties.
     *
     * @return The constructed ItemStack.
     */
    public ItemStack build() {
        if (material == null) {
            throw new IllegalArgumentException("Material cannot be null.");
        }

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.displayName(title);

        if (lore != null && !lore.isEmpty()) {
            itemMeta.lore(lore);
        }

        if (owner != null && material == Material.PLAYER_HEAD) {
            ((SkullMeta) itemMeta).setOwningPlayer(owner);
        }

        if (glow) {
            itemMeta.addEnchant(Enchantment.LURE, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
