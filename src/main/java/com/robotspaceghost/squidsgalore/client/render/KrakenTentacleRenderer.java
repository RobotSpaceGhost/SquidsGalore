package com.robotspaceghost.squidsgalore.client.render;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.KrakenTentacleModel;
import com.robotspaceghost.squidsgalore.entities.KrakenTentacleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KrakenTentacleRenderer extends MobRenderer<KrakenTentacleEntity, KrakenTentacleModel<KrakenTentacleEntity>> {

    protected static final ResourceLocation TEXTURE_DEFAULT = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken_tentacle.png");
    protected static final ResourceLocation TEXTURE_ETHEREAL = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken_tentacle_ethereal.png");

    public KrakenTentacleRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KrakenTentacleModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(KrakenTentacleEntity entity) {
        if (entity.hasCustomName() && entity.getCustomName() != null)
        {
            String name = entity.getCustomName().getString().toLowerCase().replaceAll("\\s+","");
            if (name.contains("ether")) return TEXTURE_ETHEREAL;
        }
        return TEXTURE_DEFAULT;
    }
}
