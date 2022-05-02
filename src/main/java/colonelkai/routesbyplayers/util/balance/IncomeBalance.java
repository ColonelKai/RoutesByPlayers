package colonelkai.routesbyplayers.util.balance;

import colonelkai.routesbyplayers.RoutesByPlayers;

import java.io.File;

public class IncomeBalance extends UserBalance {

    public void deposit(int amount) {
        this.setAmount(this.getAmount() + amount);
    }

    @Override
    public File getFile() {
        return new File(RoutesByPlayers.getPlugin().getDataFolder(),
                "data/balance/incoming/" + this.owner.toString() + ".yml");
    }
}
