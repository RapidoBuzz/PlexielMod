
package net.mcreator.plexielmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.plexielmod.itemgroup.OngletplexielmodItemGroup;
import net.mcreator.plexielmod.PlexielmodModElements;

import java.util.List;

@PlexielmodModElements.ModElement.Tag
public class PlexraShovelItem extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:plexra_shovel")
	public static final Item block = null;
	public PlexraShovelItem(PlexielmodModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 100000f;
			}

			public float getAttackDamage() {
				return -2f;
			}

			public int getHarvestLevel() {
				return 1000;
			}

			public int getEnchantability() {
				return 10000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlexirepairitemarmortoolItem.block, (int) (1)));
			}
		}, 1, 16f, new Item.Properties().group(OngletplexielmodItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("La pelle ultime!"));
			}
		}.setRegistryName("plexra_shovel"));
	}
}
