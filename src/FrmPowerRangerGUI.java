import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class FrmPowerRangerGUI {
    private JTextField IDTextf;
    private JTextField Nombretextf;
    private JComboBox ComboBxpoder;
    private JComboBox comboBoNivelEntre;
    private JComboBox comboBoBase;
    private JButton agergarNuevoRangerButton;
    private JButton buscarRangerPorIDButton;
    private JTextArea textArea1;
    private JTextField BuscarIdtextF;
    private JComboBox ComboboFiltrar;
    private JButton conteoPorPoderButton;
    private JPanel Jpanel;
    private JButton filtrarButton;
    private JTable table1;

    LinkedList<PowerRanger> powerRangers = new LinkedList<>();


    public FrmPowerRangerGUI() {
        agergarNuevoRangerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ponemos en variables el input del usuario
                    int ID = Integer.parseInt(IDTextf.getText());
                    String Nombre = Nombretextf.getText();
                    String TipodePoder = (String) ComboBxpoder.getSelectedItem();
                    int NivelEntrenamiento = comboBoNivelEntre.getSelectedIndex() + 1;
                    String BaseSecreta = (String) comboBoBase.getSelectedItem();

                    //Instanciamos una defaultTableModel

                    DefaultTableModel tableModel = new DefaultTableModel();

                    //Inicialisamos las columnas de la tabla
                    tableModel.addColumn("ID");
                    tableModel.addColumn("NombreReal");
                    tableModel.addColumn("TipoDePoder");
                    tableModel.addColumn("NivelDeEntrenamiento");
                    tableModel.addColumn("BaseSecreta");

                    //Asignamos el modelo de la tabla a table1
                    table1.setModel(tableModel);

                    //Ponemos los encabezados

                    tableModel.addRow(new Object[]{
                            "ID,",
                            "Nombre",
                            "Tipo de poder",
                            "Nivel",
                            "Base secreta"
                    });



                    //Creamos un booleano para controlar si se repite el ID
                    boolean Repetido = false;

                    for (PowerRanger powerRanger : powerRangers){ //Recorremos la lista con un for each
                        if (ID == powerRanger.getID()) { // Si el ID es igual al de otro power ranger
                            JOptionPane.showMessageDialog(null, "El ID ya existe"); // Indicamos que ya existe
                            Repetido = true; //Cambiamos el estado del booleano a true por que si se repite el ID
                            break; //Acabamos con el for
                        }
                    }

                    if (!Repetido) { //Si no estubo repetido
                        PowerRanger power = new PowerRanger(ID, Nombre, TipodePoder, NivelEntrenamiento, BaseSecreta); //Instanciamos el nuevo ranger

                        powerRangers.add(power); //Lo agregamos a la lista
                        JOptionPane.showMessageDialog(null, "Aniadido correctamente"); // Mostramos que se añadio correctamente
                        tableModel.addRow(new Object[]{ // Lo mostramos en la tabla
                                power.getID(),
                                power.getNombreReal(),
                                power.getTipoDePoder(),
                                power.getNivelDeEntrenamiento(),
                                power.getBaseSecreta()
                        });
                    }
                    //Setteamos todos los modificables a su respectivo default
                    IDTextf.setText("");
                    Nombretextf.setText("");
                    ComboBxpoder.setSelectedIndex(0);
                    comboBoNivelEntre.setSelectedIndex(0);
                    comboBoBase.setSelectedIndex(0);


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error"); // Si ocurrio un error se muestra en pantalla
                }


            }
        });
        buscarRangerPorIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(BuscarIdtextF.getText()); //Creamos una variable donde almacenar el ID a buscar

                    boolean Encontrado = false; //Creamos una variable Boolean para controlar si se encontro o no

                    //Usamos la busqueda lineal con un for each
                    for (PowerRanger powerRanger : powerRangers){
                        if (ID == powerRanger.getID()) { // Si el ID es igual
                            JOptionPane.showMessageDialog(null, "Hemos encontrado al ranger"); //Se muestra que se encontro
                            //Se pone la info en los campos editables
                            IDTextf.setText(String.valueOf(powerRanger.getID()));
                            Nombretextf.setText(powerRanger.getNombreReal());
                            ComboBxpoder.setSelectedItem(powerRanger.getTipoDePoder());
                            comboBoNivelEntre.setSelectedIndex(powerRanger.getNivelDeEntrenamiento() -1);
                            comboBoBase.setSelectedItem(powerRanger.getBaseSecreta());
                            //Cambiamos la variable booleana a true por que si se encontro
                            Encontrado = true;
                            break;// Y acabamos con la busqueda lineal
                        }
                    }
                    if (!Encontrado) { // Si no se encontro
                        JOptionPane.showMessageDialog(null, "No se ha encontrado"); //Mostramos que no se encontro
                    }
                    BuscarIdtextF.setText(""); // Se borra el campo de texto

                } catch (Exception X) {
                    JOptionPane.showMessageDialog(null, "Error"); //Si ocurrio un error se muestra en pantalla
                }

            }
        });
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String BaseSecreta = (String) ComboboFiltrar.getSelectedItem(); //Tomamos el input del usuario del combobox
                    LinkedList<PowerRanger> powerrangerfiltrado = new LinkedList<>(); // Creamos una lista para los filtrados

                    //Instanciamos una defaultTableModel

                    DefaultTableModel tableModel = new DefaultTableModel();

                    //Inicialisamos las columnas de la tabla
                    tableModel.addColumn("ID");
                    tableModel.addColumn("NombreReal");
                    tableModel.addColumn("TipoDePoder");
                    tableModel.addColumn("NivelDeEntrenamiento");
                    tableModel.addColumn("BaseSecreta");

                    //Asignamos el modelo de la tabla a table1
                    table1.setModel(tableModel);

                    //Ponemos los encabezados

                    tableModel.addRow(new Object[]{
                            "ID,",
                            "Nombre",
                            "Tipo de poder",
                            "Nivel",
                            "Base secreta"
                    });

                    //Recorremos la lista con un for each
                    for (PowerRanger power : powerRangers) {
                        if (!power.getBaseSecreta().equals(BaseSecreta)) { // Si la base no es igual a la que pidio el usuario agregamos el power ranger a la lista filtrada
                            powerrangerfiltrado.add(power);
                        }
                    }

                    //Convertimos a array para aplicar el ordenado por burbuja
                    PowerRanger[] array = powerrangerfiltrado.toArray(new PowerRanger[0]);

                    // Burbuja
                    for (int i = 0; i < array.length - 1; i++) {
                        for (int j = 0; j < array.length - i - 1; j++) {
                            if (array[j].getNivelDeEntrenamiento() > array[j + 1].getNivelDeEntrenamiento()) {
                                // Intercambio
                                PowerRanger temp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = temp;
                            }
                        }
                    }


                    // Mostrar los resultados ordenados en el JTable con un for each
                    for (PowerRanger pr : array) {
                        tableModel.addRow(new Object[]{
                                pr.getID(),
                                pr.getNombreReal(),
                                pr.getTipoDePoder(),
                                pr.getNivelDeEntrenamiento(),
                                pr.getBaseSecreta()
                        });
                    }



                } catch (Exception X) {
                    JOptionPane.showMessageDialog(null," error");//Si ocurrio un error se muestra en pantalla
                }
            }
        });
        conteoPorPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringBuilder sb = new StringBuilder(); //Creamos un String Builed para almacenar la info

                int cantidadDino = PowerRanger.contarRangersPorTipo(powerRangers, "Dino Poder", 0); // Utilizamos la funcion recursiva con "Dino Poder" y la lista powerRangers
                sb.append("Cantidad de Rangers con Dino Poder: ").append(cantidadDino).append("\n"); // Agregamos al String Builder

                int cantidadNinja = PowerRanger.contarRangersPorTipo(powerRangers, "Ninja Shadow", 0); // Utilizamos la funcion recursiva con "Ninja Shadow" y la lista powerRangers
                sb.append("Cantidad de Rangers con Ninja Shadow: ").append(cantidadNinja).append("\n");// Agregamos al String Builder

                int cantidadPoder = PowerRanger.contarRangersPorTipo(powerRangers, "Poder Cósmico", 0); // Utilizamos la funcion recursiva con "Poder Cósmico" y la lista powerRangers
                sb.append("Cantidad de Rangers con Poder Cósmico: ").append(cantidadPoder).append("\n");// Agregamos al String Builder

                int cantidadFuria = PowerRanger.contarRangersPorTipo(powerRangers, "Furia Salvaje", 0); // Utilizamos la funcion recursiva con "Furia Salvaje" y la lista powerRangers
                sb.append("Cantidad de Rangers con Furia Salvaje: ").append(cantidadFuria).append("\n");// Agregamos al String Builder

                int cantidadMegazord = PowerRanger.contarRangersPorTipo(powerRangers, "Megazord Control", 0); // Utilizamos la funcion recursiva con "Megazord Control" y la lista powerRangers
                sb.append("Cantidad de Rangers con Megazord Control: ").append(cantidadMegazord).append("\n");// Agregamos al String Builder

                textArea1.setText(sb.toString()); // Mostramos el String builder en el text area

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmPowerRangerGUI");
        frame.setContentPane(new FrmPowerRangerGUI().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
