package com.umorist.mods.weaponsmod.item;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;

public class SniperRifle extends ItemSword {
    private float damage;
    private int fireRate;
    private int ammoCapacity;

    public SniperRifle(String name, float damage, int fireRate, int ammoCapacity) {
        super(ToolMaterial.DIAMOND);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.damage = damage;
        this.fireRate = fireRate;
        this.ammoCapacity = ammoCapacity;
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            playerIn.sendMessage(new net.minecraft.util.text.TextComponentString(
                "§6Снайпер готов! Урон: " + this.damage + " | Боеприпасов: " + this.ammoCapacity));
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        target.attackEntityFrom(net.minecraft.util.DamageSource.causePlayerDamage((EntityPlayer) attacker), this.damage);
        return true;
    }

    public float getDamage() {
        return this.damage;
    }

    public int getFireRate() {
        return this.fireRate;
    }

    public int getAmmoCapacity() {
        return this.ammoCapacity;
    }
}
