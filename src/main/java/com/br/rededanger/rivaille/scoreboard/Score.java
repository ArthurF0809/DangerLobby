package com.br.rededanger.rivaille.scoreboard;

import org.bukkit.Bukkit;

import com.br.rededanger.rivaille.Danger;

public class Score {

	public static void register() {
		registerListeners();
		loadScoreTask();

	}

	public static void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new ScoreRegister(), Danger.getPlugin());

	}

	public static void loadScoreTask() {
		Bukkit.getOnlinePlayers().forEach(p -> {
			ScoreRegister.createScoreBoard(p);

		});
		new ScoreUpdater().runTaskTimerAsynchronously(Danger.getInstance(), 40L, 20L * 4);

	}

}
