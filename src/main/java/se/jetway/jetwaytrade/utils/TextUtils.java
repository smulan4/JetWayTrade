package se.jetway.jetwaytrade.utils;

import org.bukkit.ChatColor;

public class TextUtils {

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
