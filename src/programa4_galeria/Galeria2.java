/*
 * Tarea 4: Arreglar la Galeria 2 (Navegación Circular)
 * Alumno: Park Daniel
 */
import java.awt.FlowLayout;
import java.awt.Image; // Importar la clase Image
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Galeria2 extends JFrame{
    // Tamaño fijo deseado para las imágenes
    private static final int IMAGE_WIDTH = 350;
    private static final int IMAGE_HEIGHT = 250;
    
    JButton btnAdelante, btnAtras;
    JPanel panelbtn;
    ArrayList<ImageIcon> images;
    int ImgActual = 0; 
    JLabel etimage;
    
    public Galeria2(){
        setTitle("Mi Galeria");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());     
        
        images = new ArrayList<>();
        // Al cargar, escalamos el ImageIcon para tener la misma dimensión
        images.add(getScaledIcon("images/image1.jpg"));         
        images.add(getScaledIcon("images/image2.jpg"));
        images.add(getScaledIcon("images/image3.jpg"));
        
        etimage = new JLabel();
        showImage(ImgActual);
                
        btnAdelante = new JButton("Adelante");          
        btnAtras = new JButton("Atras");
        panelbtn = new JPanel();
        
        btnAtras.addActionListener(e->showImage(ImgActual-1));
        
        btnAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(ImgActual+1);
            }
        });
        
        panelbtn.add(btnAtras); panelbtn.add(btnAdelante);
        add(etimage);
        add(panelbtn);
        setVisible(true);
    }
    
    /**
     * Función que carga una imagen de la ruta especificada y la escala a un tamaño fijo.
     */
    private ImageIcon getScaledIcon(String path) {
        // 1. Cargar el icono original
        ImageIcon originalIcon = new ImageIcon(path);
        
        // 2. Obtener el objeto Image de la imagen
        Image originalImage = originalIcon.getImage();
        
        // 3. Escalar la imagen al tamaño fijo (usando un algoritmo de escalado suave)
        Image scaledImage = originalImage.getScaledInstance(
            IMAGE_WIDTH, 
            IMAGE_HEIGHT, 
            Image.SCALE_SMOOTH // Algoritmo de alta calidad
        );
        
        // 4. Devolver la nueva ImageIcon escalada
        return new ImageIcon(scaledImage);
    }
    
    public static void main(String[] args) {
        new Galeria2();
    }
    
    public void showImage(int newIndex){
        int totalImages = images.size();
        
        // Lógica circular para ADELANTE (última -> primera)
        if(newIndex >= totalImages){
            newIndex = 0; 
        } 
        // Lógica circular para ATRÁS (primera -> última)
        else if(newIndex < 0){
            newIndex = totalImages - 1;
        }

        this.ImgActual = newIndex;           
        etimage.setIcon(images.get(this.ImgActual));
        System.out.println("Mostrando imagen índice: " + this.ImgActual);
    }
}