package main;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import metodopassovariavel.IFuncao;
import metodopassovariavel.MetodoDePassoVariavel;
import metodopassovariavel.Ponto;


public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        IFuncao funcao =new Exemplo1();
        List<Ponto> pontos = new LinkedList<>();
        MetodoDePassoVariavel metodo = new MetodoDePassoVariavel(funcao);
        
        pontos = metodo.comeca(pontos, 
                new BigDecimal(0), 
                new BigDecimal(2), 
                BigDecimal.valueOf(0.5), 
                new BigDecimal(1).divide(new BigDecimal(10).pow(5)), 
                BigDecimal.valueOf(0.25), 
                BigDecimal.valueOf(0.01));
        imprime(pontos);
        
        //Não apaguem, são alguns testes com bigDecimal, depois seria legal 
        //formalizar isso no doc
//        BigDecimal i = new BigDecimal(5/4);
//        System.out.println(i.toString());
//                
//        BigDecimal j = new BigDecimal(5).divide(new BigDecimal(4));
//        System.out.println(j.toString());
//        
//        BigDecimal i1 = new BigDecimal(0.84);
//        System.out.println(i1.toString());
//                
//        BigDecimal j1 = new BigDecimal(84).divide(new BigDecimal(100));
//        System.out.println(j1.toString());
//        
//        BigDecimal k1 = new BigDecimal("0.84");
//        System.out.println(k1.toString());
        
//        BigDecimal i2 = new BigDecimal( new BigDecimal("0.84").doubleValue() );
//        System.out.println(i2.toString());
//        
//        BigDecimal j2 = BigDecimal.valueOf(new BigDecimal("0.84").doubleValue());
//        System.out.println(j2.toString());
//        
//        BigDecimal i3 = BigDecimal.valueOf(Math.pow(new BigDecimal("0.000000000081").doubleValue(),0.25));
//        System.out.println(i3.toString());
//          BigDecimal i4 = BigDecimal.valueOf(1);
//          BigDecimal j4 = BigDecimal.valueOf(3);
//          System.out.println(i4.divide(j4, MathContext.DECIMAL128).toString());
          
        
        
    }
        
    public static void imprime(List<Ponto> pontos){
        for(int i=0;i<pontos.size();i++){
            System.out.println("T:"+pontos.get(i).getT()+" W:"+pontos.get(i).getW()+" H:"+pontos.get(i).getH());
        }
    }
}
