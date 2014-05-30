package metodopassovariavel;

import PacoteGrafico.Pagina;
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
    public final List<Ponto> calcula(List<Ponto> resposta,BigDecimal a,BigDecimal b,BigDecimal alfa,BigDecimal TOL,BigDecimal hmax,BigDecimal hmin, BigDecimal h){
        
        boolean FLAG = true;
        BigDecimal t,w,r,sigma,
                   k1,k2,k3,k4,k5,k6;
        
        //Passo 1:
        t= a;
        w=alfa;
                
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

    /**
     * Executa o Método de passo variável de Runge-Kutta-Fehlberg exibindo 
     * todo passo-a-passo.
     * @param resposta A lista com os pontos encontrados
     * @param a limite inferior do intervalo
     * @param b limite superior do intervalo
     * @param alfa condição inicial
     * @param TOL Tolerancia maxima (detalhar)
     * @param hmax Tamanho máximo de passo
     * @param hmin Tamanho mínimo de passo
     */
    public final List<Ponto> calculaComLog(List<Ponto> resposta,BigDecimal a,BigDecimal b,BigDecimal alfa,BigDecimal TOL,BigDecimal hmax,BigDecimal hmin, BigDecimal h, Pagina pagina){
        
        boolean FLAG = true;
        BigDecimal t,w,r,sigma,
                   k1,k2,k3,k4,k5,k6;
        
        //Passo 1:
        t= a;
        w=alfa;
                
        //SAIDA(t,w)
        resposta.add(new Ponto<>(t,w,BigDecimal.ZERO));        
        pagina.log("Iniciando Método com: Hinicial="+h+"; Hmin="+hmin+"; Hmax="+hmax);
        //Passo 2:
        while(FLAG){
            pagina.log("Calculando ponto t+h, onde t="+t);
            //Passo 3:
            k1=calculador.K1(h, t, w);
            k2=calculador.K2(h, t, w, k1);
            k3=calculador.K3(h, t, w, k1, k2);
            k4=calculador.K4(h, t, w, k1, k2, k3);
            k5=calculador.K5(h, t, w, k1, k2, k3, k4);
            k6=calculador.K6(h, t, w, k1, k2, k3, k4, k5);
           
            //Passo 4:
            r = calculador.R(h, k1, k3, k4, k5, k6);
            
            //Passo 5: r<=TOL            
            if(r.compareTo(TOL)<=0){
                pagina.log("Aproximação de H aceita; H="+h);
                //Passo 6: Aproximação aceita
                t = t.add(h);
                w=calculador.W(h, w, k1, k3, k4, k5);
                
                pagina.log("T="+t);
                pagina.log("W="+w);                
                //Passo 7
                //SAIDA(t,w,h)
                resposta.add(new Ponto(t,w,h));
               // imprime(resposta);
                //continue;
            }else{
                pagina.log("Aproximação de H não aceita;");
            }
            
            //Passo 8:
            sigma= calculador.sigma(TOL, r);
            pagina.log("Sigma = "+sigma);
            //Passo 9: sigma <= 0.1
            if(sigma.compareTo(BigDecimal.valueOf(0.1))<=0 ){
                //h = h*0.1
                pagina.log("Sigma <= 0.1, alterando H para H*0.1");
                h=h.multiply(BigDecimal.valueOf(0.1)); 
            }else            
            //sigma>=4 
            if(sigma.compareTo(BigDecimal.valueOf(4))>=0 ){
                pagina.log("Sigma >= 4, alterando H para H*4");
                //h=h*4
                h=h.multiply(new BigDecimal(4)); 
            }else{
                pagina.log("Sigma entre 0.1 e 4, alterando H para H*sigma");
                //h=sigma*h;
                h=h.multiply(sigma);                
            }
            pagina.log("H ="+h);
            
            //Passo 10: h>hmax
            if(h.compareTo(hmax)>0) {
                pagina.log("H ultrapassou Hmax, H=Hmax");
                h=hmax;
            }
            
            //Passo 11: t>=b
            if(t.compareTo(b)>=0){               
                pagina.log("T ultrapassou o limite B, encerrando.");
                FLAG=false;            
            }
            //t+h>b
            if(t.add(h).compareTo(b)>0) {
                pagina.log("T+H ultrapassa o limite B, reduzindo H para H="+h);
                h=b.subtract(t);
            }
            //h<hmin
            if(h.compareTo(hmin)<0){
                pagina.log("H é menor que Hmin, encerrando.");
                FLAG=false;
                //Exibir mensagem de erro;
            }        
        }
        //Passo 12:
        return resposta;
    }
}
