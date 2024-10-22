package org.gtlcore.gtlcore.common.data;

import org.gtlcore.gtlcore.common.entity.NukeBombEntity;

import net.minecraft.world.entity.MobCategory;

import com.tterrag.registrate.util.entry.EntityEntry;

import static org.gtlcore.gtlcore.api.registries.GTLRegistration.REGISTRATE;

public class GTLEntityTypes {

    public static final EntityEntry<NukeBombEntity> NUKE_BOMB = REGISTRATE
            .<NukeBombEntity>entity("nuke_bomb", NukeBombEntity::new, MobCategory.MISC)
            .properties(builder -> builder.sized(0.98F, 0.98F).fireImmune().clientTrackingRange(10).updateInterval(10))
            .register();

    public static void init() {}
}
