package w3n.eyris.carnage.tools;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.scheduler.BukkitTask;
import w3n.eyris.carnage.tools.commands.GoToLobbyCommand;
import w3n.eyris.carnage.tools.commands.GoToPracticeCommand;
import w3n.eyris.carnage.tools.commands.WorldResetCommand;

import w3n.eyris.carnage.tools.eventlisteners.*;
import w3n.eyris.carnage.tools.tasks.CountdownTask;

import java.io.File;
import java.util.Random;

public class Main extends JavaPlugin {

    public Main()
    {
        super();
    }
    protected Main(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file)
    {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        Random rn = new Random();
        int x = rn.nextInt(1000) + 1;
        int z = rn.nextInt(1000) + 1;
        MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        MVWorldManager worldManager = core.getMVWorldManager();
//        worldManager.cloneWorld("worldtemplate", "world"); // does this make a complete copy or just settings?
        worldManager.loadDefaultWorlds();

        this.getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerChangedWorldEventListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerPortalListener(this), this);

    }

    @Override
    public void onDisable() {
    }


}