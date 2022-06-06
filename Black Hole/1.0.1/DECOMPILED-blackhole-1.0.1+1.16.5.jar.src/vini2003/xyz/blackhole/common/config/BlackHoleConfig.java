/*    */ package vini2003.xyz.blackhole.common.config;
/*    */ 
/*    */ import me.shedaniel.autoconfig.AutoConfig;
/*    */ import me.shedaniel.autoconfig.ConfigData;
/*    */ import me.shedaniel.autoconfig.annotation.Config;
/*    */ import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Excluded;
/*    */ 
/*    */ @Config(name = "blackhole")
/*    */ public class BlackHoleConfig implements ConfigData {
/*    */   @Excluded
/*    */   public static BlackHoleConfig cache;
/*    */   
/*    */   public static void refresh() {
/* 14 */     cache = (BlackHoleConfig)AutoConfig.getConfigHolder(BlackHoleConfig.class).getConfig();
/*    */   }
/*    */ 
/*    */   
/*    */   @Excluded
/*    */   public static final int defaultLimit = 64;
/* 20 */   public int limit = 64;
/*    */   
/*    */   @Excluded
/*    */   public static final float defaultFollow = 0.00125F;
/*    */   
/*    */   public boolean follow = true;
/*    */   
/* 27 */   public float followSpeed = 0.00125F;
/*    */   
/*    */   @Excluded
/*    */   public static final float defaultGrow = 3.851E-5F;
/*    */   
/*    */   public boolean grow = true;
/*    */   
/* 34 */   public float growSpeed = 3.851E-5F;
/*    */   
/*    */   @Excluded
/*    */   public static final float defaultPull = 0.125F;
/*    */   
/*    */   public boolean pull = true;
/*    */   
/* 41 */   public float pullSpeed = 0.125F;
/*    */   public boolean damage = true;
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/blackhole-1.0.1+1.16.5.jar!/vini2003/xyz/blackhole/common/config/BlackHoleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */