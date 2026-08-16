package com.umorist.mods.lanworld.network;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class LANWorldHandler {

    @SubscribeEvent
    public static void onServerConnect(FMLNetworkEvent.ServerConnectionFromClientEvent event) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (server != null && server.getNetworkSystem() != null) {
            System.out.println("[LAN World] Игрок подключился к вашему миру");
        }
    }

    @SubscribeEvent
    public static void onServerDisconnect(FMLNetworkEvent.ServerDisconnectionFromClientEvent event) {
        System.out.println("[LAN World] Игрок покинул мир");
    }
}
