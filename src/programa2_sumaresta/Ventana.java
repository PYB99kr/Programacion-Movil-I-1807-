/*
 * Tarea 2: Agregar boton restar en el programa que suma
 * Alumno: Park Daniel
 */
package programa2_sumaresta;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
    JButton b1, b2;
    JButton bResta;
    JTextField txt1, txt2;
    JPanel panel01, panelR;
    JLabel et01, et02, etR;
    
    public Ventana(){
        setTitle("Mi ventana");
        setSize(350,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1)); 
        setResizable(false);
        
        b1 = new JButton("Sumar");
        b2 = new JButton("Limpiar");
        bResta = new JButton("Restar"); 

        txt1 = new JTextField(20);
        txt2 = new JTextField(20);
        et01 = new JLabel("Numero 1:");         
        et02 = new JLabel("Numero 2:");
        etR = new JLabel();
        panel01 = new JPanel();
        panelR = new JPanel();
        panelR.setBackground(Color.gray);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        bResta.addActionListener(this); 
        
        panel01.add(et01);
        panel01.add(txt1);
        panel01.add(et02);
        panel01.add(txt2);
        panel01.add(b1);
        panel01.add(b2);
        panel01.add(bResta);
        
        panelR.add(etR);
        
        add(panel01);         
        add(panelR);
        add(new JPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)){
            try {
                int op1 = Integer.parseInt(txt1.getText());
                int op2 = Integer.parseInt(txt2.getText());
                int res = op1 + op2;
                System.out.println("sumando "+ res);
                JOptionPane.showMessageDialog(null, res);
                etR.setText("Suma: " + String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource().equals(bResta)){
            try {
                int op1 = Integer.parseInt(txt1.getText());
                int op2 = Integer.parseInt(txt2.getText());
                int res = op1 - op2; 
                System.out.println("restando "+ res);
                JOptionPane.showMessageDialog(null, res);
                etR.setText("Resta: " + String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(b2.equals(e.getSource())){
            txt1.setText("");
            txt2.setText("");
            etR.setText("");
        }
    }
    
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }         
}