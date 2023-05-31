package colonelkai.routesbyplayers.gui.inventory;

import colonelkai.routesbyplayers.util.context.TemplatePlayerContext;

public interface ContextedTemplate extends InventoryTemplate {
    public void setCtx(TemplatePlayerContext ctx);
}
