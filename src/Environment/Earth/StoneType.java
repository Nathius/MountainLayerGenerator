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
import javax.persistence.Entity;
import javax.persistence.NamedQueries;

/**
 *
 * @author Nathius
 */
public class StoneType {
    
    private static List<StoneType> s_allStones;
    private static HashMap<String, StoneType> s_allStonesByName;
    
    private List m_stoneHasOres;
    private List m_stoneHasGems;
    
    private String m_name;
    private float m_baseValue;
    private Color m_color;
    private int m_id;
    
    private static int s_nextID = -1;
    

    public StoneType(String inName, float inBaseValue, Color inColor)
    {
        
        m_name = inName;
        m_baseValue = inBaseValue;
        m_color = inColor;
        
        ArrayList<OreType> m_stoneHasOre = new ArrayList();

        ArrayList<GemType> m_stoneHasGems = new ArrayList();
        
        if(s_nextID <= 0)
        {
            s_nextID = 1;
        }
        m_id = s_nextID;
        s_nextID++;
        
        if(s_allStones == null)
        {
            s_allStones = new ArrayList();
        }
        s_allStones.add(this);
        
        if(s_allStonesByName == null)
        {
            s_allStonesByName = new HashMap();
        }
        s_allStonesByName.put(inName, this);
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public float getBaseValue()
    {
        return m_baseValue;
    }
    
    public Color getColor()
    {
        return m_color;
    }
    
    public int getID()
    {
        return m_id;
    }
    
    public List<GemType> getContainedGems()
    {
        return m_stoneHasGems;
    }
    
    public List<OreType> getContainedOres()
    {
        return m_stoneHasOres;
    }
    
    public void addContainableGem(GemType inGem)
    {
        m_stoneHasGems.add(inGem);
    }
    
    public void addContainableOre(OreType inOre)
    {
        m_stoneHasOres.add(inOre);
    }
    
    public static List<StoneType> getAllStones()
    {
        return s_allStones;
    }
    public static HashMap<String, StoneType> getAllStonesByName()
    {
        return s_allStonesByName;
    }
    public static StoneType GetStoneTypeByName(String inName)
    {
        return s_allStonesByName.get(inName);
    }
    
}
