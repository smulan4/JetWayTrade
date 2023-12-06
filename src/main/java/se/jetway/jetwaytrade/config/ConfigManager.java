package se.jetway.jetwaytrade.config;

import org.bukkit.configuration.file.FileConfiguration;
import se.jetway.jetwaytrade.JetWayTrade;
import se.jetway.jetwaytrade.util.TextUtil;

/**
 * ConfigManager is a class that manages the configuration for the JetWayTrade plugin.
 * It provides a simple interface for retrieving configuration values and handling placeholders in text.
 */
public class ConfigManager {

    /**
     * The internal representation of the configuration.
     */
    private final FileConfiguration config;

    /**
     * Creates a new instance of ConfigManager.
     *
     * @param plugin An instance of the JetWayTrade plugin to retrieve the configuration file.
     */
    public ConfigManager(JetWayTrade plugin) {
        this.config = plugin.getConfig();
    }

    /**
     * Gets the FileConfiguration object representing the plugin configuration.
     *
     * @return The FileConfiguration object.
     */
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * Retrieves a string value from the configuration based on the specified ConfigKey.
     * If the key is not found, it returns the default value associated with the key.
     *
     * @param key The ConfigKey representing the configuration entry.
     * @return The retrieved or default string value.
     */
    public String getString(ConfigKey key) {
        String configKey = key.name().toLowerCase().replace('_', '-');
        return config.getString(configKey, getDefaultStringValues(key));
    }

    /**
     * Retrieves a string value from the configuration based on the specified ConfigKey
     * and replaces a placeholder with the given replacement.
     *
     * @param configKey   The ConfigKey representing the configuration entry.
     * @param placeholder The placeholder to replace in the retrieved string.
     * @param replacement The string to replace the placeholder with.
     * @return The string value with the placeholder replaced.
     */
    public String getStringWithPlaceholder(ConfigKey configKey, TextUtil.Placeholder placeholder, String replacement) {
        return TextUtil.replaceExistingPlaceholder(getString(configKey), placeholder, replacement);
    }

    /**
     * Gets the default string value associated with the specified ConfigKey.
     *
     * @param configKey The ConfigKey representing the configuration entry.
     * @return The default string value.
     */
    private String getDefaultStringValues(ConfigKey configKey) {
        return configKey.getValue();
    }
}
