package mc.arexmc.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import mc.arexmc.main.Main;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Board {
	
	public static Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
	public static Objective obj = board.registerNewObjective("aaa", "bbb");
	
	 public static Team Owner = board.registerNewTeam("01Owner");			
	 public static Team Admin  = board.registerNewTeam("02Admin");
	 public static Team Developer = board.registerNewTeam("03Developer");
	 public static Team Moderator = board.registerNewTeam("04Moderator");
	 public static Team Builder = board.registerNewTeam("05Builder");
	 public static Team Supporter = board.registerNewTeam("06Supporter");
	 public static Team Guard = board.registerNewTeam("07Guard");
	 public static Team Youtuber = board.registerNewTeam("08Youtuber");
	 public static Team Master = board.registerNewTeam("09Master");
	 public static Team Predator = board.registerNewTeam("10Predator");
	 public static Team Wizard = board.registerNewTeam("11Wizard");
	 public static Team Hunter = board.registerNewTeam("12Hunter");
	 public static Team Spieler = board.registerNewTeam("13Spieler");
	
	

	
	
	public static void createTeams() {
		
		if(Owner == null) {
		 Team Owner = board.registerNewTeam("01Owner");			
		 Team Admin  = board.registerNewTeam("02Admin");
		 Team Developer = board.registerNewTeam("03Developer");
		 Team Moderator = board.registerNewTeam("04Moderator");
		 Team Builder = board.registerNewTeam("05Builder");
		 Team Supporter = board.registerNewTeam("06Supporter");
		 Team Guard = board.registerNewTeam("07Guard");
		 Team Youtuber = board.registerNewTeam("08Youtuber");
		 Team Master = board.registerNewTeam("09Master");
         Team Predator = board.registerNewTeam("10Predator");
		 Team Wizard = board.registerNewTeam("11Wizard");
		 Team Hunter = board.registerNewTeam("12Hunter");
		 Team Spieler = board.registerNewTeam("13Spieler");
		}
		 
		 Owner.setPrefix("§4§lO §8× §4");
		 Admin.setPrefix("§c§lA §8× §C");
		 Developer.setPrefix("§b§lD §8× §b");
		 Moderator.setPrefix("§5§lM §8× §5");
		 Builder.setPrefix("§6§lB §8× §6");
		 Supporter.setPrefix("§9§lS §8× §9");
		 Guard.setPrefix("§3§lG §8× §3");
		 Youtuber.setPrefix("§f");
		 Master.setPrefix("§c");
		 Predator.setPrefix("§9");
		 Wizard.setPrefix("§5");
		 Hunter.setPrefix("§3");
		 Spieler.setPrefix("§7");
		 
		
		
	}
	
	public static void createScoreboard(Player p) {
		
		
		
		
		
		
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			PermissionUser user = PermissionsEx.getUser(all);
			
			if(user.inGroup("Owner")) {
				Owner.addPlayer(all);
				
			} else if(user.inGroup("Admin")) {
				Admin.addPlayer(all);
				
			} else if(user.inGroup("Developer")) {
				Developer.addPlayer(all);
				
			} else if(user.inGroup("Moderator")) {
				Moderator.addPlayer(all);
				
			} else if(user.inGroup("Builder")) {
				Builder.addPlayer(all);
				
			} else if(user.inGroup("Supporter")) {
				Supporter.addPlayer(all);
				
			} else if(user.inGroup("Guard")) {
				Guard.addPlayer(all);
				
			} else if(user.inGroup("Youtuber")) {
				Youtuber.addPlayer(all);
				
			} else if(user.inGroup("Master")) {
				Master.addPlayer(all);
				
			} else if(user.inGroup("Predator")) {
				Predator.addPlayer(all);
				
			} else if(user.inGroup("Wizard")) {
				Wizard.addPlayer(all);
				
			} else if(user.inGroup("Hunter")) {
				Hunter.addPlayer(all);
				
			} else {
				Spieler.addPlayer(all);
				
			}
			
			
			
			
		}
		
		
		
		p.setScoreboard(board);
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public static void updateTab() {
		
		
		
	
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instance, new Runnable() {

			@Override
			public void run() {
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					PermissionUser user = PermissionsEx.getUser(all);
					
					if(user.inGroup("Owner")) {
						Owner.addPlayer(all);
						
					} else if(user.inGroup("Admin")) {
						Admin.addPlayer(all);
						
					} else if(user.inGroup("Developer")) {
						Developer.addPlayer(all);
						
					} else if(user.inGroup("Moderator")) {
						Moderator.addPlayer(all);
						
					} else if(user.inGroup("Builder")) {
						Builder.addPlayer(all);
						
					} else if(user.inGroup("Supporter")) {
						Supporter.addPlayer(all);
						
					} else if(user.inGroup("Guard")) {
						Guard.addPlayer(all);
						
					} else if(user.inGroup("Youtuber")) {
						Youtuber.addPlayer(all);
						
					} else if(user.inGroup("Master")) {
						Master.addPlayer(all);
						
					} else if(user.inGroup("Predator")) {
						Predator.addPlayer(all);
						
					} else if(user.inGroup("Wizard")) {
						Wizard.addPlayer(all);
						
					} else if(user.inGroup("Hunter")) {
						Hunter.addPlayer(all);
						
					} else {
						Spieler.addPlayer(all);
						
					}
					
					
					
					
				}
					
				
				
				
			}
			
		}, 100, 100);
		
	}
}
