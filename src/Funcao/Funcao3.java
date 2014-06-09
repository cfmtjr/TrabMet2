package Funcao;

import java.math.BigDecimal;
import java.math.MathContext;
import metodopassovariavel.IFuncao;

/**
 *
 * @author Alessandro Campello Silva,
 * <p>
 * Carlos Filipe M. Teixeira Jr.,
 * <p>
 * Thadeu José Caldas Neves,
 * <p>
 * Tomas M.G. de Siqueira.
 */
public class Funcao3 implements IFuncao {

    static final double sqrt_pi_2 = Math.sqrt(Math.PI/2); /* sqrt(pi/2) */

    static final double sqrt_2_pi = Math.sqrt(2/Math.PI); /* sqrt(2/pi) */

    static final double _1_sqrt_2pi = 1/Math.sqrt(2*Math.PI); /* 1/sqrt(2*pi) */

    static final double pi_2 = Math.PI/2; /* pi/2 */

    static double f_data_b[] = {0.63041404314570539241,
        -0.42344511405705333544,
        0.37617172643343656625,
        -0.16249489154509567415,
        0.03822255778633008694,
        -0.00564563477132190899,
        0.00057454951976897367,
        -0.00004287071532102004,
        0.00000245120749923299,
        -0.00000011098841840868,
        0.00000000408249731696,
        -0.00000000012449830219,
        0.00000000000320048425,
        -0.00000000000007032416,
        0.00000000000000133638,
        -0.00000000000000002219,
        0.00000000000000000032};

    static double f_data_e[] = {0.97462779093296822410,
        -0.02424701873969321371,
        0.00103400906842977317,
        -0.00008052450246908016,
        0.00000905962481966582,
        -0.00000131016996757743,
        0.00000022770820391497,
        -0.00000004558623552026,
        0.00000001021567537083,
        -0.00000000251114508133,
        0.00000000066704761275,
        -0.00000000018931512852,
        0.00000000005689898935,
        -0.00000000001798219359,
        0.00000000000594162963,
        -0.00000000000204285065,
        0.00000000000072797580,
        -0.00000000000026797428,
        0.00000000000010160694,
        -0.00000000000003958559,
        0.00000000000001581262,
        -0.00000000000000646411,
        0.00000000000000269981,
        -0.00000000000000115038,
        0.00000000000000049942,
        -0.00000000000000022064,
        0.00000000000000009910,
        -0.00000000000000004520,
        0.00000000000000002092,
        -0.00000000000000000982,
        0.00000000000000000467,
        -0.00000000000000000225,
        0.00000000000000000110,
        -0.00000000000000000054,
        0.00000000000000000027,
        -0.00000000000000000014,
        0.00000000000000000007,
        -0.00000000000000000004,
        0.00000000000000000002,
        -0.00000000000000000001,
        0.00000000000000000001};

    static double f_data_f[] = {
        0.99461545179407928910,
        -0.00524276766084297210,
        0.00013325864229883909,
        -0.00000770856452642713,
        0.00000070848077032045,
        -0.00000008812517411602,
        0.00000001359784717148,
        -0.00000000246858295747,
        0.00000000050925789921,
        -0.00000000011653400634,
        0.00000000002906578309,
        -0.00000000000779847361,
        0.00000000000222802542,
        -0.00000000000067239338,
        0.00000000000021296411,
        -0.00000000000007041482,
        0.00000000000002419805,
        -0.00000000000000861080,
        0.00000000000000316287,
        -0.00000000000000119596,
        0.00000000000000046444,
        -0.00000000000000018485,
        0.00000000000000007527,
        -0.00000000000000003131,
        0.00000000000000001328,
        -0.00000000000000000574,
        0.00000000000000000252,
        -0.00000000000000000113,
        0.00000000000000000051,
        -0.00000000000000000024,
        0.00000000000000000011,
        -0.00000000000000000005,
        0.00000000000000000002,
        -0.00000000000000000001,
        0.00000000000000000001};

    private static Funcao3 instance;

    private Funcao3() {

    }

    public static Funcao3 getInstance() {
        if (instance == null) {
            instance = new Funcao3();
        }
        return instance;
    }

    @Override
    public BigDecimal calcula(BigDecimal x, BigDecimal y) {
        //sin(x^2)
        return new BigDecimal(Math.sin(x.pow(2).doubleValue()));
    }

    static double fresnel_sin_0_8(double x) {
        double x_8 = x / 8.0;
        double xx = 2.0 * x_8 * x_8 - 1.0;
        double t0 = 1.;
        double t1 = xx;
        double ot1 = x_8;
        double ot2 = 2.0 * x_8 * t1 - ot1;
        double sumS = f_data_b[0] * ot1 + f_data_b[1] * ot2;
        int n;
        double t2;
        for (n = 2; n < 17; n++) {
            t2 = 2.0 * xx * t1 - t0;
            ot1 = ot2;
            ot2 = 2.0 * x_8 * t2 - ot1;
            sumS += f_data_b[n] * ot2;
            t0 = t1;
            t1 = t2;
        }
        return _1_sqrt_2pi * Math.sqrt(x) * sumS;
    }

    static double fresnel_sin_8_inf(double x) {
        double xx = 128.0 / (x * x) - 1.0;   /* 2.0*(8/x)^2 - 1 */

        double t0 = 1.0;
        double t1 = xx;
        double sumP = f_data_e[0] + f_data_e[1] * t1;
        double sumQ = f_data_f[0] + f_data_f[1] * t1;
        double t2;
        int n;
        for (n = 2; n < 35; n++) {
            t2 = 2.0 * xx * t1 - t0;
            sumP += f_data_e[n] * t2; /*  sumP += f_data_e[n]*ChebyshevT(n,xx) */

            sumQ += f_data_f[n] * t2; /*  sumQ += f_data_f[n]*ChebyshevT(n,xx) */

            t0 = t1;
            t1 = t2;
        }
        for (n = 35; n < 41; n++) {
            t2 = 2.0 * xx * t1 - t0;
            sumP += f_data_e[n] * t2; /*  sumQ += f_data_f[n]*ChebyshevT(n,xx) */

            t0 = t1;
            t1 = t2;
        }
        return 0.5 - _1_sqrt_2pi * (0.5 * sumP * Math.sin(x) / x + sumQ * Math.cos(x)) / Math.sqrt(x);
    }

    double fresnel_s(double x) {
        double xx = x * x * pi_2;
        double ret_val;
        if (xx <= 8.0) {
            ret_val = fresnel_sin_0_8(xx);
        } else {
            ret_val = fresnel_sin_8_inf(xx);
        }
        return (x < 0.0) ? -ret_val : ret_val;
    }

    @Override
    public String toString() {
        return "sin(x^2)";
    }

    @Override
    public BigDecimal calculaAlfa(double ini) {
        //y(x) = sqrt(pi/2) * FresnelS(sqrt(2/pi) x)
        double s = fresnel_s(Math.sqrt(2/Math.PI)*ini);
        System.out.println(s);
        double ans = sqrt_pi_2 * s;
        return new BigDecimal(ans, new MathContext(20));
    }
}
