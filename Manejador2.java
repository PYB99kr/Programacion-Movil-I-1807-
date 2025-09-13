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

public class Manejador2 extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4;
    JPanel pc, pc2;
    JLabel etiquetaNombre, etiquetaPanel2;
    JTextField nombreDado;
    JButton btnEnviarDatos;

    public Manejador2() {
        setTitle("Programa 01");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(3, 2));

        etiquetaNombre = new JLabel("Nombre: ");
        nombreDado = new JTextField(20);
        btnEnviarDatos = new JButton("Enviar");
        btnEnviarDatos.addActionListener(this);
        
        pc = new JPanel();
        pc.add(etiquetaNombre);
        pc.add(nombreDado);
        pc.add(btnEnviarDatos);
        
        pc2 = new JPanel();
        etiquetaPanel2 = new JLabel("Panel de Resultados");
        pc2.add(etiquetaPanel2);
        
        b1 = new JButton("azul");
        b2 = new JButton("naranja");
        b3 = new JButton("verde");
        b4 = new JButton("rojo");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(pc);
        add(pc2);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == b1) {
            System.out.println("azul");
            pc2.setBackground(Color.BLUE);
        } else if (source == b2) {
            System.out.println("naranja");
            pc2.setBackground(Color.ORANGE);
        } else if (source == b3) {
            System.out.println("verde");
            pc2.setBackground(Color.GREEN);
        } else if (source == b4) {
            System.out.println("rojo");
            pc2.setBackground(Color.RED);
        } else if (source == btnEnviarDatos) {
            String nombre = nombreDado.getText();
            JOptionPane.showMessageDialog(this, "Hola " + nombre);
            etiquetaPanel2.setText("Hola " + nombre);
        }
    }
    
    public static void main(String[] args) {
        new Manejador2();
    }
}