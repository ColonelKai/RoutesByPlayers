package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.CreateMenuSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.OwnedNodesListSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.OwnedRoutesListSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.RouteRequestListSlot;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

public class ManageTemplate implements InventoryTemplate {
    @Override
    public int getInventorySize() {
        return 27;
    }


    @Override
    public Collection<Slot> getSlots() {
        Collection<Slot> slots =  new ArrayList<>();
        slots.add(new OwnedNodesListSlot(this, 10));
        slots.add(new OwnedRoutesListSlot(this, 12));
        slots.add(new RouteRequestListSlot(this, 14));
        slots.add(new CreateMenuSlot(this, 16));
        return slots;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Manage";
    }
}
