package colonelkai.routesbyplayers.config.key;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class LocationKey extends AbstractSerializationKey<Location> {
    protected LocationKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<Location> get(@NotNull YamlConfiguration configuration) {
        return Optional.ofNullable(configuration.getLocation(this.getNode()));
    }
}
