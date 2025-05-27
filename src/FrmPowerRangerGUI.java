import javax.swing.*;
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
                    int ID = Integer.parseInt(IDTextf.getText());
                    String Nombre = Nombretextf.getText();
                    String TipodePoder = (String) ComboBxpoder.getSelectedItem();
                    int NivelEntrenamiento = comboBoNivelEntre.getSelectedIndex() + 1;
                    String BaseSecreta = (String) comboBoBase.getSelectedItem();


                    boolean Repetido = false;

                    for (PowerRanger powerRanger : powerRangers){
                        if (ID == powerRanger.getID()) {
                            JOptionPane.showMessageDialog(null, "El ID ya existe");
                            Repetido = true;
                            break;
                        }
                    }

                    if (Repetido) {
                        powerRangers.add(new PowerRanger(ID, Nombre, TipodePoder, NivelEntrenamiento, BaseSecreta));
                        JOptionPane.showMessageDialog(null, "Aniadido correctamente");
                    }

                    IDTextf.setText("");
                    Nombretextf.setText("");
                    ComboBxpoder.setSelectedIndex(0);
                    comboBoNivelEntre.setSelectedItem(0);
                    comboBoBase.setSelectedItem(0);


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }


            }
        });
        buscarRangerPorIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(BuscarIdtextF.getText());

                    boolean Encontrado = false;
                    for (PowerRanger powerRanger : powerRangers){
                        textArea1.setText(powerRanger.getNombreReal());
                    }

                    //Busqueda lineal
                    for (PowerRanger powerRanger : powerRangers){
                        if (ID == powerRanger.getID()) {
                            JOptionPane.showMessageDialog(null, "Hemos encontrado al ranger");
                            Nombretextf.setText(powerRanger.getNombreReal());
                            ComboBxpoder.setSelectedItem(powerRanger.getTipoDePoder());
                            comboBoNivelEntre.setSelectedItem(powerRanger.getNivelDeEntrenamiento());
                            comboBoBase.setSelectedItem(powerRanger.getBaseSecreta());

                            Encontrado = true;
                            break;
                        }
                    }
                    if (!Encontrado) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado");
                    }

                } catch (Exception X) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

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
