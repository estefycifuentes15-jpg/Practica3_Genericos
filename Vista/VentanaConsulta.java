package Vista;

import Controlador.Controlador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsulta extends JFrame {
    private JTextField txtCedulaBusqueda;
    private JTextArea txtResultado;
    private Controlador controlador;

    public VentanaConsulta(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Consulta de Empleados");
        setSize(450, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblCedula = new JLabel("Cédula a buscar:");
        lblCedula.setBounds(30, 30, 110, 25);
        add(lblCedula);

        txtCedulaBusqueda = new JTextField();
        txtCedulaBusqueda.setBounds(140, 30, 160, 25);
        add(txtCedulaBusqueda);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 30, 90, 25);
        add(btnBuscar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBounds(30, 80, 370, 210);
        add(scrollPane);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaStr = txtCedulaBusqueda.getText();
                try {
                    long cedula = Long.parseLong(cedulaStr);
                    String resultado = controlador.consultarEmpleadoGeneral(cedula);
                    txtResultado.setText(resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La cédula debe contener únicamente números.", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}