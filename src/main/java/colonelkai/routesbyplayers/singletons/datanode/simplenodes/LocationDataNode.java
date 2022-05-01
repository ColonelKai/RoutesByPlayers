package colonelkai.routesbyplayers.singletons.datanode.simplenodes;

import colonelkai.routesbyplayers.singletons.datanode.DataNode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationDataNode implements DataNode<Location> {
    @Override
    public void save(YamlConfiguration yaml, Location data, String path) {
        yaml.set(path, data);
    }

    @Override
    public Location load(YamlConfiguration yaml, String path) {
        return yaml.getLocation(path);
    }
}
