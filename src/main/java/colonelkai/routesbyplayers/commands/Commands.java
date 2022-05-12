package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.RoutesByPlayers;
import org.bukkit.plugin.Plugin;

public class Commands {
    public static void register() {
        RoutesByPlayers routesByPlayers = RoutesByPlayers.getPlugin();

        routesByPlayers.getCommand("RoutesByPlayers").setExecutor(new RoutesByPlayersCommand());
        routesByPlayers.getCommand("rbp_gui_debug").setExecutor(new RBPGuiDebug());
    }
}
