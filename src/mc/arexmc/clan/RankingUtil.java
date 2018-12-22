package mc.arexmc.clan;

import java.util.List;

import org.bukkit.entity.Player;

import mc.arexmc.main.Data;

public class RankingUtil {

	public static void getRanking(Player p) {
		List<String> list = ClanData.getClans();
		String top1 = "Keiner";
		int top1kill = 0;
		String top2 = "Keiner";
		int top2kill = 0;
		String top3 = "Keiner";
		int top3kill = 0;
		String top4 = "Keiner";
		int top4kill = 0;
		String top5 = "Keiner";
		int top5kill = 0;
		String top6 = "Keiner";
		int top6kill = 0;
		String top7 = "Keiner";
		int top7kill = 0;
		String top8 = "Keiner";
		int top8kill = 0;
		String top9 = "Keiner";
		int top9kill = 0;
		String top10 = "Keiner";
		int top10kill = 0;
		for (int i = 0; i < list.size(); i++) {
			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top1kill) {
				top1kill = clan.getKills();
				top1 = clan.getTag();
			}
		}
		list.remove(top1.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top2kill) {
				top2kill = clan.getKills();
				top2 = clan.getTag();
			}
		}
		list.remove(top2.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top3kill) {
				top3kill = clan.getKills();
				top3 = clan.getTag();
			}
		}
		list.remove(top3.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top4kill) {
				top4kill = clan.getKills();
				top4 = clan.getTag();
			}
		}

		list.remove(top4.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top5kill) {
				top5kill = clan.getKills();
				top5 = clan.getTag();
			}
		}

		list.remove(top5.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top6kill) {
				top6kill = clan.getKills();
				top6 = clan.getTag();
			}
		}

		list.remove(top6.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top7kill) {
				top7kill = clan.getKills();
				top7 = clan.getTag();
			}
		}

		list.remove(top7.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top8kill) {
				top8kill = clan.getKills();
				top8 = clan.getTag();
			}
		}

		list.remove(top8.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top9kill) {
				top9kill = clan.getKills();
				top9 = clan.getTag();
			}
		}
		list.remove(top9.toLowerCase());
		for (int i = 0; i < list.size(); i++) {

			ClanData clan = new ClanData(list.get(i));
			if (clan.getKills() > top10kill) {
				top10kill = clan.getKills();
				top10 = clan.getTag();
			}
		}

		p.sendMessage(Data.getHeader());
		if (ClanData.getClans().size() > 0) {
			if (top1kill != 0) {
				ClanData clantop1 = new ClanData(top1);
				p.sendMessage(Data.Prefix + "Platz 1: §" + clantop1.getColor() + clantop1.getTag() + " §8 | §c"
						+ clantop1.getKills() + " Kills §8| §c" + clantop1.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 1: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 1: Niemand");
		if (ClanData.getClans().size() > 1) {
			if (top2kill != 0) {
				ClanData clantop2 = new ClanData(top2);
				p.sendMessage(Data.Prefix + "Platz 2: §" + clantop2.getColor() + clantop2.getTag() + " §8 | §c"
						+ clantop2.getKills() + " Kills §8| §c" + clantop2.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 2: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 2: Niemand");

		if (ClanData.getClans().size() > 2) {

			if (top3kill != 0) {
				ClanData clantop3 = new ClanData(top3);
				p.sendMessage(Data.Prefix + "Platz 3: §" + clantop3.getColor() + clantop3.getTag() + " §8 | §c"
						+ clantop3.getKills() + " Kills §8| §c" + clantop3.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 3: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 3: Niemand");

		if (ClanData.getClans().size() > 3) {

			if (top4kill != 0) {
				ClanData clantop4 = new ClanData(top4);
				p.sendMessage(Data.Prefix + "Platz 4: §" + clantop4.getColor() + clantop4.getTag() + " §8 | §c"
						+ clantop4.getKills() + " Kills §8| §c" + clantop4.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 4: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 4: Niemand");

		if (ClanData.getClans().size() > 4) {
			if (top5kill != 0) {

				ClanData clantop5 = new ClanData(top5);
				p.sendMessage(Data.Prefix + "Platz 5: §" + clantop5.getColor() + clantop5.getTag() + " §8 | §c"
						+ clantop5.getKills() + " Kills §8| §c" + clantop5.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 5: Niemand");

		} else
			p.sendMessage(Data.Prefix + "Platz 5: Niemand");

		if (ClanData.getClans().size() > 5) {
			if (top6kill != 0) {
				ClanData clantop6 = new ClanData(top6);
				p.sendMessage(Data.Prefix + "Platz 6: §" + clantop6.getColor() + clantop6.getTag() + " §8 | §c"
						+ clantop6.getKills() + " Kills §8| §c" + clantop6.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 6: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 6: Niemand");

		if (ClanData.getClans().size() > 6) {
			if (top7kill != 0) {
				ClanData clantop7 = new ClanData(top7);
				p.sendMessage(Data.Prefix + "Platz 7: §" + clantop7.getColor() + clantop7.getTag() + " §8 | §c"
						+ clantop7.getKills() + " Kills §8| §c" + clantop7.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 7: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 7: Niemand");

		if (ClanData.getClans().size() > 7) {
			if (top8kill != 0) {
				ClanData clantop8 = new ClanData(top8);
				p.sendMessage(Data.Prefix + "Platz 8: §" + clantop8.getColor() + clantop8.getTag() + " §8 | §c"
						+ clantop8.getKills() + " Kills §8| §c" + clantop8.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 8: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 8: Niemand");

		if (ClanData.getClans().size() > 8) {
			if (top9kill != 0) {
				ClanData clantop9 = new ClanData(top9);
				p.sendMessage(Data.Prefix + "Platz 9: §" + clantop9.getColor() + clantop9.getTag() + " §8 | §c"
						+ clantop9.getKills() + " Kills §8| §c" + clantop9.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 9: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 9: Niemand");

		if (ClanData.getClans().size() > 9) {
			if (top10kill != 0) {
				ClanData clantop10 = new ClanData(top10);
				p.sendMessage(Data.Prefix + "Platz 10: §" + clantop10.getColor() + clantop10.getTag() + " §8 | §c"
						+ clantop10.getKills() + " Kills §8| §c" + clantop10.getTode() + " Tode");
			} else
				p.sendMessage(Data.Prefix + "Platz 10: Niemand");
		} else
			p.sendMessage(Data.Prefix + "Platz 10: Niemand");
		p.sendMessage(Data.getHeader());

	}

}
