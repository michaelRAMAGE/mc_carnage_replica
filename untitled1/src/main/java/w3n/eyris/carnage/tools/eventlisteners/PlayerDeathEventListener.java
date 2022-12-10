package w3n.eyris.carnage.tools.eventlisteners;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class PlayerDeathEventListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        String def_death_msg = e.getDeathMessage();
        System.out.println(def_death_msg);
        Entity entity = e.getEntity();
        if (entity instanceof Player) {
            Player p = e.getEntity().getPlayer();
            // Get player name
            String name = entity.getName();
            // Declare
            String death_msg = name;
            // Get location
            Location loc = entity.getLocation();
            String death_loc = "(" + Math.floor(loc.getX()) + ", " + Math.floor(loc.getY()) + ", " + Math.floor(loc.getZ()) + ")";
            // Get cause
            EntityDamageEvent.DamageCause death_cause = Objects.requireNonNull(entity.getLastDamageCause()).getCause();
            switch (death_cause) {
                case DROWNING: death_msg += " drowned to death";
                    break;
                case CONTACT:
                    break;
                case ENTITY_ATTACK:
                    assert p != null;
                    death_msg += " was slain by " + Objects.requireNonNull(p.getKiller()).getName();
                case SUFFOCATION: death_msg += " suffocated";
                    break;
                case FALL: death_msg += " died by fall";
                    break;
                case FIRE: death_msg += " died by fire";
                    break;
                case LAVA: death_msg += " died by lava";
                    break;
                case ENTITY_EXPLOSION: death_msg += " died by explosion";
                    break;
                case STARVATION: death_msg += " starved";
                    break;
                default: death_msg += " died";
            }
            death_msg += " at " + death_loc;
            e.setDeathMessage(death_msg);
            p = null;
        }
        entity = null;

    }
}


