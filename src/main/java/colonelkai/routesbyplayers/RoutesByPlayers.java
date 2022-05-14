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

import java.util.Collection;

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
        Managers.getInstance().getConfigManager().readConfig();
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

    public static void loadAllData() {
        RoutesByPlayers.getPlugin().getLogger().info("Loading Data...");
        Managers.getInstance().getSerializableManagers().forEach(Manager::reloadAll);
    }

    public static void saveAllData() {
        RoutesByPlayers.getPlugin().getLogger().info("Saving Data...");
        Collection<Manager<?, ?>> managers = Managers.getInstance().getSerializableManagers();
        managers.forEach(Manager::saveAll);
    }
}
