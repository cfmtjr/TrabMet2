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
public class Funcao2 implements IFuncao {

    private static Funcao2 instance;
    
    private Funcao2(){
        
    }
    
    public static Funcao2 getInstance(){
        if(instance == null)
            instance = new Funcao2();
        return instance;
    }
    
    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        //x^3+((x^4)*y)
        return x.pow(3).add(x.pow(4).multiply(y));
    }

    @Override
    public String toString() {
        return "x^3+((x^4)*y)";
    }
}
