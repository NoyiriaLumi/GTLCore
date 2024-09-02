package org.gtlcore.gtlcore.common.data;

import appeng.api.stacks.AEKeyType;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.ItemDefinition;
import appeng.core.localization.GuiText;
import appeng.items.materials.MaterialItem;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import appeng.menu.me.common.MEStorageMenu;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.common.data.GTCompassNodes;
import com.gregtechceu.gtceu.common.data.GTCompassSections;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import org.gtlcore.gtlcore.common.item.StructureWriteBehavior;
import org.gtlcore.gtlcore.utils.TextUtil;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static org.gtlcore.gtlcore.api.registries.GTLRegistration.REGISTRATE;

public class GTLItems {

    public static void init() {}

    static {
        REGISTRATE.creativeModeTab(() -> GTLCreativeModeTabs.GTL_CORE);
    }

    private static ItemEntry<StorageComponentItem> registerStorageComponentItem(int tier) {
        return REGISTRATE
                .item("cell_component_" + tier + "m", p -> new StorageComponentItem(p, 1048576 * tier))
                .register();
    }

    private static ItemEntry<BasicStorageCell> registerStorageCell(int tier,
                                                                   ItemEntry<StorageComponentItem> StorageComponent,
                                                                   boolean isItem) {
        ItemDefinition<MaterialItem> CELL_HOUSING = isItem ? AEItems.ITEM_CELL_HOUSING : AEItems.FLUID_CELL_HOUSING;
        return REGISTRATE
                .item((isItem ? "item" : "fluid") + "_storage_cell_" + tier + "m", p -> new BasicStorageCell(
                        p.stacksTo(1),
                        StorageComponent,
                        CELL_HOUSING,
                        3 + 0.5 * Math.log(tier) / Math.log(4),
                        1024 * tier,
                        8192 * tier,
                        isItem ? 63 : 18,
                        isItem ? AEKeyType.items() : AEKeyType.fluids()))
                .register();
    }

