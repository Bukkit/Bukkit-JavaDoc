package org.bukkit.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to mark methods as being event handler methods
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /**
     * Define the priority of the event.
     * <p />
     * First Priority to the last priority executed:
     * <p />
     * <ol>
     * <li>LOWEST</li>
     * <li>LOW</li>
     * <li>NORMAL</li>
     * <li>HIGH</li>
     * <li>HIGHEST</li>
     * <li>MONITOR</li>
     * </ol>
     */
    EventPriority priority() default EventPriority.NORMAL;

    /**
     * Define if we must ignore if the event is cancelled or not.
     * <p />
     * If ignoreCancelled = true and the event is cancelled,
     * your method is not call.
     * <p />
     * Otherwise, your method is always called.
     */
    boolean ignoreCancelled() default false;
}
