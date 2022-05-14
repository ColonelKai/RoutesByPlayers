package colonelkai.routesbyplayers.util.balance;

import java.io.File;

public class IncomeBalance extends UserBalance {

    public void deposit(int amount) {
        this.setAmount(this.getAmount() + amount);
    }

    @Override
    public File getFile(File file) {
        return new File(file, this.owner.toString() + ".yml");
    }
}
