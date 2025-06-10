package me.runnable;

import me.CustomHealthDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class MatchRunnable extends BukkitRunnable {
    private CustomHealthDisplay plugin;
    private Set<Player> players;

    public MatchRunnable(CustomHealthDisplay plugin, Set<Player> players) {
        this.plugin = plugin;
        this.players = players;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began: " + this.plugin.toString() + ": " + this.players.toString());
        if(this.players.isEmpty()) {
            cancel();
        }

    }
    public Set<Player> getPlayers() {
        return players;
    }


    
    
    public String toString() {
        return "runnableClass:" + this.plugin.toString() +
               "\nPlayers = " + this.players;


    }

}
