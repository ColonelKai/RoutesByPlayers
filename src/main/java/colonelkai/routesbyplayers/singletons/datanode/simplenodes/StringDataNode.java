package colonelkai.routesbyplayers.singletons.datanode.simplenodes;

import colonelkai.routesbyplayers.singletons.datanode.DataNode;
import org.bukkit.configuration.file.YamlConfiguration;

public class StringDataNode implements DataNode<String> {
    @Override
    public void save(YamlConfiguration yaml, String data, String path) {
        yaml.set(path, data);
    }

    @Override
    public String load(YamlConfiguration yaml, String path) {
        return yaml.getString(path);
    }
}
