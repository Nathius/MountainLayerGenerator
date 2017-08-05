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

/**
 *
 * @author Nathius
 */
public class GemTypeMappings {
    
    private static ArrayList<StoneHasGem> m_stoneContainsGems;
    
    public static ArrayList<StoneHasGem> GetGemTypeMappings()
    {
        return m_stoneContainsGems;
    }
    
    public static void InitStoneContainsGemList(
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
    
}
