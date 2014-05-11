package main;

import java.math.BigDecimal;
import metodopassovariavel.IFuncao;

/**
 * @author Thadeu Jose
 */

public class Exemplo1 implements IFuncao{

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        // y' = y - x^2 + 1
        return y.subtract(x.pow(2)).add(new BigDecimal(1));               
    }
}
