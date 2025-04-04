import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Tragamoneda extends JFrame {
    // Labels para representar los rodillos de la máquina tragamonedas
    private JLabel rodillo1, rodillo2, rodillo3;
    private JButton botonGirar;
    private Random random = new Random();
    
    // Array con las imágenes de los símbolos del tragamonedas
    private String[] imagenes = {"imagen1.png.jpg", "imagen2.png.jpg", "imagen3.png.jpg", "imagen4.png.jpg", "imagen5.png.jpg", "imagen6.png.jpg"};

    public Tragamoneda() {
        setTitle("Tragamoneda"); // Título de la ventana
        setSize(500, 350); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        setLayout(null);
        getContentPane().setBackground(new Color(40, 30, 20)); // Color de fondo
        
        // Título del juego
        JLabel titulo = new JLabel("TRAGAMONEDA", SwingConstants.CENTER);
        titulo.setBounds(150, 10, 200, 30);
        titulo.setFont(new Font("Serif", Font.BOLD, 20));
        titulo.setForeground(Color.YELLOW);
        add(titulo);
        
        // Panel para contener los rodillos
        JPanel panelRodillos = new JPanel();
        panelRodillos.setBounds(100, 100, 500, 200);
        panelRodillos.setLayout(new GridLayout(1, 3, 10, 10)); // Disposición en rejilla
        panelRodillos.setBackground(new Color(60, 50, 40)); // Color de fondo
        
        // Inicialización de los rodillos con la primera imagen
        rodillo1 = new JLabel(new ImageIcon(imagenes[0]));
        rodillo2 = new JLabel(new ImageIcon(imagenes[0]));
        rodillo3 = new JLabel(new ImageIcon(imagenes[0]));
        
        // Agregar rodillos al panel
        panelRodillos.add(rodillo1);
        panelRodillos.add(rodillo2);
        panelRodillos.add(rodillo3);
        add(panelRodillos);
        
        // Botón para girar los rodillos
        botonGirar = new JButton();
        botonGirar.setBounds(190, 500, 100, 100);
        botonGirar.setIcon(new ImageIcon("boton.png.jpg")); // Imagen del botón
        botonGirar.setBorderPainted(false);
        botonGirar.setContentAreaFilled(false);
        
        // Acción del botón para iniciar el giro de los rodillos en un hilo separado
        botonGirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> girarRodillos()).start();
            }
        });
        add(botonGirar);
    }

    // Método que simula el giro de los rodillos
    private void girarRodillos() {
        try {
            for (int i = 0; i < 10; i++) {  // Simulación del giro con 10 iteraciones
                rodillo1.setIcon(new ImageIcon(imagenes[random.nextInt(imagenes.length)]));
                rodillo2.setIcon(new ImageIcon(imagenes[random.nextInt(imagenes.length)]));
                rodillo3.setIcon(new ImageIcon(imagenes[random.nextInt(imagenes.length)]));
                Thread.sleep(200); // Pausa entre cada cambio de imagen
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        // Obtener las imágenes finales de los rodillos
        String img1 = ((ImageIcon) rodillo1.getIcon()).getDescription();
        String img2 = ((ImageIcon) rodillo2.getIcon()).getDescription();
        String img3 = ((ImageIcon) rodillo3.getIcon()).getDescription();
        
        // Verificar si las tres imágenes son iguales para determinar si hay premio
        if (img1.equals(img2) && img2.equals(img3)) {
            JOptionPane.showMessageDialog(this, "¡Ganaste! 🎉"); // Mensaje de victoria
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tragamoneda juego = new Tragamoneda();
            juego.setVisible(true); // Mostrar la ventana del juego
        });
    }
}