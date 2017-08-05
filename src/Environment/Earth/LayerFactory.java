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
        OreTypeMappings.InitStoneContainsOreList(
            sedimentaryStones, 
            igneousIntrusive,
            igneousExtrusive,
            metamorphicStones);
        m_stoneContainsOres = OreTypeMappings.GetOreTypeMappings();
        
        GemTypeMappings.InitStoneContainsGemList(
            sedimentaryStones, 
            igneousIntrusive,
            igneousExtrusive,
            metamorphicStones);
        m_stoneContainsGems = GemTypeMappings.GetGemTypeMappings();
        
        //add all stones to the layer type stone lists
        m_layerTypeContainStones = new HashMap();
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
        List<OreType> allOres = new ArrayList();
        for (StoneHasOre item : m_stoneContainsOres) {
            if (item.stone == inStone) {
                allOres.add(item.ore);
            }
        }
        
        int num = s_random.nextInt(allOres.size());
        
        Deposit newDeposit = Deposit.GenerateDeposit(allOres.get(num), 10, 100, 10, 100);
        return newDeposit;
    }
    
    public Deposit getRandomGemDepositForStone(StoneType inStone)
    {
        List<GemType> allGems = new ArrayList();
        for (StoneHasGem item : m_stoneContainsGems) {
            if (item.stone == inStone) {
                allGems.add(item.gem);
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

