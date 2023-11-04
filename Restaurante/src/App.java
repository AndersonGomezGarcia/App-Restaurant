import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    private static double costoTotal = 0.0;
    private static int tiempoTotal = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurante App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 1000);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel platosLabel = new JLabel("Seleccione un plato:");
        JLabel facturaLabel = new JLabel("--Factura:                 ");
        JComboBox<String> platosComboBox = new JComboBox<>();
        JButton agregarAlCarritoButton = new JButton("Agregar al Carrito");
        JButton pagarButton = new JButton("Pagar");
        JTextArea carritoTextArea = new JTextArea(10, 32);
        JTextArea facturaTextArea = new JTextArea(10, 30);
        JTextArea infoPlatoTextArea = new JTextArea(5, 50);
        infoPlatoTextArea.setEditable(false);
        carritoTextArea.setEditable(false);
        facturaTextArea.setEditable(false);

        JLabel costoTotalLabel = new JLabel("   -----| Costo Total: $0.0. |  ");
        JLabel tiempoTotalLabel = new JLabel("   -----| Tiempo Total: $0.0. |  ");

        panel.add(platosLabel);
        panel.add(platosComboBox);
        panel.add(infoPlatoTextArea);
        panel.add(agregarAlCarritoButton);
        
        panel.add(carritoTextArea);
        panel.add(costoTotalLabel);
        panel.add(tiempoTotalLabel);
        panel.add(pagarButton);
        panel.add(facturaLabel);
        panel.add(facturaTextArea);

        //ArrayList<Plato> menu = new ArrayList<>();
        ArrayList<Plates> menu = new ArrayList<>();
        CreateListPlates(menu);
        

        for (Plates plato : menu) {
            platosComboBox.addItem(plato.getName());

        }

        platosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plates seleccionado = Plates.SearchPlate(menu, platosComboBox.getSelectedItem().toString());
                System.out.println(seleccionado.getName());
                infoPlatoTextArea.setText("Nombre: " + seleccionado.getName() + "\n" +
                        "Descripción: " + seleccionado.getDescription() + "\n" +
                        "Tipo: " + seleccionado.getType() + "\n" +
                        "Costo: $" + seleccionado.getCost() + "\n" +
                        "Tiempo de preparación: " + seleccionado.getPreparationTime() + " minutos");
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plates seleccionado = Plates.SearchPlate(menu, platosComboBox.getSelectedItem().toString());
                costoTotal += seleccionado.getCost();
                costoTotalLabel.setText("Costo Total: $" + costoTotal);
                
                carritoTextArea.append(seleccionado.getName() + "\n");
                ShoppingCar.CreatePlate(menu, seleccionado.getName(), seleccionado.getDescription(), seleccionado.getType(), ShoppingCar.CalculateTotalCost(), ShoppingCar.CalculateTotalTime());
                ShoppingCar.AddPlate(seleccionado);
                tiempoTotal = ShoppingCar.CalculateTotalTime();
                tiempoTotalLabel.setText("Tiempo Total: "+tiempoTotal);
            }
        });
        frame.setVisible(true);
        pagarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                facturaTextArea.setText("");
                facturaTextArea.setText(ShoppingCar.GeneratePurchaseBill());
            }
        });
    }
    public static void CreateListPlates(ArrayList<Plates> plateList){
        Plates.CreatePlate (plateList, "Plato 1", "Descripción del Plato 1", "Entrada", 10099,     15);
        Plates.CreatePlate(plateList, "Plato 2", "Descripción del Plato 2", "Bebida", 3299,     5);
        Plates.CreatePlate(plateList, "Plato 3", "Descripción del Plato 3", "Plato Fuerte", 19399,  30);
        Plates.CreatePlate(plateList, "Plato 4", "Descripción del Plato 4", "Entrada", 8899,    12);
        Plates.CreatePlate(plateList, "Plato 5", "Descripción del Plato 5", "Bebida", 2249,     3);
        Plates.CreatePlate(plateList, "Plato 6", "Descripción del Plato 6", "Plato Fuerte", 24499,  40);
        Plates.CreatePlate(plateList, "Plato 7", "Descripción del Plato 7", "Entrada", 9999,    14);
        Plates.CreatePlate(plateList, "Plato 8", "Descripción del Plato 8", "Bebida", 4449,     6);
        Plates.CreatePlate(plateList, "Plato 9", "Descripción del Plato 9", "Plato Fuerte", 2299,  35);
        Plates.CreatePlate(plateList, "Plato 10", "Descripción del Plato 10", "Entrada", 7299,  10);
    }
    
}


