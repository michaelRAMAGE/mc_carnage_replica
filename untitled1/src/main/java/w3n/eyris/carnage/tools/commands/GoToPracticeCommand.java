package w3n.eyris.carnage.tools.commands;

import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import w3n.eyris.carnage.tools.Main;
import w3n.eyris.carnage.tools.utils;

public class GoToPracticeCommand implements CommandExecutor {
    private Plugin plugin;

    public GoToPracticeCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String practice_world = "carnage";
        if (command.getName().equalsIgnoreCase("goToPractice")) {
            if (sender instanceof Player) {
                System.out.println("Is a player");
                if (((Player) sender).getWorld().getName() != practice_world) {
                    utils.sendAllPlayersToNewWorld(practice_world, this.plugin);
                }
                else {
                    sender.sendMessage("You are already in practice server");
                }
            }
            else {
                System.out.println("Not uh player");
            }
        }
        return true;
    }
}
