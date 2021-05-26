
package net.mcreator.plexielmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.plexielmod.procedures.PlexrafoodQuandLaNourritureEstMangeeProcedure;
import net.mcreator.plexielmod.itemgroup.OngletplexielmodItemGroup;
import net.mcreator.plexielmod.PlexielmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@PlexielmodModElements.ModElement.Tag
public class PlexrafoodItem extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:plexrafood")
	public static final Item block = null;
	public PlexrafoodItem(PlexielmodModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(OngletplexielmodItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(1000).saturation(1000f).setAlwaysEdible().build()));
			setRegistryName("plexrafood");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("La nourriture ULTIME!! (Mieux qu'un pomme de notch)."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PlexrafoodQuandLaNourritureEstMangeeProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
