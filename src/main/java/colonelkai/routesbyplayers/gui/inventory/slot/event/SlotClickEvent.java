package colonelkai.routesbyplayers.gui.inventory.slot.event;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface SlotClickEvent extends SlotEvent<InventoryClickEvent> {

    @Override
    default Class<InventoryClickEvent> getTargetClass() {
        return InventoryClickEvent.class;
    }
}
