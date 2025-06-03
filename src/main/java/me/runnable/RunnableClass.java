package me.runnable;

import me.CustomHealthDisplay;

public class RunnableClass implements Runnable {
    private CustomHealthDisplay plugin;
    private Set<player> players;
    private BukkitTask task;

    public RunnableClass(CustomHealthDisplay plugin, Set<player> players, BukkitTask task) {
        this.plugin = plugin;
        this.players = players;
        this.task = task;
    }
    @Override
    public void run() {
        plugin.getLogger().info("Match began.");

    }
    public String toString() {
        return "runnableClass:" +
               "\nPlayers = " + this.players +
               "\nTask = " + this.task;
            
               
    
    }
}
