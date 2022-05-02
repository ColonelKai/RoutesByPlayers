package colonelkai.routesbyplayers.config.key;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IntegerKey extends AbstractSerializationKey<Integer> {

    IntegerKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<Integer> get(@NotNull YamlConfiguration configuration) {
        //check fixes the default boolean value of '0'
        if (configuration.contains(this.getNode(), true)) {
            return Optional.empty();
        }
        return Optional.of(configuration.getInt(this.getNode()));
    }
}
