/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteGrafico;

import com.panayotis.gnuplot.GNUPlotException;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import main.Exemplo1;
import metodopassovariavel.IFuncao;
import metodopassovariavel.MetodoDePassoVariavel;
import metodopassovariavel.Ponto;
import metodopassovariavel.ResultSet;

/**
 *
 * @author Administrador
 */
public class Pagina extends javax.swing.JFrame {

    private IFuncao funcao;
    private List<Ponto> pontos;
    private MetodoDePassoVariavel metodo;
    private Thread t;
    private static String path;

    public Pagina() {
        funcao = new Exemplo1();

        initComponents();
        jLabel4.setText("Função: " + funcao.toString());
    }

    public void terminarExecucao() {
        jButton7.setEnabled(false);
    }
    
    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public void mostrarErro(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }
    public void iniciarMetodo() {
        try {
            if (!t.isAlive()) {
                t = new Thread(metodo);
                t.start();
                jButton7.setEnabled(true);
            } else {
                mostrarErro("O método já está executando, espere até que ele\n"
                        + "termine para poder criar outra instância de execução.", "Método em execução");
            }
        } catch (NullPointerException e) {
            t = new Thread(metodo);
            t.start();
            jButton7.setEnabled(true);
        }
    }

    public void log(final String mensagem) {
        jTextArea1.append("\n" + mensagem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("0.5");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Hmax");

        jTextField2.setText("0.01");

        jLabel2.setText("Hmin");

        jTextField3.setText("0.4");

        jLabel3.setText("HInicial");

        jButton1.setText("Rodar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Rodar sem detalhes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        makeTextAreaAutoScroll(jTextArea1);

        jButton3.setText("Gerar gráfico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        jButton4.setText("Imprimir H");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir H, T e W");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Limpar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Parar execução");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Alterar Path do GnuPlot");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(jButton8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Obtém os H's e inicia a lista de pontos
        Double valorHmax = Double.valueOf(jTextField1.getText());
        BigDecimal hmax = BigDecimal.valueOf(valorHmax);
        Double valorHmin = Double.valueOf(jTextField2.getText());
        BigDecimal hmin = BigDecimal.valueOf(valorHmin);
        Double valorH = Double.valueOf(jTextField3.getText());
        BigDecimal h = BigDecimal.valueOf(valorH);
        pontos = new LinkedList<>();

        //Executa o método
        metodo = new MetodoDePassoVariavel(funcao, pontos,
                new BigDecimal(1),
                new BigDecimal(10),
                BigDecimal.valueOf(0.5),
                new BigDecimal(1).divide(new BigDecimal(10).pow(5)),
                hmax, hmin, h, this, true);
        iniciarMetodo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //Obtém os H's e inicia a lista de pontos
        Double valorHmax = Double.valueOf(jTextField1.getText());
        BigDecimal hmax = BigDecimal.valueOf(valorHmax);
        Double valorHmin = Double.valueOf(jTextField2.getText());
        BigDecimal hmin = BigDecimal.valueOf(valorHmin);
        Double valorH = Double.valueOf(jTextField3.getText());
        BigDecimal h = BigDecimal.valueOf(valorH);
        pontos = new LinkedList<>();

        //Executa o método
        metodo = new MetodoDePassoVariavel(funcao,
                pontos,
                new BigDecimal(1),
                new BigDecimal(10),
                BigDecimal.valueOf(0.5),
                new BigDecimal(1).divide(new BigDecimal(10).pow(5)),
                hmax,//0.25), 
                hmin,
                h,
                this,
                false);//0.01));
        iniciarMetodo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(System.getProperty("os.name").contains("Windows") && path == null){
            path = JOptionPane.showInputDialog(null, "Favor informar o caminho"
                    + " do executável wgnuplot.exe: ", "Caminho do executável", JOptionPane.PLAIN_MESSAGE);
        }
        if(path != null)
            if(!path.equals(""))
                jButton8.setEnabled(true);
        if((System.getProperty("os.name").contains("Windows") && jButton8.isEnabled()) ||
                (System.getProperty("os.name").equals("Linux"))){
            ResultSet result = new ResultSet(pontos);
            if(t != null){
                plot(result);
            } else {
                mostrarErro("Não existem pontos a serem plotados.\n"
                        + "Execute o método para obter os resultados.", "Resultados não detectados");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            if (!t.isAlive()) {
                for (Ponto ponto : pontos) {
                    log("H:" + ponto.getH());
                }
            } else {
                mostrarErro("O método ainda está executando, espere até que ele\n"
                        + "termine para poder mostrar os resultados.", "Método em execução");
            }
        } catch(NullPointerException e){
            mostrarErro("Não existem resultados a serem mostrados.\n"
                    + "Execute o método para obter mostrar os resultados.", "Resultados não detectados");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
            if (!t.isAlive()) {
                for (Ponto ponto : pontos) {
                    log("T:" + ponto.getT() + " W:" + ponto.getW() + " H:" + ponto.getH());
                }
            } else {
                mostrarErro("O método ainda está executando, espere até que ele\n"
                        + "termine para poder mostrar os resultados.", "Método em execução");
            }
        } catch(NullPointerException e){
            mostrarErro("Não existem resultados a serem mostrados.\n"
                    + "Execute o método para poder mostrar os resultados.", "Resultados não detectados");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextArea1.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        metodo.setFLAG(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String temp = JOptionPane.showInputDialog(null, "Informe o novo caminho"
                + " do executável wgnuplot.exe: ", "Caminho do executável", JOptionPane.PLAIN_MESSAGE);
        if(temp != null)
            if(!temp.equals(""))
                path = temp;
    }//GEN-LAST:event_jButton8ActionPerformed

    public static void plot(ResultSet result){
        JavaPlot p = null;
        boolean caminhoErrado;
        if(System.getProperty("os.name").contains("Windows")){
            do{
                try{
                    p = new JavaPlot(path);
                    caminhoErrado = false;
                } catch (GNUPlotException e) {
                        path = JOptionPane.showInputDialog(null, "Executável não encontrado, informe o caminho correto para o executável: ",
                                "Executável não encontrado", JOptionPane.ERROR_MESSAGE);
                        if(path == null)
                            return;
                        caminhoErrado = true;
                }
            } while (caminhoErrado);
        } else {
            p = new JavaPlot();
        }
        p.addPlot(result);
        PlotStyle stl = ((AbstractPlot) p.getPlots().get(0)).getPlotStyle();
        stl.setStyle(Style.LINESPOINTS);
        stl.setPointSize(2);
        p.plot();
    }

    public static void makeTextAreaAutoScroll(JTextArea textArea) {

        // Get the text area's scroll pane :
        final JScrollPane scrollPane = (JScrollPane) (textArea.getParent().getParent());

        // Disable the auto scroll :
        ((DefaultCaret) textArea.getCaret()).setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        // Add a listener to the vertical scroll bar :
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

            private int _val = 0;
            private int _ext = 0;
            private int _max = 0;

            private final BoundedRangeModel _model = scrollPane.getVerticalScrollBar().getModel();

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {

                // Get the new max :
                int newMax = _model.getMaximum();

                // If the new max has changed and if we were scrolled to bottom :
                if (newMax != _max && (_val + _ext == _max)) {

                    // Scroll to bottom :
                    _model.setValue(_model.getMaximum() - _model.getExtent());
                }

                // Save the new values :
                _val = _model.getValue();
                _ext = _model.getExtent();
                _max = _model.getMaximum();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
