package me.runnable;

import me.CustomHealthDisplay;
import org.bukkit.entity.Player;

import java.util.Set;

public class RunnableClass implements Runnable {
    private CustomHealthDisplay plugin;
    private Set<Player> players;

    public RunnableClass(CustomHealthDisplay plugin, Set<Player> players) {
        this.plugin = plugin;
        this.players = players;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began: " + this.plugin.toString() + "" + this.players.toString());

    }
    public String toString() {
        return "runnableClass:" + this.plugin.toString() +
               "\nPlayers = " + this.players;


    }
}
