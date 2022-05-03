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
