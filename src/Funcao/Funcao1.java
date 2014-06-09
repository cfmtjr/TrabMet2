package Funcao;

import java.math.BigDecimal;
import java.math.MathContext;
import metodopassovariavel.IFuncao;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public class Funcao1 implements IFuncao{
    
    private static Funcao1 instance;
    
    private Funcao1(){
        
    }
    
    public static Funcao1 getInstance(){
        if(instance == null)
            instance = new Funcao1();
        return instance;
    }
    
    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        // y' = y - x^2 + 1
        return y.subtract(x.pow(2)).add(new BigDecimal(1));
    }
    
    @Override
    public BigDecimal calculaAlfa(double ini){
        //y(x) = e^x + x^2 + 2x+1
        return new BigDecimal((Math.exp(ini) + Math.pow(ini,2) + 2*ini + 1), new MathContext(20));
    }
    
    @Override
    public String toString(){
        return "y' = y - x^2 + 1";
    }
}
