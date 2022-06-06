/*    */ package vini2003.xyz.blackhole;
/*    */ import net.fabricmc.api.ModInitializer;
/*    */ import net.minecraft.class_2960;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleCallbacks;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleCommands;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleComponents;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleConfigs;
/*    */ 
/*    */ public class BlackHole implements ModInitializer {
/*    */   public static class_2960 identifier(String path) {
/* 11 */     return new class_2960("blackhole", path);
/*    */   }
/*    */   public static final String ID = "blackhole";
/*    */   
/*    */   public void onInitialize() {
/* 16 */     BlackHoleCommands.initialize();
/* 17 */     BlackHoleCallbacks.initialize();
/* 18 */     BlackHoleConfigs.initialize();
/* 19 */     BlackHoleComponents.initialize();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/BlackHole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */