package org.gtlcore.gtlcore.common;

import appeng.core.AELog;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.gtlcore.gtlcore.GTLCore;
import org.gtlcore.gtlcore.common.data.*;
import org.gtlcore.gtlcore.common.recipe.condition.OrbitCondition;
import org.gtlcore.gtlcore.config.ConfigHolder;

import static org.gtlcore.gtlcore.api.registries.GTLRegistration.REGISTRATE;

public class CommonProxy {

    public CommonProxy() {
        CommonProxy.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(eventBus);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addMaterialRegistries);
        eventBus.addListener(this::addMaterials);
        eventBus.addListener(this::modifyMaterials);
        eventBus.addGenericListener(Class.class, this::registerRecipeConditions);
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        eventBus.addGenericListener(CoverDefinition.class,this::registerCovers);
    }

    public static void init() {
        GTLCreativeModeTabs.init();
        ConfigHolder.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(this::postRegistrationInitialization).whenComplete((res, err) -> {
            if (err != null) {
                AELog.warn(err);
            }
        });
    }

    public void postRegistrationInitialization() {
        GTLItems.InitUpgrades();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    // You MUST have this for custom materials.
    // Remember to register them not to GT's namespace, but your own.
    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(GTLCore.MOD_ID);
    }

    // As well as this.
    private void addMaterials(MaterialEvent event) {
        GTLMaterials.init();
    }

    // This is optional, though.
    private void modifyMaterials(PostMaterialEvent event) {
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GTLRecipeTypes.init();
    }

    public void registerRecipeConditions(GTCEuAPI.RegisterEvent<String, Class<? extends RecipeCondition>> event) {
        GTRegistries.RECIPE_CONDITIONS.register(OrbitCondition.INSTANCE.getType(), OrbitCondition.class);
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GTLMachines.init();
        GTLMachines.LARGE_SEMI_FLUID_GENERATOR.setRecipeTypes(new GTRecipeType[]{GTLRecipeTypes.SEMI_FLUID_GENERATOR_FUELS});
    }

    private void registerCovers(GTCEuAPI.RegisterEvent<ResourceLocation, CoverDefinition> event) {
        GTLCovers.init();
    }
}
