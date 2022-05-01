package colonelkai.routesbyplayers;

import colonelkai.routesbyplayers.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class RoutesByPlayers extends JavaPlugin {

    /*
    RoutesByPlayers, by ColonelKai, with advice from MoseMister

    FRONTEND TO-DO
    TODO: Start GUI
    TODO: Nodes Manager GUI
          TODO: Routes Manager
          TODO: Travel Cost Manager
    TODO: Travel GUI
    TODO: Global Data GUI
        TODO: List of Node
        TODO: List of Routes

    BACKEND TO-DO
    DONE: Implement config
    TODO: Implement Nodes
    TODO: Implement Player
    TODO: Implement Routes
        TODO: Implement Route Creation Invite
    TODO: Implement Upkeep
    TODO: Implement Travel
        TODO: Implement Travel Cost
    TODO: Implement Admin Stuff
        TODO: Implement Admin Removal of Path & Node

     Holy Dot -> .
     */

    static RoutesByPlayers plugin;

    public static @NotNull RoutesByPlayers getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        ConfigManager.readConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
