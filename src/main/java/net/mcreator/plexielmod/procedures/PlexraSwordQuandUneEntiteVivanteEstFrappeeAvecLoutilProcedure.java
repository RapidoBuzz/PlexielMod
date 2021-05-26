package net.mcreator.plexielmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.plexielmod.enchantment.LifestealEnchantment;
import net.mcreator.plexielmod.PlexielmodModElements;
import net.mcreator.plexielmod.PlexielmodMod;

import java.util.Map;

@PlexielmodModElements.ModElement.Tag
public class PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure extends PlexielmodModElements.ModElement {
	public PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure(PlexielmodModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PlexielmodMod.LOGGER
						.warn("Failed to load dependency sourceentity for procedure PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency itemstack for procedure PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((EnchantmentHelper.getEnchantmentLevel(LifestealEnchantment.enchantment, (itemstack))) == 1)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 15, (int) 1));
		} else if (((EnchantmentHelper.getEnchantmentLevel(LifestealEnchantment.enchantment, (itemstack))) == 2)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 10, (int) 1));
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 2));
		}
	}
}
