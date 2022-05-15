package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.gui.inventory.templates.MainMenuTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RoutesByPlayersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Can only be executed as a player.");
            return false;
        }

        Player player = (Player) sender;
        player.openInventory(new MainMenuTemplate().create(player));

        return true;
    }
}
