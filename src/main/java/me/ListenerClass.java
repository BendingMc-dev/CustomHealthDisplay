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
    private HashMap<Arena, RunnableClass> ongoingRunnables = new HashMap<>();
    private HashMap<Arena, BukkitTask> ongoingTasks = new HashMap<>();


    public ListenerClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
    }





    @EventHandler
    public void onMatchStart(MatchStartEvent event) {

        Arena arena = event.getMatch().getArena();
        Set<Player> players = event.getMatch().getPlayers();

        RunnableClass runnableClass = new RunnableClass(plugin, players);
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, runnableClass, 0L, 20L);
        plugin.getLogger().info("Match started: " + ongoingRunnables.get(arena));

        ongoingRunnables.put(arena, runnableClass);
        if (!ongoingRunnables.containsKey(arena) && !ongoingRunnables.containsKey(runnableClass)) {
            plugin.getLogger().info("Arena and RunnableClass equal null, removing data.");
            ongoingRunnables.remove(arena);
            task.cancel();
        }



    }
    @EventHandler
    public void onMatchEnd(MatchEndEvent event) {
        Arena arena = event.getMatch().getArena();


    }
}