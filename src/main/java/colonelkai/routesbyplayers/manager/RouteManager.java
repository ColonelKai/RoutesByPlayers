package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.config.key.SerializationKeys;
import colonelkai.routesbyplayers.util.Route;
import colonelkai.routesbyplayers.util.identity.customidentifier.RouteIdentifier;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class RouteManager extends AbstractManager<RouteIdentifier, Route> {
    @Override
    public Route load(File file) {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        RouteIdentifier routeIdentifier =
                SerializationKeys
                        .ROUTE_IDENTIFIER
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Route-Identifier key is missing"));
        Route route = new Route();
        route.setIdentifier(routeIdentifier);
        return route;
    }

    @Override
    public void save(Route value) throws IOException {
        File file = value.getFile(this.getParentFolder());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                throw new IOException(new IllegalAccessException("Cannot write file"));
            }
        }
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        SerializationKeys.ROUTE_IDENTIFIER.set(configuration, value.getIdentifier());
        configuration.save(file);
    }

    @Override
    public File getParentFolder() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder() + File.separator + "data/route");
    }
}
