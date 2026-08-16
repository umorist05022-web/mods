package com.umorist.mods.weaponsmod.item;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;

public class CustomKnife extends ItemSword {
    private float damage;
    private float speed;

    public CustomKnife(String name, float damage, float speed) {
        super(ToolMaterial.IRON);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.damage = damage;
        this.speed = speed;
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            String knifeName = this.getUnlocalizedName().replace("item.", "").replace("_knife", "");
            playerIn.sendMessage(new net.minecraft.util.text.TextComponentString(
                "§a" + knifeName.toUpperCase() + " готов! Урон: " + this.damage + " | Скорость: " + this.speed));
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        target.attackEntityFrom(net.minecraft.util.DamageSource.causePlayerDamage((EntityPlayer) attacker), this.damage);
        
        // Добавляем эффект скорости при попадании
        target.addVelocity(0, 0.1, 0);
        
        return true;
    }

    public float getDamage() {
        return this.damage;
    }

    public float getSpeed() {
        return this.speed;
    }
}
