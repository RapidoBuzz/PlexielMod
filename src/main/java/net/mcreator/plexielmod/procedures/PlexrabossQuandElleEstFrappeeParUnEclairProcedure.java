package net.mcreator.plexielmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.plexielmod.PlexielmodModElements;
import net.mcreator.plexielmod.PlexielmodMod;

import java.util.Map;

@PlexielmodModElements.ModElement.Tag
public class PlexrabossQuandElleEstFrappeeParUnEclairProcedure extends PlexielmodModElements.ModElement {
	public PlexrabossQuandElleEstFrappeeParUnEclairProcedure(PlexielmodModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency entity for procedure PlexrabossQuandElleEstFrappeeParUnEclair!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
	}
}
