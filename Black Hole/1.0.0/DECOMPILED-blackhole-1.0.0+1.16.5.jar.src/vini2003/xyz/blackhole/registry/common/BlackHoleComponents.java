/*    */ package vini2003.xyz.blackhole.registry.common;
/*    */ 
/*    */ import dev.onyxstudios.cca.api.v3.component.ComponentKey;
/*    */ import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentFactory;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
/*    */ import vini2003.xyz.blackhole.BlackHole;
/*    */ import vini2003.xyz.blackhole.common.components.BlackHoleWorldComponent;
/*    */ 
/*    */ public class BlackHoleComponents implements WorldComponentInitializer {
/* 12 */   public static final ComponentKey<BlackHoleWorldComponent> BLACK_HOLES = ComponentRegistry.getOrCreate(BlackHole.identifier("black_holes"), BlackHoleWorldComponent.class);
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initialize() {}
/*    */ 
/*    */   
/*    */   public void registerWorldComponentFactories(WorldComponentFactoryRegistry worldComponentFactoryRegistry) {
/* 20 */     worldComponentFactoryRegistry.register(BLACK_HOLES, BlackHoleWorldComponent::new);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/registry/common/BlackHoleComponents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */