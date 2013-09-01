package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * This event is called when a command is run from the server console. It is
 * called early in the command handling process, and modifications in this event
 * (via {@link #setCommand(String)}) will be shown in the behavior.
 * <p>
 * Many plugins will have <b>no use for this event</b>, and you should attempt
 * to avoid using it if it is not necessary.
 * <p>
 * Some examples of valid uses for this event are:
 * <ul>
 * <li>Logging executed commands to a separate file</li>
 * <li>Variable substitution (for example, replacing "<code>${ip:Steve}</code>"
 * with the connection IP of the player named Steve)</li>
 * <li>Conditionally blocking commands belonging to other plugins (for example,
 * you may not use <code>/home</code> in the combat arena)</li>
 * <li>Per-sender command aliases (for example, after the console runs '
 * <code>calias cr gamemode creative</code>', start replacing a command of '
 * <code>cr</code>' with '<code>gamemode creative</code>').</li>
 * </ul>
 * <p>
 * Examples of incorrect uses are:
 * <ul>
 * <li>Using this event to run command logic</li>
 * </ul>
 * <p>
 * If the event is cancelled, processing of the command will halt.
 * <p>
 * The state of whether or not there is a slash at the beginning of the message
 * should be preserved. If a slash is added or removed, unexpected behavior may
 * result.
 */
public class ServerCommandEvent extends ServerEvent {
    private static final HandlerList handlers = new HandlerList();
    private String command;
    private final CommandSender sender;

    public ServerCommandEvent(final CommandSender sender, final String command) {
        this.command = command;
        this.sender = sender;
    }

    /**
     * Gets the command that the user is attempting to execute from the console
     *
     * @return Command the user is attempting to execute
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the command that the server will execute
     *
     * @param message New message that the server will execute
     */
    public void setCommand(String message) {
        this.command = message;
    }

    /**
     * Get the command sender.
     *
     * @return The sender
     */
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
