package com.br.rededanger.rivaille.scoreboard;

import com.br.rededanger.rivaille.Danger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.br.rededanger.rivaille.libs.Groups;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ScoreUpdater extends BukkitRunnable {

	@SuppressWarnings("unused")
	public static void setName(Player player, String s) {
		Utils INFO = new Utils(player);
		ScoreBoardAPI sb = ScoreRegister.boards.get(player);

		if (sb == null)
			return;

		sb.setDisplayName(s);

	}

	public static void updateScoreBoard(Player player) {
		ScoreBoardAPI sb = ScoreRegister.boards.get(player);

		if (sb == null)
			return;

		sb.update("§7" + player.getName(), 9);
		sb.update("§7" + Groups.getNameColor(player), 8);
		sb.update("§b#1", 3);
		sb.update("§e" + Danger.getPlayersFromServer("skywars"), 2);

	}

	@Override
	public void run() {
		Iterator<Player> iter = ScoreRegister.boards.keySet().iterator();

		try {
			while (iter.hasNext()) {
				Player player = iter.next();
				updateScoreBoard(player);

			}

		} catch (ConcurrentModificationException e) {}

	}

}
