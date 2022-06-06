/*    */ package vini2003.xyz.blackhole.registry.client;
/*    */ 
/*    */ import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
/*    */ import net.minecraft.class_310;
/*    */ import vini2003.xyz.blackhole.BlackHoleClient;
/*    */ import vini2003.xyz.blackhole.common.components.BlackHoleWorldComponent;
/*    */ import vini2003.xyz.blackhole.registry.common.BlackHoleComponents;
/*    */ 
/*    */ 
/*    */ public class BlackHoleCallbacks
/*    */ {
/*    */   public static void initialize() {
/* 13 */     ClientTickEvents.START_CLIENT_TICK.register(client -> BlackHoleClient.isBlackedOut = false);
/*    */ 
/*    */ 
/*    */     
/* 17 */     ClientTickEvents.END_CLIENT_TICK.register(client -> {
/*    */           if ((class_310.method_1551()).field_1687 != null) {
/*    */             BlackHoleWorldComponent blackHoleWorldComponent = (BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get((class_310.method_1551()).field_1687);
/*    */             blackHoleWorldComponent.tick();
/*    */           } 
/*    */         });
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/registry/client/BlackHoleCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */