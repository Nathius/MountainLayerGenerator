/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Nathius
 */

@Entity
@NamedQueries({@NamedQuery(name = GemType.GET_ALL_QUERY_NAME, query = "SELECT gem FROM GemType gem")})
public class GemType {
    
    public static final String GET_ALL_QUERY_NAME = "GemType.getAll";
    
    private static List<GemType> s_allGems;
    
    private String m_name;
    private float m_baseValue;
    private float m_cutValue;
    private Color m_color;
    private int m_id;
    
    private static int s_nextID = -1;
    
    public GemType(String inName, float inBaseValue, float inCutValue, Color inColor)
    {
        m_name = inName;
        m_baseValue = inBaseValue;
        m_cutValue = inCutValue;
        m_color = inColor;

        
        if(s_nextID <= 0)
        {
            s_nextID = 1;
        }
        m_id = s_nextID;
        s_nextID++;
        
        if(s_allGems == null)
        {
            s_allGems = new ArrayList<GemType>();
        }
        s_allGems.add(this);
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public float getBaseValue()
    {
        return m_baseValue;
    }
    
    public float getCutValue()
    {
        return m_cutValue;
    }
    
    public Color getColor()
    {
        return m_color;
    }
    
    @Id
    @Column(name = "gem_type_id")
    public int getID()
    {
        return m_id;
    }
    
    public static List<GemType> getAllGems()
    {
        return s_allGems;
    }
    

}
