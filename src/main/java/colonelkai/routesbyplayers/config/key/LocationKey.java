package colonelkai.routesbyplayers.config.key;

import colonelkai.routesbyplayers.RoutesByPlayers;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LocationKey extends AbstractSerializationKey<Location> {
    protected LocationKey(@NotNull String node) {
        super(node);
    }

    @Override
    public void set(@NotNull FileConfiguration configuration, @Nullable Location value) {
        configuration.set((this.getNode()+".x"), value.getBlockX());
        configuration.set((this.getNode()+".y"), value.getBlockY());
        configuration.set((this.getNode()+".z"), value.getBlockZ());
        configuration.set((this.getNode()+".world"), value.getWorld().getName());
    }

    @Override
    public @NotNull Optional<Location> get(@NotNull FileConfiguration configuration) {
        int x = configuration.getInt(this.getNode() + ".x");
        int y = configuration.getInt(this.getNode() + ".y");
        int z = configuration.getInt(this.getNode() + ".z");
        String world = configuration.getString(this.getNode() + ".world");

        return Optional.of(new Location(RoutesByPlayers.getPlugin().getServer().getWorld(world) ,x, y, z));
    }
}
