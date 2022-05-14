package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import colonelkai.routesbyplayers.gui.inventory.templates.RouteInventoryTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RBPGuiDebug implements CommandExecutor {

    // horrible, horrible code but it will all be deleted after I'm done setting up GUIs so, just don't care.

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Can't open via non-player sender.");
            return false;
        }
        Player player = ((Player) sender).getPlayer();
        String name = args[0];
        if (name.equals("RouteList")) {
            player.openInventory(new RouteInventoryTemplate().create(player, 1));
            player.sendMessage("Opening RouteList...");
            return true;

        }
        player.sendMessage("reached fi.");
        return false;
    }
}
