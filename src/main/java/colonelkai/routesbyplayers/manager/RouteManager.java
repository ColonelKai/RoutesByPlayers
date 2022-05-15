package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.config.key.SerializationKeys;
import colonelkai.routesbyplayers.util.Route;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class RouteManager extends AbstractManager<RouteIdentifier, Route> {
    @Override
    public @NotNull Route load(@NotNull File file) {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        RouteIdentifier routeIdentifier =
                SerializationKeys
                        .ROUTE_IDENTIFIER
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Route-Identifier key is missing"));
        int nodeOnePrice =
                SerializationKeys
                        .NODE1PRICE
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Node 1 price key is missing"));
        int nodeTwoPrice =
                SerializationKeys
                        .NODE1PRICE
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Node 1 price key is missing"));
        Route route = new Route();
        route.setIdentifier(routeIdentifier);
        route.setNode1Price(nodeOnePrice);
        route.setNode2Price(nodeTwoPrice);
        return route;
    }

    @Override
    public boolean add(@NotNull Route element) {
        try {
            element.getFirstNode();
            element.getSecondNode();
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
        return super.add(element);
    }

    @Override
    public void save(@NotNull Route value) throws IOException {
        File file = value.getFile(this.getParentFolder());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                throw new IOException(new IllegalAccessException("Cannot write file"));
            }
        }
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        SerializationKeys.ROUTE_IDENTIFIER.set(configuration, value.getIdentifier());
        SerializationKeys.NODE1PRICE.set(configuration, value.getNode1Price());
        SerializationKeys.NODE2PRICE.set(configuration, value.getNode2Price());

        configuration.save(file);
    }

    @Override
    public File getParentFolder() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder() + File.separator + "data/route");
    }
}
