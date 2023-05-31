package colonelkai.routesbyplayers.gui.inventory.slot.createmenu;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class RequestRouteSlot extends Slot {
    public RequestRouteSlot(@NotNull InventoryTemplate template, int slotIndex) {
        super(template, slotIndex, new ItemStackBuilder()
                        .setName(ChatColor.WHITE + "Request Route")
                        .setMaterial(Material.BELL)
                        .setAmount(1)
                        .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.CANCEL_CLICK);
    }
}
