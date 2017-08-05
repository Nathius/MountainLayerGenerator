/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestDrivers;

import Environment.Earth.Layer;
import Environment.Earth.LayerFactory;
import Environment.Earth.StoneType;
import java.util.List;

/**
 *
 * @author Nathius
 */
public class LayerFactoryTestDriver {

    public static void main(String[] args)
    {
        LayerFactory factory = LayerFactory.getLayerFactory();
        
        List<Layer> layers = factory.makeLayers(20);
        
        System.out.println("A new mountain is found!");
        for(Layer l : layers)
        {
            System.out.println(l.toString());
        }   
    }
}
