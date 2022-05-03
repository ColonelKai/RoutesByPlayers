package colonelkai.routesbyplayers.gui.inventory.slot;

import colonelkai.routesbyplayers.gui.inventory.ItemStackBuilder;
import colonelkai.routesbyplayers.gui.inventory.PagedInventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.event.SlotEvents;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class NextPageSlot extends Slot {


    public NextPageSlot(@SuppressWarnings("TypeMayBeWeakened") @NotNull PagedInventoryTemplate template) {
        super(template, 9, new ItemStackBuilder()
                        .setMaterial(Material.PLAYER_HEAD)
                        .setAmount(1)
                        .setName("Next")
                        .addLore("To page: 0")
                        .build(),
                SlotEvents.CANCEL_DRAG,
                SlotEvents.TO_PAGE_CLICK_EVENT);
    }

    @Override
    public @NotNull PagedInventoryTemplate getTemplate() {
        return (PagedInventoryTemplate) super.getTemplate();
    }
}
