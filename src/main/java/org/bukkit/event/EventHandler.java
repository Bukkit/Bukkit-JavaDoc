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
     * Define the priority of the event,
     * 
     * First execution to the last: LOWEST -> LOW -> NORMAL -> HIGH -> HIGHEST -> MONITOR
     * 
     */
    EventPriority priority() default EventPriority.NORMAL;
    
    
    /**
     * Define if we must ignore if the event is cancelled or not
     * 
     * true -> ignoreCancelled / false -> Do not ignoreCancelled
     * 
     */
    boolean ignoreCancelled() default false;
}
