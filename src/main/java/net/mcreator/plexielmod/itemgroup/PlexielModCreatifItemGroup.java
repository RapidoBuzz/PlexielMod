
package net.mcreator.plexielmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.plexielmod.item.PlexirepairitemarmortoolItem;
import net.mcreator.plexielmod.PlexielmodModElements;

@PlexielmodModElements.ModElement.Tag
public class PlexielModCreatifItemGroup extends PlexielmodModElements.ModElement {
	public PlexielModCreatifItemGroup(PlexielmodModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplexiel_mod_creatif") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlexirepairitemarmortoolItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
