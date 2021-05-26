package net.mcreator.plexielmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;

import net.mcreator.plexielmod.PlexielmodModElements;
import net.mcreator.plexielmod.PlexielmodMod;

import java.util.Map;

@PlexielmodModElements.ModElement.Tag
public class PlexrabowPendantQueLesBallesVolentParTickProcedure extends PlexielmodModElements.ModElement {
	public PlexrabowPendantQueLesBallesVolentParTickProcedure(PlexielmodModElements instance) {
		super(instance, 52);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency x for procedure PlexrabowPendantQueLesBallesVolentParTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency y for procedure PlexrabowPendantQueLesBallesVolentParTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency z for procedure PlexrabowPendantQueLesBallesVolentParTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency world for procedure PlexrabowPendantQueLesBallesVolentParTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("plexielmod:plexi_armor_equip")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("plexielmod:plexi_armor_equip")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
	}
}
