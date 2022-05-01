package colonelkai.routesbyplayers.util.currency;

import java.util.UUID;

public interface Currency {
    public boolean hasEnough(UUID uuid);

    public boolean transaction(UUID uuid);
}
