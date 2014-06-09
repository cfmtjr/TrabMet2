package Funcao;

import java.math.BigDecimal;
import java.math.MathContext;
import metodopassovariavel.IFuncao;
import org.apache.commons.math3.special.Gamma;

/**
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */

/**
 * Créditos pelos métodos de cálculo das funções Gamma mantidos
 * ao projeto <i>Apache Commons</i>
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

    @Override
    public BigDecimal calculaAlfa(double ini) {
        //y(x) = e^(x^5/5)-(e^(x^5/5) x^4 Gamma(4/5, x^5/5))/(5^(1/5) (x^5)^(4/5))
        double pow = Math.pow(ini, 5)/5;
        double exp = Math.exp(pow);
        double gamma = Gamma.regularizedGammaQ(0.8, pow)*Gamma.gamma(0.8);
        double ans = exp - (exp*Math.pow(ini, 4)* gamma)/(Math.pow(5, 0.2)*Math.pow(Math.pow(ini, 5),0.8));
        return new BigDecimal(ans, new MathContext(20));
    }
}
