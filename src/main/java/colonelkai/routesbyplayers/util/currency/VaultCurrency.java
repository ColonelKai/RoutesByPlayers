package colonelkai.routesbyplayers.util.currency;

import java.util.UUID;

public class VaultCurrency extends AbstractCurrency {
    public VaultCurrency(int amount) {
        super(amount);
    }

    // TODO after vault has been added

    @Override
    public boolean hasEnoughOnSelf(UUID uuid) {
        return false;
    }

    @Override
    public boolean hasEnoughOnUpkeep(UUID uuid) {
        return false;
    }


    @Override
    public boolean transactionInventory(UUID uuid) {
        return false;
    }

    @Override
    public boolean transactionUpkeep(UUID uuid) {
        return false;
    }

    @Override
    public boolean transactionIncome(UUID uuid) {
        return false;
    }
}
