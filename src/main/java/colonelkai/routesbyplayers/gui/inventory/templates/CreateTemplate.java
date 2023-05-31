package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.createmenu.CreateNodeSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.createmenu.RequestRouteSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.CreateMenuSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.OwnedNodesListSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.OwnedRoutesListSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.managemenu.RouteRequestListSlot;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

public class CreateTemplate implements InventoryTemplate {
    @Override
    public int getInventorySize() {
        return 9;
    }

    @Override
    public Collection<Slot> getSlots() {
        Collection<Slot> slots =  new ArrayList<>();
        slots.add(new CreateNodeSlot(this, 2));
        slots.add(new RequestRouteSlot(this, 6));
        return slots;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Create";
    }
}
