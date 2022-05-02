package colonelkai.routesbyplayers.util.balance;

import colonelkai.routesbyplayers.util.identity.Identifiable;

import java.util.UUID;

public abstract class UserBalance implements Identifiable.Serializable<UUID> {
    protected UUID owner;
    protected int amount;

    // region getset


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            amount = 0; //THIS SHOULD THROW A ILLEGAL ARGUMENT EXCEPTION
        }
        this.amount = amount;
    }

    @Override
    public UUID getIdentifier() {
        return this.owner;
    }

    @Override
    public void setIdentifier(UUID element) {
        this.owner = element;
    }

    // endregion
}
