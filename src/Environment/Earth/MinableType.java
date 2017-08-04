/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

/**
 *
 * @author Nathius
 */
public class MinableType {
    protected String m_name;
    protected String m_unitName;
    
    public MinableType(String inName, String inUnitName)
    {
        m_name = inName;
        m_unitName = inUnitName;
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public String getUnitName()
    {
        return m_unitName;
    }
}
