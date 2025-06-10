package me;


import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.event.match.MatchEndEvent;
import me.realized.duels.api.event.match.MatchStartEvent;
import me.runnable.RunnableClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Set;


public class ListenerClass implements Listener {
    private CustomHealthDisplay plugin;
    private HashMap<BukkitTask, RunnableClass> ongoingRunnables = new HashMap<>();

    public ListenerClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
    }





    @EventHandler
    public void onMatchStart(MatchStartEvent event) {

        Arena arena = event.getMatch().getArena();
        Set<Player> players = event.getMatch().getPlayers();

        RunnableClass runnableClass = new RunnableClass(plugin, players, arena);
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, runnableClass, 0L, 20L);
        plugin.getLogger().info("Match started: " + ongoingRunnables.get(arena));

        ongoingRunnables.put(task, runnableClass);
        if (!ongoingRunnables.containsKey(task) && !ongoingRunnables.containsValue(runnableClass)) {
            plugin.getLogger().info("BukkitTask and RunnableClass equal null, removing data.");
            ongoingRunnables.remove(task);
            task.cancel();
        }



    }
    @EventHandler
    public void onMatchEnd(MatchEndEvent event) {
        if (event.getWinner() != null) {
            BukkitTask task = ongoingRunnables.get(task);
            task.cancel();
            
            ongoingRunnables.remove(task);
        
        }
    }
    @EventHandler
    public void onSpectate(SpectateStartEvent event) {
        SpectatorManager spectatorManager = new SpectatorManager(plugin, spectator);
        Spectator spectator = event.getSpectator();
        plugin.getLogger().info(spectator + "has started spectating!")
        if(spectator == null) {
            Spectate.setCancelled();
        } 
    }
}
