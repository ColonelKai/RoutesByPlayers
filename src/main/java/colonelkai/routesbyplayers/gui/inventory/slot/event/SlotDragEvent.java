package colonelkai.routesbyplayers.gui.inventory.slot.event;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.event.inventory.InventoryDragEvent;

public interface SlotDragEvent<S extends Slot> extends SlotEvent<InventoryDragEvent, S> {

    @Override
    default Class<InventoryDragEvent> getTargetClass() {
        return InventoryDragEvent.class;
    }
}
