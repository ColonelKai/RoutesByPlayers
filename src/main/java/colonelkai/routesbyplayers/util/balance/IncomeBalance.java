package colonelkai.routesbyplayers.util.balance;

import java.util.UUID;

public class IncomeBalance extends UserBalance {

    public void deposit(int amount) {
        this.setAmount(this.getAmount()+amount);
    }

}
