
package laboratorio2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author angie
 */
public class menu{
    public static void main(String[] args) {
        // ventana
        JFrame frame = new JFrame("Menú de Ejercicios");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout absoluto

        // botones
        JButton btnPunto1 = new JButton("Primer punto");
        JButton btnPunto2 = new JButton("Segundo punto");
        JButton btnPunto3 = new JButton("Tercer punto");
        JButton btnPunto4 = new JButton("Cuarto punto");

        // Establecer posición y tamaño 
        btnPunto1.setBounds(60, 40, 200, 30);
        btnPunto2.setBounds(60, 80, 200, 30);
        btnPunto3.setBounds(60, 120, 200, 30);
        btnPunto4.setBounds(60, 160, 200, 30);
        // Añadir los botones 
        frame.add(btnPunto1);
        frame.add(btnPunto2);
        frame.add(btnPunto3);
        frame.add(btnPunto4);
        
        
        btnPunto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto1
                Punto1 punto1 = new Punto1();
                punto1.main(null); // Llamar al método main de la clase Punto1
            }
        });

        btnPunto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto2
                Punto2 punto2 = new Punto2();
                punto2.main(null); // Llamar al método main de la clase Punto2
            }
        });

        btnPunto3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto3
                Punto3 punto3 = new Punto3();
                punto3.main(null); // Llamar al método main de la clase Punto3
            }
        });
 btnPunto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto3
                Punto4 punto4 = new Punto4();
                punto4.main(null); // Llamar al método main de la clase Punto3
            }
        });
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}