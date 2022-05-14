package colonelkai.routesbyplayers.util.balance;

import java.io.File;

public class UpkeepBalance extends UserBalance {
    public void deposit(int amount) {
        this.setAmount(this.getAmount() + amount);
    }

    public boolean withdraw(int amount) {
        if (amount > this.getAmount()) {
            return false;
        } else {
            this.setAmount(this.getAmount() - amount);
            return true;
        }
    }

    @Override
    public File getFile(File file) {
        return new File(file, this.owner.toString() + ".yml");
    }
}