    public static ItemEntry<ComponentItem> REALLY_ULTIMATE_BATTERY = REGISTRATE
            .item("really_max_battery", ComponentItem::create)
            .lang("Really Ultimate Battery")
            .onRegister(
                    attach(new TooltipBehavior(lines -> lines.add(Component.literal("§7填满就能通关GregTechCEu Modern")))))
            .onRegister(compassNodeExist(GTCompassSections.BATTERIES, "really_ultimate_battery"))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UEV)))
            .register();
    public static ItemEntry<ComponentItem> TRANSCENDENT_ULTIMATE_BATTERY = REGISTRATE
            .item("transcendent_max_battery", ComponentItem::create)
            .lang("Transcendent Ultimate Battery")
            .onRegister(
                    attach(new TooltipBehavior(lines -> lines.add(Component.literal("§7填满就能通关GregTech Leisure")))))
            .onRegister(compassNodeExist(GTCompassSections.BATTERIES, "transcendent_ultimate_battery"))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UIV)))
            .register();
    public static ItemEntry<ComponentItem> EXTREMELY_ULTIMATE_BATTERY = REGISTRATE
            .item("extremely_max_battery", ComponentItem::create)
            .lang("Extremely Ultimate Battery")
            .onRegister(
                    attach(new TooltipBehavior(lines -> lines.add(Component.literal("§7有生之年将它填满")))))
            .onRegister(compassNodeExist(GTCompassSections.BATTERIES, "extremely_ultimate_battery"))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UXV)))
            .register();
    public static ItemEntry<ComponentItem> INSANELY_ULTIMATE_BATTERY = REGISTRATE
            .item("insanely_max_battery", ComponentItem::create)
            .lang("Insanely Ultimate Battery")
            .onRegister(
                    attach(new TooltipBehavior(
                            lines -> lines.add(Component.literal(TextUtil.dark_purplish_red("填满也就图一乐"))))))
            .onRegister(compassNodeExist(GTCompassSections.BATTERIES, "insanely_ultimate_battery"))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.OpV)))
            .register();
    public static ItemEntry<ComponentItem> MEGA_ULTIMATE_BATTERY = REGISTRATE
            .item("mega_max_battery", ComponentItem::create)
            .lang("Mega Ultimate Battery")
            .onRegister(
                    attach(new TooltipBehavior(
                            lines -> lines.add(Component.literal(TextUtil.full_color("填满电池 机械飞升"))))))
            .onRegister(compassNodeExist(GTCompassSections.BATTERIES, "mega_ultimate_battery"))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.MAX)))
            .register();

    public static ItemEntry<Item> ELECTRIC_MOTOR_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_electric_motor", Item::new).lang("MAX Electric Motor")
                    .onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "electric_motor")).register() :
            null;

    public static ItemEntry<ComponentItem> ELECTRIC_PUMP_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_electric_pump", ComponentItem::create)
                    .lang("MAX Electric Pump")
                    .onRegister(attach(new CoverPlaceBehavior(GTLCovers.ELECTRIC_PUMP_MAX)))
                    .onRegister(attach(new TooltipBehavior(lines -> {
                        lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                        lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                                1280 * 64 * 64 * 4 / 20));
                    })))
                    .onRegister(compassNodeExist(GTCompassSections.COVERS, "pump", GTCompassNodes.COVER))
                    .register() :
            null;

    public static ItemEntry<ComponentItem> CONVEYOR_MODULE_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_conveyor_module", ComponentItem::create)
                    .lang("MAX Conveyor Module")
                    .onRegister(attach(new CoverPlaceBehavior(GTLCovers.CONVEYOR_MODULE_MAX)))
                    .onRegister(attach(new TooltipBehavior(lines -> {
                        lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                        lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
                    })))
                    .onRegister(compassNodeExist(GTCompassSections.COVERS, "conveyor", GTCompassNodes.COVER))
                    .register() :
            null;

    public static ItemEntry<Item> ELECTRIC_PISTON_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_electric_piston", Item::new).lang("MAX Electric Piston")
                    .onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "piston")).register() :
            null;

    public static ItemEntry<ComponentItem> ROBOT_ARM_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_robot_arm", ComponentItem::create)
                    .lang("MAX Robot Arm")
                    .onRegister(attach(new CoverPlaceBehavior(GTLCovers.ROBOT_ARM_MAX)))
                    .onRegister(attach(new TooltipBehavior(lines -> {
                        lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                        lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
                    })))
                    .onRegister(compassNodeExist(GTCompassSections.COVERS, "robot_arm", GTCompassNodes.COVER))
                    .register() :
            null;

    public static ItemEntry<Item> FIELD_GENERATOR_MAX = GTCEuAPI.isHighTier() ?
            REGISTRATE.item("max_field_generator", Item::new).lang("MAX Field Generator")
                    .onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "field_generator")).register() :
            null;

    public static ItemEntry<Item> EMITTER_MAX = GTCEuAPI.isHighTier() ? REGISTRATE.item("max_emitter", Item::new)
            .lang("MAX Emitter").onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "emitter")).register() :
            null;

    public static ItemEntry<Item> SENSOR_MAX = GTCEuAPI.isHighTier() ? REGISTRATE.item("max_sensor", Item::new)
            .lang("MAX Sensor").onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "sensor")).register() : null;

    public static ItemEntry<ComponentItem> PRIMITIVE_ROBOT_ARM = REGISTRATE
            .item("primitive_robot_arm", ComponentItem::create)
            .lang("primitive robot Arm")
            .onRegister(attach(new CoverPlaceBehavior(GTLCovers.ROBOT_ARM_ULV)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 33554431));
            })))
            .onRegister(compassNodeExist(GTCompassSections.COVERS, "robot_arm", GTCompassNodes.COVER))
            .register();

    public static ItemEntry<ComponentItem> PRIMITIVE_FLUID_REGULATOR = REGISTRATE
            .item("primitive_fluid_regulator", ComponentItem::create)
            .lang("Primitive Fluid Regulator")
            .onRegister(attach(new CoverPlaceBehavior(GTLCovers.FLUID_REGULATORS_ULV)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.fluid.regulator.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", Integer.MAX_VALUE));
            })))
            .onRegister(compassNodeExist(GTCompassSections.COMPONENTS, "fluid_regulator"))
            .register();

    public static final ItemEntry<ComponentItem> DEBUG_STRUCTURE_WRITER = REGISTRATE
            .item("debug_structure_writer", ComponentItem::create)
            .onRegister(GTItems.attach(StructureWriteBehavior.INSTANCE))
            .register();

    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_1M = registerStorageComponentItem(1);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_4M = registerStorageComponentItem(4);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_16M = registerStorageComponentItem(16);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_64M = registerStorageComponentItem(64);
    public static final ItemEntry<StorageComponentItem> CELL_COMPONENT_256M = registerStorageComponentItem(256);

    public static final ItemEntry<BasicStorageCell> ITEM_CELL_1M = registerStorageCell(1, CELL_COMPONENT_1M, true);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_4M = registerStorageCell(4, CELL_COMPONENT_4M, true);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_16M = registerStorageCell(16, CELL_COMPONENT_16M, true);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_64M = registerStorageCell(64, CELL_COMPONENT_64M, true);
    public static final ItemEntry<BasicStorageCell> ITEM_CELL_256M = registerStorageCell(256, CELL_COMPONENT_256M,
            true);

    public static final ItemEntry<BasicStorageCell> FLUID_CELL_1M = registerStorageCell(1, CELL_COMPONENT_1M, false);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_4M = registerStorageCell(4, CELL_COMPONENT_4M, false);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_16M = registerStorageCell(16, CELL_COMPONENT_16M, false);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_64M = registerStorageCell(64, CELL_COMPONENT_64M, false);
    public static final ItemEntry<BasicStorageCell> FLUID_CELL_256M = registerStorageCell(256, CELL_COMPONENT_256M,
            false);

    public static final ItemEntry<PortableCellItem> SUPER_PORTABLE_ITEM_CELL = REGISTRATE
            .item("super_portable_item_storage_cell", p -> new PortableCellItem(AEKeyType.items(),
                    63,
                    MEStorageMenu.PORTABLE_ITEM_CELL_TYPE,
                    new StorageTier(100, "super", Integer.MAX_VALUE, 100, WETWARE_MAINFRAME_UHV),
                    p.stacksTo(1), 0xDDDDDD))
            .register();

    public static final ItemEntry<PortableCellItem> SUPER_PORTABLE_FLUID_CELL = REGISTRATE
            .item("super_portable_fluid_storage_cell", p -> new PortableCellItem(AEKeyType.fluids(),
                    18,
                    MEStorageMenu.PORTABLE_ITEM_CELL_TYPE,
                    new StorageTier(100, "super", Integer.MAX_VALUE, 100, WETWARE_MAINFRAME_UHV),
                    p.stacksTo(1), 0xFF6D36))
            .register();

    public static void InitUpgrades() {
        String storageCellGroup = GuiText.StorageCells.getTranslationKey();
        String portableCellGroup = GuiText.PortableCells.getTranslationKey();

        var itemCells = List.of(
                ITEM_CELL_1M, ITEM_CELL_4M, ITEM_CELL_16M, ITEM_CELL_64M,
                ITEM_CELL_256M);
        for (var itemCell : itemCells) {
            Upgrades.add(AEItems.FUZZY_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.INVERTER_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, itemCell, 1, storageCellGroup);
        }

        var fluidCells = List.of(
                FLUID_CELL_1M, FLUID_CELL_4M, FLUID_CELL_16M, FLUID_CELL_64M,
                FLUID_CELL_256M);
        for (var fluidCell : fluidCells) {
            Upgrades.add(AEItems.INVERTER_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, fluidCell, 1, storageCellGroup);
        }

        Upgrades.add(AEItems.FUZZY_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.INVERTER_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.VOID_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.ENERGY_CARD, SUPER_PORTABLE_ITEM_CELL, 2, portableCellGroup);

        Upgrades.add(AEItems.INVERTER_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.VOID_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.ENERGY_CARD, SUPER_PORTABLE_FLUID_CELL, 2, portableCellGroup);
    }
}