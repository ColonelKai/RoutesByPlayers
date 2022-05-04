package colonelkai.routesbyplayers.gui.inventory.slot.event;

import org.bukkit.event.inventory.InventoryDragEvent;

public interface SlotDragEvent extends SlotEvent<InventoryDragEvent> {

    @Override
    default Class<InventoryDragEvent> getTargetClass() {
        return InventoryDragEvent.class;
    }
}
