package com.br.rededanger.rivaille.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;
import java.util.WeakHashMap;

public class ScoreRegister implements Listener {

	public static WeakHashMap<Player, ScoreBoardAPI> boards;

	static {
		boards = new WeakHashMap<>();

	}

	public static String getUUID() {
		return UUID.randomUUID().toString().substring(0, 6) + UUID.randomUUID().toString().substring(0, 6) + (int) Math.round(Math.random() * 100.0D);

	}

	public static void createScoreBoard(Player player) {
		String UUIDRandom = getUUID();

		ScoreBoardAPI sb = new ScoreBoardAPI("§6§lLobby", UUIDRandom);

		sb.blankLine(10);
		sb.add("§fOlá ", 9);
		sb.add("§fSeu grupo: ", 8);
		sb.blankLine(7);
		sb.add(" Minigames: ", 6);
		sb.add(" Outros: &cOff.", 5);
		sb.blankLine(4);
		sb.add("§fHub: ", 3);
		sb.add("§fJogadores: ", 2);
		sb.blankLine(1);
		sb.add("§e rededanger.com.br", 0);
		sb.build();
		ScoreRegister.boards.remove(player);
		sb.send(player);
		ScoreRegister.boards.put(player, sb);

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		boards.remove(event.getPlayer());

	}

}
