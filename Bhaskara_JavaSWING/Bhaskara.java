package br.victormagosso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Float.parseFloat;

public class Bhaskara extends JFrame{
    private JPanel panelBaskara;
    private JTextField valorA;
    private JTextField valorB;
    private JTextField valorC;
    private JLabel valorDelta;
    private JLabel concavidadeDirecao;
    private JButton buttonCalcular;
    private JButton buttonLimpar;
    private JLabel valorX1;
    private JLabel valorX2;

    public Bhaskara(){
        add(panelBaskara);
        setTitle("Baskara");
        setSize(600, 400);

        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float vA = parseFloat(valorA.getText());
                float vB = parseFloat(valorB.getText());
                float vC = parseFloat(valorC.getText());

                valorDelta.setText(String.valueOf((Math.pow(vB, 2) - (4*vA*vC))));

                ImageIcon iconCima = new ImageIcon(getClass().getResource("cima.png"));
                ImageIcon iconBaixo = new ImageIcon(getClass().getResource("baixo.png"));

                if (vA > 0){
                    concavidadeDirecao.setIcon(iconCima);
                }else{
                    concavidadeDirecao.setIcon(iconBaixo);
                }

                float vD = parseFloat(valorDelta.getText());
                float x1 = ((-vB + vD)/2*vA);
                float x2 = ((-vB - vD)/2*vA);

                if (parseFloat(valorDelta.getText()) < 0){
                    valorX1.setText("Não possui raízes reais");
                    valorX2.setText("Não possui raízes reais");
                }else {
                    valorX1.setText("X¹ = " + x1);
                    valorX2.setText("X² = " + x2);
                }

            }
        });
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valorA.setText("");
                valorB.setText("");
                valorC.setText("");
                valorDelta.setText("");
                concavidadeDirecao.setText("");
                concavidadeDirecao.setIcon(null);
                valorX1.setText("X¹ = ");
                valorX2.setText("X² = ");
            }
        });
    }
}
