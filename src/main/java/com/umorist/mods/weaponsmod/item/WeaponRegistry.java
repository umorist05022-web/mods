package com.umorist.mods.weaponsmod.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class WeaponRegistry {

    // Снайперские винтовки
    public static Item svdRifle;
    public static Item awpRifle;
    public static Item barrettRifle;

    // Ножи
    public static Item butterflyKnife;
    public static Item karambitKnife;
    public static Item m9Knife;

    // Боеприпасы
    public static Item rifleAmmo;
    public static Item pistolAmmo;

    public static void registerItems() {
        // Регистрация снайперских винтовок
        svdRifle = new SniperRifle("svd_rifle", 8.0f, 20, 50);
        awpRifle = new SniperRifle("awp_rifle", 10.0f, 30, 40);
        barrettRifle = new SniperRifle("barrett_rifle", 12.0f, 50, 30);

        // Регистрация ножей
        butterflyKnife = new CustomKnife("butterfly_knife", 6.0f, 0.8f);
        karambitKnife = new CustomKnife("karambit_knife", 5.0f, 1.0f);
        m9Knife = new CustomKnife("m9_knife", 5.5f, 0.9f);

        // Регистрация боеприпасов
        rifleAmmo = new Item();
        rifleAmmo.setUnlocalizedName("rifle_ammo");

        pistolAmmo = new Item();
        pistolAmmo.setUnlocalizedName("pistol_ammo");
    }
}
