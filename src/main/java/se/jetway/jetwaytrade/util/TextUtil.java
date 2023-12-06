package se.jetway.jetwaytrade.util;

import org.bukkit.ChatColor;

/**
 * Utility class for handling text-related operations.
 */
public final class TextUtil {

    /**
     * Private constructor to prevent instantiation
     */
    private TextUtil() {}

    /**
     * Translates color codes in a text string using ChatColor.
     *
     * @param text The input text containing color codes.
     * @return The text with color codes translated.
     */
    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Replace a new placeholder within a String.
     *
     * @param input The String containing the Placeholder.
     * @param placeholder The Placeholder that will be replaced.
     * @param replacement The replacement of the Placeholder.
     * @return The String with the placeholder replaced with the replacement.
     */
    public static String replacePlaceholder(String input, String placeholder, String replacement) {
        if (placeholder != null && replacement != null) {
            return input.replaceAll(placeholder, replacement);
        }
        return input;
    }

    /**
     * Replace an already existing Placeholder within a String.
     *
     * @param input The String containing the Placeholder.
     * @param placeholder The Placeholder Enum.
     * @param replacement The replacement of the Placeholder.
     * @return The string with the placeholder replaced with the replacement.
     */
    public static String replaceExistingPlaceholder(String input, Placeholder placeholder, String replacement) {
        switch (placeholder) {
            case SENDER:
                return replacePlaceholder(input, Placeholder.SENDER.getValue(), replacement);
            case RECEIVER:
                return replacePlaceholder(input, Placeholder.RECEIVER.getValue(), replacement);
            default: return input;
        }
    }

    /**
     * Placeholder Enum that handles existing Placeholders and their values.
     */
    public enum Placeholder {
        SENDER("<sender>"),
        RECEIVER("<receiver>");

        private final String value;

        private Placeholder(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
