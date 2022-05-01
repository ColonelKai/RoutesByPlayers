package colonelkai.routesbyplayers.singletons.datanode;

import org.bukkit.configuration.file.YamlConfiguration;

public interface DataNode<T> {


    public void save(YamlConfiguration yaml, T data, String path);

    public T load(YamlConfiguration yaml, String path);
}
