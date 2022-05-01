package colonelkai.routesbyplayers.singletons.datanode.simplenodes;

import colonelkai.routesbyplayers.singletons.datanode.DataNode;
import org.bukkit.configuration.file.YamlConfiguration;

public class IntDataNode implements DataNode<Integer> {
    @Override
    public void save(YamlConfiguration yaml, Integer data, String path) {
        yaml.set(path, data);
    }

    @Override
    public Integer load(YamlConfiguration yaml, String path) {
        return yaml.getInt(path);
    }
}
