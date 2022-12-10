package w3n.eyris.carnage.tools.eventlisteners;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import w3n.eyris.carnage.tools.CarnageTimeManager;
import w3n.eyris.carnage.tools.tasks.CountdownTask;
import w3n.eyris.carnage.tools.utils;

public class PlayerChangedWorldEventListener implements Listener {

    private Plugin plugin;

    public PlayerChangedWorldEventListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent e) {

        System.out.println("Player changed world...");
        System.out.println(e.getPlayer().getWorld().getName());
        System.out.println(e.getPlayer().hasPlayedBefore());
        System.out.println(e.getPlayer().getWorld().getName().equals("world") && !e.getPlayer().hasPlayedBefore());
        if (e.getPlayer().getWorld().getName().equals("world") && !e.getPlayer().hasPlayedBefore()) {
            System.out.println("Giving player items...");

            utils.addStarterItems(e.getPlayer());

            System.out.println("Bukkit task");
            BukkitTask task = new CountdownTask(plugin).runTaskLater(plugin, 20*15);
            }
    }
}

