package colonelkai.routesbyplayers.gui.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {

    private Material material;
    private int amount;
    private final List<String> lore = new ArrayList<>();
    private String name;

    public Material getMaterial() {
        return this.material;
    }

    public ItemStackBuilder setMaterial(Material material) {
        if (!material.isItem()) {
            throw new IllegalArgumentException("Material must be a item");
        }
        this.material = material;
        return this;
    }

    public int getAmount() {
        return this.amount;
    }

    public ItemStackBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public List<String> getLore() {
        return this.lore;
    }

    public ItemStackBuilder addLore(@NotNull String lore) {
        this.lore.add(lore);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ItemStackBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder from(ItemStack stack) {
        this.material = stack.getType();
        this.amount = stack.getAmount();
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) {
            return this;
        }
        this.lore.clear();
        if (meta.getLore() != null) {
            this.lore.addAll(meta.getLore());
        }
        this.name = meta.getDisplayName();
        return this;
    }

    public ItemStack build() {
        if (this.material == null) {
            throw new IllegalArgumentException("Material must be set before building");
        }
        if (this.amount <= 0) {
            throw new IllegalArgumentException("Amount must be set before building");
        }
        ItemStack itemStack = new ItemStack(this.material, this.amount);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            throw new RuntimeException("Well ... Bukkit finally made it actually nullable");
        }
        if (!this.lore.isEmpty()) {
            meta.setLore(this.lore);
        }
        if (this.name != null) {
            meta.setDisplayName(this.name);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
