
package net.mcreator.plexielmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.plexielmod.itemgroup.OngletplexielmodItemGroup;
import net.mcreator.plexielmod.PlexielmodModElements;

import java.util.List;

@PlexielmodModElements.ModElement.Tag
public class FuzeIiIroulettepaladienneItem extends PlexielmodModElements.ModElement {
	@ObjectHolder("plexielmod:fuze_ii_iroulettepaladienne")
	public static final Item block = null;
	public FuzeIiIroulettepaladienneItem(PlexielmodModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, PlexielmodModElements.sounds.get(new ResourceLocation("plexielmod:fuze_roulette_paladienne")),
					new Item.Properties().group(OngletplexielmodItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("fuze_ii_iroulettepaladienne");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("FUZE - C'EST LA ROULETTE PALADIENNE (Musique Compl\u00E8te)"));
		}
	}
}
