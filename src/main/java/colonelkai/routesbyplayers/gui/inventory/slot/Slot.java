package colonelkai.routesbyplayers.gui.inventory.slot;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Slot implements Comparable<Slot> {

    private final int slotIndex;
    private final @NotNull ItemStack stack;
    private final Collection<SlotEvent<?>> events = new HashSet<>();
    private final @NotNull InventoryTemplate template;

    protected Slot(@NotNull InventoryTemplate template, int slotIndex, @NotNull ItemStack stack, SlotEvent<?>... events) {
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

    public <E extends InventoryEvent> Collection<? extends SlotEvent<E>> getEvents(Class<E> clazz) {
        return this.events.stream().filter(slot -> slot.getTargetClass().isAssignableFrom(clazz)).map(slot -> (SlotEvent<E>) slot).collect(Collectors.toSet());
    }

    @Override
    public int compareTo(@NotNull Slot o) {
        return this.getIndex() - o.getIndex();
    }
}
