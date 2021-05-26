
package net.mcreator.plexielmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.plexielmod.procedures.PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure;
import net.mcreator.plexielmod.itemgroup.OngletplexielmodItemGroup;
import net.mcreator.plexielmod.PlexielmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@PlexielmodModElements.ModElement.Tag
public class PlexraSwordItem extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:plexra_sword")
	public static final Item block = null;
	public PlexraSwordItem(PlexielmodModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 40f;
			}

			public float getAttackDamage() {
				return 151f;
			}

			public int getHarvestLevel() {
				return 100;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlexirepairitemarmortoolItem.block, (int) (1)));
			}
		}, 3, 6f, new Item.Properties().group(OngletplexielmodItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00C9p\u00E9e Ultime"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("sourceentity", sourceentity);
					$_dependencies.put("itemstack", itemstack);
					PlexraSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("plexra_sword"));
	}
}
