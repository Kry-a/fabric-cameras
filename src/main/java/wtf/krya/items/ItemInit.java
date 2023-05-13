package wtf.krya.items;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import wtf.krya.FabricCameras;

public class ItemInit implements ItemRegistryContainer {
  public static final Item POLAROID_CAMERA = new PolaroidCameraItem();
  public static final Item CAMERA_FILM = new Item(new OwoItemSettings().group(FabricCameras.ITEM_GROUP));
}
