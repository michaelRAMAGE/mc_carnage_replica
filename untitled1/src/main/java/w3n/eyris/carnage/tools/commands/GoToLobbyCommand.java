package w3n.eyris.carnage.tools.commands;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import w3n.eyris.carnage.tools.Main;
import w3n.eyris.carnage.tools.utils;

import static org.bukkit.Bukkit.getServer;

public class GoToLobbyCommand implements CommandExecutor {

    private final Plugin plugin;

    public GoToLobbyCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("goToLobby")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                String current_world = p.getWorld().getName();
                if (current_world != "world") {
                    utils.sendAllPlayersToNewWorld("world", this.plugin); // sends players to
                    String msg = utils.unloadAndDeleteWorld(current_world, this.plugin);
                    System.out.println(msg);
                }
                else {
                    p.sendMessage("You are already in the main lobby");
                }
            }
        }
        return true;
    }
}
