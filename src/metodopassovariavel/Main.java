package metodopassovariavel;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Exemplo1 e=new Exemplo1();
        List<Ponto> pontos = new LinkedList<>();
        e.comeca(pontos, 0.0, 2.0, 0.5, Math.pow(10, -5), 0.25, 0.01);
        e.imprime(pontos);
    }
}
