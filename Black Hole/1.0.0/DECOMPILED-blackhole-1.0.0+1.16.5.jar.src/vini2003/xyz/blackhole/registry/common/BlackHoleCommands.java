/*     */ package vini2003.xyz.blackhole.registry.common;
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.arguments.IntegerArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.builder.RequiredArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.mojang.brigadier.tree.CommandNode;
/*     */ import com.mojang.brigadier.tree.LiteralCommandNode;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*     */ import net.minecraft.class_124;
/*     */ import net.minecraft.class_2168;
/*     */ import net.minecraft.class_2170;
/*     */ import net.minecraft.class_2540;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_2588;
/*     */ import net.minecraft.class_3218;
/*     */ import net.minecraft.class_3222;
/*     */ import vini2003.xyz.blackhole.common.components.BlackHoleComponent;
/*     */ import vini2003.xyz.blackhole.common.config.BlackHoleConfig;
/*     */ import vini2003.xyz.blackhole.registry.client.BlackHoleNetworking;
/*     */ 
/*     */ public class BlackHoleCommands {
/*     */   private static int spawnBlackHole(CommandContext<class_2168> context) throws CommandSyntaxException {
/*  26 */     class_243 pos = ((class_2168)context.getSource()).method_9207().method_19538();
/*     */     
/*  28 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*     */     
/*  30 */     if (((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(class_3218)).getBlackHoles().isEmpty()) {
/*  31 */       BlackHoleComponent blackHole = new BlackHoleComponent((class_1937)class_3218);
/*  32 */       blackHole.setPos(pos);
/*  33 */       blackHole.setSize(1.0F);
/*     */       
/*  35 */       ((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(class_3218)).getBlackHoles().add(blackHole);
/*  36 */       BlackHoleComponents.BLACK_HOLES.sync(class_3218);
/*     */       
/*  38 */       ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.spawn.success")).method_27692(class_124.field_1060), true);
/*     */     } else {
/*  40 */       ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.spawn.failure")).method_27692(class_124.field_1061), true);
/*     */     } 
/*     */     
/*  43 */     return 1;
/*     */   }
/*     */   
/*     */   private static int kill(CommandContext<class_2168> context) throws CommandSyntaxException {
/*  47 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*     */     
/*  49 */     if (!((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(class_3218)).getBlackHoles().isEmpty()) {
/*  50 */       ((BlackHoleWorldComponent)BlackHoleComponents.BLACK_HOLES.get(class_3218)).getBlackHoles().clear();
/*  51 */       BlackHoleComponents.BLACK_HOLES.sync(class_3218);
/*     */       
/*  53 */       ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.KILL_PACKET, new class_2540(Unpooled.buffer())));
/*     */ 
/*     */ 
/*     */       
/*  57 */       ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.kill.success")).method_27692(class_124.field_1060), true);
/*     */     } else {
/*  59 */       ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.kill.failure")).method_27692(class_124.field_1061), true);
/*     */     } 
/*     */     
/*  62 */     return 1;
/*     */   }
/*     */   
/*     */   private static int followSpeed(CommandContext<class_2168> context) throws CommandSyntaxException {
/*  66 */     float followSpeed = IntegerArgumentType.getInteger(context, "followSpeed") * 0.00125F;
/*     */     
/*  68 */     int previousSpeed = (int)(BlackHoleConfig.cache.followSpeed / 0.00125F);
/*     */     
/*  70 */     BlackHoleConfig.cache.followSpeed = followSpeed;
/*     */     
/*  72 */     class_2540 buf = new class_2540(Unpooled.buffer());
/*  73 */     buf.writeFloat(followSpeed);
/*     */     
/*  75 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.FOLLOW_SPEED_PACKET, buf));
/*     */ 
/*     */ 
/*     */     
/*  79 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.followSpeed", new Object[] { Integer.valueOf(previousSpeed), Integer.valueOf(IntegerArgumentType.getInteger(context, "followSpeed")) })).method_27692(class_124.field_1060), true);
/*     */     
/*  81 */     return 1;
/*     */   }
/*     */   
/*     */   private static int growSpeed(CommandContext<class_2168> context) throws CommandSyntaxException {
/*  85 */     float growSpeed = IntegerArgumentType.getInteger(context, "growSpeed") * 3.851E-5F;
/*     */     
/*  87 */     int previousSpeed = (int)(BlackHoleConfig.cache.growSpeed / 3.851E-5F);
/*     */     
/*  89 */     BlackHoleConfig.cache.growSpeed = growSpeed;
/*     */     
/*  91 */     class_2540 buf = new class_2540(Unpooled.buffer());
/*  92 */     buf.writeFloat(growSpeed);
/*     */     
/*  94 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.GROW_SPEED_PACKET, buf));
/*     */ 
/*     */ 
/*     */     
/*  98 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.growSpeed", new Object[] { Integer.valueOf(previousSpeed), Integer.valueOf(IntegerArgumentType.getInteger(context, "growSpeed")) })).method_27692(class_124.field_1060), true);
/*     */     
/* 100 */     return 1;
/*     */   }
/*     */   
/*     */   private static int pullSpeed(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 104 */     float pullSpeed = IntegerArgumentType.getInteger(context, "pullSpeed") * 0.125F;
/*     */     
/* 106 */     int previousSpeed = (int)(BlackHoleConfig.cache.pullSpeed / 0.125F);
/*     */     
/* 108 */     BlackHoleConfig.cache.pullSpeed = pullSpeed;
/*     */     
/* 110 */     class_2540 buf = new class_2540(Unpooled.buffer());
/* 111 */     buf.writeFloat(pullSpeed);
/*     */     
/* 113 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.PULL_SPEED_PACKET, buf));
/*     */ 
/*     */ 
/*     */     
/* 117 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.pullSpeed", new Object[] { Integer.valueOf(previousSpeed), Integer.valueOf(IntegerArgumentType.getInteger(context, "pullSpeed")) })).method_27692(class_124.field_1060), true);
/*     */     
/* 119 */     return 1;
/*     */   }
/*     */   
/*     */   private static int damage(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 123 */     boolean damage = BoolArgumentType.getBool(context, "damage");
/*     */     
/* 125 */     boolean previousDamage = BlackHoleConfig.cache.damage;
/*     */     
/* 127 */     BlackHoleConfig.cache.damage = damage;
/*     */     
/* 129 */     class_2540 buf = new class_2540(Unpooled.buffer());
/* 130 */     buf.writeBoolean(damage);
/*     */     
/* 132 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.DAMAGE_PACKET, buf));
/*     */ 
/*     */ 
/*     */     
/* 136 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.damage." + (damage ? "enable" : "disable"), new Object[] { Boolean.valueOf(previousDamage), Boolean.valueOf(damage) })).method_27692(class_124.field_1060), true);
/*     */     
/* 138 */     return 1;
/*     */   }
/*     */   
/*     */   private static int pause(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 142 */     BlackHoleConfig.cache.follow = false;
/* 143 */     BlackHoleConfig.cache.pull = false;
/* 144 */     BlackHoleConfig.cache.grow = false;
/* 145 */     BlackHoleConfig.cache.damage = false;
/*     */     
/* 147 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.PAUSE_PACKET, new class_2540(Unpooled.buffer())));
/*     */ 
/*     */ 
/*     */     
/* 151 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.pause")).method_27692(class_124.field_1060), true);
/*     */     
/* 153 */     return 1;
/*     */   }
/*     */   
/*     */   private static int resume(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 157 */     BlackHoleConfig.cache.follow = true;
/* 158 */     BlackHoleConfig.cache.pull = true;
/* 159 */     BlackHoleConfig.cache.grow = true;
/* 160 */     BlackHoleConfig.cache.damage = true;
/*     */     
/* 162 */     ((class_2168)context.getSource()).method_9211().method_3760().method_14571().forEach(player -> ServerPlayNetworking.send(player, BlackHoleNetworking.RESUME_PACKET, new class_2540(Unpooled.buffer())));
/*     */ 
/*     */ 
/*     */     
/* 166 */     ((class_2168)context.getSource()).method_9207().method_7353((class_2561)(new class_2588("text.command.blackhole.resume")).method_27692(class_124.field_1060), true);
/*     */     
/* 168 */     return 1;
/*     */   }
/*     */   
/*     */   public static void initialize() {
/* 172 */     CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
/*     */           LiteralCommandNode<class_2168> blackHoleRoot = class_2170.method_9247("blackhole").build();
/*     */           LiteralCommandNode<class_2168> blackHoleSpawn = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("spawn").requires(())).executes(BlackHoleCommands::spawnBlackHole)).build();
/*     */           LiteralCommandNode<class_2168> blackHoleKill = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("kill").requires(())).executes(BlackHoleCommands::kill)).build();
/*     */           LiteralCommandNode<class_2168> blackHolePull = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("pull").requires(())).then((CommandNode)((RequiredArgumentBuilder)class_2170.method_9244("pullSpeed", (ArgumentType)IntegerArgumentType.integer()).executes(BlackHoleCommands::pullSpeed)).build())).build();
/*     */           LiteralCommandNode<class_2168> blackHoleGrow = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("grow").requires(())).then((CommandNode)((RequiredArgumentBuilder)class_2170.method_9244("growSpeed", (ArgumentType)IntegerArgumentType.integer()).executes(BlackHoleCommands::growSpeed)).build())).build();
/*     */           LiteralCommandNode<class_2168> blackHoleFollow = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("follow").requires(())).then((CommandNode)((RequiredArgumentBuilder)class_2170.method_9244("followSpeed", (ArgumentType)IntegerArgumentType.integer()).executes(BlackHoleCommands::followSpeed)).build())).build();
/*     */           LiteralCommandNode<class_2168> blackHoleDamage = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("damage").requires(())).then((CommandNode)((RequiredArgumentBuilder)class_2170.method_9244("damage", (ArgumentType)BoolArgumentType.bool()).executes(BlackHoleCommands::damage)).build())).build();
/*     */           LiteralCommandNode<class_2168> blackHolePause = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("pause").requires(())).executes(BlackHoleCommands::pause)).build();
/*     */           LiteralCommandNode<class_2168> blackHoleResume = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("resume").requires(())).executes(BlackHoleCommands::resume)).build();
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleSpawn);
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleKill);
/*     */           blackHoleRoot.addChild((CommandNode)blackHolePull);
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleGrow);
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleFollow);
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleDamage);
/*     */           blackHoleRoot.addChild((CommandNode)blackHolePause);
/*     */           blackHoleRoot.addChild((CommandNode)blackHoleResume);
/*     */           dispatcher.getRoot().addChild((CommandNode)blackHoleRoot);
/*     */         });
/*     */   }
/*     */ }


/* Location:              /Users/alex/BAK/vini2003/Build/Black Hole/1.0.0/blackhole-1.0.0+1.16.5.jar!/vini2003/xyz/blackhole/registry/common/BlackHoleCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */