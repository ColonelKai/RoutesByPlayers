package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Route;
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
        Player player = ((Player) sender);
        if (args.length == 0) {
            player.sendMessage("Argument required (RouteList)");
            return false;
        }
        String name = args[0];
        if (name.equals("RouteList")) {
            if (Managers.getInstance().getRouteManager().getElements().isEmpty()) {
                Route route = new Route();
                Managers.getInstance().getRouteManager().add(route);
            }


            player.openInventory(InventoryTemplates.ROUTE.create(player));
            player.sendMessage("Opening RouteList...");
            return true;

        }
        player.sendMessage("reached fi.");
        return false;
    }
}
