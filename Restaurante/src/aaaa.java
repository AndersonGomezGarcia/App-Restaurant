
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



/**
 *
 * @author Anderson
 */
public class App extends JFrame implements ActionListener, ItemListener {
    Container contenedor;
    FlowLayout layout;
    JLabel etiqueta1, etiqueta2;
    JTextField campo;
    JTextArea area1;
    JScrollPane scroll;
    JComboBox <String> combo;  
    JButton boton1, boton2;
    JCheckBox caja1, caja2, caja3;
    public App(){

        

        contenedor = getContentPane();
        layout = new FlowLayout();
        contenedor.setLayout(layout);
        
        String colores [] = {"rojo","azul","verde"};
        combo = new JComboBox<String>(colores);
        combo.addItemListener(this);
        contenedor.add(combo);

        etiqueta1 = new JLabel("Hola eventos");
        etiqueta1.setText("Adios");
        etiqueta1.setIcon(new ImageIcon("C:\\Users\\Univalle\\Desktop\\gui\\img\\liveaction.jpeg"));
        contenedor.add(etiqueta1);

        etiqueta2 = new JLabel("Hola olvidona");
        etiqueta2.setFont(new Font("Monospaced", Font.ITALIC, 20));        
        contenedor.add(etiqueta2);
        

        campo = new JTextField(10);
        campo.addActionListener(this);
        contenedor.add(campo);

        area1 = new JTextArea(10,10);        
        scroll = new JScrollPane(area1);
        contenedor.add(scroll);     
        
        boton1 = new JButton("Ingresar");
        boton1.addActionListener(this);
        contenedor.add(boton1);     

        boton2 = new JButton("Borrar");
        boton2.addActionListener(this);
        contenedor.add(boton2);   
        
        caja1 = new JCheckBox("Vivie en Tulua");
        caja1.addItemListener(this);
        contenedor.add(caja1);

        caja2 = new JCheckBox("Tiene moto");
        caja2.addItemListener(this);
        contenedor.add(caja2);

        caja3 = new JCheckBox("Promedio + de 4");
        caja3.addItemListener(this);
        contenedor.add(caja3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            String texto = campo.getText();
            JOptionPane.showMessageDialog(contenedor, texto);
            if(caja1.isSelected()){
                JOptionPane.showMessageDialog(contenedor, "Si vive el estudiante en Tulua");
            }
        }else if(e.getSource()==boton2){
            campo.setText("");
        }else if(e.getSource()==campo){
            JOptionPane.showMessageDialog(contenedor, "Presionaste enter");
        }
        

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==caja1){
            if(e.getStateChange()==1){
                etiqueta1.setText("Vive en Tulua");
            }else{
                etiqueta1.setText("No vive en Tulua");
            }

        }
    }
}
