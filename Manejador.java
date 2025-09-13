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

public class Manejador extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4;
    JPanel pc, pd;
    JLabel texto;
    JTextField casillaNombre;
    JButton btnEnviar;

    public Manejador() {
        setTitle("Manejador");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(3, 2));
        
        b1 = new JButton("Rojo");
        b2 = new JButton("Azul");
        b3 = new JButton("Amarillo");
        b4 = new JButton("Blanco");
        
        pc = new JPanel();
        pc.setBackground(Color.ORANGE);
        
        pd = new JPanel();
        texto = new JLabel("Nombre: ");
        casillaNombre = new JTextField(20);
        btnEnviar = new JButton("Enviar Datos");
        
        btnEnviar.addActionListener(this);
        
        pd.add(texto);
        pd.add(casillaNombre);
        pd.add(btnEnviar);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(pc);
        add(pd);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == b1) {
            System.out.println("Presionado rojo");
            pc.setBackground(Color.RED);
        } else if (source == b2) {
            System.out.println("Presionado azul");
            pc.setBackground(Color.BLUE);
        } else if (source == b3) {
            System.out.println("Presionado amarillo");
            pc.setBackground(Color.YELLOW);
        } else if (source == b4) {
            System.out.println("Presionado blanco");
            pc.setBackground(Color.WHITE);
        } else if (source == btnEnviar) {
            System.out.println("Enviando datos");
            JOptionPane.showMessageDialog(this, "Hola " + casillaNombre.getText());
        }
    }
    
    public static void main(String[] args) {
        new Manejador();
    }
}