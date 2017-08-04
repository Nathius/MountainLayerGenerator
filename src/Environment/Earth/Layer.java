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
    private List<Deposit> m_ores;
    
    
    public Layer(int inDepth, StoneType inStoneType, List<Deposit> inOres)
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
    
    public List<Deposit> getOreTypes()
    {
        return m_ores;
    }

    @Override
    public String toString() {
        String str = "Layer \n\tdepth:" + m_depth + ", \n\tstone:" + m_stoneType.getName() + ", \n\tores :";
        int i = 0;
        for(Deposit deposit : m_ores)
        {
            i++;
            str += "\n\t\t" 
                    + i + ") " 
                    + deposit.GetOreType().getName() 
                    + ", size: " + deposit.getSize() 
                        + " " + deposit.GetOreType().getUnitName()
                    + ", purity: " + deposit.GetPurity() + "%";
        }
        return str;
        
    }
    
    
    
    
    
}
