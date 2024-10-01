
package laboratorio2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/**
 *
 * @author angie
 */
class Carro {
    String marca;
    String modelo;
    String color;
    int kilometraje;

    public Carro(String marca, String modelo, String color, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public int getKilometraje() { return kilometraje; }
}

public class Punto4 extends JFrame {
    private Carro[] carros;
    private JTextArea areaT;
    private JButton botonModel, botonK;

    public Punto4() {
        setTitle("Ordenar Carros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        areaT= new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaT);
        add(scrollPane);
        
        JPanel panelBotones = new JPanel();
        botonModel = new JButton("Ordenar por Modelo");
        botonK = new JButton("Ordenar por Kilometraje");
        panelBotones.add(botonModel);
        panelBotones.add(botonK);
        add(panelBotones, "South");
        
        botonModel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(carros, Comparator.comparing(Carro::getModelo));
                mosCarros();
            }
        });

        botonK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(carros, Comparator.comparingInt(Carro::getKilometraje));
                mosCarros();
            }
        });

        ingCarros();
    }

    private void ingCarros() {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad de carros:");
        int cantidad = Integer.parseInt(cantidadStr);
        carros = new Carro[cantidad];

        for (int i = 0; i < cantidad; i++) {
            String marca = JOptionPane.showInputDialog(this, "Marca del carro " + (i + 1) + ":");
            String modelo = JOptionPane.showInputDialog(this, "Modelo del carro " + (i + 1) + ":");
            String color = JOptionPane.showInputDialog(this, "Color del carro " + (i + 1) + ":");
            String kilometrajeStr = JOptionPane.showInputDialog(this, "Kilometraje del carro " + (i + 1) + ":");
            int kilometraje = Integer.parseInt(kilometrajeStr);

            carros[i] = new Carro(marca, modelo, color, kilometraje);
        }

        mosCarros();
    }

    private void mosCarros() {
        areaT.setText("");
        for (Carro carro : carros) {
            areaT.append("Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo() + ", Color: " + carro.getColor() + ", Kilometraje: " + carro.getKilometraje() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Punto4().setVisible(true);
            }
        });
    }
}