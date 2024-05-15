package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaJuegos extends JFrame {
    private JPanel panelComboBox;
    private JComboBox cbJuegos;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JPanel pFecha;
    private JButton bAceptar;
    private JTextField tfEmpresa;
    private JPanel panelPrincipal;
    private JButton bSalir;
    //private JCalendar cFecha

    public VistaJuegos() {
        super("Juegos");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
        //cFecha = new JCalendar();
        //pFecha.add(cFecha);
    }

    public void addBEditarAl (ActionListener al){
        bEditar.addActionListener(al);
    }
    public void addBBorrarAl (ActionListener al){
        bBorrar.addActionListener(al);
    }
    public void addBAceptarAl (ActionListener al){
        bAceptar.addActionListener(al);
    }
    public void addCbEquiposAl (ActionListener al){
        cbJuegos.addActionListener(al);
    }
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }

    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    public JComboBox getCbJuegos() {
        return cbJuegos;
    }

    public JPanel getPanelDatos() {
        return panelDatos;
    }

    public JTextArea getTaDatos() {
        return taDatos;
    }

    public JPanel getPanelCrear() {
        return panelCrear;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JPanel getpFecha() {
        return pFecha;
    }

    public JTextField getTfEmpresa() {
        return tfEmpresa;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}