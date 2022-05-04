package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class BooleanKey extends AbstractSerializationKey<Boolean> {

    BooleanKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<Boolean> get(@NotNull FileConfiguration configuration) {
        //check fixes the default boolean value of 'false'
        if (configuration.contains(this.getNode(), true)) {
            return Optional.empty();
        }
        return Optional.of(configuration.getBoolean(this.getNode()));
    }
}
