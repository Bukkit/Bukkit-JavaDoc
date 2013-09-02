package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.TravelAgent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Called when a player is about to teleport because it is in contact with a portal
 * <p>
 * For other entities see {@link org.bukkit.event.entity.EntityPortalEvent EntityPortalEvent}
 */
public class PlayerPortalEvent extends PlayerTeleportEvent {
    private static final HandlerList handlers = new HandlerList();
    protected boolean useTravelAgent = true;
    protected TravelAgent travelAgent;

    public PlayerPortalEvent(final Player player, final Location from, final Location to, final TravelAgent pta) {
        super(player, from, to);
        this.travelAgent = pta;
    }

    public PlayerPortalEvent(Player player, Location from, Location to, TravelAgent pta, TeleportCause cause) {
        super(player, from, to, cause);
        this.travelAgent = pta;
    }

    /**
     * Sets whether or not the Travel Agent will be used.
     * <p>
     * If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #to} Location, and will try to create one if there is none.
     * <p>
     * If this is set to false, the {@link #player} will simply be teleported to the {@link #to} Location.
     *
     * @param useTravelAgent Whether to use the Travel Agent
     */
    public void useTravelAgent(boolean useTravelAgent) {
        this.useTravelAgent = useTravelAgent;
    }

    /**
     * Gets whether or not the Travel Agent will be used.
     * <p>
     * If this is set to true, the TravelAgent will try to find a Portal at
     * the {@link #to} Location, and will try to create one if there is none.
     * <p>
     * If this is set to false, the {@link #player} will simply be teleported to the {@link #to} Location.
     *
     * @return Whether to use the Travel Agent
     */
    public boolean useTravelAgent() {
        return useTravelAgent && travelAgent != null;
    }

    /**
     * Gets the Travel Agent used (or not) in this event.
     *
     * @return The Travel Agent used (or not) in this event
     */
    public TravelAgent getPortalTravelAgent() {
        return this.travelAgent;
    }

    /**
     * Sets the Travel Agent used (or not) in this event.
     *
     * @param travelAgent The Travel Agent used (or not) in this event
     */
    public void setPortalTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}