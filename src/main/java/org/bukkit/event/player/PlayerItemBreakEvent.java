package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * This event is called when a player's item breaks (such as a shovel or flint
 * and steel) due to the loss of its last point of durability. The item that
 * is breaking will exist in the inventory with a stack size of 0, or you may
 * use {@link #getBrokenItem()} to retrieve it.
 * <p>
 * After this event is complete, the itemstack's {@link ItemStack#getData()
 * data value} will be reset to 0.
 * <p>
 * This event may not be cancelled.
 */
public class PlayerItemBreakEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack brokenItem;

    public PlayerItemBreakEvent(final Player player, final ItemStack brokenItem) {
        super(player);
        this.brokenItem = brokenItem;
    }

    /**
     * Get the item that is breaking.
     * <p>
     * This item is mutable; any changes will be reflected in the inventory
     * immediately.
     *
     * @return The broken item
     */
    public ItemStack getBrokenItem() {
        return brokenItem;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
