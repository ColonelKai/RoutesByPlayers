package colonelkai.routesbyplayers.util.currency;

import java.util.UUID;

public interface Currency {
    public boolean hasEnoughOnSelf(UUID uuid);

    public boolean hasEnoughOnUpkeep(UUID uuid);

    public boolean transactionInventory(UUID uuid);

    public boolean transactionUpkeep(UUID uuid);

    public boolean transactionIncome(UUID uuid);
}
