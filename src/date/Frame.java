
package date;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Frame extends JFrame{
    private JPanel panel;
    private JLabel etiqueta;
    private JButton botonR, botonG, botonB;
    private int contadorR = 0, contadorV = 0, contadorA = 0;
    private int pulsado = 0;
    
    public Frame(){
        iniciarComponentes();
        colocarEtiqueta();
        colocarBotones();
        eventoClick();
        eventoRuedaRaton();
    }

    private void iniciarComponentes() {
        this.setSize(700,500);
        this.setTitle("Ejercicio 3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(true);
        this.add(panel);
    }

    private void colocarEtiqueta() {
        etiqueta = new JLabel("Color (Rojo, Verde, Azul)");
        etiqueta.setFont(new Font("arial",0,24));
        etiqueta.setBounds(200,30,300,40);
        etiqueta.setHorizontalTextPosition(SwingConstants.CENTER);
        
        panel.add(etiqueta);
    }

    private void colocarBotones() {
        /* BOTON ROJO pulsado == 1*/
        botonR = new JButton("ROJO");
        botonR.setForeground(Color.red);
        botonR.setFont(new Font("Arial",1,18));
        
        botonR.setBounds(85,300,120,70);
        panel.add(botonR);
        
        /* BOTON VERDE pulsado == 2*/
        botonG = new JButton("VERDE");
        botonG.setForeground(Color.green);
        botonG.setFont(new Font("Arial",1,18));
        
        botonG.setBounds(290,300,120,70);
        panel.add(botonG);
        
        /* BOTON AZUL pulsado == 3*/
        botonB = new JButton("AZUL");
        botonB.setForeground(Color.blue);
        botonB.setFont(new Font("Arial",1,18));
        
        botonB.setBounds(495,300,120,70);
        panel.add(botonB);
    }

    private void eventoClick() {
        ActionListener l1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;
            }
        };  botonR.addActionListener(l1);
        
        ActionListener l2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 2;
            }
        };  botonG.addActionListener(l2);
        
        ActionListener l3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 3;
            }
        };  botonB.addActionListener(l3);
    }
    
    private void eventoRuedaRaton(){
        MouseWheelListener l1 = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(pulsado != 0){
                    if(pulsado == 1){//rojo
                        contadorR += e.getPreciseWheelRotation();
                        
                        if(contadorR < 0){
                            contadorR = 0;
                        }
                        if(contadorR > 255){
                            contadorR = 255;
                        }
                    } else if(pulsado == 2){//verde
                        contadorV += e.getPreciseWheelRotation();
                        
                        if(contadorV < 0){
                            contadorV = 0;
                        }
                        if(contadorV > 255){
                            contadorV = 255;
                        }
                    } else{//azul
                        contadorA += e.getPreciseWheelRotation();
                        
                        if(contadorA < 0){
                            contadorA = 0;
                        }
                        if(contadorA > 255){
                            contadorA = 255;
                        }
                    }
                    
                    panel.setBackground(new Color(contadorR, contadorV,contadorA));
                }
                etiqueta.setText("Color (Rojo: "+contadorR+", Verde: "+contadorV+", Azul: "+contadorA+")");
                etiqueta.setBounds(etiqueta.getX(), etiqueta.getY(), 400,etiqueta.getHeight());
            }
        };  panel.addMouseWheelListener(l1);
    }
}
