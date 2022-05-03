package colonelkai.routesbyplayers.gui.inventory.slot.event;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface SlotClickEvent<S extends Slot> extends SlotEvent<InventoryClickEvent, S> {

    @Override
    default Class<InventoryClickEvent> getTargetClass() {
        return InventoryClickEvent.class;
    }
}
