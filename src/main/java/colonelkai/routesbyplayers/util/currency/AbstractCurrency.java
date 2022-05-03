package colonelkai.routesbyplayers.util.currency;

abstract public class AbstractCurrency implements Currency {
    int amount;

    public AbstractCurrency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
