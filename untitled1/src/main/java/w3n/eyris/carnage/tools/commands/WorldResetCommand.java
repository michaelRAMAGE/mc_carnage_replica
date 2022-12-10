package w3n.eyris.carnage.tools.commands;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.Plugin;
import w3n.eyris.carnage.tools.Main;
import w3n.eyris.carnage.tools.utils;

import java.io.File;

import static org.bukkit.Bukkit.getServer;

public class WorldResetCommand implements CommandExecutor, Listener {
    private Plugin plugin;

    public WorldResetCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String practice_world = "world";
        if (command.getName().equalsIgnoreCase("resetWorld")) {
            if (sender instanceof Player) {
                utils.sendAllPlayersToNewWorld("lobby", this.plugin); // send back to lobby
                String msg = utils.unloadAndDeleteWorld(practice_world, plugin);
                this.plugin.getServer().createWorld(new WorldCreator(practice_world)); // recreate world
//                utils.sendAllPlayersToNewWorld(practice_world, this.plugin);
            }
        }
        return true;
    }
}
