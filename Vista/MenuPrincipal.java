package Vista;

import Controlador.Controlador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    
    public MenuPrincipal() {
        Controlador controlador = new Controlador();
        
        setTitle("Sistema de Gestión de Empleados - UPS");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("GESTIÓN DE PERSONAL - UPS");
        lblTitulo.setBounds(100, 20, 220, 25);
        add(lblTitulo);

        JButton btnRegistrar = new JButton("1. Registrar Empleado");
        btnRegistrar.setBounds(80, 70, 220, 35);
        add(btnRegistrar);

        JButton btnConsultar = new JButton("2. Consultar Empleado");
        btnConsultar.setBounds(80, 130, 220, 35);
        add(btnConsultar);

        JButton btnSalir = new JButton("3. Salir");
        btnSalir.setBounds(80, 190, 220, 35);
        add(btnSalir);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaRegistro(controlador).setVisible(true);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaConsulta(controlador).setVisible(true);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
}