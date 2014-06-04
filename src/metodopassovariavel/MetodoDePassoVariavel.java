package metodopassovariavel;

import PacoteGrafico.Pagina;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public class MetodoDePassoVariavel implements Runnable{

    private IFuncao funcao;
    private Calculador calculador;
    private MathContext mc;
    List<Ponto> resposta;
    BigDecimal a;
    BigDecimal b;
    BigDecimal alfa;
    BigDecimal TOL;
    BigDecimal hmax;
    BigDecimal hmin;
    BigDecimal h;
    Pagina pagina;
    boolean log;
    private boolean FLAG = false;

    public void setFLAG(boolean FLAG) {
        this.FLAG = FLAG;
    }
    
        /**
     * Construtor do Método de passo variável de Runge-Kutta-Fehlberg com log 
     * configurável
     * @param funcao A função a ser calculada
     * @param resposta A lista com os pontos encontrados
     * @param a limite inferior do intervalo
     * @param b limite superior do intervalo
     * @param alfa condição inicial
     * @param TOL Tolerancia maxima (detalhar)
     * @param hmax Tamanho máximo de passo
     * @param hmin Tamanho mínimo de passo
     * @param pagina Página em que o método será executado
     * @param log Variável booleana para definir se o métododeverá usar log ou não
     */
    public MetodoDePassoVariavel(IFuncao funcao, List<Ponto> resposta,BigDecimal a,BigDecimal b,BigDecimal alfa,BigDecimal TOL,BigDecimal hmax,BigDecimal hmin, BigDecimal h, Pagina pagina, boolean log) {
        this.funcao = funcao;               
        this.calculador = new Calculador(this.funcao);
        this.resposta = resposta;
        this.a = a;
        this.b = b;
        this.alfa = alfa;
        this.TOL = TOL;
        this.hmax = hmax;
        this.hmin = hmin;
        this.h = h;
        this.pagina = pagina;
        this.log = log;
        this.mc = new MathContext(20);
    }
    
    private final void calcula(){
        
        FLAG = true;
        BigDecimal t,w,r,sigma,
                   k1,k2,k3,k4,k5,k6;
        
        pagina.log("Iniciando método.");

        //Passo 1:
        t= a;
        w=alfa;
                
        //SAIDA(t,w)
        resposta.add(new Ponto<>(t,w,BigDecimal.ZERO));    
        if(log)
            pagina.log("Iniciando Método com: Hinicial="+h+"; Hmin="+hmin+"; Hmax="+hmax);
        //Passo 2:
        while(FLAG){
            if(log)
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
                if(log)
                    pagina.log("Aproximação de H aceita; H="+h.toEngineeringString());
                //Passo 6: Aproximação aceita
                t = t.add(h);
                w=calculador.W(h, w, k1, k3, k4, k5);
                w=w.round(mc); 
                t=t.round(mc);
                h=h.round(mc);
                if(log){
                    pagina.log("T="+t);
                    pagina.log("W="+w);
                }
                //Passo 7
                //SAIDA(t,w,h)
                resposta.add(new Ponto(t,w,h));
               // imprime(resposta);
                //continue;
            }else{
                if(log)
                    pagina.log("Aproximação de H não aceita;");
            }
            
            //Passo 8:
            sigma= calculador.sigma(TOL, r);
            if(log)
                pagina.log("Sigma = "+sigma);
            //Passo 9: sigma <= 0.1
            if(sigma.compareTo(BigDecimal.valueOf(0.1))<=0 ){
                //h = h*0.1
                if(log)
                    pagina.log("Sigma <= 0.1, alterando H para H*0.1");
                h=h.multiply(BigDecimal.valueOf(0.1)); 
            }else            
            //sigma>=4 
            if(sigma.compareTo(BigDecimal.valueOf(4))>=0 ){
                if(log)
                    pagina.log("Sigma >= 4, alterando H para H*4");
                //h=h*4
                h=h.multiply(new BigDecimal(4)); 
            }else{
                if(log)
                    pagina.log("Sigma entre 0.1 e 4, alterando H para H*sigma");
                //h=sigma*h;
                h=h.multiply(sigma);                
            } if(log)
                pagina.log("H ="+h);
            
            //Passo 10: h>hmax
            if(h.compareTo(hmax)>0) {
                if(log)
                    pagina.log("H ultrapassou Hmax, H=Hmax");
                h=hmax;
            }
            
            //Passo 11: t>=b
            if(t.compareTo(b)>=0){               
                if(log)
                    pagina.log("T ultrapassou o limite B, encerrando.");
                FLAG=false;            
            }
            //t+h>b
            if(t.add(h).compareTo(b)>0) {
                if(log)
                    pagina.log("T+H ultrapassa o limite B, reduzindo H para H="+h);
                h=b.subtract(t);
            }
            //h<hmin
            if(h.compareTo(hmin)<0){
                if(log)
                    pagina.log("H é menor que Hmin, encerrando.");
                FLAG=false;
                //Exibir mensagem de erro;
            }        
        }
        //Passo 12:
        //pagina.setPontos(resposta);
        pagina.log("Método terminado.");
        pagina.log("\n" + resposta.size() + " pontos calculados.");
    }

    @Override
    public void run() {
        calcula();
        pagina.terminarExecucao();
    }

}
