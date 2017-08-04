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
    
    //1 value = 1 copper
    //10copper = 1 silver
    //100 copper = 1 gold
    //1000 copper = 1 platinum
    //default stone value 1 silver
    private final float m_defaultStoneValue = 10;
    
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
    
    private HashMap<String, StoneType> GetSoilStones()
    {
        HashMap<String, StoneType> soilStones = new HashMap();
        
        soilStones.put("Dirt", new StoneType("Dirt", 0, Color.red));
        soilStones.put("Peat", new StoneType("Peat", 0, Color.yellow));
        soilStones.put("Silt", new StoneType("Silt", 0, Color.gray));
        soilStones.put("Sand", new StoneType("Sand", 0, Color.yellow));
        soilStones.put("Clay", new StoneType("Clay", 0, Color.red));
        
        return soilStones;
    }
    
    private HashMap<String, StoneType> GetSedementaryStones()
    {
        HashMap<String, StoneType> sedimentaryStones = new HashMap();
        
        sedimentaryStones.put("Chalk", new StoneType("Chalk", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Chert", new StoneType("Chert", m_defaultStoneValue, Color.RED));
        sedimentaryStones.put("Clay Stone", new StoneType("Clay Stone", m_defaultStoneValue, Color.gray));
        sedimentaryStones.put("Conglomerate", new StoneType("Conglomerate", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Mudstone", new StoneType("Mudstone", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Limestone", new StoneType("Limestone", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Rock Salt", new StoneType("Rock Salt", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Sandstone", new StoneType("Sandstone", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Shale", new StoneType("Shale", m_defaultStoneValue, Color.gray));
        sedimentaryStones.put("Siltstone", new StoneType("Siltstone", m_defaultStoneValue, Color.yellow));
        
        return sedimentaryStones;
    }
    
    public HashMap<String, StoneType> GetIgneousIntrusiveStones()
    {
        HashMap<String, StoneType> igneousIntrusive = new HashMap();
        
        igneousIntrusive.put("Diorite", new StoneType("Diorite", m_defaultStoneValue, Color.gray));
        igneousIntrusive.put("Gabbro", new StoneType("Gabbro", m_defaultStoneValue, Color.gray));
        igneousIntrusive.put("Granite", new StoneType("Granite", m_defaultStoneValue, Color.gray));
        
        return igneousIntrusive;
    }
    
    public HashMap<String, StoneType> GetIgneousExtrusiveStones()
    {
        HashMap<String, StoneType> igneousExtrusive = new HashMap();
        
        igneousExtrusive.put("Andesite", new StoneType("Andesite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Basalt", new StoneType("Basalt", m_defaultStoneValue, Color.black));
        igneousExtrusive.put("Dacite", new StoneType("Dacite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Felsite", new StoneType("Felsite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Obsidian", new StoneType("Obsidian", m_defaultStoneValue, Color.black));
        igneousExtrusive.put("Rhyolite", new StoneType("Rhyolite", m_defaultStoneValue, Color.gray));
        
        return igneousExtrusive;
    }
    
    public HashMap<String, StoneType> GetMetamorphicStones()
    {
        HashMap<String, StoneType> metamorphicStones = new HashMap();
        
        metamorphicStones.put("Gneiss", new StoneType("Gneiss", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Marble", new StoneType("Marble", m_defaultStoneValue, Color.white));
        metamorphicStones.put("Phyllite", new StoneType("Phyllite", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Quartzite", new StoneType("Quartzite", m_defaultStoneValue, Color.white));
        metamorphicStones.put("Schist", new StoneType("Schist", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Slate", new StoneType("Slate", m_defaultStoneValue, Color.gray));
        
        return metamorphicStones;
    }
    
    private LayerFactory()
    {
        //Set up and get the Stone type lists
        HashMap<String, StoneType> soilStones = GetSoilStones();
        HashMap<String, StoneType> sedimentaryStones = GetSedementaryStones();
        HashMap<String, StoneType> igneousIntrusive = GetIgneousIntrusiveStones();
        HashMap<String, StoneType> igneousExtrusive = GetIgneousExtrusiveStones();
        HashMap<String, StoneType> metamorphicStones = GetMetamorphicStones();
        
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
        m_stoneContainsOres = new ArrayList();
        
        OreType nativeAluminum = new OreType("Native Aluminum", m_defaultStoneValue, Color.gray);
        Iterator<StoneType> iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeAluminum));
        }
        
        OreType cassiterite = new OreType("Cassiterite", m_defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), cassiterite));
        }
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), cassiterite));
        
        OreType nativeCopper = new OreType("Native Copper", m_defaultStoneValue, Color.red);
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeCopper));
        }
        
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Sandstone"), nativeCopper));
        
        OreType gelena = new OreType("Gelena", m_defaultStoneValue, Color.gray);
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
        
        OreType garnierite = new OreType("Garnierite", m_defaultStoneValue, Color.green);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gabbro"), garnierite));
        
        OreType nativeGold = new OreType("Native Gold", m_defaultStoneValue, Color.yellow);
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

        
        OreType hematite = new OreType("Hematite", m_defaultStoneValue, Color.gray);
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
        
        OreType nativeSilver = new OreType("Native Silver", m_defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), nativeSilver));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gneiss"), nativeSilver));
        
        OreType limonite = new OreType("Limonite", m_defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), limonite));
        }
        
        OreType magnetite = new OreType("Magnetite", m_defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), magnetite));
        }
        
        OreType malachite = new OreType("Malachite", m_defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Limestone"), malachite));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Marble"), malachite));
        
        OreType nativePlatinum = new OreType("Native Platinum", m_defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativePlatinum));
        }
        
        OreType sphalerite = new OreType("Sphalerite", m_defaultStoneValue, Color.gray);
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), sphalerite));
        }
        
        OreType tetrahedrite = new OreType("Tetrahedrite", m_defaultStoneValue, Color.gray);
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
        
        GemType amberOpal = new GemType("Amber Opal", m_defaultStoneValue, m_defaultStoneValue * 2, Color.gray);
        Iterator<StoneType> iterator = StoneType.getAllStones().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsGems.add(new StoneHasGem(iterator.next(), amberOpal));
        }
        //m_stoneContainsGems.add(new StoneHasGem(StoneType.GetStoneTypeByName("Granite"), cassiterite));
        
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
        int maxOresPerLayer = 5;
        
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

