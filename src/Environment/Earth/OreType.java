/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathius
 */
public class OreType {
    private static List<OreType> s_allOres;
    
    private String m_name;
    private float m_baseValue;
    private Color m_color;
    private int m_id;
    
    private static int s_nextID = -1;
    
    public OreType(String inName, float inBaseValue, Color inColor)
    {
        m_name = inName;
        m_baseValue = inBaseValue;
        m_color = inColor;

        
        if(s_nextID <= 0)
        {
            s_nextID = 1;
        }
        m_id = s_nextID;
        s_nextID++;
        
        if(s_allOres == null)
        {
            s_allOres = new ArrayList<OreType>();
        }
        s_allOres.add(this);
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
    
    public static List<OreType> getAllOres()
    {
        return s_allOres;
    }
    

}
