package colonelkai.routesbyplayers.gui.inventory.slot;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Slot {

    private final int slotIndex;
    private final @NotNull ItemStack stack;
    private final Collection<SlotEvent<?, ? extends Slot>> events = new HashSet<>();
    private final @NotNull InventoryTemplate template;

    @SafeVarargs
    protected Slot(@NotNull InventoryTemplate template, int slotIndex, @NotNull ItemStack stack, SlotEvent<?, ? extends Slot>... events) {
        this.slotIndex = slotIndex;
        this.stack = stack;
        this.events.addAll(Arrays.asList(events));
        this.template = template;
    }

    public @NotNull InventoryTemplate getTemplate() {
        return this.template;
    }

    public int getIndex() {
        return this.slotIndex;
    }

    public @NotNull ItemStack getStack() {
        return this.stack.clone();
    }

    public <E extends Event> Collection<SlotEvent<E, ? extends Slot>> getEvents(Class<E> clazz) {
        return this.events.stream().filter(slot -> slot.getTargetClass().isAssignableFrom(clazz)).map(slot -> (SlotEvent<E, ? extends Slot>) slot).collect(Collectors.toSet());
    }
}
