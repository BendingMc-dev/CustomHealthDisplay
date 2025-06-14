package me;


import me.realized.duels.api.Duels;
import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.arena.ArenaManager;
import me.realized.duels.api.event.match.MatchEndEvent;
import me.realized.duels.api.event.match.MatchStartEvent;
import me.runnable.MatchRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import java.util.HashMap;
import java.util.Set;


public class ListenerClass implements Listener {
    private CustomHealthDisplay plugin;
    private HashMap<Arena, MatchRunnable> ongoingRunnables = new HashMap<>();
    private ArenaManager arenaManager;


    public ListenerClass(CustomHealthDisplay plugin) {
        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");

        this.plugin = plugin;
        this.arenaManager = api.getArenaManager();



    }

    @EventHandler
    public void onMatchStart(MatchStartEvent event) {


        Set<Player> players = event.getMatch().getPlayers();
        MatchRunnable matchRunnable = new MatchRunnable(plugin, players);
        Player player1 = matchRunnable.getPlayer1();
        Arena arena = arenaManager.get(player1);
        if(arena == null) {
            plugin.getLogger().info("Arena is null");
        }



        MatchRunnable task = new MatchRunnable(plugin, players);
        task.runTaskTimer(plugin, 0L, 20L);
     //   plugin.getLogger().info("Match started: " + ongoingRunnables.get(arena));

        ongoingRunnables.put(arena, task);
        if (!ongoingRunnables.containsKey(arena) && !ongoingRunnables.containsValue(task)) {
            plugin.getLogger().info("BukkitTask and RunnableClass equal null, removing data.");
            ongoingRunnables.remove(arena);
            task.cancel();
        }



    }

    @EventHandler
    public void onMatchEnd(MatchEndEvent event) {
        Set<Player> players = event.getMatch().getPlayers();
        Arena arena = event.getMatch().getArena();
        MatchRunnable task = ongoingRunnables.remove(arena);
        if (task != null) {
            task.cancel();
        }
      //  plugin.getLogger().info("Match ended: " + players.toString());
    }
}