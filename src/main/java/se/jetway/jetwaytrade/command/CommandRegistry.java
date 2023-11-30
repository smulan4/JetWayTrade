package se.jetway.jetwaytrade.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {

    private final Map<String, SubCommand> subCommandMap;
    private final Map<String, CommandInfo> commandInfoMap;

    public CommandRegistry() {
        subCommandMap = new HashMap<>();
        commandInfoMap = new HashMap<>();
    }

    /**
     * Adds SubCommand to HashMap of SubCommands with value as the CommandName.
     *
     * @param subCommand SubCommand that gets added to the Map of SubCommands.
     */
    public void registerSubCommand(SubCommand subCommand) {
        CommandInfo commandInfo = subCommand.getClass().getAnnotation(CommandInfo.class);
        if (commandInfo != null) {
            String commandName = commandInfo.commandName().toLowerCase();
            subCommandMap.put(commandName, subCommand);
            commandInfoMap.put(commandName, commandInfo);
        } else {
            System.out.println("SubCommand " + subCommand.getClass().getSimpleName() + " is missing CommandInfo annotation.");
        }
    }

    /**
     * Returns SubCommand from its CommandName.
     *
     * @param commandName of the SubCommand.
     * @return the SubCommand.
     */
    public SubCommand getSubCommand(String commandName) {
        return subCommandMap.get(commandName);
    }

    /**
     * Returns list of the key elements from the SubCommand Map.
     *
     * @return ArrayList of keys.
     */
    public List<String> getSubCommandNames() {
        return new ArrayList<>(subCommandMap.keySet());
    }

    /**
     * Returns List of values from the CommandInfo list.
     *
     * @return ArrayList of values.
     */
    public List<CommandInfo> getCommandInfoList() {
        return new ArrayList<>(commandInfoMap.values());
    }

}
