package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import metodopassovariavel.IFuncao;

/**
 * @author Thadeu Jose
 */

public  class Exemplo1 implements IFuncao{

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        // y' = y - x^2 + 1
        //return y.subtract(x.pow(2)).add(new BigDecimal(1));
        //x^3+((x^4)*y)
        return x.pow(3).add(x.pow(4).multiply(y));
        //sin(x^2)
        //return new BigDecimal(Math.sin(x.pow(2).doubleValue()));    
    }
    
    @Override
    public String toString(){
        return "x^3+((x^4)*y)";
    }
}
