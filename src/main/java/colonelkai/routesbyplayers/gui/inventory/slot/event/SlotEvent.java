package colonelkai.routesbyplayers.gui.inventory.slot.event;

import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

public interface SlotEvent<E extends Event> {

    void run(@NotNull E event, @NotNull Slot slot);

    Class<E> getTargetClass();
}
