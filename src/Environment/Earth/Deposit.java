/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Environment.Earth;

import java.util.Random;

/**
 *
 * @author Nathius
 */
public class Deposit {
    public MinableType oreType;
    
    public int size;
    public int purity; //as a percentage eg purity 38 = 38%
    
    public Deposit(MinableType inOreType, int inSize, int inPurity)
    {
        oreType = inOreType;
        size = inSize;
        purity = inPurity;
    }
    
    public MinableType GetOreType()
    {
        return oreType;
    }
   
    public int getSize()
    {
        return size;
    }
    
    public int GetPurity()
    {
        return purity;
    }
   
    public static Deposit GenerateDeposit(MinableType oreType, int minSize, int maxSize, int minPurity, int maxPurity)
    {        
        Random rand = new Random();
        int randomSize = rand.nextInt(maxSize - minSize) + minSize;
        
        maxPurity = maxPurity >= 100 ? 100 : maxPurity;
        minPurity = minPurity <= 0 ? 0 : minPurity;
        int randomPurity = rand.nextInt(maxPurity - minPurity) + minPurity;
                
        return new Deposit(oreType, randomSize, randomPurity);
    }
    
   
    
}
