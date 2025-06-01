package me;


import me.realized.duels.api.event.match.MatchStartEvent;
import me.realized.duels.api.match.Match;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;


public class ListenerClass implements Listener {
    @EventHandler
    public void onMatchStart(MatchStartEvent event) {
       Player[] players = event.getPlayers();
       
    }
    public void onMatchEnd(Match match) {
        if(match == null) {
            return;
        }
    }

}
