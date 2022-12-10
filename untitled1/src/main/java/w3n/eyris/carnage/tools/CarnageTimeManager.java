package w3n.eyris.carnage.tools;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import w3n.eyris.carnage.tools.tasks.CountdownTask;

import java.util.Timer;

public class CarnageTimeManager {
    private static Plugin plugin;
    private static CarnageTimeManager instance = null;

    // configs
    private static int session_timer_secs = 60*60*2;
    private static int start_time_countdown_secs = 60;

    private CarnageTimeManager() {
    }

    public static CarnageTimeManager getInstance(Plugin p) {
        if (instance == null) {
            instance = new CarnageTimeManager();
        }
        plugin = p;
        return instance;
    }

    public static void start_startTimeCountdown() {
        // invoke the scheduled task
        BukkitTask task = new CountdownTask(plugin).runTaskLater(plugin, 20);
    }

    public static void start_SessionTimer() {
        // invoke the scheduled task
    }


    public static int getSession_timer_secs() {
        return session_timer_secs;
    }

    public static void setSession_timer_secs(int session_timer_secs) {
        CarnageTimeManager.session_timer_secs = session_timer_secs;
    }

    public static int getStart_time_countdown_secs() {
        return start_time_countdown_secs;
    }

    public static void setStart_time_countdown_secs(int start_time_countdown_secs) {
        CarnageTimeManager.start_time_countdown_secs = start_time_countdown_secs;
    }
}
