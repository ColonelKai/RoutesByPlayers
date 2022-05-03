package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.config.key.SerializationKeys;
import colonelkai.routesbyplayers.util.Node;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class NodeManager extends AbstractManager<String, Node> {
    @Override
    public Node load(File file) {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        UUID uuid =
                SerializationKeys
                        .OWNER
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Owner key is missing"));
        String name =
                SerializationKeys
                        .NAME
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Name key is missing"));
        Location location =
                SerializationKeys
                        .LOCATION
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Location key is missing"));
        return new Node(location, uuid, name);
    }

    @Override
    public void save(Node value) throws IOException {
        File file = value.getFile(this.getParentFolder());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                throw new IOException(new IllegalAccessException("Cannot write file"));
            }
        }
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        SerializationKeys.LOCATION.set(configuration, value.getLocation());
        SerializationKeys.OWNER.set(configuration, value.getOwner());
        SerializationKeys.NAME.set(configuration, value.getIdentifier());
        configuration.save(file);
    }

    @Override
    public File getParentFolder() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder() + File.separator + "data/node");
    }

}
