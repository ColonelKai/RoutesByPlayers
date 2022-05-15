package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.config.ConfigManager;
import colonelkai.routesbyplayers.gui.InventoryManager;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
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
        return Arrays
                .stream(this.getClass().getDeclaredFields())
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> Manager.class.isAssignableFrom(field.getType()))
                .map(field -> {
                    try {
                        return (Manager<?, ?>) field.get(this);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        //noinspection ReturnOfNull
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static @NotNull Managers getInstance() {
        return INSTANCE;
    }


}
