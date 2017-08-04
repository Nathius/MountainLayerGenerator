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
    
    private float defaultStoneValue = 10;
    
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
        
        sedimentaryStones.put("Chalk", new StoneType("Chalk", defaultStoneValue, Color.white));
        sedimentaryStones.put("Chert", new StoneType("Chert", defaultStoneValue, Color.RED));
        sedimentaryStones.put("Clay Stone", new StoneType("Clay Stone", defaultStoneValue, Color.gray));
        sedimentaryStones.put("Conglomerate", new StoneType("Conglomerate", defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Mudstone", new StoneType("Mudstone", defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Limestone", new StoneType("Limestone", defaultStoneValue, Color.white));
        sedimentaryStones.put("Rock Salt", new StoneType("Rock Salt", defaultStoneValue, Color.white));
        sedimentaryStones.put("Sandstone", new StoneType("Sandstone", defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Shale", new StoneType("Shale", defaultStoneValue, Color.gray));
        sedimentaryStones.put("Siltstone", new StoneType("Siltstone", defaultStoneValue, Color.yellow));
        
        return sedimentaryStones;
    }
    
    public HashMap<String, StoneType> GetIgneousIntrusiveStones()
    {
        HashMap<String, StoneType> igneousIntrusive = new HashMap();
        
        igneousIntrusive.put("Diorite", new StoneType("Diorite", defaultStoneValue, Color.gray));
        igneousIntrusive.put("Gabbro", new StoneType("Gabbro", defaultStoneValue, Color.gray));
        igneousIntrusive.put("Granite", new StoneType("Granite", defaultStoneValue, Color.gray));
        
        return igneousIntrusive;
    }
    
    public HashMap<String, StoneType> GetIgneousExtrusiveStones()
    {
        HashMap<String, StoneType> igneousExtrusive = new HashMap();
        
        igneousExtrusive.put("Andesite", new StoneType("Andesite", defaultStoneValue, Color.gray));
        igneousExtrusive.put("Basalt", new StoneType("Basalt", defaultStoneValue, Color.black));
        igneousExtrusive.put("Dacite", new StoneType("Dacite", defaultStoneValue, Color.gray));
        igneousExtrusive.put("Felsite", new StoneType("Felsite", defaultStoneValue, Color.gray));
        igneousExtrusive.put("Obsidian", new StoneType("Obsidian", defaultStoneValue, Color.black));
        igneousExtrusive.put("Rhyolite", new StoneType("Rhyolite", defaultStoneValue, Color.gray));
        
        return igneousExtrusive;
    }
    
    public HashMap<String, StoneType> GetMetamorphicStones()
    {
        HashMap<String, StoneType> metamorphicStones = new HashMap();
        
        metamorphicStones.put("Gneiss", new StoneType("Gneiss", defaultStoneValue, Color.gray));
        metamorphicStones.put("Marble", new StoneType("Marble", defaultStoneValue, Color.white));
        metamorphicStones.put("Phyllite", new StoneType("Phyllite", defaultStoneValue, Color.gray));
        metamorphicStones.put("Quartzite", new StoneType("Quartzite", defaultStoneValue, Color.white));
        metamorphicStones.put("Schist", new StoneType("Schist", defaultStoneValue, Color.gray));
        metamorphicStones.put("Slate", new StoneType("Slate", defaultStoneValue, Color.gray));
        
        return metamorphicStones;
    }
    
    private LayerFactory()
    {
        m_layerTypeContainStones = new HashMap();
        //create stones
        //1 value = 1 copper
        //10copper = 1 silver
        //100 copper = 1 gold
        //1000 copper = 1 platinum
        
        //default stone value 1 silver
        
        
        //Stone type lists
        HashMap<String, StoneType> soilStones = GetSoilStones();
        HashMap<String, StoneType> sedimentaryStones = GetSedementaryStones();
        HashMap<String, StoneType> igneousIntrusive = GetIgneousIntrusiveStones();
        HashMap<String, StoneType> igneousExtrusive = GetIgneousExtrusiveStones();
        HashMap<String, StoneType> metamorphicStones = GetMetamorphicStones();
        
  
        //Create the ores and
        //set up the ores contained in each stone type
        m_stoneContainsOres = new ArrayList();
        
        OreType nativeAluminum = new OreType("Native Aluminum", defaultStoneValue, Color.gray);
        Iterator<StoneType> iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeAluminum));
        }
        
        OreType cassiterite = new OreType("Cassiterite", defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), cassiterite));
        }
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), cassiterite));
        
        OreType nativeCopper = new OreType("Native Copper", defaultStoneValue, Color.red);
        iterator = igneousExtrusive.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativeCopper));
        }
        
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Sandstone"), nativeCopper));
        
        OreType gelena = new OreType("Gelena", defaultStoneValue, Color.gray);
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
        
        OreType garnierite = new OreType("Garnierite", defaultStoneValue, Color.green);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gabbro"), garnierite));
        
        OreType nativeGold = new OreType("Native Gold", defaultStoneValue, Color.yellow);
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

        
        OreType hematite = new OreType("Hematite", defaultStoneValue, Color.gray);
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
        
        OreType nativeSilver = new OreType("Native Silver", defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Granite"), nativeSilver));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Gneiss"), nativeSilver));
        
        OreType limonite = new OreType("Limonite", defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), limonite));
        }
        
        OreType magnetite = new OreType("Magnetite", defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), magnetite));
        }
        
        OreType malachite = new OreType("Malachite", defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Limestone"), malachite));
        m_stoneContainsOres.add(new StoneHasOre(StoneType.GetStoneTypeByName("Marble"), malachite));
        
        OreType nativePlatinum = new OreType("Native Platinum", defaultStoneValue, Color.gray);
        iterator = sedimentaryStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), nativePlatinum));
        }
        
        OreType sphalerite = new OreType("Sphalerite", defaultStoneValue, Color.gray);
        iterator = metamorphicStones.values().iterator();
        while(iterator.hasNext())
        {
            m_stoneContainsOres.add(new StoneHasOre(iterator.next(), sphalerite));
        }
        
        OreType tetrahedrite = new OreType("Tetrahedrite", defaultStoneValue, Color.gray);
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
        
        
        //add all stones to the layer type stone lists
        m_layerTypeContainStones.put(LayerTypes.SOIL, soilStones);
        m_layerTypeContainStones.put(LayerTypes.METAMORPHIC, metamorphicStones);
        m_layerTypeContainStones.put(LayerTypes.IGNEOUS_EXTRUSIVE, igneousExtrusive);
        m_layerTypeContainStones.put(LayerTypes.SEDIMENTARY, sedimentaryStones);
        m_layerTypeContainStones.put(LayerTypes.IGNEOUS_INTRUSIVE, igneousIntrusive);

        
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
    
    //TODO commented out untill m_stoneContainsGems mapping is populated
//    public Deposit getRandomGemDepositForStone(StoneType inStone)
//    {
//        List<OreType> allOres = new ArrayList<OreType>();
//        for(int i = 0; i < m_stoneContainsGems.size(); i++)
//        {
//            if(m_stoneContainsGems.get(i).stone == inStone)
//            {
//                allOres.add(m_stoneContainsGems.get(i).ore);
//            }
//        }
//        
//        int num = s_random.nextInt(allOres.size());
//        
//        Deposit newDeposit = Deposit.GenerateDeposit(allOres.get(num), 10, 100, 10, 100);
//        return newDeposit;
//    }
    
    public List<Layer> makeLayers(int numLayers)
    {
        if(numLayers > 50 || numLayers < 10)
        {
            numLayers = s_random.nextInt(30) + 15;
        }
        List<Layer> layers = new ArrayList<Layer>();
        
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
        
        return new Layer(0 ,stone , depositsForLayer);
    }
    
}

