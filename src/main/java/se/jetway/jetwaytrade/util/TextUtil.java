package se.jetway.jetwaytrade.util;

import com.google.common.util.concurrent.AtomicDouble;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

/**
 * Utility class for handling text-related operations.
 */
public final class TextUtil {

    /**
     * Private constructor to prevent instantiation
     */
    private TextUtil() {}

    // TODO Hex
    public static Component colorComponent(Component component) {
        String test = PlainTextComponentSerializer.plainText().serialize(component);
        return MiniMessage.miniMessage().deserialize(test).asComponent();
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
