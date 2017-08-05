/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author Nathius
 */
public class StoneTypeMappings {
    
    //1 value = 1 copper
    //10copper = 1 silver
    //100 copper = 1 gold
    //1000 copper = 1 platinum
    //default stone value 1 silver
    private static final float m_defaultStoneValue = 10;
    
    private static HashMap<String, StoneType> m_soilStones;
    private static HashMap<String, StoneType> m_sedimentaryStones;
    private static HashMap<String, StoneType> m_igneousExtrusive;
    private static HashMap<String, StoneType> m_igneousIntrusive;
    private static HashMap<String, StoneType> m_metamorphicStones;
    
    private StoneTypeMappings()
    {
        //private constructor
    }
    
    public static HashMap<String, StoneType> GetSoilStones()
    {
    return m_soilStones;
    }
    public static HashMap<String, StoneType> GetSedimentaryStones()
    {
    return m_sedimentaryStones;
    }
    public static HashMap<String, StoneType> GetIgneousExtrusive()
    {
    return m_igneousExtrusive;
    }
    public static HashMap<String, StoneType> GetIgneousIntrusive()
    {
    return m_igneousIntrusive;
    }
    public static HashMap<String, StoneType> GetMetamorphicStones()
    {
    return m_metamorphicStones;
    }
    
    public static void InitMappings()
    {
        m_soilStones = InitSoilStones();
        m_sedimentaryStones = InitSedementaryStones();
        m_igneousIntrusive = InitIgneousIntrusiveStones();
        m_igneousExtrusive = InitIgneousExtrusiveStones();
        m_metamorphicStones = InitMetamorphicStones();
    }
    
    private static HashMap<String, StoneType> InitSoilStones()
    {
        HashMap<String, StoneType> soilStones = new HashMap();
        
        soilStones.put("Dirt", new StoneType("Dirt", 0, Color.red));
        soilStones.put("Peat", new StoneType("Peat", 0, Color.yellow));
        soilStones.put("Silt", new StoneType("Silt", 0, Color.gray));
        soilStones.put("Sand", new StoneType("Sand", 0, Color.yellow));
        soilStones.put("Clay", new StoneType("Clay", 0, Color.red));
        
        return soilStones;
    }
    
    private static HashMap<String, StoneType> InitSedementaryStones()
    {
        HashMap<String, StoneType> sedimentaryStones = new HashMap();
        
        sedimentaryStones.put("Chalk", new StoneType("Chalk", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Chert", new StoneType("Chert", m_defaultStoneValue, Color.RED));
        sedimentaryStones.put("Clay Stone", new StoneType("Clay Stone", m_defaultStoneValue, Color.gray));
        sedimentaryStones.put("Conglomerate", new StoneType("Conglomerate", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Mudstone", new StoneType("Mudstone", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Limestone", new StoneType("Limestone", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Rock Salt", new StoneType("Rock Salt", m_defaultStoneValue, Color.white));
        sedimentaryStones.put("Sandstone", new StoneType("Sandstone", m_defaultStoneValue, Color.yellow));
        sedimentaryStones.put("Shale", new StoneType("Shale", m_defaultStoneValue, Color.gray));
        sedimentaryStones.put("Siltstone", new StoneType("Siltstone", m_defaultStoneValue, Color.yellow));
        
        return sedimentaryStones;
    }
    
    public static HashMap<String, StoneType> InitIgneousIntrusiveStones()
    {
        HashMap<String, StoneType> igneousIntrusive = new HashMap();
        
        igneousIntrusive.put("Diorite", new StoneType("Diorite", m_defaultStoneValue, Color.gray));
        igneousIntrusive.put("Gabbro", new StoneType("Gabbro", m_defaultStoneValue, Color.gray));
        igneousIntrusive.put("Granite", new StoneType("Granite", m_defaultStoneValue, Color.gray));
        
        return igneousIntrusive;
    }
    
    public static HashMap<String, StoneType> InitIgneousExtrusiveStones()
    {
        HashMap<String, StoneType> igneousExtrusive = new HashMap();
        
        igneousExtrusive.put("Andesite", new StoneType("Andesite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Basalt", new StoneType("Basalt", m_defaultStoneValue, Color.black));
        igneousExtrusive.put("Dacite", new StoneType("Dacite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Felsite", new StoneType("Felsite", m_defaultStoneValue, Color.gray));
        igneousExtrusive.put("Obsidian", new StoneType("Obsidian", m_defaultStoneValue, Color.black));
        igneousExtrusive.put("Rhyolite", new StoneType("Rhyolite", m_defaultStoneValue, Color.gray));
        
        return igneousExtrusive;
    }
    
    public static HashMap<String, StoneType> InitMetamorphicStones()
    {
        HashMap<String, StoneType> metamorphicStones = new HashMap();
        
        metamorphicStones.put("Gneiss", new StoneType("Gneiss", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Marble", new StoneType("Marble", m_defaultStoneValue, Color.white));
        metamorphicStones.put("Phyllite", new StoneType("Phyllite", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Quartzite", new StoneType("Quartzite", m_defaultStoneValue, Color.white));
        metamorphicStones.put("Schist", new StoneType("Schist", m_defaultStoneValue, Color.gray));
        metamorphicStones.put("Slate", new StoneType("Slate", m_defaultStoneValue, Color.gray));
        
        return metamorphicStones;
    }
    
    
    
}
