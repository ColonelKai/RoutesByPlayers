package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class StringKey extends AbstractSerializationKey<String> {
    protected StringKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<String> get(@NotNull YamlConfiguration configuration) {
        return Optional.ofNullable(configuration.getString(this.getNode()));
    }
}
