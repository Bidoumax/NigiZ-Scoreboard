package fr.bidoumax.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin implements Listener{

@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		
		if(Bukkit.getOnlinePlayers().isEmpty())
			for(Player online : Bukkit.getOnlinePlayers())
				createBoard(online);
		
	System.out.println("Plguin [NigiZ] Scoreboard Hub ---> en marche");
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		createBoard(event.getPlayer());
	}
	public void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("HubScoreboard-1", "dummy", "NigiZ");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score1 = obj.getScore("=-=-=-=-=-=-=-=");
		score1.setScore(3);
		Score score2 = obj.getScore("Joueur en ligne: " + Bukkit.getOnlinePlayers().size());
		score2.setScore(2);
		Score score3 = obj.getScore("zdqqdzq");
		score3.setScore(1);
		Score score4 = obj.getScore("=-=-=-=-=-=-=-=");
		score4.setScore(0);
		player.setScoreboard(board);
	}

}