package me.runnable;

import me.CustomHealthDisplay;
import me.realized.duels.api.Duels;
import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.spectate.SpectateManager;
import me.realized.duels.api.spectate.Spectator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MatchRunnable extends BukkitRunnable {
    private CustomHealthDisplay plugin;
    private Set<Player> players;
    private Player player1;
    private Player player2;
    private SpectateManager spectateManager;
    private Arena arena;


    public MatchRunnable(CustomHealthDisplay plugin, Set<Player> players) {
        this.plugin = plugin;
        this.players = players;

        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");
        this.spectateManager = api.getSpectateManager();
    }

    @Override
    public void run() {
        List<Spectator> spectators = getSpectators(spectateManager);
        for (Spectator spectator : spectators) {
            Player player = spectator.getPlayer();
            
        }

        plugin.getLogger().info("Match began: " + this.plugin.toString() + ": " + this.players.toString());


    }
    public Set<Player> getPlayers() {
        return players;
    }
    public void setPlayers(Set<Player> players) {
        Iterator<Player> iterator = players.iterator();
        if(iterator.hasNext()) {
            player1 = iterator.next();
        }
        if(iterator.hasNext()) {
            player2 = iterator.next();
        }
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public double getHP1() {
        return player1.getHealth();
    }
    public double getHP2() {
        return player2.getHealth();
    }
    public List<Spectator> getSpectators(SpectateManager spectateManager) {
        return spectateManager.getSpectators(arena);
    }

    
    
    public String toString() {
        return "runnableClass:" + this.plugin.toString() +
               "\nPlayers = " + this.players;


    }

}
