package Funcao;

import java.math.BigDecimal;
import java.math.MathContext;
import metodopassovariavel.IFuncao;

/**
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */

/**
 * Métodos de cálculo das funções Fresnel foram encontrados em
 * http://www.network-theory.co.uk/download/gslextras/Fresnel/
 */

public class Funcao4 implements IFuncao{

    static int gama;

    private static Funcao4 instance;
    
    private Funcao4(){
        gama = -100;
    }
    
    public static Funcao4 getInstance(){
        if(instance == null)
            instance = new Funcao4();
        return instance;
    }
    
    public static void setGama(int g){
        gama = g;
    }
    
    public static int getGama(){
        return gama;
    }

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        return new BigDecimal(gama).multiply(y);
    }

    @Override
    public String toString() {
        return gama + "*y";                
    }

    @Override
    public BigDecimal calculaAlfa(double ini) {
        //y(x) = e^(gama*x)
        return new BigDecimal((Math.exp(gama*ini)), new MathContext(20));
    }
    
}
