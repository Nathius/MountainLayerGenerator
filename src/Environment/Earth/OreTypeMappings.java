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

/**
 *
 * @author Nathius
 */



public class OreTypeMappings {
    
    private static List<StoneHasOre> m_stoneContainsOres;
    
    public static List<StoneHasOre> GetOreTypeMappings()
    {
        return m_stoneContainsOres;
    }
    
    public static void InitStoneContainsOreList(
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
}
