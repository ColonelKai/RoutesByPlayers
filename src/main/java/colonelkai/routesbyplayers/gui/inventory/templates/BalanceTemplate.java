package colonelkai.routesbyplayers.gui.inventory.templates;

import colonelkai.routesbyplayers.gui.inventory.InventoryTemplate;
import colonelkai.routesbyplayers.gui.inventory.slot.Slot;
import colonelkai.routesbyplayers.gui.inventory.slot.balancemenu.IncomeBalanceSlot;
import colonelkai.routesbyplayers.util.context.TemplateContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BalanceTemplate implements InventoryTemplate {
    TemplateContext ctx;

    public BalanceTemplate() {
    }

    public void setCtx(TemplateContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getInventorySize() {
        return 27;
    }

    @Override
    public Collection<Slot> getSlots() {
        List<Slot> slots = new ArrayList<>();
        slots.add(new IncomeBalanceSlot(this, 16, this.ctx.getPlayer()));
        return slots;
    }

    @Override
    public @NotNull String getTemplateName() {
        return "Balance";
    }
}
