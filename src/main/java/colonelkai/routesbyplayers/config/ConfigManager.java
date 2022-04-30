package colonelkai.routesbyplayers.config;

import colonelkai.routesbyplayers.RoutesByPlayers;
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

    public static String getUseMoney() {
        return configFile.getString("Upkeep.Money.Use");
    }

    public static Long getAmountMoney() {
        return configFile.getLong("Upkeep.Money.Amount");
    }

    public static ItemStack getUpkeepItem() {
        return configFile.getItemStack("Upkeep.Item.Item");
    }

    public static Long getItemUpkeepDistance() {
        return configFile.getLong("Upkeep.Item.Distance");
    }

    public static boolean getIfPublicStopPoints() {
        return configFile.getBoolean("PublicStopPoints");
    }

    public static boolean getStopPointsOnDynmap() {
        return configFile.getBoolean("StopPointsOnDynmap");
    }

    public static int getMinimumDistance() {
        return configFile.getInt("MinimumDistance");
    }

    public static int getMaximumStopPoints() {
        return configFile.getInt("MaximumStopPoints");
    }
}
