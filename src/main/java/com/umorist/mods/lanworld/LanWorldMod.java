package com.umorist.mods.lanworld;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = LanWorldMod.MODID, name = LanWorldMod.NAME, version = LanWorldMod.VERSION)
public class LanWorldMod {
    public static final String MODID = "lanworld";
    public static final String NAME = "LAN World Plug-n-Play";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("LAN World Mod Pre-Initialization");
        logger.info("Регистрация обработчиков событий...");
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        logger.info("LAN World Mod Initialization Complete");
        logger.info("Мод готов к использованию");
    }
}
