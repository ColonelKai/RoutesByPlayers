package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.config.key.SerializationKeys;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import colonelkai.routesbyplayers.util.balance.UpkeepBalance;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpkeepBalanceManager extends AbstractManager<UUID, UpkeepBalance> {
    @Override
    public UpkeepBalance load(File file) {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        UUID uuid =
                SerializationKeys
                        .OWNER
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Owner key is missing"));
        int amount =
                SerializationKeys
                        .AMOUNT
                        .get(configuration)
                        .orElseThrow(() -> new IllegalArgumentException("Amount key is missing"));
        UpkeepBalance upkeepBalance = new UpkeepBalance();
        upkeepBalance.setAmount(amount);
        upkeepBalance.setIdentifier(uuid);
        return upkeepBalance;
    }

    @Override
    public void save(UpkeepBalance value) throws IOException {
        File file = value.getFile().getParentFile();
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                throw new IOException(new IllegalAccessException("Cannot write file"));
            }
        }
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        SerializationKeys.AMOUNT.set(configuration, value.getAmount());
        SerializationKeys.OWNER.set(configuration, value.getIdentifier());
        configuration.save(file);
    }
}
