package me;


import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.event.match.MatchEndEvent;
import me.realized.duels.api.event.match.MatchStartEvent;
import me.realized.duels.api.match.Match;
import me.runnable.RunnableClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Set;


public class ListenerClass implements Listener {
    private CustomHealthDisplay plugin;
    private HashMap<Arena, RunnableClass> ongoingRunnables = new HashMap<>();



    public ListenerClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
        //RunnableClass runnableClass = new RunnableClass(plugin);
    }





    @EventHandler
    public void onMatchStart(MatchStartEvent event) {
       
       Arena arena = event.getMatch().getArena();

       Set<Player> players = event.getMatch().getPlayers();

       RunnableClass runnableClass = new RunnableClass(plugin, players, task);
        
       ongoingRunnables.put(arena, runnableClass);
    
       BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, runnableClass, 0L, 20L)

       ongoingRunnables.get(arena);
           
       ongoingRunnables.get(runnableClass);
        if (ongoingRunnables.get(arena).equals("null") && ongoingRunnables.get(runnableClass).equals("null")) {
            plugin.getLogger().info("Arena and RunnableClass equal null, removing data.")
            ongoingRunnables.remove(arena);
            runnableClass.cancel;
        }
    


    }
    @EventHandler
    public void onMatchEnd(MatchEndEvent match) {
        RunnableClass runnableClass = ongoingRunnables.remove(arena);
        if (runnableClass != null) {
        runnableClass.cancel();
        }
    }
}


