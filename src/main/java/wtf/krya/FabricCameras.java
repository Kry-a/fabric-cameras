package wtf.krya;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.network.OwoNetChannel;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wtf.krya.items.ItemInit;

public class FabricCameras implements ModInitializer {
  public static final String MOD_ID = "fabriccameras";
  public static final Logger LOGGER = LoggerFactory.getLogger("Fabric Cameras");

  public static final OwoNetChannel MY_CHANNEL = OwoNetChannel.create(new Identifier(MOD_ID, "main"));

  public static final OwoItemGroup ITEM_GROUP = OwoItemGroup.builder(new Identifier(MOD_ID, "item_group"), ItemInit.POLAROID_CAMERA::getDefaultStack)
    .displaySingleTab()
    .initializer(group -> group.addTab(Icon.of(Items.SPONGE), "tab_1", null, true))
    .build();

  @Override
  public void onInitialize() {
    FieldRegistrationHandler.register(ItemInit.class, MOD_ID, true);
    ITEM_GROUP.initialize();
  }
}