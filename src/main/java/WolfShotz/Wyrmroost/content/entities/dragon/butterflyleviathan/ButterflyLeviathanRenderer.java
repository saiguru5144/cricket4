package WolfShotz.Wyrmroost.content.entities.dragon.butterflyleviathan;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ButterflyLeviathanRenderer extends AbstractDragonRenderer<ButterflyLeviathanEntity>
{
    public final ResourceLocation BLUE   = location("butterfly_leviathan.png");
    public final ResourceLocation PURPLE = location("butterfly_leviathan_purple.png");
    // Special
    public final ResourceLocation ALBINO = location("butterfly_leviathan_alb.png");
    
    public ButterflyLeviathanRenderer(EntityRendererManager manager) {
        super(manager, new ButterflyLeviathanModel(), 2f);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ButterflyLeviathanEntity entity) {
        if (entity.isSpecial()) return ALBINO;
        switch (entity.getVariant()) {
            default:
            case 1: return BLUE;
            case 2: return PURPLE;
        }
    }
    
    @Override
    public String getResourceDirectory() { return DEF_LOC + "butterflyleviathan/"; }
}