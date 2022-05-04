package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DoubleKey extends AbstractSerializationKey<Double> {

    DoubleKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<Double> get(@NotNull FileConfiguration configuration) {
        if (!configuration.contains(this.getNode())) {
            return Optional.empty();
        }
        return Optional.of(configuration.getDouble(this.getNode()));
    }
}
