/*   */ package vini2003.xyz.blackhole.registry.common;
/*   */ import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
/*   */ import net.minecraft.class_3218;
/*   */ import net.minecraft.server.MinecraftServer;
/*   */ import vini2003.xyz.blackhole.common.components.BlackHoleWorldComponent;
/*   */ 
/*   */ public class BlackHoleCallbacks {
/*   */   public static void initialize() {
/* 9 */     ServerTickEvents.END_SERVER_TICK.register(server -> {
/*   */           for (class_3218 world : server.method_3738()) {
/*   */             BlackHoleWorldComponent blackHoleWorldComponent = (BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(world);
/*   */             blackHoleWorldComponent.tick();
/*   */           } 
/*   */         });
/*   */   }
/*   */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/registry/common/BlackHoleCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */