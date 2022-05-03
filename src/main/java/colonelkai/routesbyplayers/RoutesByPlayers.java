package colonelkai.routesbyplayers;

import colonelkai.routesbyplayers.config.ConfigManager;
import colonelkai.routesbyplayers.manager.*;
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
        this.getLogger().info("Loading Data...");
        RoutesByPlayers.loadAllData();
    }

    @Override
    public void onDisable() {
        RoutesByPlayers.saveAllData();
    }

    private static void loadAllData() {
        Managers.NODE_MANAGER.addAll(Managers.NODE_MANAGER.loadAll(Managers.NODE_MANAGER.getParentFolder()));
        Managers.ROUTE_MANAGER.addAll(Managers.ROUTE_MANAGER.loadAll(Managers.ROUTE_MANAGER.getParentFolder()));
        Managers.UPKEEP_BALANCE_MANAGER.addAll(Managers.UPKEEP_BALANCE_MANAGER.loadAll(Managers.UPKEEP_BALANCE_MANAGER.getParentFolder()));
        Managers.INCOME_BALANCE_MANAGER.addAll(Managers.INCOME_BALANCE_MANAGER.loadAll(Managers.INCOME_BALANCE_MANAGER.getParentFolder()));
    }

    private static void saveAllData() {
        Managers.NODE_MANAGER.saveAll();
        Managers.ROUTE_MANAGER.saveAll();
        Managers.UPKEEP_BALANCE_MANAGER.saveAll();
        Managers.INCOME_BALANCE_MANAGER.saveAll();

    }
}
