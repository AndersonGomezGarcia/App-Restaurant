import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    private static double costoTotal = 0.0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurante App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel platosLabel = new JLabel("Seleccione un plato:");
        JComboBox<Plato> platosComboBox = new JComboBox<>();
        JButton agregarAlCarritoButton = new JButton("Agregar al Carrito");
        JButton pagarButton = new JButton("Pagar");
        JTextArea carritoTextArea = new JTextArea(10, 30);
        JTextArea facturaTextArea = new JTextArea(10, 30);
        JTextArea infoPlatoTextArea = new JTextArea(5, 50);
        infoPlatoTextArea.setEditable(false);
        carritoTextArea.setEditable(false);
        facturaTextArea.setEditable(false);

        JLabel costoTotalLabel = new JLabel("--Costo Total: $0.0");
        JLabel tiempoTotalLabel = new JLabel("--Costo Total: $0.0");

        panel.add(platosLabel);
        panel.add(platosComboBox);
        panel.add(infoPlatoTextArea);
        panel.add(agregarAlCarritoButton);
        
        panel.add(carritoTextArea);
        panel.add(costoTotalLabel);
        panel.add(tiempoTotalLabel);
        panel.add(pagarButton);
        panel.add(facturaTextArea);

        ArrayList<Plato> menu = new ArrayList<>();
        menu.add(new Plato("bandeja paisa", "arroz, chorizo, chicharron, frijoles y tajadas", "Plato fuerte", 20000, 30));
        menu.add(new Plato("salmon a la plancha", "arroz, salmon a la plancha, ensalada ", "Plato fuerte", 25000, 40));
        menu.add(new Plato("pollo a la naranja", "arroz, pollo ensalada dulce, tajadas", "Plato fuerte", 18000, 30));
        menu.add(new Plato("nuggets", "croquetas de pollo", "entrada", 8000, 15));
        menu.add(new Plato("alitas BBQ", "6 alas con salsa BBQ", "entrada", 9000, 15));

        menu.add(new Plato("agua", "agua cristal", "bebida", 4000, 0));
        menu.add(new Plato("limonada de koco", "limonada de coco", "bebida", 5000, 5));
        menu.add(new Plato("gaseosa", "gaseosa cocacola", "bebida", 5000, 5));

        for (Plato plato : menu) {
            platosComboBox.addItem(plato);
        }

        platosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato seleccionado = (Plato) platosComboBox.getSelectedItem();
                infoPlatoTextArea.setText("Nombre: " + seleccionado.getNombre() + "\n" +
                        "Descripción: " + seleccionado.getDescripcion() + "\n" +
                        "Tipo: " + seleccionado.getTipo() + "\n" +
                        "Costo: $" + seleccionado.getCosto() + "\n" +
                        "Tiempo de preparación: " + seleccionado.getTiempoPreparacion() + " minutos");
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato seleccionado = (Plato) platosComboBox.getSelectedItem();
                costoTotal += seleccionado.getCosto();
                costoTotalLabel.setText("Costo Total: $" + costoTotal);
                carritoTextArea.append(seleccionado.toString() + "\n");
            }
        });

        frame.setVisible(true);
        pagarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                facturaTextArea.setText("factura");
            }
        });
    }
}

class Plato {
    private String nombre;
    private String descripcion;
    private String tipo;
    private double costo;
    private int tiempoPreparacion;

    public Plato(String nombre, String descripcion, String tipo, double costo, int tiempoPreparacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipo + " - Costo: $" +costo;
    }
}