package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.mainmenu.BalanceSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.mainmenu.NodeListSlot;
import colonelkai.routesbyplayers.gui.inventory.slot.mainmenu.RouteListSlot;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

public class MainMenuTemplate implements InventoryTemplate {

    @Override
    public int getInventorySize() {
        return 27;
    }

    @Override
    public Collection<Slot> getSlots() {
        Collection<Slot> slots =  new ArrayList<>();
        slots.add(new NodeListSlot(this, 10));
        slots.add(new RouteListSlot(this, 12));
        slots.add(new BalanceSlot(this, 14));
        return slots;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "RoutesByPlayers";
    }
}
