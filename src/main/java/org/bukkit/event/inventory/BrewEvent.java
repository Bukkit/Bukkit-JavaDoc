package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.BrewerInventory;

/**
 * Called when an item is brewed in its inventory.
 */
public class BrewEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private BrewerInventory contents;
    private boolean cancelled;

    public BrewEvent(Block brewer, BrewerInventory contents) {
        super(brewer);
        this.contents = contents;
    }

    /**
     * Returns the contents of the brewer inventory.
     *
     * @return contents of the brewer inventory.
     */
    public BrewerInventory getContents() {
        return contents;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
