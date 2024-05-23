package controlador.controladorV;


import modelo.Equipo;
import modelo.Jugador;
import vista.VistaJugadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVJugadores {
    private VistaJugadores vjd;
    private ControladorV cv;
    private Jugador jd;
    private Equipo eq;
    private List<Jugador> listaJd;
    private List<Equipo> listaEq;
    private int combo = 0;
    private JComboBox combobox;

    public ControladorVJugadores(ControladorV cv) {
        this.cv = cv;
    }

    public void rellenarLista(){
        listaEq = cv.comboEquipos();
        combobox = vjd.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }

    public void mostrarJugadores() {
        vjd = new VistaJugadores();

        vjd.addBAceptarAl(new BAceptarAl());
        vjd.addBBorrarAl(new BBorrarAl());
        vjd.addBEditarAl(new BEditarAl());
        vjd.addCbJugadoresAl(new CbJugadoresAl());
        vjd.addBSalirAl(new BSalirAl());

        vjd.setVisible(true);
        vjd.getPanelComboBox().setVisible(true);
        vjd.getPanelDatos().setVisible(false);
        vjd.getPanelCrear().setVisible(false);


        rellenarLista();
    }

    public class CbJugadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vjd.getCbJugadores().getSelectedIndex();
            if(combo>=1) {
                if (combo == 1  ) {
                    vjd.getPanelCrear().setVisible(true);
                    vjd.getPanelDatos().setVisible(false);
                    vjd.limpiar();
                } else {
                    vjd.getPanelDatos().setVisible(true);
                    vjd.getPanelCrear().setVisible(false);

                    try {
                        jd = cv.buscarJugador(vjd.getCbJugadores().getItemAt(combo).toString());

                    vjd.getTaDatos().setText(jd.getNombre()+"\n"+jd.getNacionalidad()+"\n"+ jd.getNickname()+
                            "\n"+ jd.getRol()+"\n"+ jd.getFechaNacimiento()+"\n"+ jd.getSueldo());

                    vjd.getTfNombre().setText(jd.getNombre());
                    vjd.getTfNacionalidad().setText(jd.getNacionalidad());
                    vjd.getTfNickname().setText(jd.getNickname());
                    vjd.getTfRol().setText(jd.getRol());
                    vjd.getTfSueldo().setText(String.valueOf(jd.getSueldo()));

                        listaEq = cv.comboEquipos();
                        listaEq.forEach(o->vjd.getCbEquipos().addItem(o.getNombre()));





                        //Hay que cambiar el tipo de dato
                        java.util.Date fechaFundacion = jd.getFechaNacimiento();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaFundacion);
                        vjd.getcFecha().setCalendar(calendar);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }
    }

    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjd.getPanelCrear().setVisible(true);

        }
    }

    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (combo == 0) {
                    jd = new Jugador();
                }
                jd.setNombre(vjd.getTfNombre().getText());
                jd.setNacionalidad(vjd.getTfNacionalidad().getText());
                jd.setNickname(vjd.getTfNickname().getText());
                jd.setRol(vjd.getTfRol().getText());
                jd.setSueldo(Integer.valueOf(vjd.getTfSueldo().getText()));


                java.sql.Date fecha = new java.sql.Date(vjd.getcFecha().getDate().getTime());
                jd.setFechaNacimiento(fecha);

                eq = listaEq.get(vjd.getCbEquipos().getSelectedIndex()+2);
                jd.setEquiposByIdEquipo(eq);

                cv.insertarJugador(jd);
                System.out.println("Jugador insertado");
                vjd.limpiar();

                // Actualizar ComboBox
                listaJd = cv.comboJugadores();
                vjd.getCbJugadores().removeAllItems();
                listaJd.forEach(o -> vjd.getCbJugadores().addItem(o.getNickname()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarJugador();
                vjd.limpiar();
                //Actualizar ComboBox
                listaJd = cv.comboJugadores();
                vjd.getCbJugadores().removeAllItems();
                listaJd.forEach(o -> vjd.getCbJugadores().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjd.dispose();
        }
    }

}