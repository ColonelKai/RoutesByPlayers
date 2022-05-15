package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.config.ConfigManager;
import colonelkai.routesbyplayers.gui.InventoryManager;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Managers {
    private final IncomeBalanceManager incomeBalance = new IncomeBalanceManager();
    private final UpkeepBalanceManager upkeepBalance = new UpkeepBalanceManager();
    private final NodeManager node = new NodeManager();
    private final RouteManager route = new RouteManager();


    private final InventoryManager inventory = new InventoryManager();
    private final ConfigManager config = new ConfigManager();

    private static final Managers INSTANCE = new Managers();

    private Managers() {

    }

    public @NotNull ConfigManager getConfigManager() {
        return this.config;
    }

    public @NotNull InventoryManager getInventoryManager() {
        return this.inventory;
    }

    public @NotNull IncomeBalanceManager getIncomeBalanceManager() {
        return this.incomeBalance;
    }

    public @NotNull UpkeepBalanceManager getUpkeepBalanceManager() {
        return this.upkeepBalance;
    }

    public @NotNull NodeManager getNodeManager() {
        return this.node;
    }

    public @NotNull RouteManager getRouteManager() {
        return this.route;
    }

    public Collection<Manager<?, ?>> getSerializableManagers() {
        List<Manager<?, ?>> list = new ArrayList<>();
        list.add(this.incomeBalance);
        list.add(this.upkeepBalance);
        list.add(this.node);
        list.add(this.route);
        return list;
    }

    public static @NotNull Managers getInstance() {
        return INSTANCE;
    }


}
