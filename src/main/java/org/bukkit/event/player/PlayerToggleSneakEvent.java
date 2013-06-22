package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a player attempts to change their sneaking state. If they are
 * trying to start sneaking, {@link #isSneaking() event.isSneaking()} will be
 * true; if they are trying to stop, it will be false.
 * <p>
 * If the event is cancelled, the current sneaking state will be retained
 * (visible via {@link Player#isSneaking() event.getPlayer().isSneaking()}.)
 */
public class PlayerToggleSneakEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isSneaking;
    private boolean cancel = false;

    public PlayerToggleSneakEvent(final Player player, final boolean isSneaking) {
        super(player);
        this.isSneaking = isSneaking;
    }

    /**
     * The new sneaking state that the player is attempting to change to.
     *
     * @return new sneaking state
     */
    public boolean isSneaking() {
        return isSneaking;
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
