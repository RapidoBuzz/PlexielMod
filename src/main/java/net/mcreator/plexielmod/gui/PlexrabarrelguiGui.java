
package net.mcreator.plexielmod.gui;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.ScreenManager;

import net.mcreator.plexielmod.PlexielmodModElements;
import net.mcreator.plexielmod.PlexielmodMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@PlexielmodModElements.ModElement.Tag
public class PlexrabarrelguiGui extends PlexielmodModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public PlexrabarrelguiGui(PlexielmodModElements instance) {
		super(instance, 70);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
	}
	private static class ContainerRegisterHandler {
		@SubscribeEvent
		public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(containerType.setRegistryName("plexrabarrelgui"));
		}
	}
	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, PlexrabarrelguiGuiWindow::new));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		World world;
		PlayerEntity entity;
		int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(96);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
			if (pos != null) {
				if (extraData.readableBytes() == 1) { // bound to item
					byte hand = extraData.readByte();
					ItemStack itemstack;
					if (hand == 0)
						itemstack = this.entity.getHeldItemMainhand();
					else
						itemstack = this.entity.getHeldItemOffhand();
					itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				} else if (extraData.readableBytes() > 1) {
					extraData.readByte(); // drop padding
					Entity entity = world.getEntityByID(extraData.readVarInt());
					if (entity != null)
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
				} else { // might be bound to block
					TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
					if (ent != null) {
						ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
					}
				}
			}
			this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 23, 15) {
			}));
			this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 41, 15) {
			}));
			this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 59, 15) {
			}));
			this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 77, 15) {
			}));
			this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 95, 15) {
			}));
			this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 113, 15) {
			}));
			this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 131, 15) {
			}));
			this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 148, 70) {
			}));
			this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 149, 15) {
			}));
			this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 167, 15) {
			}));
			this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 5, 34) {
			}));
			this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 23, 34) {
			}));
			this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 41, 34) {
			}));
			this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 59, 34) {
			}));
			this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 77, 34) {
			}));
			this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 95, 34) {
			}));
			this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 113, 34) {
			}));
			this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 77, 52) {
			}));
			this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 131, 52) {
			}));
			this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 149, 52) {
			}));
			this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 167, 52) {
			}));
			this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 5, 70) {
			}));
			this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 23, 70) {
			}));
			this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 41, 70) {
			}));
			this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 59, 70) {
			}));
			this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 77, 70) {
			}));
			this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 95, 70) {
			}));
			this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 113, 70) {
			}));
			this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 131, 70) {
			}));
			this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 5, 15) {
			}));
			this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 167, 70) {
			}));
			this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 5, 88) {
			}));
			this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 23, 88) {
			}));
			this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 41, 88) {
			}));
			this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 59, 88) {
			}));
			this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 77, 88) {
			}));
			this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 95, 88) {
			}));
			this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 113, 88) {
			}));
			this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 131, 88) {
			}));
			this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 149, 88) {
			}));
			this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 167, 88) {
			}));
			this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 5, 106) {
			}));
			this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 23, 106) {
			}));
			this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 41, 106) {
			}));
			this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 59, 106) {
			}));
			this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 77, 106) {
			}));
			this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 95, 106) {
			}));
			this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 113, 106) {
			}));
			this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 131, 106) {
			}));
			this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 149, 106) {
			}));
			this.customSlots.put(65, this.addSlot(new SlotItemHandler(internal, 65, 167, 106) {
			}));
			this.customSlots.put(66, this.addSlot(new SlotItemHandler(internal, 66, 5, 124) {
			}));
			this.customSlots.put(67, this.addSlot(new SlotItemHandler(internal, 67, 23, 124) {
			}));
			this.customSlots.put(68, this.addSlot(new SlotItemHandler(internal, 68, 41, 124) {
			}));
			this.customSlots.put(69, this.addSlot(new SlotItemHandler(internal, 69, 59, 124) {
			}));
			this.customSlots.put(70, this.addSlot(new SlotItemHandler(internal, 70, 77, 124) {
			}));
			this.customSlots.put(71, this.addSlot(new SlotItemHandler(internal, 71, 95, 124) {
			}));
			this.customSlots.put(72, this.addSlot(new SlotItemHandler(internal, 72, 113, 124) {
			}));
			this.customSlots.put(73, this.addSlot(new SlotItemHandler(internal, 73, 131, 124) {
			}));
			this.customSlots.put(74, this.addSlot(new SlotItemHandler(internal, 74, 149, 124) {
			}));
			this.customSlots.put(75, this.addSlot(new SlotItemHandler(internal, 75, 167, 124) {
			}));
			this.customSlots.put(76, this.addSlot(new SlotItemHandler(internal, 76, 5, 143) {
			}));
			this.customSlots.put(77, this.addSlot(new SlotItemHandler(internal, 77, 23, 143) {
			}));
			this.customSlots.put(78, this.addSlot(new SlotItemHandler(internal, 78, 41, 143) {
			}));
			this.customSlots.put(79, this.addSlot(new SlotItemHandler(internal, 79, 59, 143) {
			}));
			this.customSlots.put(80, this.addSlot(new SlotItemHandler(internal, 80, 77, 143) {
			}));
			this.customSlots.put(81, this.addSlot(new SlotItemHandler(internal, 81, 95, 143) {
			}));
			this.customSlots.put(82, this.addSlot(new SlotItemHandler(internal, 82, 113, 143) {
			}));
			this.customSlots.put(83, this.addSlot(new SlotItemHandler(internal, 83, 131, 143) {
			}));
			this.customSlots.put(84, this.addSlot(new SlotItemHandler(internal, 84, 149, 143) {
			}));
			this.customSlots.put(85, this.addSlot(new SlotItemHandler(internal, 85, 167, 143) {
			}));
			this.customSlots.put(86, this.addSlot(new SlotItemHandler(internal, 86, 167, 34) {
			}));
			this.customSlots.put(87, this.addSlot(new SlotItemHandler(internal, 87, 131, 34) {
			}));
			this.customSlots.put(88, this.addSlot(new SlotItemHandler(internal, 88, 149, 34) {
			}));
			this.customSlots.put(89, this.addSlot(new SlotItemHandler(internal, 89, -185, 92) {
			}));
			this.customSlots.put(90, this.addSlot(new SlotItemHandler(internal, 90, 113, 52) {
			}));
			this.customSlots.put(91, this.addSlot(new SlotItemHandler(internal, 91, 95, 52) {
			}));
			this.customSlots.put(92, this.addSlot(new SlotItemHandler(internal, 92, 59, 52) {
			}));
			this.customSlots.put(93, this.addSlot(new SlotItemHandler(internal, 93, 41, 52) {
			}));
			this.customSlots.put(94, this.addSlot(new SlotItemHandler(internal, 94, 23, 52) {
			}));
			this.customSlots.put(95, this.addSlot(new SlotItemHandler(internal, 95, 5, 52) {
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 14 + 8 + sj * 18, 79 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 14 + 8 + si * 18, 79 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 81) {
					if (!this.mergeItemStack(itemstack1, 81, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 81, false)) {
					if (index < 81 + 27) {
						if (!this.mergeItemStack(itemstack1, 81 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 81, 81 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			if (!bound && (playerIn instanceof ServerPlayerEntity)) {
				if (!playerIn.isAlive() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity) playerIn).hasDisconnected()) {
					for (int j = 0; j < internal.getSlots(); ++j) {
						playerIn.dropItem(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
					}
				} else {
					for (int i = 0; i < internal.getSlots(); ++i) {
						playerIn.inventory.placeItemBackInInventory(playerIn.world,
								internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
					}
				}
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote()) {
				PlexielmodMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
