package mc.arexmc.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mc.arexmc.antiwerbung.BlockWordAPI;
import mc.arexmc.antiwerbung.BlockWordCMD;
import mc.arexmc.broadcast.BroadcastAPI;
import mc.arexmc.chatcolor.AdminChatcolorCMD;
import mc.arexmc.chatcolor.ChatcolorAPI;
import mc.arexmc.chatcolor.ChatcolorCMD;
import mc.arexmc.chatcolor.ChatcolorEvent;
import mc.arexmc.clan.ClanCMD;
import mc.arexmc.clan.ClanData;
import mc.arexmc.clan.ClanEvent;
import mc.arexmc.commands.*;
import mc.arexmc.listener.*;
import mc.arexmc.utils.Board;
import mc.arexmc.utils.CombatLog;
import mc.arexmc.utils.Config;
import mc.arexmc.utils.PlayerCache;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	
	public void onEnable() {
		instance = this;
		System.out.println("AREXMC | Enabling");
		ClanData.createCFG();
		BlockWordAPI.createCFG();
		ChatcolorAPI.createCFG();
		Config.create();
		Board.createTeams();
		Board.updateTab();
		BroadcastAPI.createCFG();
		BroadcastAPI.startCasting();
		registerCMD();
		registerEVENTS();
		
	}
	
	private void registerEVENTS() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new CombatLog(), this);
		pm.registerEvents(new ChatEvent(), this);
		pm.registerEvents(new UnknownCommandListener(), this);
		pm.registerEvents(new ServerListEvent(), this);
		pm.registerEvents(new ClanEvent(), this);
		pm.registerEvents(new ChatcolorEvent(), this);
	}

	private void registerCMD() {

		getCommand("youtube").setExecutor(new YoutubeCMD());
		getCommand("info").setExecutor(new InformationCMD());
		getCommand("system").setExecutor(new SystemCMD());
		getCommand("abfall").setExecutor(new AbfallCMD());
		getCommand("random").setExecutor(new RandomCMD());
		getCommand("rename").setExecutor(new RenameCMD());
		getCommand("Broadcast").setExecutor(new BroadcastCMD());
		getCommand("Socialspy").setExecutor(new SocialspyCMD());
		getCommand("msg").setExecutor(new MSGCMD());
		getCommand("r").setExecutor(new MsgRCMD());
		getCommand("countdown").setExecutor(new CountdownCMD());
		getCommand("enderchest").setExecutor(new EnderchestCMD());
		getCommand("feed").setExecutor(new FeedCMD());
		getCommand("giveall").setExecutor(new GiveallCMD());
		getCommand("chatclear").setExecutor(new ChatclearCMD());
		getCommand("gamemode").setExecutor(new GamemodeCMD());
		getCommand("more").setExecutor(new MoreCMD());
		getCommand("skull").setExecutor(new SkullCMD());
		getCommand("teamchat").setExecutor(new TeamChatCMD());
		getCommand("team").setExecutor(new TeamCMD());
		getCommand("verlosung").setExecutor(new VerlosungCMD());
		getCommand("vanish").setExecutor(new VanishCMD());
		getCommand("tp").setExecutor(new TPCMD());
		getCommand("tphere").setExecutor(new TPhereCMD());
		getCommand("stack").setExecutor(new StackCMD());
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("god").setExecutor(new GodCMD());
		getCommand("ping").setExecutor(new PingCMD());
		getCommand("clan").setExecutor(new ClanCMD());
		getCommand("chatcolor").setExecutor(new ChatcolorCMD());
		getCommand("admincolor").setExecutor(new AdminChatcolorCMD());
		getCommand("blockword").setExecutor(new BlockWordCMD());
		getCommand("globalmute").setExecutor(new GlobalmuteCMD());
		getCommand("slowchat").setExecutor(new SlowChatCMD());
		getCommand("setmotd").setExecutor(new SetMotdCMD());
		getCommand("wartungen").setExecutor(new WartungenCMD());
		getCommand("taler").setExecutor(new CoinsCMD());
		getCommand("stats").setExecutor(new StatsCMD());
		getCommand("ban").setExecutor(new BanCMD());
		getCommand("tempban").setExecutor(new TempbanCMD());
		getCommand("unban").setExecutor(new UnbanCMD());
		getCommand("mute").setExecutor(new MuteCMD());
		getCommand("unmute").setExecutor(new StatsCMD());
		getCommand("warn").setExecutor(new WarnCMD());
		getCommand("removewarns").setExecutor(new RemoveWarnsCMD());

	}

	public void onDisable() {
		System.out.println("AREXMC | Disabling");
		
		
	}
	
	public static boolean isInt(String s)
	  {
	    try
	    {
	      Integer.parseInt(s);
	    }
	    catch (NumberFormatException nfe)
	    {
	      return false;
	    }
	    return true;
	  }
 
}
