package com.example;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLib;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import static com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient.renderBanner;

public class ExampleModClient implements ClientModInitializer {

	public static final EntityModelLayer netherite_banner_shield_model_layer = new EntityModelLayer(new Identifier("examplemod", "netherite_banner_shield"),"main");

	public static ShieldEntityModel modelNetheriteShield;

	public static final SpriteIdentifier NETHERITE_BANNER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("examplemod", "entity/netherite_banner_shield_base"));
	public static final SpriteIdentifier NETHERITE_BANNER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("examplemod", "entity/netherite_banner_shield_base_nopattern"));


	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(netherite_banner_shield_model_layer, ShieldEntityModel::getTexturedModelData);

		ShieldSetModelCallback.EVENT.register((loader) -> {
			modelNetheriteShield = new ShieldEntityModel(loader.getModelPart(netherite_banner_shield_model_layer));
			return ActionResult.PASS;
		});

		BuiltinItemRendererRegistry.INSTANCE.register(ExampleMod.NETHERITE_BANNER_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
			renderBanner(stack, matrices, vertexConsumers, light, overlay, modelNetheriteShield, NETHERITE_BANNER_SHIELD_BASE, NETHERITE_BANNER_SHIELD_BASE_NO_PATTERN);
		});
	}
}