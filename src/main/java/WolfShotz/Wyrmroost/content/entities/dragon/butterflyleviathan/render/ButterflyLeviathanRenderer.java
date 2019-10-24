package WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan.render;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonRenderer;
import WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan.ButterflyLeviathanEntity;
import WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan.ButterflyLeviathanModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class ButterflyLeviathanRenderer extends AbstractDragonRenderer<ButterflyLeviathanEntity>
{
    public final ResourceLocation BLUE   = location("butterfly_leviathan.png");
    public final ResourceLocation PURPLE = location("butterfly_leviathan_purple.png");
    // Special
    public final ResourceLocation ALBINO = location("butterfly_leviathan_alb.png");
    // Glow
    public final ResourceLocation GLOW   = location("butterfly_leviathan_activated.png");
    
    public ButterflyLeviathanRenderer(EntityRendererManager manager) {
        super(manager, new ButterflyLeviathanModel(), 2f);
        addLayer(new GlowLayer(d -> GLOW, ButterflyLeviathanEntity::hasConduit));
    }
    
    @Override
    public void doRender(ButterflyLeviathanEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
        if (entity.hasConduit()) ConduitRenderer.render(entity, this::bindTexture, x, y + 3, z, partialTicks);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ButterflyLeviathanEntity entity) {
        if (entity.isSpecial()) return ALBINO;
        switch (entity.getVariant()) {
            default: // Fall back: WHAT VARIANT IS THIS?!
            case 0: return BLUE;
            case 1: return PURPLE;
        }
    }
    
    @Override
    public String getResourceDirectory() { return DEF_LOC + "butterflyleviathan/"; }
}