package me;


import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.event.match.MatchEndEvent;
import me.realized.duels.api.event.match.MatchStartEvent;
import me.realized.duels.api.event.spectate.SpectateStartEvent;
import me.realized.duels.api.spectate.Spectator;
import me.runnable.MatchRunnable;
import me.runnable.SpectatorRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import java.util.HashMap;
import java.util.Set;


public class ListenerClass implements Listener {
    private CustomHealthDisplay plugin;
    private HashMap<Arena, MatchRunnable> ongoingRunnables = new HashMap<>();
    private HashMap<HandlerList, SpectatorRunnable> spectatorRunnables = new HashMap<>();


    public ListenerClass(CustomHealthDisplay plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMatchStart(MatchStartEvent event) {

        Arena arena = event.getMatch().getArena();
        Set<Player> players = event.getMatch().getPlayers();

        MatchRunnable task = new MatchRunnable(plugin, players);
        task.runTaskTimer(plugin, 0L, 20L);
        plugin.getLogger().info("Match started: " + ongoingRunnables.get(arena));

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
            plugin.getLogger().info("Match ended: " + players.toString());
    }
    @EventHandler
    public void onSpectate(SpectateStartEvent event) {

        Spectator spectator = event.getSpectator();
        HandlerList handlers = event.getHandlers();

        SpectatorRunnable task = new SpectatorRunnable(plugin, spectator);
        task.runTaskTimer(plugin, 0L, 20L);

        spectatorRunnables.put(handlers, task);
        plugin.getLogger().info(spectator + "has started spectating! Handlers: " + handlers);
    }
    @EventHandler
    public void onSpectateEnd(SpectateStartEvent event) {
        Spectator spectator = event.getSpectator();
        HandlerList handlers = event.getHandlers();
        SpectatorRunnable task = spectatorRunnables.remove(handlers);
        if (task != null) {
            task.cancel();
        }
        plugin.getLogger().info(spectator + "has stopped spectating! Handlers: " + handlers);
    }
}
