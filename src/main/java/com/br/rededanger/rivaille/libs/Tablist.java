package com.br.rededanger.rivaille.libs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class Tablist {
	public static Class<?> getNmsClass(String nmsClassName)
			throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);

	}

	public static String getServerVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().substring(23);

	}

	public static void sendTablist(Player player, String message, String message2) {
		try {
			if ((getServerVersion().equalsIgnoreCase("v1_9_R1")) ||
					(getServerVersion().equalsIgnoreCase("v1_9_R2"))) {
				Object header = getNmsClass("ChatComponentText").getConstructor(new Class[]{String.class}).newInstance(new Object[]{ChatColor.translateAlternateColorCodes('&', message)});
				Object footer = getNmsClass("ChatComponentText").getConstructor(new Class[]{String.class}).newInstance(new Object[]{ChatColor.translateAlternateColorCodes('&', message2)});

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{header});

				Field field = ppoplhf.getClass().getDeclaredField("b");
				field.setAccessible(true);
				field.set(ppoplhf, footer);

				Object nmsp = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, new Object[]{ppoplhf});

			}else if ((getServerVersion().equalsIgnoreCase("v1_8_R2")) ||
					(getServerVersion().equalsIgnoreCase("v1_8_R3"))) {
				Object header = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + message + "'}"});
				Object footer = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + message2 + "'}"});

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{header});

				Field field = ppoplhf.getClass().getDeclaredField("b");
				field.setAccessible(true);
				field.set(ppoplhf, footer);

				Object nmsp = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, new Object[]{ppoplhf});

			}else {
				Object header = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + message + "'}"});
				Object footer = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + message2 + "'}"});

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{header});

				Field field = ppoplhf.getClass().getDeclaredField("b");
				field.setAccessible(true);
				field.set(ppoplhf, footer);

				Object nmsp = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(pcon, new Object[]{ppoplhf});

			}

		}catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException event) {
			event.printStackTrace();

		}

	}

}
