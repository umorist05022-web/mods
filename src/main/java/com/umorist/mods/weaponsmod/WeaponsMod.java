package com.umorist.mods.weaponsmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import com.umorist.mods.weaponsmod.item.WeaponRegistry;

@Mod(modid = WeaponsMod.MODID, name = WeaponsMod.NAME, version = WeaponsMod.VERSION)
public class WeaponsMod {
    public static final String MODID = "weaponsmod";
    public static final String NAME = "Weapons Mod";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Weapons Mod Pre-Initialization");
        logger.info("Регистрация оружия...");
        WeaponRegistry.registerItems();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        logger.info("Weapons Mod Initialization Complete");
        logger.info("Доступно оружие:");
        logger.info("- Снайперские винтовки (SVD, AWP, Barrett)");
        logger.info("- Ножи (Бабочка, Керамбит, М9)");
        logger.info("- Пистолеты и автоматы");
    }
}
