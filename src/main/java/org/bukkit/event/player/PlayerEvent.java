package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * An abstract base for player-related events.
 */
public abstract class PlayerEvent extends Event {
    protected Player player;

    public PlayerEvent(final Player who) {
        player = who;
    }

    PlayerEvent(final Player who, boolean async) {
        super(async);
        player = who;

    }

    /**
     * Returns the player involved in this event. If multiple players are
     * involved, the "primary" player is preferred, or if both players are
     * equal in involvement, there is no distinction as to which is returned
     * here.
     *
     * @return Player who is involved in this event
     */
    public final Player getPlayer() {
        return player;
    }
}
