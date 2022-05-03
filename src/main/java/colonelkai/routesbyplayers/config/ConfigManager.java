package colonelkai.routesbyplayers.config;

import colonelkai.routesbyplayers.RoutesByPlayers;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigManager {

    private static File file;
    private static FileConfiguration configFile;

    private static void recreate() {
        boolean exist = file.exists();
        if (!file.delete() && exist) {
            throw new IllegalStateException("Failed to create the config. Something went wrong");
        }
        InputStream stream = RoutesByPlayers.getPlugin().getResource("/config.yml");
        try {
            Files.copy(stream, file.toPath());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to create the config. Something went wrong");
        }
    }

    public static void readConfig() {
        file = new File(RoutesByPlayers.getPlugin().getDataFolder(), "config.yml");

        if (!file.exists()) {
            recreate();
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static boolean getUseMoney() {
        return configFile.getBoolean("Currency.Vault");
    }

    public static double getUpkeepAmount() {
        return configFile.getDouble("Upkeep.Amount");
    }

    public static Material getUpkeepItem() {
        String deez = configFile.getString("Currency.Item");
        return Material.getMaterial(deez);
    }

    public static boolean getIfPublicNodes() {
        return configFile.getBoolean("PublicNodes");
    }

    public static boolean getNodesOnDynmap() {
        return configFile.getBoolean("NodesOnDynmap");
    }

    public static int getMinimumDistance() {
        return configFile.getInt("MinimumDistance");
    }

    public static int getMaximumNodes() {
        return configFile.getInt("MaximumNodes");
    }
}
