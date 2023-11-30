package se.jetway.jetwaytrade.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import se.jetway.jetwaytrade.command.commands.TradeCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabExecutor {

    private final CommandRegistry commandRegistry;

    public CommandHandler() {
        commandRegistry = new CommandRegistry();
        commandRegistry.registerSubCommand(new TradeCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length == 0) {
            displayHelp(commandSender);
            return true;
        }

        String arg = args[0];
        SubCommand subCommand = commandRegistry.getSubCommand(arg);

        if (subCommand != null) {
            subCommand.execute(commandSender, args);
        } else {
            unknownSubCommand(commandSender);
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> subCommands = new ArrayList<>(commandRegistry.getSubCommandNames());
            subCommands.removeIf(subCommand -> !subCommand.toLowerCase().startsWith(args[0].toLowerCase()));
            return subCommands;
        }
        return null;
    }

    /**
     * Displays a message with available subcommands and their descriptions.
     *
     * @param commandSender Sender that will receive the message.
     */
    private void displayHelp(CommandSender commandSender) {
        for (CommandInfo commandInfo : commandRegistry.getCommandInfoList()) {
            String commandName = commandInfo.commandName();
            String description = commandInfo.description();
            commandSender.sendMessage("/" + commandName + " - " + description);
        }
    }

    /**
     * Sends a message to the CommandSender when the subcommand is not recognisable.
     *
     * @param commandSender Sender that will receive the message.
     */
    private void unknownSubCommand(CommandSender commandSender) {
        commandSender.sendMessage("Unknown Subcommand");
    }
}
