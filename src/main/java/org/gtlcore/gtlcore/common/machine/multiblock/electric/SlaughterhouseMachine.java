package org.gtlcore.gtlcore.common.machine.multiblock.electric;

import org.gtlcore.gtlcore.api.machine.multiblock.StorageMachine;
import org.gtlcore.gtlcore.config.GTLConfigHolder;
import org.gtlcore.gtlcore.utils.MachineUtil;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.util.FakePlayer;

import com.enderio.machines.common.init.MachineBlocks;
import com.mojang.authlib.GameProfile;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SlaughterhouseMachine extends StorageMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SlaughterhouseMachine.class, StorageMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private boolean isSpawn;
    private final UUID uuid;
    private final String[] mobList1 = GTLConfigHolder.INSTANCE.mobList1;
    private final String[] mobList2 = GTLConfigHolder.INSTANCE.mobList2;

    public SlaughterhouseMachine(IMachineBlockEntity holder) {
        super(holder, 1);
        this.uuid = UUID.randomUUID();
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected static String[] decompose(String location) {
        String[] astring = new String[] { "minecraft", location };
        int i = location.indexOf(":");
        if (i >= 0) {
            astring[1] = location.substring(i + 1);
            if (i >= 1) {
                astring[0] = location.substring(0, i);
            }
        }
        return astring;
    }

    @Override
    public void afterWorking() {
        Level level = getLevel();
        BlockPos blockPos = MachineUtil.getOffsetPos(3, 1, getFrontFacing(), getPos());
        ItemStack itemStack = getMachineStorageItem();
        boolean isFixed = itemStack.is(MachineBlocks.POWERED_SPAWNER.asItem()) && itemStack.getTag() != null;

        if (level instanceof ServerLevel serverLevel) {
            FakePlayer fakePlayer = new FakePlayer(serverLevel, new GameProfile(uuid, "slaughter"));
            String[] mobList = isFixed ? null : MachineUtil.notConsumableCircuit(this, 1) ? this.mobList1 : this.mobList2;
            int tierMultiplier = (getTier() - 2) * 8;

            DamageSource source = new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                    .getHolderOrThrow(DamageTypes.GENERIC_KILL), fakePlayer);

            List<Entity> entities = level.getEntitiesOfClass(Entity.class, new AABB(
                    blockPos.getX() - 3,
                    blockPos.getY() - 1,
                    blockPos.getZ() - 3,
                    blockPos.getX() + 3,
                    blockPos.getY() + 6,
                    blockPos.getZ() + 3));

            for (Entity entity : entities) {
                if (!entity.kjs$isPlayer()) {
                    if (entity.kjs$isLiving()) {
                        entity.hurt(source, 10000);
                    } else if (entity instanceof ItemEntity itemEntity) {
                        MachineUtil.outputItem(this, itemEntity.getItem());
                        itemEntity.kill();
                    }
                    entity.kill();
                }
            }

            for (int i = 0; i <= tierMultiplier; i++) {
                String mob = isFixed ? itemStack.getTag().getCompound("BlockEntityTag")
                        .getCompound("EntityStorage").getCompound("Entity").getString("id") : mobList[(int) (Math.random() * mobList.length)];

                Optional<EntityType<?>> entityType = EntityType.byString(mob);
                if (entityType.isPresent()) {
                    EntityType<?> type = entityType.get();
                    Entity entity = type.create(serverLevel);

                    if (entity instanceof LivingEntity livingEntity) {
                        if (!this.isSpawn) {
                            livingEntity.setPos(blockPos.getCenter());
                            serverLevel.addFreshEntity(livingEntity);
                        } else {
                            String[] mobParts = decompose(mob);
                            if (mobParts.length < 2) continue;
                            LootTable lootTable = serverLevel.getServer().getLootData()
                                    .getLootTable(new ResourceLocation(mobParts[0], "entities/" + mobParts[1]));
                            LootParams lootParams = new LootParams.Builder(serverLevel)
                                    .withParameter(LootContextParams.LAST_DAMAGE_PLAYER, fakePlayer)
                                    .withParameter(LootContextParams.THIS_ENTITY, livingEntity)
                                    .withParameter(LootContextParams.DAMAGE_SOURCE, source)
                                    .withParameter(LootContextParams.ORIGIN, blockPos.getCenter())
                                    .create(lootTable.getParamSet());

                            lootTable.getRandomItems(lootParams).forEach(stack -> MachineUtil.outputItem(this, isFixed ? stack.copyWithCount(tierMultiplier) : stack));
                            if (isFixed) break;
                        }
                    }
                }
            }
        }
        super.afterWorking();
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (!this.isFormed) return;
        textList.add(Component.translatable("gtceu.machine.slaughterhouse.is_spawn")
                .append(ComponentPanelWidget.withButton(Component.literal("[")
                        .append(this.isSpawn ?
                                Component.translatable("gtceu.machine.off") :
                                Component.translatable("gtceu.machine.on"))
                        .append(Component.literal("]")), "spawn_switch")));
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (!clickData.isRemote) {
            if (componentData.equals("spawn_switch")) {
                this.isSpawn = !this.isSpawn;
            }
        }
    }
}
