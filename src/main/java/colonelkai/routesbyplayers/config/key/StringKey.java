package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class StringKey extends AbstractSerializationKey<String> {
    protected StringKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<String> get(@NotNull FileConfiguration configuration) {
        return Optional.ofNullable(configuration.getString(this.getNode()));
    }
}
