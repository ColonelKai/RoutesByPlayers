package colonelkai.routesbyplayers.singletons.datanode.simplenodes;

import colonelkai.routesbyplayers.singletons.datanode.DataNode;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Objects;
import java.util.UUID;

public class UUIDNode implements DataNode<UUID> {
    @Override
    public void save(YamlConfiguration yaml, UUID data, String path) {
        yaml.set(path, data.toString());
    }

    @Override
    public UUID load(YamlConfiguration yaml, String path) {
        return UUID.fromString(Objects.requireNonNull(yaml.getString(path)));
    }
}
