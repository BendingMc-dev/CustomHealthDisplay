package me.runnable;

import me.CustomHealthDisplay;
import me.realized.duels.api.Duels;
import me.realized.duels.api.arena.Arena;
import me.realized.duels.api.arena.ArenaManager;
import me.realized.duels.api.spectate.SpectateManager;
import me.realized.duels.api.spectate.Spectator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import plugin.customcooking.CustomCooking;
import plugin.customcooking.utility.AdventureUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MatchRunnable extends BukkitRunnable {
    private CustomHealthDisplay plugin;
    private Set<Player> players;
    private Player player1;
    private Player player2;
    private SpectateManager spectateManager;
    private ArenaManager arenaManager;
    private Arena arena;




    public MatchRunnable(CustomHealthDisplay plugin, Set<Player> players) {
        Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");
        setPlayers(players);

        this.plugin = plugin;
        this.players = players;


        this.spectateManager = api.getSpectateManager();
        this.arenaManager = api.getArenaManager();


        if(player1 != null) {
            this.arena = arenaManager.get(player1);
        }



    }

    @Override
    public void run() {
        if(arena == null) {
            plugin.getLogger().info("Arena is null");
            return;
        }
       // plugin.getLogger().info("Match: " + arena.toString() + " Players: " + this.players.toString());
        List<Spectator> spectators = getSpectators(spectateManager);
        for (Spectator spectator : spectators) {
            Player player = spectator.getPlayer();
            AdventureUtil.playerActionbar(player, getFormat());



        }





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
    public List<Spectator> getSpectators(SpectateManager spectateManager) {
        return spectateManager.getSpectators(arena);
    }
    public String getFormat() {
        return String.format("<gray>%s: <red>%d / %.0f <grey>| %s: <red>%d / %.0f",
                player1.getName(), (int) player1.getHealth(), player1.getMaxHealth(),
                player2.getName(), (int) player2.getHealth(), player2.getMaxHealth());
    }
    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public double getHealth1() { return player1.getHealth(); }
    public double getHealth2() { return player2.getHealth(); }

}
