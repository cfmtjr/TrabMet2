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
public class Funcao4 implements IFuncao{

    int gama;

    public Funcao4() {
        this(-100);        
    }

    public Funcao4(int gama) {
        this.gama = gama;
    }

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        return new BigDecimal(gama).multiply(y);
    }

    @Override
    public String toString() {
        return "gama*y";                
    }
    
}
