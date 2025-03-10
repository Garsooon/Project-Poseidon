package org.bukkit.event.inventory;

import org.bukkit.event.Listener;
/**
* Handles all events thrown in relation to inventories
 */
public class InventoryListener implements Listener {
    public InventoryListener() {}

    /**
     * Called when an ItemStack is successfully smelted in a furnace.
     *
     * @param event Relevant event details
     */
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {}

    /**
     * Called when an ItemStack is successfully burned as fuel in a furnace.
     *
     * @param event Relevant event details
     */
    public void onFurnaceBurn(FurnaceBurnEvent event) {}

    /**
     * Called when a player opens an inventory.
     * <br>
     * Note that this event does not fire when the player opens their player inventory.
     *
     * @param event Relevant event details
     */
    public void onInventoryOpen(InventoryOpenEvent event) {}

    /**
     * Called when a player closes their currently opened inventory.
     *
     * @param event Relevant event details
     */
    public void onInventoryClose(InventoryCloseEvent event) {}

    /**
     * Called when a player click on an inventory slot in their opened inventory.
     *
     * @param event Relevant event details
     */
    public void onInventoryClick(InventoryClickEvent event) {}

    /**
     * @author moderator_man
     */
    public void onInventoryTransaction(InventoryTransactionEvent event) {}
}
