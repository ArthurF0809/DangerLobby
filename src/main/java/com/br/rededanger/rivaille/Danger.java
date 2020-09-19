package com.br.rededanger.rivaille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.io.ByteArrayDataInput;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.br.rededanger.rivaille.commands.BuildCommand;
import com.br.rededanger.rivaille.libs.ItemBuild;
import com.br.rededanger.rivaille.libs.TagAPI;
import com.br.rededanger.rivaille.listeners.Listeners;
import com.br.rededanger.rivaille.listeners.Protection;
import com.br.rededanger.rivaille.menus.Menus;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Danger extends JavaPlugin implements PluginMessageListener {

	public static Danger instance;
	public static Plugin plugin;

	private static Map<String, Integer> serverCount = new HashMap<String, Integer>();

	public static String permGlobal = "lobby.*";
	public static String noPerm = "§cVocê não tem permissão.";

	public static List<String> jogadores = Lists.newArrayList();
	public static ArrayList<Player> build = new ArrayList<Player>();

	public Danger() {
		plugin = this;
		instance = this;

	}

	public static Danger getInstance() {
		return instance;

	}

	public static Plugin getPlugin() {
		return plugin;

	}

	public void onEnable() {
		ConsoleCommandSender cs = Bukkit.getConsoleSender();
		cs.sendMessage("§6Rede Danger §f- §aVersion §f1.0");
		cs.sendMessage(" ");
		cs.sendMessage("Plugin: §lLobby");
		cs.sendMessage("Autor: §l" + getDescription().getAuthors());
		cs.sendMessage(" ");
		cs.sendMessage(" §aPlugin iniciando, carregando listeners.");
		cs.sendMessage("§a[§l||||||||||||§a]99%");

		TagAPI.startScheduler();

		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ItemBuild(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Menus(), this);

		getCommand("build").setExecutor(new BuildCommand());

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				for(World world : Bukkit.getServer().getWorlds()){
					world.setTime(5000L);

				}

			}

		}, 0L, 10000L);

	}

	public static void sendServer(Player player, String serverName) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(serverName);
		player.sendPluginMessage(getInstance(), "BungeeCord", out.toByteArray());

	}

	int count = 1;

	public static int getPlayersFromServer(String serverName) {
		if (serverCount.containsKey(serverName.toLowerCase())) {
			return serverCount.get(serverName.toLowerCase());

		}
		return 0;

	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) {
			return;
		}
		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();
		if (subchannel.equals("SomeSubChannel")) {
			// Use the code sample in the 'Response' sections below to read
			// the data.
		}
	}

}
