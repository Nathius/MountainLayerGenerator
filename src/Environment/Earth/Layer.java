/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.util.List;

/**
 *
 * @author Nathius
 */
public class Layer {
    
    private StoneType m_stoneType;
    private int m_depth;
    private List<OreType> m_ores;
    
    
    public Layer(int inDepth, StoneType inStoneType, List<OreType> inOres)
    {
        m_depth = inDepth;
        m_stoneType = inStoneType;
        m_ores = inOres;
    }
    
    public int getDepth()
    {
        return m_depth;
    }
    public void setDepth(int inDepth)
    {
        m_depth = inDepth;
    }
    
    public StoneType getStoneType()
    {
        return m_stoneType;
    }
    
    public List<OreType> getOreTypes()
    {
        return m_ores;
    }

    @Override
    public String toString() {
        String str = "Layer \n\tdepth:" + m_depth + ", \n\tstone:" + m_stoneType.getName() + ", \n\tores :";
        int i = 0;
        for(OreType ore : m_ores)
        {
            i++;
            str += "\n\t\t" + i + ") " + ore.getName();
        }
        return str;
        
    }
    
    
    
    
    
}
