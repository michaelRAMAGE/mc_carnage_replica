package w3n.eyris.carnage.tools;

import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import java.io.File;

public class utils {

    public static void sendAllPlayersToNewWorld(String world_name, Plugin plugin) {
        if (plugin.getServer().getWorld(world_name) == null) {
            plugin.getServer().createWorld(new WorldCreator(world_name));
        }
        for (Player p : plugin.getServer().getOnlinePlayers()) {
            p.teleport(plugin.getServer().getWorld(world_name).getSpawnLocation()); // does not trigger worldload event?
        }
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public static void addStarterItems(Player player) {
        ItemStack stack1 = new ItemStack(Material.TORCH, 64);
        ItemStack stack2 = new ItemStack(Material.COOKED_BEEF, 5);
        player.getInventory().addItem(stack1);
        player.getInventory().addItem(stack2);
    }

    public static String unloadAndDeleteWorld(String world_name, Plugin plugin) {
        int directory_deleted_success = -1;
        int unload_success = -1;
        File delete;
        try {
//            delete = plugin.getServer().getWorld(world_name).getWorldFolder();
            unload_success = plugin.getServer().unloadWorld(world_name, false) ? 1 : 0;
//            if (delete != null) {
//                deleteDirectory(delete);
//                directory_deleted_success = delete.isDirectory() ? 0 : 1;
//            }
        }
        catch(Exception e) {
            System.out.println("unloadAndDeleteWorld error: " + e.getMessage() + ", " + e.getCause());
        }
        return "UNLOAD_SUCCESS: " + unload_success + ", " + "DIRECTORY_DELETE_SUCCESS?" + directory_deleted_success;

    }
}
