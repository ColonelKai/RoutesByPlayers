package colonelkai.routesbyplayers.manager;

import colonelkai.routesbyplayers.RoutesByPlayers;
import colonelkai.routesbyplayers.config.key.SerializationKeys;
import colonelkai.routesbyplayers.util.balance.IncomeBalance;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class IncomeBalanceManager extends AbstractManager<UUID, IncomeBalance> {

    @Override
    public IncomeBalance load(File file) {
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
        IncomeBalance balance = new IncomeBalance();
        balance.setIdentifier(uuid);
        balance.setAmount(amount);
        return balance;
    }

    @Override
    public void save(IncomeBalance value) throws IOException {
        File file = this.getDefaultLocation();
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

    @Override
    public File getDefaultLocation() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder(),
                "data" + File.separator + "incomebalance");
    }
}
