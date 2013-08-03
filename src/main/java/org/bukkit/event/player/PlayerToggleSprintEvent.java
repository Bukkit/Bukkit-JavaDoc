package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a player attempts to change their sprinting state. If they are
 * trying to start sprinting, {@link #isSprinting() event.isSprinting()} will
 * be true; if they are trying to stop, it will be false.
 * <p>
 * If the event is cancelled, the current sprinting state will be retained
 * (visible via {@link Player#isSprinting() event.getPlayer().isSprinting()}
 * .)
 */
public class PlayerToggleSprintEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isSprinting;
    private boolean cancel = false;

    public PlayerToggleSprintEvent(final Player player, final boolean isSprinting) {
        super(player);
        this.isSprinting = isSprinting;
    }

    /**
     * The new sprinting state that the player is attempting to change to.
     *
     * @return new sprinting state
     */
    public boolean isSprinting() {
        return isSprinting;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
