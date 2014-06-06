package Funcao;

import java.math.BigDecimal;
import metodopassovariavel.IFuncao;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public class Funcao3 implements IFuncao{
 
    private static Funcao3 instance;
    
    private Funcao3(){
        
    }
    
    public static Funcao3 getInstance(){
        if(instance == null)
            instance = new Funcao3();
        return instance;
    }
    
    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        //sin(x^2)
        return new BigDecimal(Math.sin(x.pow(2).doubleValue()));    
   }

    @Override
    public String toString() {
        return "sin(x^2)"; 
    }   
}
