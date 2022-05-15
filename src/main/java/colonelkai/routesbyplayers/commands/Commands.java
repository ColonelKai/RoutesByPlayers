package colonelkai.routesbyplayers.commands;

import colonelkai.routesbyplayers.RoutesByPlayers;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;

public class Commands {
    public static void register() {
        register("rbp_gui_debug", new RBPGuiDebug());
        register("RoutesByPlayers", new RoutesByPlayersCommand());
    }

    private static void register(String command, CommandExecutor executor) {
        RoutesByPlayers routesByPlayers = RoutesByPlayers.getPlugin();
        PluginCommand bCommand = routesByPlayers.getCommand(command);
        if (bCommand == null) {
            throw new RuntimeException("Command of '" + command + "' could not be found in plugin.yml");
        }
        bCommand.setExecutor(executor);
        if (executor instanceof TabCompleter) {
            bCommand.setTabCompleter((TabCompleter) executor);
        }
    }
}
