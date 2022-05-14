package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.gui.inventory.templates.InventoryTemplates;
import colonelkai.routesbyplayers.manager.Managers;
import colonelkai.routesbyplayers.util.Node;
import colonelkai.routesbyplayers.util.Route;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;

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
            player.sendMessage("Argument required (RouteList, CreateTestRoutenNodes, saveAll)");
            return false;
        }
        String name = args[0];
        if (name.equals("RouteList")) {
            if (Managers.getInstance().getRouteManager().getElements().isEmpty()) {
                Route route = new Route();
                try {
                    Managers.getInstance().getRouteManager().add(route);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            player.openInventory(InventoryTemplates.ROUTE.create(player));
            player.sendMessage("Opening RouteList...");
            return true;
        }
        else if(name.equals("CreateTestRoutenNodes")) {
            player.sendMessage("Creating....");
            Node nodeA = new Node(
                    new Location(RoutesByPlayers.getPlugin().getServer().getWorld("world"), 1000, 0, 1000),
                    UUID.randomUUID(),
                    "TestNode2"
            );
            Node nodeB = new Node(
                    new Location(RoutesByPlayers.getPlugin().getServer().getWorld("world"), 0, 0, 0),
                    UUID.randomUUID(),
                    "TestNode1"
            );

            try {
                Managers.getInstance().getNodeManager().add(nodeA);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Managers.getInstance().getNodeManager().add(nodeB);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Route route = new Route();
            route.setIdentifier(new RouteIdentifier(nodeA, nodeB));
            route.setNode2Price(3);
            route.setNode1Price(5);

            try {
                Managers.getInstance().getRouteManager().add(route);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        } else if(name.equals("saveAll")) {
            RoutesByPlayers.saveAllData();
        }
        player.sendMessage("reached fi.");
        return false;
    }
}
