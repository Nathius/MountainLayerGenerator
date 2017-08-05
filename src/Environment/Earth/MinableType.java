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
    protected String m_namePrefix;
    protected String m_unitName;
    
    public MinableType(String inName, String inNamePrefix, String inUnitName)
    {
        m_name = inName;
        m_namePrefix = inNamePrefix;
        m_unitName = inUnitName;
    }
    
    public String getName()
    {
        return m_name;
    }
    
    public String GetNamePrefix()
    {
        return m_namePrefix;
    }
    
    public String getUnitName()
    {
        return m_unitName;
    }
}
