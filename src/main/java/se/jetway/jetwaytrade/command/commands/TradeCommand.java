package se.jetway.jetwaytrade.command.commands;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import se.jetway.jetwaytrade.command.CommandInfo;
import se.jetway.jetwaytrade.command.SubCommand;
import se.jetway.jetwaytrade.menu.MenuManager;
import se.jetway.jetwaytrade.menu.MenuTypes;

@CommandInfo(
        commandName = "test",
        permission = "use",
        description = "Trade with another player."
)
public class TradeCommand implements SubCommand {

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            MenuManager.openMenu(player, MenuTypes.Trade);
        }

    }
}
