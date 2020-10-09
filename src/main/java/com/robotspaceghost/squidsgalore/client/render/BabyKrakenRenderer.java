package com.robotspaceghost.squidsgalore.client.render;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.BabyKrakenModel;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BabyKrakenRenderer extends MobRenderer<BabyKrakenEntity, BabyKrakenModel<BabyKrakenEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/baby_kraken.png");

    public BabyKrakenRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BabyKrakenModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(BabyKrakenEntity entity) {
        return TEXTURE;
    }
}
