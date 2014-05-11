/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodopassovariavel;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author Administrador
 */
 class Calculador {
    
    private static MathContext MC = MathContext.DECIMAL128;
    
    public Calculador(IFuncao funcao) {
        this.funcao = funcao;
    }
    
    private IFuncao funcao;
    
    private BigDecimal fracao(int numerador, int denominador){
        return new BigDecimal(numerador).divide(new BigDecimal(denominador),MC);
    }
    
    private BigDecimal fracao(int numerador, BigDecimal denominador){
        return new BigDecimal(numerador).divide(denominador,MC);
    }
    
    
    
    /**
     * Calcula K1: h*f(t,w)
     * @param h
     * @param t
     * @param w
     * @return 
     */
    public BigDecimal K1(BigDecimal h, BigDecimal t, BigDecimal w){
        return h.multiply(funcao.calcula(t, w));
    }
    
    /**
     * Calcula K2: h*f( t+h/4 , w+K1/4 )
     * @param K1
     * @param h
     * @param t
     * @param w
     * @return 
     */
    public BigDecimal K2(BigDecimal h, BigDecimal t, BigDecimal w, BigDecimal K1){
        return h.multiply(funcao.calcula(t.add(h.divide(new BigDecimal(4),MC)), 
                                        w.add(K1.divide(new BigDecimal(4),MC))));
    }
    
    /**
     * Calcula K3: h*f(t + h*(3/8), w + K1*(3/32) + K2*(9/32) ) 
     * @param h
     * @param t
     * @param w
     * @param K1
     * @param K2
     * @return 
     */
    public BigDecimal K3(BigDecimal h, BigDecimal t, BigDecimal w, 
            BigDecimal K1,BigDecimal K2){
        return h.multiply(funcao.calcula(t.add(h.multiply(fracao(3,8))),
                           w.add(K1.multiply(fracao(3,32)))
                            .add(K2.multiply(fracao(9,32)))));
    }
    
    /**
     * Calcula K4: h*f(t+ h*(12/13), w + K1*(1932/2197) - K2*(7200/2197)
     *                                 + K3*(7296/2197))
     * @param h
     * @param t
     * @param w
     * @param K1
     * @param K2
     * @param K3
     * @return 
     */
    public BigDecimal K4(BigDecimal h, BigDecimal t, BigDecimal w, 
            BigDecimal K1,BigDecimal K2, BigDecimal K3){
        return h.multiply(funcao.calcula(t.add(h.multiply(fracao(12,13))),
                           w.add(K1.multiply(fracao(1932,2197)))
                            .subtract(K2.multiply(fracao(7200,2197)))
                            .add(K3.multiply(fracao(7296,2197)))));
    }
    
    /**
     * Calcula K5: h*f(t+ h, w + K1*(439/216) - K2*8
     *                         + K3*(3680/513) - K4*(845/4104))      
     * @param h
     * @param t
     * @param w
     * @param K1
     * @param K2
     * @param K3
     * @param K4
     * @return 
     */
    public BigDecimal K5(BigDecimal h, BigDecimal t, BigDecimal w, 
            BigDecimal K1,BigDecimal K2, BigDecimal K3, BigDecimal K4){
        return h.multiply(funcao.calcula(t.add(h),                
                           w.add(K1.multiply(fracao(439,216)))
                            .subtract(K2.multiply(new BigDecimal(8)))
                            .add(K3.multiply(fracao(3680,513)))
                            .subtract(K4.multiply(fracao(845,4104)))));
    }
    
    /**
     * Calcula K6: h*f(t+ h/2, w - K1*(8/27) + K2*2
     *                      - K3*(3544/2565) + K4*(1859/4104) 
     *                      - K5*(11/40))      
     * @param h
     * @param t
     * @param w
     * @param K1
     * @param K2
     * @param K3
     * @param K4
     * @param K5
     * @return 
     */
    public BigDecimal K6(BigDecimal h, BigDecimal t, BigDecimal w, 
            BigDecimal K1,BigDecimal K2, BigDecimal K3, BigDecimal K4,
            BigDecimal K5){
        return h.multiply(funcao.calcula(t.add(h.divide(new BigDecimal(2),MC)),
                           w.subtract(K1.multiply(fracao(8,27)))
                            .add(K2.multiply(new BigDecimal(2)))
                            .subtract(K3.multiply(fracao(3544,2565)))
                            .add(K4.multiply(fracao(1859,4104)))
                            .subtract(K5.multiply(fracao(11,40)))));
    }
    
    /**
     * Calcula R: 1/h * | K1*(1/360) - K3*(128/4275)
     *                      - K4*(2197/75240) + K5*(1/50) 
     *                      - K6*(2/55) |
     * obs. |x| é módulo de x
     * @param h
     * @param K1
     * @param K3
     * @param K4
     * @param K5
     * @return 
     */
    public BigDecimal R(BigDecimal h,BigDecimal K1, BigDecimal K3, 
            BigDecimal K4, BigDecimal K5, BigDecimal K6){
        return fracao(1,h).multiply(
                            K1.multiply(fracao(1,360))
                            .subtract(K3.multiply(fracao(128,4275)))
                            .subtract(K4.multiply(fracao(2197,75240)))
                            .add(K5.multiply(fracao(1,50)))
                            .add(K6.multiply(fracao(2,55))).abs());
    }
    
    /**
     * Método para Calcular W(i+1), por RK 4º ordem
     * W(i+1) = w + K1*(25/216) + K3*(1408/2565)
     *                      + K4*(2197/4104) - K5*(1/5) 
     * @param h
     * @param w
     * @param K1
     * @param K3
     * @param K4
     * @param K5
     * @return 
     */
    public BigDecimal W(BigDecimal h, BigDecimal w, 
            BigDecimal K1, BigDecimal K3, BigDecimal K4,
            BigDecimal K5){
        return w.add(K1.multiply(fracao(25,216)))
                    .add(K3.multiply(fracao(1408,2565)))
                    .add(K4.multiply(fracao(2197,4104)))
                    .subtract(K5.multiply(fracao(1,5)));                
    }
    
    /**
     * calcula Sigma: sigma = 0,84 * (TOL/R)^(1/4)
     *            
     * @param TOL
     * @param R
     * @return 
     */
    public BigDecimal sigma(BigDecimal TOL, BigDecimal R){
        return fracao(84, 100).multiply(
                BigDecimal.valueOf(Math.pow(TOL.divide(R,MC).doubleValue(),0.25)));
    }
}
