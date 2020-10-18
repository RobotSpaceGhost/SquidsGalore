package com.robotspaceghost.squidsgalore.client.render;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.KrakenModel;
import com.robotspaceghost.squidsgalore.entities.KrakenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KrakenRenderer extends MobRenderer<KrakenEntity, KrakenModel<KrakenEntity>> {

    protected static final ResourceLocation TEXTURE_DEFAULT = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken.png");
    protected static final ResourceLocation TEXTURE_HURT = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken_hurt.png");


    public KrakenRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KrakenModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(KrakenEntity entity) {
        if (entity.hasCustomName() && entity.getCustomName() != null)
        {
            String name = entity.getCustomName().getString().toLowerCase().replaceAll("\\s+","");
            if (name.contains("injured")) return TEXTURE_HURT;
        }
        return TEXTURE_DEFAULT;
    }
}