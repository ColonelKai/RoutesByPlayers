package colonelkai.routesbyplayers;

import colonelkai.routesbyplayers.commands.Commands;
import colonelkai.routesbyplayers.commands.RoutesByPlayersCommand;
import colonelkai.routesbyplayers.config.ConfigManager;
import colonelkai.routesbyplayers.gui.InventoryEventHandler;
import colonelkai.routesbyplayers.manager.Manager;
import colonelkai.routesbyplayers.manager.Managers;
import org.bukkit.Bukkit;
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
        Bukkit.getPluginManager().registerEvents(new InventoryEventHandler(), this);
        Managers.getInstance().getConfigManager().readConfig();
        this.getLogger().info("Loading Data...");
        RoutesByPlayers.loadAllData();
        this.getLogger().info("Registering Events...");
        Bukkit.getPluginManager().registerEvents(new InventoryEventHandler(), this);
        this.getLogger().info("Registering commands...");
        Commands.register();
    }

    @Override
    public void onDisable() {
        RoutesByPlayers.saveAllData();
    }

    private static void loadAllData() {
        Managers.getInstance().getSerializableManagers().forEach(Manager::reloadAll);
    }

    private static void saveAllData() {
        Managers.getInstance().getSerializableManagers().forEach(Manager::saveAll);
    }
}
