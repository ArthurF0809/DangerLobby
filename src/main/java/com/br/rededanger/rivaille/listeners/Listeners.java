package com.br.rededanger.rivaille.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.br.rededanger.rivaille.Danger;
import com.br.rededanger.rivaille.libs.Groups;
import com.br.rededanger.rivaille.libs.ItemBuild;
import com.br.rededanger.rivaille.libs.Manager;
import com.br.rededanger.rivaille.libs.Tablist;
import com.br.rededanger.rivaille.libs.TagAPI;
import com.br.rededanger.rivaille.scoreboard.ScoreRegister;
import com.br.rededanger.rivaille.scoreboard.ScoreUpdater;

public class Listeners implements Listener {

	String[] badWords = {"cuz�o", "cuzao", "cuzaum", "filha da puta", "fela da puta",
			"fdp", "fia da puta", "fih da puta", "fi da puta", "fdpta",
			"vai tomar no cu", "vtnc", "vai toma no cu", "vai toma no olho do seu cu",
			"toma no cu", "tnc", "vai se foder", "vai se fuder", "vai se fode", "vai se fude",
			"va se foder", "va se fuder", "va se fode", "va se fude", "se fode", "se fude" };

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		TagAPI.setScoreboard(player);

		Location location = new Location(Bukkit.getWorld("world"), 0.484, 148, 0.492);
		location.setPitch(-0.1f);
		location.setYaw(-90.0f);
		player.teleport(location);
		Danger.build.remove(player);
		player.getInventory().clear();
		Manager.players.put(player, "ativado");
		Tablist.sendTablist(player,"§6§lDANGER\n§fwww.rededanger.com.br\n",
				"\n§eDiscord: §fdangr.me/discord\n§eLoja: §fdangr.me/loja\n\n§eAdquira VIPs e créditos acessando §floja.rededanger.com.br");
		player.setHealth(20);
		player.setHealthScale(2);
		player.setFoodLevel(20);
		player.setGameMode(GameMode.ADVENTURE);
		ItemBuild.send(player);

		ScoreRegister.boards.remove(event.getPlayer().getPlayer());
		new BukkitRunnable() {

			@Override
			public void run() {
				ScoreRegister.createScoreBoard(event.getPlayer().getPlayer());
				ScoreUpdater.updateScoreBoard(event.getPlayer().getPlayer());

			}

		}.runTask(Danger.getInstance());

		if(player.hasPermission("lobby.vip") || player.hasPermission(Danger.permGlobal)) {
			event.setJoinMessage(Groups.getGroup(player) + player.getName() + " §6entrou neste lobby!");
			player.setAllowFlight(true);

		}else {
			event.setJoinMessage(null);
		}

	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();

		String member = event.getMessage().substring(0, 1).toUpperCase() + event.getMessage().substring(1).toLowerCase();
		String vip = event.getMessage().replace("&", "§").substring(0, 1).toUpperCase() + event.getMessage().replace("&", "§").substring(1).toLowerCase();
		String staff = event.getMessage().replace("&", "§");

		if (staff.contains("%") || vip.contains("%") || member.contains("%")) {
			event.setCancelled(true);
			player.playSound((Location) player.getLocation().getWorld(), Sound.BURP, 5.0f, 5.0f);

		}

		if (player.hasPermission("lobby.staff")) {
			event.setFormat(Groups.getGroup(player) + event.getPlayer().getDisplayName() + "§7: §f" + staff);

		}else if (player.hasPermission("lobby.vip")) {
			event.setFormat(Groups.getGroup(player) + event.getPlayer().getDisplayName() + "§7: §f" + vip);

		}else {
			event.setFormat(Groups.getGroup(player) + event.getPlayer().getDisplayName() + "§7: " + member);

		}

	}

}
