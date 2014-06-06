/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import PacoteGrafico.Pagina;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import metodopassovariavel.Ponto;

/**
 *
 * @author cfmtjr
 */
public class CSVWriter implements Runnable{

    private LinkedList<Ponto> pontos = (LinkedList) Pagina.getInstance().getPontos();
    File csvFile = null;
    
    public CSVWriter(File file) {
        csvFile = file;
    }
    
    @Override
    public void run() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.append("T;W;H");
            String temp;
            for (Ponto ponto : pontos) {
                temp = "\n" + ponto.getT() + ";" + ponto.getW() + ";" + ponto.getH();
                writer.append(temp.replaceAll("\\.", ","));
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Arquivo escrito em " + csvFile.getAbsolutePath());

        } catch (IOException ex) {}
        
    }
    
}
