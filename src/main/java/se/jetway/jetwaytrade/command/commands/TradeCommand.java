package se.jetway.jetwaytrade.command.commands;


import org.bukkit.command.CommandSender;
import se.jetway.jetwaytrade.command.CommandInfo;
import se.jetway.jetwaytrade.command.SubCommand;

@CommandInfo(
        commandName = "test",
        permission = "use",
        description = "Trade with another player."
)
public class TradeCommand implements SubCommand {

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        commandSender.sendMessage("Hejsan din lilla jäkel! Snart är du på toppen! Kämpa!!");
    }
}
