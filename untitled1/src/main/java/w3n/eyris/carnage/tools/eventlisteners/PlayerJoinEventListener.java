package w3n.eyris.carnage.tools.eventlisteners;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        if (e.getPlayer().getWorld().getName() == "world") {
            e.setJoinMessage("Welcome to carnage, peasant ^->-^!");
        }
        else if (e.getPlayer().getWorld().getName() == "lobby") {
            e.setJoinMessage("Welcome to da lobby, peasant ^->-^!");
        }
    }
}
