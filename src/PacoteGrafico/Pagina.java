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
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import Funcao.*;
import Utils.CSVWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import metodopassovariavel.IFuncao;
import metodopassovariavel.MetodoDePassoVariavel;
import metodopassovariavel.Ponto;
import metodopassovariavel.ResultSet;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public class Pagina extends javax.swing.JFrame {

    private IFuncao funcao;
    private List<Ponto> pontos;
    private MetodoDePassoVariavel metodo;
    private Thread t;
    private static String path;
    private static Pagina instance;

    
    private Pagina(){
        funcao = Funcao1.getInstance();
        
        initComponents();
        jLabel4.setText("Função: " + funcao.toString());
    }
    
    public static Pagina getInstance() {
        if(instance == null)
            instance = new Pagina();
        return instance;
    }

    public void terminarExecucao() {
        jButton7.setEnabled(false);
        if(!pontos.isEmpty())
            jButton12.setEnabled(true);
    }
    
    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public List<Ponto> getPontos() {
        return pontos;
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

    private void executaMetodo()
    {
        //Obtém os H's e inicia a lista de pontos
        Double valorHmax = Double.valueOf(jtfHMax.getText());
        BigDecimal hmax = BigDecimal.valueOf(valorHmax);
        Double valorHmin = Double.valueOf(jtfHMin.getText());
        BigDecimal hmin = BigDecimal.valueOf(valorHmin);
        Double valorH = Double.valueOf(jtfHInicial.getText());
        BigDecimal h = BigDecimal.valueOf(valorH);
        Double valorInicio = Double.valueOf(jtfInicio.getText());
        BigDecimal inicio = BigDecimal.valueOf(valorInicio);
        Double valorFim = Double.valueOf(jtfFim.getText());
        BigDecimal fim = BigDecimal.valueOf(valorFim);
        Double valorTOL = Double.valueOf(jtfTOL.getText());
        BigDecimal TOL = BigDecimal.valueOf(valorTOL);
        BigDecimal alfa = funcao.calculaAlfa(valorInicio);
        
        pontos = new LinkedList<>();

        //Executa o método
        boolean exibirLog = jCheckBox1.isSelected();
        metodo = new MetodoDePassoVariavel(funcao, pontos,
                inicio,
                fim,
                alfa,
                TOL,
                hmax, 
                hmin, 
                h, 
                this, 
                exibirLog);
        iniciarMetodo();   
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfHMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfHMax = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfHInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfInicio = new javax.swing.JTextField();
        jtfFim = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jtfTOL = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programação Científica - Método de Runge-Kutta-Fehlberg.");

        jtfHMin.setText("0.01");
        jtfHMin.setName("jtfHmax"); // NOI18N

        jLabel1.setText("H Min:");

        jtfHMax.setText("0.5");
        jtfHMax.setName("jtfHmin"); // NOI18N
        jtfHMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfHMaxActionPerformed(evt);
            }
        });

        jLabel2.setText("H Max:");

        jtfHInicial.setText("0.4");
        jtfHInicial.setName("jtfHInicial"); // NOI18N

        jLabel3.setText("HInicial:");

        jButton1.setText("Rodar");
        jButton1.setName("BtnRodar"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRodarActionPerformed(evt);
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
                btnGeraGrafActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");
        jLabel4.setName("Formula"); // NOI18N

        jButton4.setText("Imprimir H");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpHActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir H, T e W");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpHTWActionPerformed(evt);
            }
        });

        jButton6.setText("Limpar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jButton7.setText("Parar execução");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        jButton8.setText("Alterar Path do GnuPlot");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltPathActionPerformed(evt);
            }
        });
        jButton8.setEnabled(false);

        jButton9.setText("Imprimir T");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpTActionPerformed(evt);
            }
        });

        jButton10.setText("Imprimir W");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpWActionPerformed(evt);
            }
        });

        jLabel5.setText("Inicio:");

        jtfInicio.setText("1");
        jtfInicio.setName("jtfInicio"); // NOI18N

        jtfFim.setText("10");
        jtfFim.setName("jtfFim"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "y' = y - x^2 + 1", "x^3+((x^4)*y", "sin(x^2)", "gama*y" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setText("gama:");

        jButton11.setText("Ok");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Exportar pontos para .csv");
        jButton7.setEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12btnPararActionPerformed(evt);
            }
        });

        jtfTOL.setText("0.00001");
        jtfTOL.setName("jtfInicio"); // NOI18N
        jtfTOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTOLActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Mostrar Log");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fim:");

        jLabel10.setText("(*)ε:");

        jLabel6.setText("* ε é a tolerância utilizada");
        jLabel6.setName("Formula"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton11)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfFim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfTOL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(60, 60, 60)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfHMin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfHMax, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfHInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfHMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfHMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfHInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfTOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton4)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7)
                                    .addComponent(jButton10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jButton12))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTextField1.setText(Integer.toString(-100));
        jTextField1.setEnabled(false);
        jButton11.setEnabled(false);
        jButton12.setEnabled(false);
        jCheckBox1.setSelected(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRodarActionPerformed
        executaMetodo();        
    }//GEN-LAST:event_btnRodarActionPerformed


    private void btnGeraGrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeraGrafActionPerformed
        ResultSet result = new ResultSet(pontos);
        if(t != null){
            plot(result);
        } else {
            mostrarErro("Não existem pontos a serem plotados.\n"
                    + "Execute o método para obter os resultados.", "Resultados não detectados");
        }
    }//GEN-LAST:event_btnGeraGrafActionPerformed

    private void btnImpHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpHActionPerformed
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
    }//GEN-LAST:event_btnImpHActionPerformed

    private void btnImpHTWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpHTWActionPerformed
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
    }//GEN-LAST:event_btnImpHTWActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        jTextArea1.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        metodo.setFLAG(false);
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnAltPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltPathActionPerformed
        String temp = JOptionPane.showInputDialog(null, "Informe o novo caminho"
                + " do executável wgnuplot.exe: ", "Caminho do executável", JOptionPane.PLAIN_MESSAGE);
        if(temp != null)
            if(!temp.equals(""))
                path = temp;
    }//GEN-LAST:event_btnAltPathActionPerformed

    private void btnImpTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpTActionPerformed
        try{
            if (!t.isAlive()) {
                for (Ponto ponto : pontos) {
                    log("T:" + ponto.getT());
                }
            } else {
                mostrarErro("O método ainda está executando, espere até que ele\n"
                        + "termine para poder mostrar os resultados.", "Método em execução");
            }
        } catch(NullPointerException e){
            mostrarErro("Não existem resultados a serem mostrados.\n"
                    + "Execute o método para obter mostrar os resultados.", "Resultados não detectados");
        }
    }//GEN-LAST:event_btnImpTActionPerformed

    private void btnImpWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpWActionPerformed
        try{
            if (!t.isAlive()) {
                for (Ponto ponto : pontos) {
                    log("W:" + ponto.getW());
                }
            } else {
                mostrarErro("O método ainda está executando, espere até que ele\n"
                        + "termine para poder mostrar os resultados.", "Método em execução");
            }
        } catch(NullPointerException e){
            mostrarErro("Não existem resultados a serem mostrados.\n"
                    + "Execute o método para obter mostrar os resultados.", "Resultados não detectados");
        }
    }//GEN-LAST:event_btnImpWActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int novoGama = Integer.parseInt(jTextField1.getText());
        if(novoGama != 0){
            Funcao4.setGama(novoGama);
            JOptionPane.showMessageDialog(null, "Valor de gama alterado para: " + novoGama);
            jLabel4.setText("Funcao: " + funcao);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um valor diferente de 0.", "Valor não aceito", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText(Integer.toString(Funcao4.getGama()));
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        switch(jComboBox1.getSelectedIndex()){
            case 0: funcao = Funcao1.getInstance(); break;
            case 1: funcao = Funcao2.getInstance(); break;
            case 2: funcao = Funcao3.getInstance(); break;
            case 3: funcao = Funcao4.getInstance(); break;
        }
        jLabel4.setText("Função: " + funcao);
        if(funcao == Funcao4.getInstance()){
            jTextField1.setEnabled(true);
            jButton11.setEnabled(true);
            jtfInicio.setText("0");
            jtfFim.setText("2");
            jtfTOL.setText("0.00001");
            jtfHMin.setText("0.0001");
            jtfHMax.setText("0.5");
            jtfHInicial.setText("0.4");
        } else {
            jTextField1.setEnabled(false);
            jButton11.setEnabled(false);
            jtfInicio.setText("1");
            jtfFim.setText("10");
            jtfTOL.setText("0.00001");
            jtfHMin.setText("0.01");
            jtfHMax.setText("0.5");
            jtfHInicial.setText("0.4");
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton12btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12btnPararActionPerformed
        File f;
        try {
            f = new File(Pagina.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if(System.getProperty("os.name").contains("Windows"))
                f = new File(f.getParentFile().getAbsolutePath() + "\\export.csv");
            else
                f = new File(f.getParentFile().getAbsolutePath() + "/export.csv");
            CSVWriter csv = new CSVWriter(f);
            new Thread(csv).start();
        } catch (URISyntaxException ex) {}
    }//GEN-LAST:event_jButton12btnPararActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jtfHMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfHMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfHMaxActionPerformed

    private void jtfTOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTOLActionPerformed

    public static void plot(ResultSet result){
        JavaPlot p;
        File f;
        if(System.getProperty("os.name").contains("Windows")){
            try {
                f = new File(Pagina.class.getProtectionDomain().getCodeSource().getLocation().toURI());
                path = f.getParentFile().getAbsolutePath() + "\\gnuplot\\bin\\wgnuplot.exe";
            } catch (URISyntaxException ex) {}
            try {
                p = new JavaPlot(path);
            } catch (GNUPlotException e) {
                JOptionPane.showMessageDialog(null, "GNUPlot não encontrado, extraia a pasta do GNUPlot "
                        + "na mesma pasta deste executável para poder plotar o gráfico", "GNUPlot não encontrado", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            } 
        } else {
            try{
                p = new JavaPlot();
            } catch (GNUPlotException e) {
                JOptionPane.showMessageDialog(null, "GNUPlot não encontrado, favor instalar para poder "
                        + "plotar o gráfico", "GNUPlot não encontrado", JOptionPane.ERROR_MESSAGE);
                return;
            }
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtfFim;
    private javax.swing.JTextField jtfHInicial;
    private javax.swing.JTextField jtfHMax;
    private javax.swing.JTextField jtfHMin;
    private javax.swing.JTextField jtfInicio;
    private javax.swing.JTextField jtfTOL;
    // End of variables declaration//GEN-END:variables
}
