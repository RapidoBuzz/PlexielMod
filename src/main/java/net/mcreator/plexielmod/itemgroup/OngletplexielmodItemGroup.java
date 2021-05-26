
package net.mcreator.plexielmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.plexielmod.item.PlexraSwordItem;
import net.mcreator.plexielmod.PlexielmodModElements;

@PlexielmodModElements.ModElement.Tag
public class OngletplexielmodItemGroup extends PlexielmodModElements.ModElement {
	public OngletplexielmodItemGroup(PlexielmodModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplexielmod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlexraSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
