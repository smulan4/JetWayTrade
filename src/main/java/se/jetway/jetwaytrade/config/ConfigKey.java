package se.jetway.jetwaytrade.config;

/**
 * ConfigKey is an enumeration that represents keys for accessing specific configuration values.
 * Each enum constant is associated with a default string value.
 */
public enum ConfigKey {

    /**
     * Messages
     */
    SENDER_TRADE_REQUEST_MESSAGE("You just sent a trade request to: <receiver>"),
    RECEIVER_TRADE_REQUEST_MESSAGE("You just received a trade request from: <sender>"),
    SENDER_TRADE_ACCEPT_MESSAGE("<receiver> accepted your trade request"),
    RECEIVER_TRADE_ACCEPT_MESSAGE("You just accepted the trade request from: <sender>"),
    SENDER_TRADE_DECLINE_MESSAGE("<receiver> just declined your trade request."),
    RECEIVER_TRADE_DECLINE_MESSAGE("You just declined the trade offer from: <sender>");

    /**
     * The default string value associated with the ConfigKey.
     */
    private final String value;

    /**
     * Constructs a ConfigKey with the specified default string value.
     *
     * @param value The default string value associated with the ConfigKey.
     */
    private ConfigKey(String value) {
        this.value = value;
    }

    /**
     * Gets the default string value associated with the ConfigKey.
     *
     * @return The default string value.
     */
    public String getValue() {
        return value;
    }
}
