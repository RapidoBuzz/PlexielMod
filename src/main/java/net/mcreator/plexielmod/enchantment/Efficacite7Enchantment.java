
package net.mcreator.plexielmod.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Blocks;

import net.mcreator.plexielmod.item.PlexrapickaxeItem;
import net.mcreator.plexielmod.item.PlexraSwordItem;
import net.mcreator.plexielmod.item.PlexraShovelItem;
import net.mcreator.plexielmod.item.PlexraAxeItem;
import net.mcreator.plexielmod.item.PlexielDimensionmodItem;
import net.mcreator.plexielmod.PlexielmodModElements;

@PlexielmodModElements.ModElement.Tag
public class Efficacite7Enchantment extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:ignition")
	public static final Enchantment enchantment = null;
	public Efficacite7Enchantment(PlexielmodModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("ignition"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.DIGGER, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 10;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.PROTECTION)
				return true;
			if (ench == Enchantments.FIRE_PROTECTION)
				return true;
			if (ench == Enchantments.FEATHER_FALLING)
				return true;
			if (ench == Enchantments.BLAST_PROTECTION)
				return true;
			if (ench == Enchantments.PROJECTILE_PROTECTION)
				return true;
			if (ench == Enchantments.RESPIRATION)
				return true;
			if (ench == Enchantments.AQUA_AFFINITY)
				return true;
			if (ench == Enchantments.THORNS)
				return true;
			if (ench == Enchantments.DEPTH_STRIDER)
				return true;
			if (ench == Enchantments.FROST_WALKER)
				return true;
			if (ench == Enchantments.BINDING_CURSE)
				return true;
			if (ench == Enchantments.SHARPNESS)
				return true;
			if (ench == Enchantments.SMITE)
				return true;
			if (ench == Enchantments.BANE_OF_ARTHROPODS)
				return true;
			if (ench == Enchantments.KNOCKBACK)
				return true;
			if (ench == Enchantments.FIRE_ASPECT)
				return true;
			if (ench == Enchantments.LOOTING)
				return true;
			if (ench == Enchantments.SWEEPING)
				return true;
			if (ench == Enchantments.EFFICIENCY)
				return true;
			if (ench == Enchantments.SILK_TOUCH)
				return true;
			if (ench == Enchantments.UNBREAKING)
				return true;
			if (ench == Enchantments.FORTUNE)
				return true;
			if (ench == Enchantments.POWER)
				return true;
			if (ench == Enchantments.PUNCH)
				return true;
			if (ench == Enchantments.FLAME)
				return true;
			if (ench == Enchantments.INFINITY)
				return true;
			if (ench == Enchantments.LUCK_OF_THE_SEA)
				return true;
			if (ench == Enchantments.LURE)
				return true;
			if (ench == Enchantments.LOYALTY)
				return true;
			if (ench == Enchantments.IMPALING)
				return true;
			if (ench == Enchantments.RIPTIDE)
				return true;
			if (ench == Enchantments.CHANNELING)
				return true;
			if (ench == Enchantments.MULTISHOT)
				return true;
			if (ench == Enchantments.QUICK_CHARGE)
				return true;
			if (ench == Enchantments.PIERCING)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			if (ench == Enchantments.SOUL_SPEED)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(PlexielDimensionmodItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlexraShovelItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlexrapickaxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlexraAxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Blocks.NETHER_GOLD_ORE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_SHOVEL, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_SHOVEL, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_SHOVEL, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_SHOVEL, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_SHOVEL, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlexraSwordItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_SWORD, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
