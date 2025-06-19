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
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Set;


public class ListenerClass implements Listener {
    private CustomHealthDisplay plugin;
    private HashMap<Arena, MatchRunnable> ongoingRunnables = new HashMap<>();
    private ArenaManager arenaManager;


    public ListenerClass(CustomHealthDisplay plugin) {
        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");
        if(api == null) {
            plugin.getLogger().info("Duels not found");
            return;
        }
        this.plugin = plugin;
        this.arenaManager = api.getArenaManager();



    }

    @EventHandler
    public void onMatchStart(MatchStartEvent event) {

        Set<Player> players = event.getMatch().getPlayers();
        MatchRunnable task = new MatchRunnable(plugin, players);
        Player player1 = task.getPlayer1();
        Arena arena = arenaManager.get(player1);

        task.runTaskTimer(plugin, 0L, 20L);
        ongoingRunnables.put(arena, task);
        plugin.getLogger().info("Match started: " + ongoingRunnables.get(arena));

    }

    @EventHandler
    public void onMatchEnd(MatchEndEvent event) {

        Set<Player> players = event.getMatch().getPlayers();
        Player player1 = players.iterator().next();
        Arena arena = arenaManager.get(player1);

        MatchRunnable task = ongoingRunnables.remove(arena);
        if (task != null) {
            task.cancel();
        }
       plugin.getLogger().info("Match ended: " + players);
    }
}