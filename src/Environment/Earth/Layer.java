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
    private LayerTypes m_layerType;
    private int m_depth;
    private List<Deposit> m_deposits;
    
    
    public Layer(int inDepth, LayerTypes inLayerType, StoneType inStoneType, List<Deposit> inDeposits)
    {
        m_depth = inDepth;
        m_layerType = inLayerType;
        m_stoneType = inStoneType;
        m_deposits = inDeposits;
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
    
    public List<Deposit> getDeposits()
    {
        return m_deposits;
    }

    @Override
    public String toString() {
        String str = m_layerType.toString().toLowerCase() + " Layer \n\tdepth:" + m_depth + ", \n\tstone:" + m_stoneType.getName() + ", \n\tores :";
        int i = 0;
        for(Deposit deposit : m_deposits)
        {
            i++;
            str += "\n\t\t" 
                    + i + ") " 
                    + deposit.GetOreType().getName() 
                    + " " + deposit.GetOreType().GetNamePrefix()
                    + ", " + deposit.getSize() 
                        + " " + deposit.GetOreType().getUnitName()
                    + ", " + deposit.GetPurity() + "% pure";
        }
        return str;
        
    }
    
    
    
    
    
}
