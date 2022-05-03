package colonelkai.routesbyplayers.gui.inventory;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface PagedInventoryTemplate extends InventoryTemplate {

    @NotNull Inventory create(@NotNull Player player, int page);

    Set<Slot> getSlots(int page);


    int getMaxPages();

    default Set<Slot> getSlots() {
        return this.getSlots(0);
    }


    @Override
    default @NotNull Inventory create(@NotNull Player player) {
        return this.create(player, 0);
    }
}
