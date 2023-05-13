package wtf.krya.items;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import wtf.krya.FabricCameras;

public class PolaroidCameraItem extends Item {
  public PolaroidCameraItem() {
    super(new OwoItemSettings().group(FabricCameras.ITEM_GROUP).maxCount(1)
      .maxDamage(100));
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    var shouldConsumeFilms = !user.getAbilities().creativeMode;
    var inventory = user.getInventory();
    var indexOfFilm = inventory.indexOf(ItemInit.CAMERA_FILM.getDefaultStack());
    var hasCameraFilm = indexOfFilm > 0;

    if (!hasCameraFilm && shouldConsumeFilms) return TypedActionResult.pass(user.getStackInHand(hand));

    var stack = user.getStackInHand(hand);
    if (shouldConsumeFilms) {
      stack.damage(1, user, p -> p.sendToolBreakStatus(user.getActiveHand()));
      var filmStack = inventory.getStack(indexOfFilm);
      filmStack.decrement(1);
    }



    return TypedActionResult.success(user.getStackInHand(hand));
  }
}
