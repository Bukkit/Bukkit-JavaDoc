package org.bukkit.command.defaults;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import com.google.common.collect.ImmutableList;

public class KillAllCommand extends VanillaCommand {
    public KillAllCommand() {
        super("killall");
        this.description = "Kill everyone on the server";
        this.usageMessage = "/killall";
        this.setPermission("bukkit.command.kill");
    }
    
    // WITH KILLCOMMAND
    
    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if (!testPermission(sender)) return true;

        if (sender instanceof Player) {
            Player p = (Player) sender;
            

            EntityDamageEvent kall = new EntityDamageEvent(player, EntityDamageEvent.DamageCause.SUICIDE, 10000);
            Bukkit.getPluginManager().callEvent(kall);
            if (kall.isCancelled()) return true;

            kall.getEntity().setLastDamageCause(kall);
            for(Player p : Bukkit.getOnlinePlayers()){
            p.sendMessage("Wow, you were just killed with everyone else on the server!");
            p.sendMessage("Ouch!");
            p.setHealth(0);

        return true;
    }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        Validate.notNull(sender, "Sender cannot be null");
        Validate.notNull(args, "Arguments cannot be null");
        Validate.notNull(alias, "Alias cannot be null");

        return ImmutableList.of();
    }
}
