/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    private static LayerFactory s_factory;
    
    private List<StoneHasOre> m_stoneContainsOres;
    
    private Map<LayerTypes, List<StoneType> > m_layerTypeContainStones;
    
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
        m_layerTypeContainStones = new HashMap<LayerTypes, List<StoneType> >();
        //create stones
        //1 value = 1 copper
        //10copper = 1 silver
        //100 copper = 1 gold
        //1000 copper = 1 platinum
        
        //default stone value 1 silver
        float defaultStoneValue = 10;
        
        //Soil type 'stones'
        //--------------------
        ArrayList<StoneType> soilStones = new ArrayList<>();
        
        StoneType dirt = new StoneType("Dirt", 0, Color.red);
        soilStones.add(dirt);
        StoneType peat = new StoneType("Peat", 0, Color.yellow);
        soilStones.add(peat);
        StoneType silt = new StoneType("Silt", 0, Color.gray);
        soilStones.add(silt);
        StoneType sand = new StoneType("Sand", 0, Color.yellow);
        soilStones.add(sand);
        StoneType clay = new StoneType("Clay", 0, Color.red);
        soilStones.add(clay);

        m_layerTypeContainStones.put(LayerTypes.SOIL, soilStones);
        
        
        //Sedimentary stones
        //--------------------
        ArrayList<StoneType> sedimentaryStones = new ArrayList<>();
        
        StoneType chalk = new StoneType("Chalk", defaultStoneValue, Color.white);
        sedimentaryStones.add(chalk);
        StoneType chert = new StoneType("Chert", defaultStoneValue, Color.RED);
        sedimentaryStones.add(chert);
        StoneType clayStone = new StoneType("Clay Stone", defaultStoneValue, Color.gray);
        sedimentaryStones.add(clayStone);
        StoneType conglomerate = new StoneType("Conglomerate", defaultStoneValue, Color.yellow);
        sedimentaryStones.add(conglomerate);
        StoneType mudStone = new StoneType("Mudstone", defaultStoneValue, Color.yellow);
        sedimentaryStones.add(mudStone);
        StoneType limeStone = new StoneType("Limestone", defaultStoneValue, Color.white);
        sedimentaryStones.add(limeStone);
        StoneType rockSalt = new StoneType("Rock Salt", defaultStoneValue, Color.white);
        sedimentaryStones.add(rockSalt);
        StoneType sandStone = new StoneType("Sandstone", defaultStoneValue, Color.yellow);
        sedimentaryStones.add(sandStone);
        StoneType shale = new StoneType("Shale", defaultStoneValue, Color.gray);
        sedimentaryStones.add(shale);
        StoneType siltStone = new StoneType("Siltstone", defaultStoneValue, Color.yellow);
        sedimentaryStones.add(siltStone);
        
        
        
        //igneous intrusive stones
        //--------------------
        ArrayList<StoneType> igneousIntrusive = new ArrayList<>();
        
        StoneType diorite = new StoneType("Diorite", defaultStoneValue, Color.gray);
        igneousIntrusive.add(diorite);
        StoneType gabbro = new StoneType("Gabbro", defaultStoneValue, Color.gray);
        igneousIntrusive.add(gabbro);
        StoneType granite = new StoneType("Granite", defaultStoneValue, Color.gray);
        igneousIntrusive.add(granite);

        
        //Igneous extrusive stones
        //--------------------
        ArrayList<StoneType> igneousExtrusive = new ArrayList<>();
        
        StoneType andesite = new StoneType("Andesite", defaultStoneValue, Color.gray);
        igneousExtrusive.add(andesite);
        StoneType basalt = new StoneType("Basalt", defaultStoneValue, Color.black);
        igneousExtrusive.add(basalt);
        StoneType dacite = new StoneType("Dacite", defaultStoneValue, Color.gray);
        igneousExtrusive.add(dacite);
        StoneType felsite = new StoneType("Felsite", defaultStoneValue, Color.gray);
        igneousExtrusive.add(felsite);
        StoneType obsidian = new StoneType("Obsidian", defaultStoneValue, Color.black);
        igneousExtrusive.add(obsidian);
        StoneType rhyolite = new StoneType("Rhyolite", defaultStoneValue, Color.gray);
        igneousExtrusive.add(rhyolite);
        
        //Metamorphic stones
        ArrayList<StoneType> metamorphicStones = new ArrayList<>();
        
        StoneType gneiss = new StoneType("Gneiss", defaultStoneValue, Color.gray);
        metamorphicStones.add(gneiss);
        StoneType marble = new StoneType("Marble", defaultStoneValue, Color.white);
        metamorphicStones.add(marble);
        StoneType phyllite = new StoneType("Phyllite", defaultStoneValue, Color.gray);
        metamorphicStones.add(phyllite);
        StoneType quartzite = new StoneType("Quartzite", defaultStoneValue, Color.white);
        metamorphicStones.add(quartzite);
        StoneType schist = new StoneType("Schist", defaultStoneValue, Color.gray);
        metamorphicStones.add(schist);
        StoneType slate = new StoneType("Slate", defaultStoneValue, Color.gray);
        metamorphicStones.add(slate);
  
        //Create the ores and
        //set up the ores contained in each stone type
        m_stoneContainsOres = new ArrayList<StoneHasOre>();
        
        OreType nativeAluminum = new OreType("Native Aluminum", defaultStoneValue, Color.gray);
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), nativeAluminum));
        }
        
        OreType cassiterite = new OreType("Cassiterite", defaultStoneValue, Color.gray);
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), cassiterite));
        }
        m_stoneContainsOres.add(new StoneHasOre(granite, cassiterite));
        
        OreType nativeCopper = new OreType("Native Copper", defaultStoneValue, Color.red);
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), nativeCopper));
        }
        m_stoneContainsOres.add(new StoneHasOre(sandStone, nativeCopper));
        
        OreType gelena = new OreType("Gelena", defaultStoneValue, Color.gray);
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), gelena));
        }
        for(int i = 0; i < metamorphicStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(metamorphicStones.get(i), gelena));
        }
        m_stoneContainsOres.add(new StoneHasOre(granite, gelena));
        m_stoneContainsOres.add(new StoneHasOre(limeStone, gelena));
        
        OreType garnierite = new OreType("Garnierite", defaultStoneValue, Color.green);
        m_stoneContainsOres.add(new StoneHasOre(gabbro, garnierite));
        
        OreType nativeGold = new OreType("Native Gold", defaultStoneValue, Color.yellow);
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), nativeGold));
        }
        for(int i = 0; i < igneousIntrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousIntrusive.get(i), nativeGold));
        }
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), nativeGold));
        }
        
        OreType hematite = new OreType("Hematite", defaultStoneValue, Color.gray);
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), hematite));
        }
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), hematite));
        }
        
        OreType nativeSilver = new OreType("Native Silver", defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(granite, nativeSilver));
        m_stoneContainsOres.add(new StoneHasOre(gneiss, nativeSilver));
        
        OreType limonite = new OreType("Limonite", defaultStoneValue, Color.gray);
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), limonite));
        }
        
        OreType magnetite = new OreType("Magnetite", defaultStoneValue, Color.gray);
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), magnetite));
        }
        
        OreType malachite = new OreType("Malachite", defaultStoneValue, Color.gray);
        m_stoneContainsOres.add(new StoneHasOre(limeStone, malachite));
        m_stoneContainsOres.add(new StoneHasOre(marble, malachite));
        
        OreType nativePlatinum = new OreType("Native Platinum", defaultStoneValue, Color.gray);
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), nativePlatinum));
        }
        
        OreType sphalerite = new OreType("Sphalerite", defaultStoneValue, Color.gray);
        for(int i = 0; i < metamorphicStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(metamorphicStones.get(i), sphalerite));
        }
        
        OreType tetrahedrite = new OreType("Tetrahedrite", defaultStoneValue, Color.gray);
        for(int i = 0; i < metamorphicStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(metamorphicStones.get(i), tetrahedrite));
        }
        for(int i = 0; i < igneousExtrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousExtrusive.get(i), tetrahedrite));
        }
        for(int i = 0; i < sedimentaryStones.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(sedimentaryStones.get(i), tetrahedrite));
        }
        for(int i = 0; i < igneousIntrusive.size(); i ++)
        {
            m_stoneContainsOres.add(new StoneHasOre(igneousIntrusive.get(i), tetrahedrite));
        }
        
        
        //add all stones to the layer type stone lists
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
        List<StoneType> allStones = m_layerTypeContainStones.get(inLayerType);
        int num = s_random.nextInt(allStones.size());
        return allStones.get(num);
    }
    
    public OreType getRandomOre()
    {
        List<OreType> allOres = OreType.getAllOres();
        int num = s_random.nextInt(allOres.size());
        return allOres.get(num);
    }
    
    public Deposit getRandomOreTypeForStone(StoneType inStone)
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
            depositsForLayer.add(getRandomOreTypeForStone(stone));
        }
        
        //TODO get random number of gem deposits
        
        return new Layer(0 ,stone , depositsForLayer);
    }
    
}

