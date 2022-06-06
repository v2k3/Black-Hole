/*    */ package vini2003.xyz.blackhole.client.modmenu;
/*    */ 
/*    */ import com.terraformersmc.modmenu.api.ConfigScreenFactory;
/*    */ import com.terraformersmc.modmenu.api.ModMenuApi;
/*    */ import me.shedaniel.autoconfig.AutoConfig;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_437;
/*    */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class BlackHoleModMenu implements ModMenuApi {
/*    */   public ConfigScreenFactory<?> getModConfigScreenFactory() {
/* 14 */     return parent -> (class_437)AutoConfig.getConfigScreen(BlackHoleConfig.class, parent).get();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/client/modmenu/BlackHoleModMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */