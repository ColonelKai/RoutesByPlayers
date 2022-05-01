package colonelkai.routesbyplayers.util.balance;

public class UpkeepBalance extends UserBalance {
    public void deposit(int amount) {
        this.setAmount(this.getAmount()+amount);
    }

    public boolean withdraw(int amount) {
        if (amount > this.getAmount()) {
            return false;
        } else {
            this.setAmount(this.getAmount() - amount);
            return true;
        }
    }
}