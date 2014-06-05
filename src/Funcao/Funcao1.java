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
public  class Funcao1 implements IFuncao{

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        // y' = y - x^2 + 1
        return y.subtract(x.pow(2)).add(new BigDecimal(1));
        
    }
    
    @Override
    public String toString(){
        return "y' = y - x^2 + 1";
    }
}
