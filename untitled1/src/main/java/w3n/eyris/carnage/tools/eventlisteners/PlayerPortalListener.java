package w3n.eyris.carnage.tools.eventlisteners;

import com.onarandombox.MultiverseCore.event.MVPlayerTouchedPortalEvent;
import com.onarandombox.MultiverseCore.event.MVWorldPropertyChangeEvent;
import com.onarandombox.MultiversePortals.event.MVPortalEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import w3n.eyris.carnage.tools.utils;

public class PlayerPortalListener implements Listener {

    private Plugin plugin;

    public PlayerPortalListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent e) {
        System.out.println("PLAYER PORTALED!!!!");
    }

    @EventHandler
    public void onTouchPortal(MVPlayerTouchedPortalEvent event) {
        System.out.println("PLAYER TOUCHED PORTAL!!!");
    }

    @EventHandler
    public void onMVPortalEvent(MVPortalEvent e) {
        System.out.println("MV PORTAL EVENT!!!");
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        System.out.println("PLAYER TELEPORTED!!!");
    }

    @EventHandler
    public void onMVWorldPropChange(MVWorldPropertyChangeEvent e) {
        System.out.println("WORLD PROPERTY EVENT CHANGED!!");
    }


}
