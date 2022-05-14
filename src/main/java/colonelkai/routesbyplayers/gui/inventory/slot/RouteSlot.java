package colonelkai.routesbyplayers.gui.inventory.slot;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class RouteSlot extends Slot {
    public RouteSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex, new ItemStackBuilder().setName("Route").setAmount(1).setMaterial(Material.ACACIA_BOAT).build());
    }
}
