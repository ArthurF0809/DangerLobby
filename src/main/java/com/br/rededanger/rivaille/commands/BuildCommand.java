package com.br.rededanger.rivaille.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.br.rededanger.rivaille.Danger;

public class BuildCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;

		}

		Player player = (Player) sender;

		if (command.getName().equalsIgnoreCase("build")) {
			if (player.hasPermission("lobby.build") || player.hasPermission(Danger.permGlobal)) {
				if (!Danger.build.contains(player)) {
					Danger.build.add(player);
					player.getInventory().clear();
					player.sendMessage("§7O modo construção foi §cativado§7, tome cuidado.");
					player.setGameMode(GameMode.CREATIVE);
					return true;

				}else {
					Danger.build.remove(player);
					player.kickPlayer("\n\n §e§lCONSTRUÇÃO \n§7O modo construção foi §adesativado§7 com sucesso!\n�7Voc� pode retornar ao servidor.");
					return true;

				}

			}else {
				player.sendMessage(Danger.noPerm);
				return true;

			}

		}

		return false;

	}

}
