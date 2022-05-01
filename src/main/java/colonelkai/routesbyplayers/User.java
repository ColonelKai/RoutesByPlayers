package colonelkai.routesbyplayers;

import java.util.UUID;

public class User {
    private int incomeAmount;
    private int upkeepAmount;

    private UUID uuid;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    // region getset
    public int getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(int incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public int getUpkeepAmount() {
        return upkeepAmount;
    }

    public void setUpkeepAmount(int upkeepAmount) {
        this.upkeepAmount = upkeepAmount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    // endregion
}
