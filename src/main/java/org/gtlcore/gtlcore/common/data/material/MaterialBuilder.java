package org.gtlcore.gtlcore.common.data.material;

import org.gtlcore.gtlcore.api.data.chemical.material.info.GTLMaterialFlags;
import org.gtlcore.gtlcore.api.data.chemical.material.info.GTLMaterialIconSet;
import org.gtlcore.gtlcore.common.data.GTLElements;
import org.gtlcore.gtlcore.config.ConfigHolder;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gtlcore.gtlcore.common.data.GTLMaterials.*;

public class MaterialBuilder {

    public static void init() {
        PotassiumPyrosulfate = new Material.Builder(GTCEu.id("potassium_pyrosulfate"))
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 7)
                .color(0xff9900).iconSet(METALLIC)
                .buildAndRegister();
        PlatinumSlag = new Material.Builder(GTCEu.id("platinum_slag"))
                .dust()
                .color(0x343318).iconSet(DULL)
                .buildAndRegister().setFormula("IrOsRhRu??");
        LeachResidue = new Material.Builder(GTCEu.id("leach_residue"))
                .dust()
                .color(0x644629).iconSet(DULL)
                .buildAndRegister().setFormula("IrOsRhRu?");
        ZincSulfate = new Material.Builder(GTCEu.id("zinc_sulfate"))
                .dust()
                .components(Zinc, 1, Sulfur, 1, Oxygen, 4)
                .color(0x533c1b).iconSet(SAND)
                .buildAndRegister();
        RhodiumNitrate = new Material.Builder(GTCEu.id("rhodium_nitrate"))
                .dust()
                .color(0x8C5A0C).iconSet(SAND)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rhodium, 1, Nitrogen, 1, Oxygen, 3, Concrete, 1)
                .buildAndRegister();
        RoughlyRhodiumMetal = new Material.Builder(GTCEu.id("roughly_rhodium_metal"))
                .dust()
                .color(0x594C1A).iconSet(SAND)
                .buildAndRegister().setFormula("?Rh?");
        ReprecipitatedRhodium = new Material.Builder(GTCEu.id("reprecipitated_rhodium"))
                .dust()
                .color(0xD40849).iconSet(SAND)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rhodium, 1, Nitrogen, 1, Hydrogen, 4)
                .buildAndRegister();
        SodiumNitrate = new Material.Builder(GTCEu.id("sodium_nitrate"))
                .dust()
                .color(0x4e2a40).iconSet(SAND)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .buildAndRegister();
        RhodiumSalt = new Material.Builder(GTCEu.id("rhodium_salt"))
                .dust()
                .color(0x61200A).iconSet(SAND)
                .buildAndRegister().setFormula("NaRhCl?");
        RhodiumSaltSolution = new Material.Builder(GTCEu.id("rhodium_salt_solution"))
                .fluid()
                .color(0x61200A).iconSet(SAND)
                .buildAndRegister().setFormula("Rh(NaCl)2Cl");
        RhodiumFilterCake = new Material.Builder(GTCEu.id("rhodium_filter_cake"))
                .dust()
                .color(0x87350C).iconSet(ROUGH)
                .buildAndRegister().setFormula("?Rh?");
        RhodiumFilterCakeSolution = new Material.Builder(GTCEu.id("rhodium_filter_cake_solution"))
                .fluid()
                .color(0x87350C).iconSet(ROUGH)
                .buildAndRegister().setFormula("?Rh?");
        SodiumRutheniate = new Material.Builder(GTCEu.id("sodium_rutheniate"))
                .dust()
                .color(0x282C8C).iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Oxygen, 4, Ruthenium, 1)
                .buildAndRegister();
        IridiumDioxide = new Material.Builder(GTCEu.id("iridium_dioxide"))
                .dust()
                .color(0xA2BFFF).iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Oxygen, 2)
                .buildAndRegister();
        RutheniumTetroxideLQ = new Material.Builder(GTCEu.id("ruthenium_tetroxide_lq"))
                .fluid()
                .color(0xA8A8A8).iconSet(ROUGH)
                .buildAndRegister();
        SodiumFormate = new Material.Builder(GTCEu.id("sodium_formate"))
                .fluid()
                .color(0xf1939c).iconSet(ROUGH)
                .components(Sodium, 1, Carbon, 1, Oxygen, 2, Hydrogen, 1)
                .buildAndRegister();
        RhodiumSulfateGas = new Material.Builder(GTCEu.id("rhodium_sulfate_gas"))
                .gas()
                .color(0xBD8743).iconSet(ROUGH)
                .buildAndRegister();
        AcidicIridium = new Material.Builder(GTCEu.id("acidic_iridium"))
                .gas()
                .color(0x634E3A).iconSet(ROUGH)
                .buildAndRegister().setFormula("???");
        RutheniumTetroxideHot = new Material.Builder(GTCEu.id("ruthenium_tetroxide_hot"))
                .gas()
                .color(0x9B9B9B).iconSet(ROUGH)
                .buildAndRegister();
        SodiumSulfate = new Material.Builder(GTCEu.id("sodium_sulfate"))
                .dust()
                .components(Sodium, 2, Sulfur, 1, Oxygen, 4)
                .color(0xF9F6CF).iconSet(SAND)
                .buildAndRegister();

        MutatedLivingSolder = new Material.Builder(GTCEu.id("mutated_living_solder"))
                .fluid()
                .color(0xC18FCC).iconSet(METALLIC)
                .radioactiveHazard(1)
                .buildAndRegister();
        SuperMutatedLivingSolder = new Material.Builder(GTCEu.id("super_mutated_living_solder"))
                .fluid()
                .color(0xB662FF).iconSet(METALLIC)
                .radioactiveHazard(2)
                .buildAndRegister();

        HexafluorideEnrichedNaquadahSolution = new Material.Builder(GTCEu.id("hexafluoride_enriched_naquadah_solution"))
                .fluid()
                .color(0x868D7F)
                .components(NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        XenonHexafluoroEnrichedNaquadate = new Material.Builder(GTCEu.id("xenon_hexafluoro_enriched_naquadate"))
                .fluid()
                .color(0x255A55)
                .components(Xenon, 1, NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        GoldTrifluoride = new Material.Builder(GTCEu.id("gold_trifluoride"))
                .dust()
                .color(0xE8C478)
                .iconSet(BRIGHT)
                .components(Gold, 1, Fluorine, 3)
                .buildAndRegister();
        XenoauricFluoroantimonicAcid = new Material.Builder(GTCEu.id("xenoauric_fluoroantimonic_acid"))
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xE0BD74)
                .components(Xenon, 1, Gold, 1, Antimony, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        GoldChloride = new Material.Builder(GTCEu.id("gold_chloride"))
                .fluid()
                .color(0xCCCC66)
                .components(Gold, 2, Chlorine, 6)
                .buildAndRegister();
        BromineTrifluoride = new Material.Builder(GTCEu.id("bromine_trifluoride"))
                .fluid()
                .color(0xA88E57)
                .components(Bromine, 1, Fluorine, 3)
                .buildAndRegister();
        HexafluorideNaquadriaSolution = new Material.Builder(GTCEu.id("hexafluoride_naquadria_solution"))
                .fluid()
                .color(0x25C213)
                .components(Naquadria, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        RadonDifluoride = new Material.Builder(GTCEu.id("radon_difluoride"))
                .fluid()
                .color(0x8B7EFF)
                .components(Radon, 1, Fluorine, 2)
                .buildAndRegister();
        RadonNaquadriaOctafluoride = new Material.Builder(GTCEu.id("radon_naquadria_octafluoride"))
                .fluid()
                .color(0x85F378)
                .components(Radon, 1, Naquadria, 1, Fluorine, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        CaesiumFluoride = new Material.Builder(GTCEu.id("caesium_fluoride"))
                .fluid()
                .color(0xFF7A5F)
                .components(Caesium, 1, Fluorine, 1)
                .buildAndRegister();
        XenonTrioxide = new Material.Builder(GTCEu.id("xenon_trioxide"))
                .fluid()
                .color(0x359FC3)
                .components(Xenon, 1, Oxygen, 3)
                .buildAndRegister();
        CaesiumXenontrioxideFluoride = new Material.Builder(GTCEu.id("caesium_xenontrioxide_fluoride"))
                .fluid()
                .color(0x5067D7)
                .components(Caesium, 1, Xenon, 1, Oxygen, 3, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        NaquadriaCaesiumXenonnonfluoride = new Material.Builder(GTCEu.id("naquadria_caesium_xenonnonfluoride"))
                .fluid()
                .color(0x54C248)
                .components(Naquadria, 1, Caesium, 1, Xenon, 1, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        RadonTrioxide = new Material.Builder(GTCEu.id("radon_trioxide"))
                .fluid()
                .color(0x9A6DD7)
                .components(Radon, 1, Oxygen, 3)
                .buildAndRegister();
        NaquadriaCaesiumfluoride = new Material.Builder(GTCEu.id("naquadria_caesiumfluoride"))
                .fluid()
                .color(0xAAEB69)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF", true);
        NitrosoniumOctafluoroxenate = new Material.Builder(GTCEu.id("nitrosonium_octafluoroxenate"))
                .fluid()
                .color(0x953D9F)
                .components(NitrogenDioxide, 2, Xenon, 1, Fluorine, 8)
                .buildAndRegister()
                .setFormula("(NO2)2XeF8", true);
        NitrylFluoride = new Material.Builder(GTCEu.id("nitryl_fluoride"))
                .fluid()
                .color(0x8B7EFF)
                .components(Nitrogen, 1, Oxygen, 2, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AcidicNaquadriaCaesiumfluoride = new Material.Builder(GTCEu.id("acidic_naquadria_caesiumfluoride"))
                .fluid()
                .color(0x75EB00)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1, Sulfur, 2, Oxygen, 8)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*F2CsF(SO4)2", true);

        SupercriticalSteam = new Material.Builder(GTCEu.id("supercritical_steam"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0xC4C4C4)
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        WaterAgarMix = new Material.Builder(GTCEu.id("water_agar_mix"))
                .fluid()
                .color(0x88FFC0)
                .buildAndRegister();

        TungstenTrioxide = new Material.Builder(GTCEu.id("tungsten_trioxide"))
                .dust()
                .components(Tungsten, 1, Oxygen, 3)
                .color(0x86FF75).iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        SpaceTime = new Material.Builder(GTCEu.id("spacetime"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1).customStill())
                .fluidPipeProperties(2147483647, ConfigHolder.INSTANCE.spacetimePip, true, true, true, true)
                .element(GTLElements.SPACETIME)
                .iconSet(new MaterialIconSet("spacetime"))
                .flags(GTLMaterialFlags.GENERATE_NANOSWARM, MaterialFlags.NO_UNIFICATION)
                .cableProperties(Integer.MAX_VALUE, 524288, 0, true)
                .buildAndRegister();

        Infinity = new Material.Builder(GTCEu.id("infinity"))
                .ingot()
                .liquid(new FluidBuilder().temperature(1000000).customStill())
                .blastTemp(32000, BlastProperty.GasTier.HIGHEST)
                .element(GTLElements.INFINITY)
                .iconSet(new MaterialIconSet("infinity"))
                .flags(MaterialFlags.GENERATE_FRAME)
                .cableProperties(Integer.MAX_VALUE, 8192, 0, true)
                .buildAndRegister();

        CompoundTriniite = new Material.Builder(GTCEu.id("trinium_compound"))
                .dust()
                .ore()
                .components(Trinium, 3, Actinium, 3, Selenium, 4, Astatine, 4)
                .color(0x675989).iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        CrystallineNitricAcid = new Material.Builder(GTCEu.id("crystalline_nitric_acid"))
                .dust()
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 3)
                .color(0xCDBD14)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SodiumChlorate = new Material.Builder(GTCEu.id("sodium_chlorate"))
                .dust()
                .components(Sodium, 1, Chlorine, 1, Oxygen, 3)
                .color(0xA5A5A5)
                .buildAndRegister();
        SodiumPerchlorate = new Material.Builder(GTCEu.id("sodium_perchlorate"))
                .dust()
                .components(Sodium, 1, Chlorine, 1, Oxygen, 4)
                .color(0xF0F0F0)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        ActiniumTriniumHydroxides = new Material.Builder(GTCEu.id("actinium_trinium_hydroxides"))
                .dust()
                .color(0xAD47CF).iconSet(ROUGH)
                .buildAndRegister().setFormula("Ke3Ac2(OH)12");
        SeleniumOxide = new Material.Builder(GTCEu.id("selenium_oxide"))
                .dust()
                .components(Selenium, 1, Oxygen, 2)
                .color(0xFFF71C).iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        TriniumTetrafluoride = new Material.Builder(GTCEu.id("trinium_tetrafluoride"))
                .dust()
                .color(0x529E57)
                .components(Trinium, 1, Fluorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Fluorocarborane = new Material.Builder(GTCEu.id("fluorocarborane"))
                .dust()
                .components(Hydrogen, 1, Carbon, 1, Hydrogen, 1, Boron, 11, Fluorine, 11)
                .color(0x00EC80).iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        CaesiumNitrate = new Material.Builder(GTCEu.id("caesium_nitrate"))
                .dust()
                .components(Caesium, 1, Nitrogen, 1, Oxygen, 3)
                .color(0x821EC7).iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        CesiumCarborane = new Material.Builder(GTCEu.id("cesium_carborane"))
                .dust()
                .components(Caesium, 1, Carbon, 1, Boron, 11, Hydrogen, 12)
                .color(0xAE6EDA).iconSet(SAND)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SilverIodide = new Material.Builder(GTCEu.id("silver_iodide"))
                .dust()
                .components(Silver, 1, Iodine, 1)
                .color(0xACA56A).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SilverNitrate = new Material.Builder(GTCEu.id("silver_nitrate"))
                .dust()
                .components(Silver, 1, Nitrogen, 1, Oxygen, 3)
                .color(0xFFFCE0).iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        TrifluoroaceticPhosphateEster = new Material.Builder(GTCEu.id("trifluoroacetic_phosphate_ester"))
                .dust()
                .components(Carbon, 8, Hydrogen, 5, Fluorine, 3, Oxygen, 2, Sulfur, 1)
                .color(0xA99F45).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        RadiumNitrate = new Material.Builder(GTCEu.id("radium_nitrate"))
                .dust()
                .color(0xCD40DA).iconSet(SAND)
                .buildAndRegister().setFormula("Ra(NO3)2");
        ActiniumNitrate = new Material.Builder(GTCEu.id("actinium_nitrate"))
                .dust()
                .color(0xDAE0EE).iconSet(DULL)
                .buildAndRegister().setFormula("Ac(NO3)3");
        PotassiumFluoride = new Material.Builder(GTCEu.id("potassium_fluoride"))
                .dust()
                .components(Potassium, 1, Fluorine, 1)
                .color(0xB9B9B9).iconSet(BRIGHT)
                .buildAndRegister();
        SodiumHydride = new Material.Builder(GTCEu.id("sodium_hydride"))
                .dust()
                .components(Sodium, 1, Hydrogen, 1)
                .color(0x757475).iconSet(DULL)
                .buildAndRegister();
        CesiumCarboranePrecursor = new Material.Builder(GTCEu.id("cesium_carborane_precursor"))
                .dust()
                .color(0xBA5C69).iconSet(DULL)
                .buildAndRegister().setFormula("CsB10H12CN(CH3)3Cl");
        LithiumAluminiumHydride = new Material.Builder(GTCEu.id("lithium_aluminium_hydride"))
                .dust()
                .components(Lithium, 1, Aluminium, 1, Hydrogen, 1)
                .color(0xABD7DF).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        LithiumAluminiumFluoride = new Material.Builder(GTCEu.id("lithium_aluminium_fluoride"))
                .dust()
                .components(Aluminium, 1, Fluorine, 4, Lithium, 1)
                .color(0xAD1F58).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AluminiumTrifluoride = new Material.Builder(GTCEu.id("aluminium_trifluoride"))
                .dust()
                .components(Aluminium, 1, Fluorine, 3)
                .color(0xB8601A).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SodiumAluminiumHydride = new Material.Builder(GTCEu.id("sodium_aluminium_hydride"))
                .dust()
                .components(Sodium, 1, Aluminium, 1, Hydrogen, 4)
                .color(0x87BFBF).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AluminiumHydride = new Material.Builder(GTCEu.id("aluminium_hydride"))
                .dust()
                .components(Aluminium, 1, Hydrogen, 3)
                .color(0x315C6E).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Alumina = new Material.Builder(GTCEu.id("alumina"))
                .dust()
                .components(Aluminium, 2, Oxygen, 3)
                .color(0x1D4759).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        CaesiumHydroxide = new Material.Builder(GTCEu.id("caesium_hydroxide"))
                .dust()
                .components(Caesium, 1, Oxygen, 1, Hydrogen, 1)
                .color(0xD7D7D7).iconSet(DULL)
                .buildAndRegister();
        Decaborane = new Material.Builder(GTCEu.id("decaborane"))
                .dust()
                .components(Boron, 10, Hydrogen, 14)
                .color(0x95B78F).iconSet(SAND)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SodiumTetrafluoroborate = new Material.Builder(GTCEu.id("sodium_tetrafluoroborate"))
                .dust()
                .components(Sodium, 1, Boron, 1, Fluorine, 4)
                .color(0xA6640F).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        SodiumBorohydride = new Material.Builder(GTCEu.id("sodium_borohydride"))
                .dust()
                .components(Sodium, 1, Boron, 1, Hydrogen, 4)
                .color(0x9AB0B2).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        PhosphorusPentasulfide = new Material.Builder(GTCEu.id("phosphorus_pentasulfide"))
                .dust()
                .components(Phosphorus, 4, Sulfur, 10)
                .color(0xE7A123).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        StoneDustResidue = new Material.Builder(GTCEu.id("stone_dust_residue"))
                .dust()
                .color(0x585858).iconSet(DULL)
                .buildAndRegister();
        AmmoniumBifluoride = new Material.Builder(GTCEu.id("ammonium_bifluoride"))
                .dust()
                .components(Nitrogen, 1, Hydrogen, 4, Hydrogen, 1, Fluorine, 2)
                .color(0x26C6BB).iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        UncommonResidues = new Material.Builder(GTCEu.id("uncommon_residues"))
                .dust()
                .color(0x3F46BD).iconSet(SAND)
                .buildAndRegister();
        PartiallyOxidizedResidues = new Material.Builder(GTCEu.id("partially_oxidized_residues"))
                .dust()
                .color(0x8F1515).iconSet(SAND)
                .buildAndRegister();
        InertResidues = new Material.Builder(GTCEu.id("inert_residues"))
                .dust()
                .color(0x4F4863).iconSet(BRIGHT)
                .buildAndRegister();
        OxidizedResidues = new Material.Builder(GTCEu.id("oxidized_residues"))
                .dust()
                .color(0x330D4A).iconSet(SAND)
                .buildAndRegister();
        HeavyOxidizedResidues = new Material.Builder(GTCEu.id("heavy_oxidized_residues"))
                .dust()
                .color(0x310D48).iconSet(SAND)
                .buildAndRegister();
        CleanInertResidues = new Material.Builder(GTCEu.id("clean_inert_residues"))
                .dust()
                .color(0x187F4D).iconSet(BRIGHT)
                .buildAndRegister();
        MetallicResidues = new Material.Builder(GTCEu.id("metallic_residues"))
                .dust()
                .color(0x205A53).iconSet(SAND)
                .buildAndRegister();
        HeavyMetallicResidues = new Material.Builder(GTCEu.id("heavy_metallic_residues"))
                .dust()
                .color(0x1C0986).iconSet(SAND)
                .buildAndRegister();
        DiamagneticResidues = new Material.Builder(GTCEu.id("diamagnetic_residues"))
                .dust()
                .color(0x30845E).iconSet(SAND)
                .buildAndRegister();
        ParamagneticResidues = new Material.Builder(GTCEu.id("paramagnetic_residues"))
                .dust()
                .color(0x25788B).iconSet(SAND)
                .buildAndRegister();
        FerromagneticResidues = new Material.Builder(GTCEu.id("ferromagnetic_residues"))
                .dust()
                .color(0x1F5D46).iconSet(SAND)
                .buildAndRegister();
        HeavyDiamagneticResidues = new Material.Builder(GTCEu.id("heavy_diamagnetic_residues"))
                .dust()
                .color(0x22316A).iconSet(SAND)
                .buildAndRegister();
        HeavyParamagneticResidues = new Material.Builder(GTCEu.id("heavy_paramagnetic_residues"))
                .dust()
                .color(0x1A8E2F).iconSet(SAND)
                .buildAndRegister();
        HeavyFerromagneticResidues = new Material.Builder(GTCEu.id("heavy_ferromagnetic_residues"))
                .dust()
                .color(0x26743E).iconSet(SAND)
                .buildAndRegister();
        ExoticHeavyResidues = new Material.Builder(GTCEu.id("exotic_heavy_residues"))
                .dust()
                .color(0x3E8496).iconSet(BRIGHT)
                .buildAndRegister();

        FumingNitricAcid = new Material.Builder(GTCEu.id("fuming_nitric_acid"))
                .fluid()
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 3)
                .color(0xB46800).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Perfluorobenzene = new Material.Builder(GTCEu.id("perfluorobenzene"))
                .fluid()
                .components(Carbon, 6, Fluorine, 6)
                .color(0x15752B).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Trimethylsilane = new Material.Builder(GTCEu.id("trimethylsilane"))
                .fluid()
                .components(Carbon, 3, Hydrogen, 10, Silicon, 1)
                .color(0x7D2FC3).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Trimethylchlorosilane = new Material.Builder(GTCEu.id("trimethylchlorosilane"))
                .fluid()
                .color(0x591399).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(CH3)3SiCl");
        NitratedTriniiteCompoundSolution = new Material.Builder(GTCEu.id("nitrated_triniite_compound_solution"))
                .fluid()
                .color(0x5E9699).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        ResidualTriniiteSolution = new Material.Builder(GTCEu.id("residual_triniite_solution"))
                .fluid()
                .color(0x68B59).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        ActiniumRadiumHydroxideSolution = new Material.Builder(GTCEu.id("actinium_radium_hydroxide_solution"))
                .fluid()
                .color(0xC3E0DC).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        ActiniumRadiumNitrateSolution = new Material.Builder(GTCEu.id("actinium_radium_nitrate_solution"))
                .fluid()
                .color(0x89C0B3).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        HeavilyFluorinatedTriniumSolution = new Material.Builder(GTCEu.id("heavily_fluorinated_trinium_solution"))
                .fluid()
                .color(0x169A33).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        EthyleneSulfide = new Material.Builder(GTCEu.id("ethylene_sulfide"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 6, Sulfur, 1, Oxygen, 1)
                .color(0x868544).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        EthylTrifluoroacetate = new Material.Builder(GTCEu.id("ethyl_trifluoroacetate"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 5, Fluorine, 3, Oxygen, 2)
                .color(0x93A658).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AcetylChloride = new Material.Builder(GTCEu.id("acetyl_chloride"))
                .fluid()
                .components(Carbon, 2, Hydrogen, 3, Oxygen, 1, Chlorine, 1)
                .color(0xD1B117).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        KryptonDifluoride = new Material.Builder(GTCEu.id("krypton_difluoride"))
                .fluid()
                .components(Krypton, 1, Fluorine, 2)
                .color(0x3FF12B).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        MoltenCalciumSalts = new Material.Builder(GTCEu.id("molten_calcium_salts"))
                .fluid()
                .color(0x7F478B)
                .iconSet(DULL)
                .buildAndRegister();
        Trimethylamine = new Material.Builder(GTCEu.id("trimethylamine"))
                .fluid()
                .color(0xCEA67D).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(CH3)3N");
        BoraneDimethylSulfide = new Material.Builder(GTCEu.id("borane_dimethyl_sulfide"))
                .fluid()
                .color(0xCEA67D).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(BH3)(CH3)2S");
        Tetrahydrofuran = new Material.Builder(GTCEu.id("tetrahydrofuran"))
                .fluid()
                .color(0x86E4CE).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(CH2)4O");
        Diborane = new Material.Builder(GTCEu.id("diborane"))
                .fluid()
                .color(0xBEEBCD).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(BH3)2");
        DiethylEther = new Material.Builder(GTCEu.id("diethyl_ether"))
                .fluid()
                .color(0x9AB0B2).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(C2H5)2O");
        BoronTrifluorideAcetate = new Material.Builder(GTCEu.id("boron_trifluoride_acetate"))
                .fluid()
                .color(0x991062).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(BF3)(C2H5)2O");
        SodiumHexafluoroaluminate = new Material.Builder(GTCEu.id("sodium_hexafluoroaluminate"))
                .fluid()
                .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                .color(0xA47732).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        DirtyHexafluorosilicicAcid = new Material.Builder(GTCEu.id("dirty_hexafluorosilicic_acid"))
                .fluid()
                .color(0xDA387D).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("H2SiF6?");
        DiluteHexafluorosilicicAcid = new Material.Builder(GTCEu.id("dilute_hexafluorosilicic_acid"))
                .fluid()
                .color(0x49DF68).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(H2O)2(H2SiF6)");
        FluorosilicicAcid = new Material.Builder(GTCEu.id("fluorosilicic_acid"))
                .fluid()
                .components(Hydrogen, 2, Silicon, 1, Fluorine, 6)
                .color(0x49BF61).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        AmmoniumFluoride = new Material.Builder(GTCEu.id("ammonium_fluoride"))
                .fluid()
                .components(Nitrogen, 1, Hydrogen, 4, Fluorine, 1)
                .color(0xB80926).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        AmmoniumBifluorideSolution = new Material.Builder(GTCEu.id("ammonium_bifluoride_solution"))
                .fluid()
                .color(0xCBC5B7).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(H2O)NH4FHF");
        SodiumHydroxideSolution = new Material.Builder(GTCEu.id("sodium_hydroxide_solution"))
                .fluid()
                .color(0x000791).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(H2O)NaOH");
        RedMud = new Material.Builder(GTCEu.id("red_mud"))
                .fluid()
                .color(0x972903).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("HCl?");
        NeutralisedRedMud = new Material.Builder(GTCEu.id("neutralised_red_mud"))
                .fluid()
                .color(0x972903).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("Fe??");
        RedSlurry = new Material.Builder(GTCEu.id("red_slurry"))
                .fluid()
                .color(0x982902).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("TiO2?");
        FerricReeChloride = new Material.Builder(GTCEu.id("ferric_ree_chloride"))
                .fluid()
                .color(0x68680D).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("Fe?");
        TitanylSulfate = new Material.Builder(GTCEu.id("titanyl_sulfate"))
                .fluid()
                .color(0xF82296).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("TiO(SO4)");
        DioxygenDifluoride = new Material.Builder(GTCEu.id("dioxygen_difluoride"))
                .fluid()
                .components(Fluorine, 1, Oxygen, 1, Oxygen, 1, Fluorine, 1)
                .color(0x18BFB9).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        OxidizedResidualSolution = new Material.Builder(GTCEu.id("oxidized_residual_solution"))
                .fluid()
                .color(0x2CD3CB).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        HeliumIIIHydride = new Material.Builder(GTCEu.id("helium_iii_hydride"))
                .fluid()
                .color(0x9F9F02).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("He_3H");
        UltraacidicResidueSolution = new Material.Builder(GTCEu.id("ultraacidic_residue_solution"))
                .fluid()
                .color(0x848C9A).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister();
        XenicAcid = new Material.Builder(GTCEu.id("xenic_acid"))
                .fluid()
                .components(Hydrogen, 2, Xenon, 1, Oxygen, 4)
                .color(0x443A76).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        DiluteHydrofluoricAcid = new Material.Builder(GTCEu.id("dilute_hydrofluoric_acid"))
                .fluid()
                .color(0x049821).iconSet(GTLMaterialIconSet.LIMPID)
                .buildAndRegister().setFormula("(H2O)(HF)");
        TritiumHydride = new Material.Builder(GTCEu.id("tritium_hydride"))
                .fluid()
                .components(Hydrogen, 1, Tritium, 1)
                .color(0xBA0202).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        DustyLiquidHeliumIII = new Material.Builder(GTCEu.id("dusty_liquid_helium_iii"))
                .fluid()
                .components(Concrete, 1, Helium3, 1)
                .color(0x774060).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        Ozone = new Material.Builder(GTCEu.id("ozone"))
                .fluid()
                .components(Oxygen, 3)
                .color(0x0176C4).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        HydrogenPeroxide = new Material.Builder(GTCEu.id("hydrogen_peroxide"))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 2)
                .color(0xC8FFFF).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        RareEarthChlorides = new Material.Builder(GTCEu.id("rare_earth_chlorides"))
                .fluid()
                .components(Concrete, 1, Chlorine, 1)
                .color(0xBDB76B).iconSet(GTLMaterialIconSet.LIMPID)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        Fluorite = new Material.Builder(GTCEu.id("fluorite"))
                .fluid()
                .dust()
                .components(Calcium, 1, Fluorine, 2)
                .color(0x18B400).iconSet(DULL)
                .buildAndRegister();

        Titanium50 = new Material.Builder(GTCEu.id("titanium_50"))
                .ingot()
                .fluid()
                .element(GTLElements.TITANIUM50)
                .blastTemp(1942)
                .color(0xd58eed)
                .iconSet(METALLIC)
                .buildAndRegister();
    }
}
