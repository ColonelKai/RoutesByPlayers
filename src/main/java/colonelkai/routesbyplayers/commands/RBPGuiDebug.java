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
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class RBPGuiDebug implements CommandExecutor, TabExecutor {

    private static final BiConsumer<CommandSender, String[]> ROUTE_LIST = (sender, arg) -> {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Can't open via non-player sender.");
            return;
        }
        Player player = ((Player) sender);
        player.openInventory(InventoryTemplates.ROUTE.create(player));
        player.sendMessage("Opening RouteList...");
    };

    private static final BiConsumer<CommandSender, String[]> NODE_LIST = (sender, arg) -> {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Can't open via non-player sender.");
            return;
        }
        Player player = ((Player) sender);
        player.openInventory(InventoryTemplates.NODE.create(player));
        player.sendMessage("Opening NodeList...");
    };

    private static final BiConsumer<CommandSender, String[]> CREATE = (sender, arg) -> {
        sender.sendMessage("Creating....");
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

        Managers.getInstance().getNodeManager().add(nodeA);
        Managers.getInstance().getNodeManager().add(nodeB);

        Route route = new Route();
        route.setIdentifier(new RouteIdentifier(nodeA, nodeB));
        route.setNode2Price(3);
        route.setNode1Price(5);

        Managers.getInstance().getRouteManager().add(route);
    };

    private static final BiConsumer<CommandSender, String[]> SAVE_ALL = (sender, arg) -> {
        RoutesByPlayers.saveAllData();
    };


    public static final Map<String, BiConsumer<CommandSender, String[]>> ARGUMENTS = new HashMap<>();

    static {
        ARGUMENTS.put("route_list", ROUTE_LIST);
        ARGUMENTS.put("create_test_routen_nodes", CREATE);
        ARGUMENTS.put("save_all", SAVE_ALL);
        ARGUMENTS.put("node_list", NODE_LIST);
    }

    // horrible, horrible code but it will all be deleted after I'm done setting up GUIs so, just don't care.

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Argument required " + ARGUMENTS.keySet());
            return false;
        }
        String name = args[0].toLowerCase();
        BiConsumer<CommandSender, String[]> consumer = ARGUMENTS.get(name);
        if (consumer == null) {
            sender.sendMessage("Unknown argument");
            return false;
        }
        consumer.accept(sender, args);
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String peek = "";
        if (strings.length > 0) {
            peek = strings[0];
        }

        final String finalPeek = peek.toLowerCase();
        return ARGUMENTS.keySet().stream().filter(a -> a.startsWith(finalPeek.toLowerCase())).sorted().collect(Collectors.toList());
    }
}
