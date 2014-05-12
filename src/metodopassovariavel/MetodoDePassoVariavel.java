package metodopassovariavel;

import java.math.BigDecimal;
import java.util.List;

public class MetodoDePassoVariavel {

    private IFuncao funcao;
    private Calculador calculador;
    
    public MetodoDePassoVariavel(IFuncao funcao) {
        this.funcao = funcao;               
        calculador = new Calculador(this.funcao);
    }
    
    /**
     * Executa o Método de passo variável de Runge-Kutta-Fehlberg
     * @param resposta A lista com os pontos encontrados
     * @param a limite inferior do intervalo
     * @param b limite superior do intervalo
     * @param alfa condição inicial
     * @param TOL Tolerancia maxima (detalhar)
     * @param hmax Tamanho máximo de passo
     * @param hmin Tamanho mínimo de passo
     */
    public final List<Ponto> comeca(List<Ponto> resposta,BigDecimal a,BigDecimal b,BigDecimal alfa,BigDecimal TOL,BigDecimal hmax,BigDecimal hmin){
        
        boolean FLAG = true;
        BigDecimal t,w,h,r,sigma,
                   k1,k2,k3,k4,k5,k6;
        
        //Passo 1:
        t= a;
        w=alfa;
        h=hmax;                
        //SAIDA(t,w)
        resposta.add(new Ponto<>(t,w,BigDecimal.ZERO));        
        
        //Passo 2:
        while(FLAG){
            
            //Passo 3:
            k1=calculador.K1(h, t, w);
            k2=calculador.K2(h, t, w, k1);
            k3=calculador.K3(h, t, w, k1, k2);
            k4=calculador.K4(h, t, w, k1, k2, k3);
            k5=calculador.K5(h, t, w, k1, k2, k3, k4);
            k6=calculador.K6(h, t, w, k1, k2, k3, k4, k5);
            
//            BigDecimal k4=h*funcao(t+(12/13)*h, w+(1932/2197)*k1-(7200/2197)*k2+(7296/2197)*k3);
//            BigDecimal k5=h*funcao(t+h, w+(439/216)*k1-(8)*k2+(3680/513)*k3-(845/4104)*k4);
//            BigDecimal k6=h*funcao(t+(1/2)*h, w-(8/27)*k1-(2)*k2+(3544/2565)*k3-(1859/4104)*k4-(11/44)*k5);
            
            //Passo 4:
            r = calculador.R(h, k1, k3, k4, k5, k6);
            
            //Passo 5: r<=TOL            
            if(r.compareTo(TOL)<=0){
                
                //Passo 6: Aproximação aceita
                t = t.add(h);
                w=calculador.W(h, w, k1, k3, k4, k5);
                
                //Passo 7
                //SAIDA(t,w,h)
                resposta.add(new Ponto(t,w,h));
               // imprime(resposta);
                //continue;
            }
            
            //Passo 8:
            sigma= calculador.sigma(TOL, r);
            
            //Passo 9: sigma <= 0.1
            if(sigma.compareTo(BigDecimal.valueOf(0.1))<=0 ){
                //h = h*0.1
                h=h.multiply(BigDecimal.valueOf(0.1)); 
            }else            
            //sigma>=4 (estava 0.4, mas no algoritmo ta 4)
            if(sigma.compareTo(BigDecimal.valueOf(4))>=0 ){
                h=h.multiply(new BigDecimal(4)); 
            }else{
                //h=sigma*h;
                h=h.multiply(sigma);                
            }
            
            //Passo 10: h>hmax
            if(h.compareTo(hmax)>0) 
                h=hmax;
            
            //Passo 11: t>=b
            if(t.compareTo(b)>=0){               
                FLAG=false;            
            }
            //t+h>b
            if(t.add(h).compareTo(b)>0) {
                h=b.subtract(t);
            }
            //h<hmin
            if(h.compareTo(hmin)<0){
                FLAG=false;
                //Exibir mensagem de erro;
            }        
        }
        //Passo 12:
        return resposta;
    }

    //t=t e w=y
  //  public abstract BigDecimal funcao(BigDecimal t,BigDecimal w);

}
