package com.br.rededanger.rivaille.libs;

import com.br.rededanger.rivaille.Danger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TagAPI {

	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player player) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

		Team master = getTeam(sb, "0000Master", "§6[Master] ");
		Team gerente = getTeam(sb, "0001Gerente", "§4[Gerente] ");
		Team admin = getTeam(sb, "0002Admin", "§c[Admin] ");
		Team coord = getTeam(sb, "0003Moderador", "§2[Moderador] ");
		Team moderador = getTeam(sb, "0004Ajudante", "§d[Ajudante] ");
		Team ajudante = getTeam(sb, "0005Youtuber", "§c[YouTuber] ");
		Team youtuber = getTeam(sb, "0006Mitico", "§5[Mítico] ");
		Team ultra = getTeam(sb, "0007Mestre", "§e[Mestre] ");
		Team mvp = getTeam(sb, "0008Elite", "§1[Elite] ");
		Team vip = getTeam(sb, "0009Guerreiro", "§a[Guerreiro] ");
		Team membro = getTeam(sb, "0010Membro", "§7");

		for (Player online : Bukkit.getOnlinePlayers()) {
			if (online.hasPermission("grupo.master")) {
				master.addPlayer(online);

			}else if (online.hasPermission("grupo.gerente")) {
				gerente.addPlayer(player);

			}else if (online.hasPermission("grupo.admin")) {
				admin.addPlayer(player);
				
			}else if (online.hasPermission("grupo.moderador")) {
				coord.addPlayer(player);

			}else if (online.hasPermission("grupo.ajudante")) {
				moderador.addPlayer(player);

			}else if (online.hasPermission("grupo.youtuber")) {
				ajudante.addPlayer(player);
				
			}else if (online.hasPermission("grupo.mitico")) {
				youtuber.addPlayer(player);

			}else if (online.hasPermission("grupo.mestre")) {
				ultra.addPlayer(player);

			}else if (online.hasPermission("grupo.elite")) {
				mvp.addPlayer(player);

			}else if (online.hasPermission("grupo.guerreiro")) {
				vip.addPlayer(player);

			}else {
				membro.addPlayer(player);

			}

		}

		player.setScoreboard(sb);

	}

	@SuppressWarnings("deprecation")
	public static void updateScoreboard(Player player) {
		if (player.getScoreboard() == null) {
			setScoreboard(player);

		}

		Scoreboard sb = player.getScoreboard();

		Team master = getTeam(sb, "0000Master", "§6[Master] ");
		Team gerente = getTeam(sb, "0001Gerente", "§4[Gerente] ");
		Team admin = getTeam(sb, "0002Admin", "§c[Admin] ");
		Team coord = getTeam(sb, "0003Moderador", "§2[Moderador] ");
		Team moderador = getTeam(sb, "0004Ajudante", "§d[Ajudante] ");
		Team ajudante = getTeam(sb, "0005Youtuber", "§c[YouTuber] ");
		Team youtuber = getTeam(sb, "0006Mitico", "§5[Mítico] ");
		Team ultra = getTeam(sb, "0007Mestre", "§e[Mestre] ");
		Team mvp = getTeam(sb, "0008Elite", "§1[Elite] ");
		Team vip = getTeam(sb, "0009Guerreiro", "§a[Guerreiro] ");
		Team membro = getTeam(sb, "0010Membro", "§7");

		for (Player online : Bukkit.getOnlinePlayers()) {
			if (online.hasPermission("grupo.master")) {
				master.addPlayer(online);

			}else if (online.hasPermission("grupo.gerente")) {
				gerente.addPlayer(player);

			}else if (online.hasPermission("grupo.admin")) {
				admin.addPlayer(player);

			}else if (online.hasPermission("grupo.moderador")) {
				coord.addPlayer(player);

			}else if (online.hasPermission("grupo.ajudante")) {
				moderador.addPlayer(player);

			}else if (online.hasPermission("grupo.youtuber")) {
				ajudante.addPlayer(player);

			}else if (online.hasPermission("grupo.mitico")) {
				youtuber.addPlayer(player);

			}else if (online.hasPermission("grupo.mestre")) {
				ultra.addPlayer(player);

			}else if (online.hasPermission("grupo.elite")) {
				mvp.addPlayer(player);

			}else if (online.hasPermission("grupo.guerreiro")) {
				vip.addPlayer(player);

			}else {
				membro.addPlayer(player);

			}

		}

	}

	public static Team getTeam(Scoreboard sb, String Team, String prefix) {
		Team team = sb.getTeam(Team);
		if (team == null) {
			team = sb.registerNewTeam(Team);

		}

		team.setPrefix(prefix);
		team.setAllowFriendlyFire(true);
		team.setCanSeeFriendlyInvisibles(true);

		return team;

	}

	public static void updateTeam(Scoreboard sb, String Team, String prefix, ChatColor entry) {
		Team team = sb.getTeam(Team);
		if (team == null) {
			team = sb.registerNewTeam(Team);

		}

		team.setPrefix(prefix);
		team.addEntry(entry.toString());

	}

	public static void startScheduler() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player online : Bukkit.getOnlinePlayers()) {
					updateScoreboard(online);

				}

			}

		}.runTaskTimer(Danger.getInstance(), 20, 20);

	}

}
