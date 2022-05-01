package colonelkai.routesbyplayers.util.balance;

public class IncomeBalance extends UserBalance {

    public void deposit(int amount) {
        this.setAmount(this.getAmount()+amount);
    }

}
