import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class Manejador1 extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4;
    JPanel pc;
    
    public Manejador1() {
        setTitle("Programa 01");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        pc = new JPanel();
        pc.setBackground(Color.WHITE);
        
        b1 = new JButton("azul"); 
        b2 = new JButton("naranja");
        b3 = new JButton("verde");
        b4 = new JButton("rojo");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.SOUTH);
        add(b3, BorderLayout.WEST);
        add(b4, BorderLayout.EAST);
        add(pc, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == b1) {
            System.out.println("azul");
            pc.setBackground(Color.BLUE);
        } else if (source == b2) {
            System.out.println("naranja");
            pc.setBackground(Color.ORANGE);
        } else if (source == b3) {
            System.out.println("verde");
            pc.setBackground(Color.GREEN);
        } else if (source == b4) {
            System.out.println("rojo");
            pc.setBackground(Color.RED);
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Manejador1();
        });
    }
}