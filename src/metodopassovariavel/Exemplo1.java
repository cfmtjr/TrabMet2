package metodopassovariavel;

/**
 * @author Thadeu Jose
 */

public class Exemplo1 extends MetodoDePassoVariavel{

    @Override
    public double funcao(double t, double w) {
        return w-Math.pow(t, 2)+1;
    }
    
    
}
