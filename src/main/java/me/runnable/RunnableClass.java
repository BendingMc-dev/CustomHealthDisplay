package me.runnable;

import me.CustomHealthDisplay;
import org.bukkit.entity.Player;

import java.util.Set;

public class RunnableClass implements Runnable {
    private CustomHealthDisplay plugin;
    private Set<Player> players;
    private Arena arena;

    public RunnableClass(CustomHealthDisplay plugin, Set<Player> players, Arena arena) {
        this.plugin = plugin;
        this.players = players;
        this.arena = arena;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began: " + this.plugin.toString() + "" + this.players.toString() + "" + this.arena.toString());

    }
    public Set<Player> getPlayers() {
        return players;
    }
    public Arena getArena() {
        return arena;
    }
    
    
    public String toString() {
        return "runnableClass:" + this.plugin.toString() +
               "\nPlayers = " + this.players +
               "\nArena = " + this.arena;


    }
}
