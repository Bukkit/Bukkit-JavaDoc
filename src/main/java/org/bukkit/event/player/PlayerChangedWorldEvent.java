package org.bukkit.event.player;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * This event will be called after a player changes worlds. To get the
 * destination world, use {@link Player#getWorld() getPlayer().getWorld()}.
 * <p>
 * This will be called in the following conditions, and possibly among others:
 * <ul>
 * <li>after {@link PlayerTeleportEvent} when teleporting to a different world
 * </li>
 * <li>after {@link PlayerRespawnEvent} when dying from a different world</li>
 * <li>after {@link PlayerPortalEvent} when the portal goes to a different
 * world</li>
 * </ul>
 * (The above list should not be considered comprehensive and may change
 * without notice.)
 */
public class PlayerChangedWorldEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final World from;

    public PlayerChangedWorldEvent(final Player player, final World from) {
        super(player);
        this.from = from;
    }

    /**
     * The world that this player is changing from.
     * <p>
     * To get the destination world, use {@link Player#getWorld()
     * getPlayer().getWorld()}.
     *
     * @return the origin world
     */
    public World getFrom() {
        return from;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
