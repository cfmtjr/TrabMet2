package metodopassovariavel;

import java.math.BigDecimal;
import java.util.List;

public abstract class MetodoDePassoVariavel {

    public MetodoDePassoVariavel() {
    }

    public final void comeca(List<Ponto> resposta,BigDecimal a,BigDecimal b,BigDecimal alfa,BigDecimal TOL,BigDecimal hmax,BigDecimal hmin){
        
        boolean FLAG = true;
        BigDecimal t,w,h,
                   k1,k2,k3,k4,k5,k6;
        
        
        t= a;
        w=alfa;
        h=hmax;
                
        //SAIDA(t,w)
        resposta.add(new Ponto<>(t,w,BigDecimal.ZERO));
        
        while(FLAG){
            
            k1=h.multiply(funcao(t, w));
            k2=h.multiply(funcao(t.add(h.multiply(new BigDecimal(1/4))), w.add(k1.multiply(new BigDecimal(1/4)))));
            k3=h.multiply(funcao(t.add(h.multiply(new BigDecimal(3/8))),w+(3/32)*k1+(9/32)*k2);
            BigDecimal k4=h*funcao(t+(12/13)*h, w+(1932/2197)*k1-(7200/2197)*k2+(7296/2197)*k3);
            BigDecimal k5=h*funcao(t+h, w+(439/216)*k1-(8)*k2+(3680/513)*k3-(845/4104)*k4);
            BigDecimal k6=h*funcao(t+(1/2)*h, w-(8/27)*k1-(2)*k2+(3544/2565)*k3-(1859/4104)*k4-(11/44)*k5);

            BigDecimal r=(1/h)*Math.abs((1/360)*k1-(128/4275)*k3-(2197/75240)*k4+(1/50)*k5+(2/55)*k6);
            
            if(r<=TOL){
                t=t+h;
                w=w+(25/216)*k1+(1408/2565)*k3+(2197/4104)*k4-(1/5)*k5;
                //SAIDA(t,w,h)
                resposta.add(new Ponto(t,w,h));
                imprime(resposta);
                continue;
            }
            
            BigDecimal sigma=0.84*Math.pow((TOL/r),(1/4));
            
            if(sigma<=0.1){//CUIDADO
                h=0.1*h;
            }
            
            if(sigma>=0.4){
                h=4*h;
            }
            else{
                h=sigma*h;
            }
            
            if(h>hmax) h=hmax;
            
            if(t>=b){               
                FLAG=false;
            }
            
            if(t+h>b) h=b-t;
            
            if(h<hmin){
                FLAG=false;
                //Exibir mensagem de erro;
            }        
        }
    }

    //t=t e w=y
    public abstract BigDecimal funcao(BigDecimal t,BigDecimal w);
    
    public void imprime(List<Ponto> pontos){
        for(int i=0;i<pontos.size();i++){
            System.out.println("T:"+pontos.get(i).getT()+" W:"+pontos.get(i).getW()+" H:"+pontos.get(i).getH());
        }
    }
}
