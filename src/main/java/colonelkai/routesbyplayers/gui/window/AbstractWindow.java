package colonelkai.routesbyplayers.gui.window;

import colonelkai.routesbyplayers.gui.slot.Slot;
import org.bukkit.inventory.Inventory;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

abstract public class AbstractWindow implements Window {
    UUID player;
    List<Slot> slots;
    Inventory inventory;

    public AbstractWindow(UUID player) {
        this.player = player;
    }
}
