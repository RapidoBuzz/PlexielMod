package net.mcreator.plexielmod.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.plexielmod.PlexielmodModElements;
import net.mcreator.plexielmod.PlexielmodMod;

import java.util.Map;
import java.util.Iterator;

@PlexielmodModElements.ModElement.Tag
public class PlexrabowQuandUneBalleToucheUneEntiteVivanteProcedure extends PlexielmodModElements.ModElement {
	public PlexrabowQuandUneBalleToucheUneEntiteVivanteProcedure(PlexielmodModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlexielmodMod.LOGGER.warn("Failed to load dependency entity for procedure PlexrabowQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 100);
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("plexielmod:advancementplexrabow_1"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				ArrowEntity entityToSpawn = new ArrowEntity(_ent.world, (LivingEntity) entity);
				entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
				entityToSpawn.setDamage((float) 5);
				entityToSpawn.setKnockbackStrength((int) 5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
	}
}
