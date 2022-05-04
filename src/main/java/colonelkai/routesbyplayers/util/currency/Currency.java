package colonelkai.routesbyplayers.util.currency;

import java.util.UUID;

public interface Currency {
    boolean hasEnoughOnSelf(UUID uuid);

    boolean hasEnoughOnUpkeep(UUID uuid);

    boolean transactionInventory(UUID uuid);

    boolean transactionUpkeep(UUID uuid);

    boolean transactionIncome(UUID uuid);
}
