package net.minecraft.server;

import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.craftbukkit.inventory.CraftInventoryDoubleChest;
import org.bukkit.craftbukkit.inventory.CraftInventoryPlayer;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;
import org.bukkit.entity.HumanEntity;

public class ContainerChest extends Container {

    public IInventory a; // Poseidon - private -> public
    private int b;
    // Poseidon start
    private CraftInventoryView view = null;
    private InventoryPlayer player;
    // Poseidon end

    public ContainerChest(IInventory iinventory, IInventory iinventory1) {
        this.a = iinventory1;
        this.b = iinventory1.getSize() / 9;
        int i = (this.b - 4) * 18;
        this.player = (InventoryPlayer) iinventory;

        int j;
        int k;

        for (j = 0; j < this.b; ++j) {
            for (k = 0; k < 9; ++k) {
                this.a(new Slot(iinventory1, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.a(new Slot(iinventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.a(new Slot(iinventory, j, 8 + j * 18, 161 + i));
        }
    }

    public boolean b(EntityHuman entityhuman) {
        if (!this.checkReachable) return true;
        return this.a.a_(entityhuman);
    }

    public ItemStack a(int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.e.get(i);

        if (slot != null && slot.b()) {
            ItemStack itemstack1 = slot.getItem();

            itemstack = itemstack1.cloneItemStack();
            if (i < this.b * 9) {
                this.a(itemstack1, this.b * 9, this.e.size(), true);
            } else {
                this.a(itemstack1, 0, this.b * 9, false);
            }

            if (itemstack1.count == 0) {
                slot.c((ItemStack) null);
            } else {
                slot.c();
            }
        }

        return itemstack;
    }

    // Poseidon
    @Override
    public CraftInventoryView getBukkitView() {
        if (view != null) return view;
        CraftInventory inventory;
        if (a instanceof InventoryPlayer) {
            inventory = new CraftInventoryPlayer((InventoryPlayer)a);
        } else if (a instanceof InventoryLargeChest) {
            inventory = new CraftInventoryDoubleChest((InventoryLargeChest)a);
        } else {
            inventory = new CraftInventory(this.a);
        }
        view = new CraftInventoryView((HumanEntity) this.player.d.getBukkitEntity(), inventory, this);
        return view;
    }
}
