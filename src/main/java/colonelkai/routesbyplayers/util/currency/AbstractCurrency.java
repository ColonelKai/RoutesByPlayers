package colonelkai.routesbyplayers.util.currency;

public abstract class AbstractCurrency implements Currency {

    private int amount;

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
