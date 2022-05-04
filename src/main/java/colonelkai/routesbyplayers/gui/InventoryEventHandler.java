package colonelkai.routesbyplayers.gui;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import colonelkai.routesbyplayers.manager.Managers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;

import java.util.Collection;
import java.util.Collections;

public class InventoryEventHandler implements Listener {

    @EventHandler
    public void onClickSlotEvent(InventoryClickEvent event) {
        try {
            this.runEventOn(event, Collections.singleton(event.getSlot()));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ignored) {
            //not one of your inventories
        }
    }

    @EventHandler
    public void onDragSlotEvent(InventoryDragEvent event) {
        try {
            this.runEventOn(event, event.getInventorySlots());
        } catch (IllegalArgumentException | IndexOutOfBoundsException ignored) {
            //not one of your inventories
        }
    }

    private <E extends InventoryEvent> void runEventOn(E event, Iterable<Integer> slotIndexs) {
        Class<E> clazz = (Class<E>) event.getClass();
        InventoryTemplate template = Managers.getInstance().getInventoryManager().getTemplate(event.getView()).orElseThrow(() -> new IllegalArgumentException("invalid inventory"));
        slotIndexs.forEach(index -> {
            Slot slot = template.getSlot(index);
            Collection<? extends SlotEvent<E>> events = slot.getEvents(clazz);
            events.forEach(slotEvent -> slotEvent.run(event, slot));
        });
    }
}
