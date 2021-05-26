
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
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.plexielmod.itemgroup.PlexielModCreatifItemGroup;
import net.mcreator.plexielmod.PlexielmodModElements;

import java.util.List;

@PlexielmodModElements.ModElement.Tag
public class PlexirepairitemarmortoolItem extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:plexirepairitemarmortool")
	public static final Item block = null;
	public PlexirepairitemarmortoolItem(PlexielmodModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 100000f;
			}

			public float getAttackDamage() {
				return 99998f;
			}

			public int getHarvestLevel() {
				return 100000;
			}

			public int getEnchantability() {
				return 100000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlexirepairitemarmortoolItem.block, (int) (1)));
			}
		}, 3, 96f, new Item.Properties().group(PlexielModCreatifItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Reparer l'armure de Plexi"));
			}
		}.setRegistryName("plexirepairitemarmortool"));
	}
}
