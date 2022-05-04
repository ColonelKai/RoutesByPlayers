package colonelkai.routesbyplayers.config.key;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class LocationKey extends AbstractSerializationKey<Location> {
    protected LocationKey(@NotNull String node) {
        super(node);
    }

    @Override
    public @NotNull Optional<Location> get(@NotNull FileConfiguration configuration) {
        return Optional.ofNullable(configuration.getLocation(this.getNode()));
    }
}
