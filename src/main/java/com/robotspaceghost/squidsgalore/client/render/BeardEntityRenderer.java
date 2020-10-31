package com.robotspaceghost.squidsgalore.client.render;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.BeardEntityModel;
import com.robotspaceghost.squidsgalore.entities.BeardEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BeardEntityRenderer extends MobRenderer<BeardEntity, BeardEntityModel<BeardEntity>> {

    public BeardEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BeardEntityModel<>(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(BeardEntity entity) {
        return new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/beard_entity.png");
    }
}
