/*    */ package vini2003.xyz.blackhole.registry.common;
/*    */ import me.shedaniel.autoconfig.AutoConfig;
/*    */ import me.shedaniel.autoconfig.ConfigHolder;
/*    */ import me.shedaniel.autoconfig.serializer.ConfigSerializer;
/*    */ import net.minecraft.class_1269;
/*    */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*    */ 
/*    */ public class BlackHoleConfigs {
/*    */   public static void initialize() {
/* 10 */     AutoConfig.register(BlackHoleConfig.class, me.shedaniel.autoconfig.serializer.GsonConfigSerializer::new);
/*    */     
/* 12 */     AutoConfig.getConfigHolder(BlackHoleConfig.class).registerSaveListener((manager, newCache) -> {
/*    */           BlackHoleConfig.cache = newCache;
/*    */           
/*    */           return class_1269.field_5812;
/*    */         });
/* 17 */     BlackHoleConfig.refresh();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/registry/common/BlackHoleConfigs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */