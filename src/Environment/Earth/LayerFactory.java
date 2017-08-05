/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Nathius
 */
public class LayerFactory {

    public static Random s_random;
    
    private enum LayerTypes
    {
        SOIL,
        SEDIMENTARY,
        IGNEOUS_EXTRUSIVE,
        IGNEOUS_INTRUSIVE,
        METAMORPHIC,
        COUNT
    };
    
    private class StoneHasOre
    {
        public StoneType stone;
        public OreType ore;
        public StoneHasOre(StoneType inStone, OreType inOre)
        {
            stone = inStone;
            ore = inOre;
        }
    }
    
    private class StoneHasGem
    {
        public StoneType stone;
        public GemType gem;
        public StoneHasGem(StoneType inStone, GemType inGem)
        {
            stone = inStone;
            gem = inGem;
        }
    }
    
    private static LayerFactory s_factory;
    
    private List<StoneHasOre> m_stoneContainsOres;
    private List<StoneHasGem> m_stoneContainsGems;
    
    private Map<LayerTypes, HashMap<String, StoneType> > m_layerTypeContainStones;
    
    private static void create() {
        s_factory = new LayerFactory();
        s_random = new Random();
    }
    
    public static LayerFactory getLayerFactory()
    {
        if(s_factory == null)
        {
            create();
        }
        return s_factory;
    }
    
    
    private LayerFactory()
    {
        //Set up and get the Stone type lists
        StoneTypeMappings.InitMappings();
        HashMap<String, StoneType> soilStones = StoneTypeMappings.GetSoilStones();
        HashMap<String, StoneType> sedimentaryStones = StoneTypeMappings.GetSedimentaryStones();
        HashMap<String, StoneType> igneousIntrusive = StoneTypeMappings.GetIgneousIntrusive();
        HashMap<String, StoneType> igneousExtrusive = StoneTypeMappings.GetIgneousExtrusive();
        HashMap<String, StoneType> metamorphicStones = StoneTypeMappings.GetMetamorphicStones();
        
        //Create the ores and
        //set up the ores contained in each stone type
        InitStoneContainsOreList(
            sedimentaryStones, 
            igneousIntrusive,
            igneousExtrusive,
            metamorphicStones);
        
        InitGemContainsOreList(
            sedimentaryStones, 
            igneousIntrusive,
            igneousExtrusive,
            metamorphicStones);
        
        //add all stones to the layer type stone lists
        m_layerTypeContainStones = new HashMap();
        m_layerTypeContainStones.put(LayerTypes.SOIL, soilStones);
        m_layerTypeContainStones.put(LayerTypes.METAMORPHIC, metamorphicStones);
        m_layerTypeContainStones.put(LayerTypes.IGNEOUS_EXTRUSIVE, igneousExtrusive);
        m_layerTypeContainStones.put(LayerTypes.SEDIMENTARY, sedimentaryStones);
        m_layerTypeContainStones.put(LayerTypes.IGNEOUS_INTRUSIVE, igneousIntrusive);
    }
    
    private void InitStoneContainsOreList(
        HashMap<String, StoneType> sedimentaryStones,
        HashMap<String, StoneType> igneousIntrusive,
        HashMap<String, StoneType> igneousExtrusive,
        HashMap<String, StoneType> metamorphicStones)
    {
        int defaultOreValue = 20;
        m_stoneContainsOres = new ArrayList();
        
        OreType nativeAluminum = new OreType("Native Aluminum", defaultOreValue, Color.gray);
        Iterator<StoneType> iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeAluminum));
        }
        
        OreType cassiterite = new OreType("Cassiterite", defaultOreValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), cassiterite));
        }
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), cassiterite));
        
        OreType nativeCopper = new OreType("Native Copper", defaultOreValue, Color.red);
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeCopper));
        }
        
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Sandstone"), nativeCopper));
        
        OreType gelena = new OreType("Gelena", defaultOreValue, Color.gray);
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), gelena));
        }
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), gelena));
        }
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), gelena));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Limestone"), gelena));
        
        OreType garnierite = new OreType("Garnierite", defaultOreValue, Color.green);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gabbro"), garnierite));
        
        OreType nativeGold = new OreType("Native Gold", defaultOreValue, Color.yellow);
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeGold));
        }
        iterator = igneousIntrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeGold));
        }
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeGold));
        }

        
        OreType hematite = new OreType("Hematite", defaultOreValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), hematite));
        }
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), hematite));
        }
        
        OreType nativeSilver = new OreType("Native Silver", defaultOreValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), nativeSilver));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gneiss"), nativeSilver));
        
        OreType limonite = new OreType("Limonite", defaultOreValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), limonite));
        }
        
        OreType magnetite = new OreType("Magnetite", defaultOreValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), magnetite));
        }
        
        OreType malachite = new OreType("Malachite", defaultOreValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Limestone"), malachite));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Marble"), malachite));
        
        OreType nativePlatinum = new OreType("Native Platinum", defaultOreValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativePlatinum));
        }
        
        OreType sphalerite = new OreType("Sphalerite", defaultOreValue, Color.gray);
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), sphalerite));
        }
        
        OreType tetrahedrite = new OreType("Tetrahedrite", defaultOreValue, Color.gray);
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), tetrahedrite));
        }
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), tetrahedrite));
        }
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), tetrahedrite));
        }
        iterator = igneousIntrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), tetrahedrite));
        }
    }
    
    private void InitGemContainsOreList(
        HashMap<String, StoneType> sedimentaryStones,
        HashMap<String, StoneType> igneousIntrusive,
        HashMap<String, StoneType> igneousExtrusive,
        HashMap<String, StoneType> metamorphicStones)
    {
        m_stoneContainsGems = new ArrayList();
        
        GemType amberOpal = new GemType("Amber Opal", 30, 50, Color.gray);
        Iterator<StoneType> iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), amberOpal));
        }
        
        GemType aventurine = new GemType("Aventurine", 9, 15, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), aventurine));
        }
        
        GemType bandedAgate = new GemType("Banded Agate", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), bandedAgate));
        }
        
        GemType bloodstone = new GemType("Bloodstone", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), bloodstone));
        }
        
        GemType blueJade = new GemType("Blue Jade", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), blueJade));
        }
        
        GemType boneOpal = new GemType("Bone Opal", 30, 50, Color.gray);
        iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), boneOpal));
        }
        
        GemType brownJasper = new GemType("Brown Jasper", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), brownJasper));
        }
        
        GemType carnelian = new GemType("Carnelian", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), carnelian));
        }
        
        GemType cherryOpal = new GemType("Cherry Opal", 30, 50, Color.gray);
        iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), cherryOpal));
        }
        
        GemType chrysocolla = new GemType("Chrysocolla", 6, 10, Color.gray);
        m_stoneContainsGems.add(new StoneHasGem(StoneType.GetStoneTypeByName("Malachite"), chrysocolla));
        
        GemType chrysoprase = new GemType("Chrysoprase", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), chrysoprase));
        }
        
        GemType citrine = new GemType("Citrine", 6, 10, Color.gray);
        iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), citrine));
        }
        
        GemType clearTourmaline = new GemType("Clear Tourmaline", 30, 50, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), clearTourmaline));
        }
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), clearTourmaline));
        }
        m_stoneContainsGems.add(new StoneHasGem(StoneType.GetStoneTypeByName("Granite"), clearTourmaline));
        
        GemType dendriticAgate = new GemType("Dendritic Agate", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), dendriticAgate));
        }
        
        GemType fireAgate = new GemType("Fire Agate", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), fireAgate));
        }
        
        GemType fortificationAgate = new GemType("Fortification Agate", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), fortificationAgate));
        }
        
        GemType goldOpal = new GemType("Gold Opal", 30, 50, Color.gray);
        iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), goldOpal));
        }
        
        GemType grayChalcedony = new GemType("Fortification Agate", 6, 10, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), grayChalcedony));
        }
        
        GemType jasperOpal = new GemType("Jasper Opal", 30, 50, Color.gray);
        iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), jasperOpal));
        }
    }
    
    public StoneType getRandomStoneType()
    {
        List<StoneType> allStones = StoneType.getAllStones();
        int num = s_random.nextInt(allStones.size());
        return allStones.get(num);
    }
    
    public StoneType getRandomStoneTypeForLayer(LayerTypes inLayerType)
    {
        HashMap<String, StoneType> allStones = m_layerTypeContainStones.get(inLayerType);
        int num = s_random.nextInt(allStones.size());
        return (StoneType)allStones.values().toArray()[num];
    }
    
    public OreType getRandomOre()
    {
        List<OreType> allOres = OreType.getAllOres();
        int num = s_random.nextInt(allOres.size());
        return allOres.get(num);
    }
    
    public Deposit getRandomOreDepositForStone(StoneType inStone)
    {
        List<OreType> allOres = new ArrayList<OreType>();
        for(int i = 0; i < m_stoneContainsOres.size(); i++)
        {
            if(m_stoneContainsOres.get(i).stone == inStone)
            {
                allOres.add(m_stoneContainsOres.get(i).ore);
            }
        }
        
        int num = s_random.nextInt(allOres.size());
        
        Deposit newDeposit = Deposit.GenerateDeposit(allOres.get(num), 10, 100, 10, 100);
        return newDeposit;
    }
    
    public Deposit getRandomGemDepositForStone(StoneType inStone)
    {
        List<GemType> allGems = new ArrayList<GemType>();
        for(int i = 0; i < m_stoneContainsGems.size(); i++)
        {
            if(m_stoneContainsGems.get(i).stone == inStone)
            {
                allGems.add(m_stoneContainsGems.get(i).gem);
            }
        }
        
        int num = s_random.nextInt(allGems.size());
        
        Deposit newDeposit = Deposit.GenerateDeposit(allGems.get(num), 10, 100, 10, 100);
        return newDeposit;
    }
    
    public List<Layer> makeLayers(int numLayers)
    {
        if(numLayers > 50 || numLayers < 10)
        {
            numLayers = s_random.nextInt(30) + 15;
        }
        List<Layer> layers = new ArrayList();
        
        int currentDepth = 1;
        int numSoil = 3;
        int perLevel = (numLayers - numSoil) / 4;
        int maxOresPerLayer = 3;
        
        //generate soil levels
        for(int i = 0; i < numSoil; i++)
        {
            layers.add(new Layer(currentDepth++, getRandomStoneTypeForLayer(LayerTypes.SOIL), new ArrayList<Deposit>()));
        }
        
        //generate sedimentary layers
        for(int i = 0; i < perLevel; i++)
        {
            Layer temp = randomLayerByType(LayerTypes.SEDIMENTARY, maxOresPerLayer);
            temp.setDepth(currentDepth++);
            layers.add(temp);
        }
        
        for(int i = 0; i < perLevel; i++)
        {
            Layer temp = randomLayerByType(LayerTypes.IGNEOUS_EXTRUSIVE, maxOresPerLayer);
            temp.setDepth(currentDepth++);
            layers.add(temp);
        }
        
        for(int i = 0; i < perLevel; i++)
        {
            Layer temp = randomLayerByType(LayerTypes.METAMORPHIC, maxOresPerLayer);
            temp.setDepth(currentDepth++);
            layers.add(temp);
        }
        
        for(int i = 0; i < perLevel; i++)
        {
            Layer temp = randomLayerByType(LayerTypes.IGNEOUS_INTRUSIVE, maxOresPerLayer);
            temp.setDepth(currentDepth++);
            layers.add(temp);
        }

        return layers;
    }
    
    public Layer randomLayerByType(LayerTypes inType, int inMaxOresPerLayer)
    {
        StoneType stone = getRandomStoneTypeForLayer(inType);
        List<Deposit> depositsForLayer = new ArrayList<Deposit>();
        
        //get a random number of ore deposits
        int numToGen = s_random.nextInt(inMaxOresPerLayer);
        for(int j = 0; j < numToGen; j++)
        {
            depositsForLayer.add(getRandomOreDepositForStone(stone));
        }
        
        //TODO get random number of gem deposits
        numToGen = s_random.nextInt(inMaxOresPerLayer);
        for(int j = 0; j < numToGen; j++)
        {
            depositsForLayer.add(getRandomGemDepositForStone(stone));
        }
        
        return new Layer(0 ,stone , depositsForLayer);
    }
    
}

