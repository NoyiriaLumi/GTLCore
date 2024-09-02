package org.gtlcore.gtlcore.common.machine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.util.FakePlayer;
import org.gtlcore.gtlcore.utils.MachineIO;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Slaughterhouse extends WorkableElectricMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            Slaughterhouse.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private boolean isSpawn;
    @Persisted
    private final UUID uuid;
    private final String[] mobList1, mobList2;

    public Slaughterhouse(IMachineBlockEntity holder, String[] mobList1, String[] mobList2) {
        super(holder);
        this.uuid = UUID.randomUUID();
        this.mobList1 = mobList1;
        this.mobList2 = mobList2;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private void getItem(ServerLevel level, BlockPos Pos, Slaughterhouse machine) {
        final DamageSource Source = new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(DamageTypes.GENERIC_KILL),
                new FakePlayer(level, new GameProfile(uuid, "slaughterhouse")));
        List<Entity> entities = level.getEntitiesOfClass(Entity.class, new AABB(
                Pos.getX() - 3,
                Pos.getY() - 1,
                Pos.getZ() - 3,
                Pos.getX() + 3,
                Pos.getY() + 6,
                Pos.getZ() + 3));
        for (Entity en : entities) {
            if (!en.kjs$isPlayer()) {
                if (en.kjs$isLiving()) {
                    en.hurt(Source, 10000);
                } else if (en instanceof ItemEntity itemEntity) {
                    MachineIO.outputItem(machine, itemEntity.getItem());
                    itemEntity.kill();
                }
            }
            en.kill();
        }
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        if (getRecipeLogic().getProgress() == 19) {
            final BlockPos pos = getPos();
            final Level level = getLevel();
            BlockPos[][] coordinates = new BlockPos[][] {
                    new BlockPos[] { pos.offset(1, 0, 0), pos.offset(3, 1, 0) },
                    new BlockPos[] { pos.offset(-1, 0, 0), pos.offset(-3, 1, 0) },
                    new BlockPos[] { pos.offset(0, 0, 1), pos.offset(0, 1, 3) },
                    new BlockPos[] { pos.offset(0, 0, -1), pos.offset(0, 1, -3) } };
            for (BlockPos[] blockPos : coordinates) {
                if (level instanceof ServerLevel serverLevel &&
                        Objects.equals(serverLevel.kjs$getBlock(blockPos[0]).getId(), "gtceu:steel_gearbox")) {
                    BlockPos mobPos = blockPos[1];
                    if (getRecipeLogic().getMachine() instanceof Slaughterhouse wmachine) {
                        final String[] mobList = MachineIO.notConsumableCircuit(wmachine, 1) ? this.mobList1 : this.mobList2;
                        if (!this.isSpawn) {
                            getItem(serverLevel, mobPos, wmachine);
                            for (int am = 0; am <= (getTier() - 2) * 8; am++) {
                                int index = (int) (Math.random() * mobList.length);
                                EntityType.byString("minecraft:" + mobList[index]).get()
                                        .spawn(serverLevel, mobPos, MobSpawnType.MOB_SUMMONED)
                                        .setYRot(serverLevel.getRandom().nextFloat() * 360F);
                            }
                        } else {
                            final LootParams lootparams = new LootParams.Builder(serverLevel)
                                    .create(LootContextParamSets.EMPTY);
                            getItem(serverLevel, mobPos, wmachine);
                            for (int am = 0; am <= (getTier() - 2) * 8; am++) {
                                int index = (int) (Math.random() * mobList.length);
                                ObjectArrayList<ItemStack> loottable = serverLevel.getServer().getLootData()
                                        .getLootTable(new ResourceLocation("minecraft:entities/" + mobList[index]))
                                        .getRandomItems(lootparams);
                                loottable.forEach(i -> MachineIO.outputItem(wmachine, i));
                            }
                        }
                    }
                }
            }
        }
        return value;
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