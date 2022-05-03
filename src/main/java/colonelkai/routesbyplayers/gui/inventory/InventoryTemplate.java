package colonelkai.routesbyplayers.gui.inventory;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface InventoryTemplate {

    @NotNull Inventory create(@NotNull Player player);

    int getInventorySize();

    Set<Slot> getSlots();

    default Slot getSlot(int index) {
        return this.getSlots().stream().filter(slot -> slot.getIndex() == index).findFirst().orElseThrow(() -> new IndexOutOfBoundsException("larger then slot provided"));
    }
}
