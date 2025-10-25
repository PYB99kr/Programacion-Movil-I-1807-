/*
 * Tarea 3: Agregar botones arriba y abajo en bolita
 * Alumno: Park Daniel
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends JFrame implements ActionListener{
    JPanel pt, pd, pb;
    int posX=0, posY=0;
    JButton btnAdelante, btnAtras, btnArriba, btnAbajo; 
    
    public Bolita(){
        setTitle("Bolita 01");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        
        pt = new PanelTexto();
        pd = new PanelDibujo();
        pb = new JPanel();
        pb.setLayout(new GridLayout(1, 4)); 
        
        btnAdelante = new JButton(">>");
        btnAtras = new JButton("<<");
        btnArriba = new JButton("^^"); 
        btnAbajo = new JButton("vv");
        
        btnAdelante.addActionListener(this);
        btnAtras.addActionListener(this);
        btnArriba.addActionListener(this); 
        btnAbajo.addActionListener(this);
        
        pb.add(btnAtras);
        pb.add(btnArriba); 
        pb.add(btnAbajo); 
        pb.add(btnAdelante);
        
        
        add(pt);
        add(pd);
        add(pb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAdelante)){
            if(posX > 400){ 
                posX=0;     
            }else{
                posX=posX+10;
            }
        }
        if(e.getSource().equals(btnAtras)){
            if(posX < 0){ 
                posX=400; 
            }else{
                posX=posX-10;
            }
        }
        if(e.getSource().equals(btnArriba)){
            if(posY < 0){ 
                posY = 400; 
            } else {
                posY = posY - 10;
            }
        }
        if(e.getSource().equals(btnAbajo)){
            if(posY > 400){ 
                posY = 0; 
            } else {
                posY = posY + 10;
            }
        }
        pd.repaint();
    }
    
    private class PanelTexto extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            Font font = new Font("Arial",20,20);
            g.setFont(font);
            g.drawString("Juego Bolita", 10, 20);           
        }
    }
    
    private class PanelDibujo extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.ORANGE);
            g.fillOval(posX, posY, 20, 20);
        }
        
    }
    
    public static void main(String[] args) {
        Bolita b = new Bolita();
        b.setVisible(true);
    }
}
