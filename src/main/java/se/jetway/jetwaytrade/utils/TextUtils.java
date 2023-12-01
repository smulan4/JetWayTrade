package se.jetway.jetwaytrade.utils;

import org.bukkit.ChatColor;

/**
 * Utility class for handling text-related operations.
 */
public class TextUtils {

    /**
     * Translates color codes in a text string using ChatColor.
     *
     * @param text The input text containing color codes.
     * @return The text with color codes translated.
     */
    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
