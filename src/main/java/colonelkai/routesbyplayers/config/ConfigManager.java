package colonelkai.routesbyplayers.config;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.config.key.SerializationKeys;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigManager {

    private final File file = new File(RoutesByPlayers.getPlugin().getDataFolder(), "config.yml");
    private @Nullable FileConfiguration configFile;

    private void recreate() {
        InputStream stream = RoutesByPlayers.getPlugin().getResource("/config.yml");
        if (stream == null) {
            throw new RuntimeException("config.yml is not located inside jar");
        }
        boolean exist = this.file.exists();
        if (exist && !this.file.delete()) {
            throw new IllegalStateException("Failed to create the config. Something went wrong");
        }
        try {
            Files.copy(stream, this.file.toPath());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to create the config. Something went wrong");
        }
    }

    public void readConfig() {
        if (!this.file.exists()) {
            this.recreate();
        }
        this.configFile = YamlConfiguration.loadConfiguration(this.file);
    }

    public boolean getUseMoney() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.USE_VAULT.get(this.configFile).orElse(false);
    }

    public double getUpkeepAmount() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.UPKEEP_AMOUNT.get(this.configFile).orElse(1.0);
    }

    public Material getUpkeepItem() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.UPKEEP_ITEM.get(this.configFile).orElse(Material.DIAMOND_BLOCK);
    }

    public boolean getIfPublicNodes() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.NODES_PUBLIC.get(this.configFile).orElse(true);
    }

    public boolean getNodesOnDynmap() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.NODES_DYNMAP.get(this.configFile).orElse(false);
    }

    public int getMinimumDistance() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.ROUTE_DISTANCE_MIN.get(this.configFile).orElse(5);
    }

    public int getMaximumNodes() {
        if (this.configFile == null) {
            this.readConfig();
        }
        if (this.configFile == null) {
            throw new RuntimeException("Cannot recreate config file");
        }
        return SerializationKeys.NODES_MAXIMUM.get(this.configFile).orElse(10);
    }
}
