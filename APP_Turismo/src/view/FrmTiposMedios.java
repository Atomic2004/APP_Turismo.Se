package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrmTiposMedios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextArea txtObservacion;
    private JTextField txtId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmTiposMedios frame = new FrmTiposMedios();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmTiposMedios() {
        setTitle("Tipos de Medios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 30, 100, 20);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 30, 250, 20);
        txtId.setEditable(false); // Autoincremental
        contentPane.add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 60, 250, 20);
        contentPane.add(txtNombre);

        JLabel lblObservacion = new JLabel("Observación:");
        lblObservacion.setBounds(30, 90, 100, 20);
        contentPane.add(lblObservacion);

        txtObservacion = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtObservacion);
        scroll.setBounds(140, 90, 250, 80);
        contentPane.add(scroll);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 200, 100, 30);
        contentPane.add(btnGuardar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(140, 200, 100, 30);
        contentPane.add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(250, 200, 100, 30);
        contentPane.add(btnEliminar);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(160, 250, 100, 30);
        contentPane.add(btnRegresar);

        // Eventos
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String obs = txtObservacion.getText();
            // Aquí llamarías a tu método para guardar en MySQL
            JOptionPane.showMessageDialog(null, "Guardado: " + nombre);
        });

        btnActualizar.addActionListener(e -> {
            String id = txtId.getText();
            String nombre = txtNombre.getText();
            String obs = txtObservacion.getText();
            // Lógica de actualización
            JOptionPane.showMessageDialog(null, "Actualizado ID: " + id);
        });

        btnEliminar.addActionListener(e -> {
            String id = txtId.getText();
            // Lógica de eliminación
            JOptionPane.showMessageDialog(null, "Eliminado ID: " + id);
        });

        btnRegresar.addActionListener(e -> {
            dispose(); // Cierra esta ventana
        });
    }
}
