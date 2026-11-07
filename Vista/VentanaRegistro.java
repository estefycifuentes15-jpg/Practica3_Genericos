package Vista;

import Controlador.Controlador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JFrame {
    private JTextField txtNombre, txtCedula, txtCampo1, txtCampo2;
    private JLabel lblCampo1, lblCampo2;
    private JComboBox<String> cmbTipo;
    private Controlador controlador;

    public VentanaRegistro(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Registro de Empleados");
        setSize(400, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 30, 180, 25);
        add(txtNombre);

        JLabel lblCedula = new JLabel("Cédula (10 dig):");
        lblCedula.setBounds(30, 70, 110, 25);
        add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(150, 70, 180, 25);
        add(txtCedula);

        JLabel lblTipo = new JLabel("Tipo Empleado:");
        lblTipo.setBounds(30, 110, 110, 25);
        add(lblTipo);

        String[] tipos = {"Administrativo", "Obrero", "Técnico"};
        cmbTipo = new JComboBox<>(tipos);
        cmbTipo.setBounds(150, 110, 180, 25);
        add(cmbTipo);

        lblCampo1 = new JLabel("Cargo:");
        lblCampo1.setBounds(30, 150, 110, 25);
        add(lblCampo1);

        txtCampo1 = new JTextField();
        txtCampo1.setBounds(150, 150, 180, 25);
        add(txtCampo1);

        lblCampo2 = new JLabel("Clave Acceso:");
        lblCampo2.setBounds(30, 190, 110, 25);
        add(lblCampo2);
        lblCampo2.setVisible(false);

        txtCampo2 = new JTextField();
        txtCampo2.setBounds(150, 190, 180, 25);
        add(txtCampo2);
        txtCampo2.setVisible(false);

        cmbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) cmbTipo.getSelectedItem();
                if (seleccionado.equals("Administrativo")) {
                    lblCampo1.setText("Cargo:");
                    lblCampo2.setVisible(false);
                    txtCampo2.setVisible(false);
                } else if (seleccionado.equals("Obrero")) {
                    lblCampo1.setText("Código Obrero:");
                    lblCampo2.setVisible(false);
                    txtCampo2.setVisible(false);
                } else if (seleccionado.equals("Técnico")) {
                    lblCampo1.setText("Código:");
                    lblCampo2.setVisible(true);
                    txtCampo2.setVisible(true);
                }
            }
        });

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 240, 120, 35);
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String val1 = txtCampo1.getText();
                String val2 = txtCampo2.getText();
                String tipo = (String) cmbTipo.getSelectedItem();

                boolean exito = false;
                if (tipo.equals("Administrativo")) {
                    exito = controlador.registrarAdministrativo(nombre, cedula, val1);
                } else if (tipo.equals("Obrero")) {
                    exito = controlador.registrarObrero(nombre, cedula, val1);
                } else if (tipo.equals("Técnico")) {
                    exito = controlador.registrarTecnico(nombre, cedula, val1, val2);
                }

                if (exito) {
                    JOptionPane.showMessageDialog(null, "¡Empleado registrado con éxito!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Verifique que la cédula tenga 10 dígitos numéricos, no esté duplicada y los campos no estén vacíos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}