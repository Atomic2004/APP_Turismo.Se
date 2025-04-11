package view;

import javax.swing.*;
import Model.PaquetesClass;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPaquetes extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textDescripcion, textPuestos, textDestino, textFechaEnvio, textIdPaquete;

    public FrmPaquetes() {
        setTitle("Gestión de Paquetes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(107, 11, 80, 24);
        contentPane.add(lblDescripcion);
        textDescripcion = new JTextField();
        textDescripcion.setBounds(180, 11, 129, 24);
        contentPane.add(textDescripcion);

        JLabel lblPuestos = new JLabel("Puestos:");
        lblPuestos.setBounds(107, 48, 63, 24);
        contentPane.add(lblPuestos);
        textPuestos = new JTextField();
        textPuestos.setBounds(180, 46, 129, 24);
        contentPane.add(textPuestos);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(107, 83, 63, 24);
        contentPane.add(lblDestino);
        textDestino = new JTextField();
        textDestino.setBounds(180, 81, 129, 24);
        contentPane.add(textDestino);

        JLabel lblFechaEnvio = new JLabel("Fecha Envío:");
        lblFechaEnvio.setBounds(107, 117, 80, 24);
        contentPane.add(lblFechaEnvio);
        textFechaEnvio = new JTextField();
        textFechaEnvio.setBounds(180, 116, 129, 24);
        contentPane.add(textFechaEnvio);

        JLabel lblIdPaquete = new JLabel("ID Paquete:");
        lblIdPaquete.setBounds(107, 152, 80, 24);
        contentPane.add(lblIdPaquete);
        textIdPaquete = new JTextField();
        textIdPaquete.setBounds(180, 151, 86, 24);
        contentPane.add(textIdPaquete);

        JButton btnGuardar = new JButton("");
        btnGuardar.setBounds(37, 200, 113, 78);
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaquetesClass cr = new PaquetesClass();
                cr.create(textDescripcion.getText(), Integer.parseInt(textPuestos.getText()), textDestino.getText(), textFechaEnvio.getText());
            }
        });
        contentPane.add(btnGuardar);

        JButton btnEliminar = new JButton("");
        btnEliminar.setBounds(160, 200, 113, 78);
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaquetesClass cr = new PaquetesClass();
                cr.delete(Integer.parseInt(textIdPaquete.getText()));
            }
        });
        contentPane.add(btnEliminar);

        JButton btnActualizar = new JButton("");
        btnActualizar.setBounds(283, 200, 113, 78);
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaquetesClass cr = new PaquetesClass();
                cr.update(Integer.parseInt(textIdPaquete.getText()), textDescripcion.getText(), Integer.parseInt(textPuestos.getText()), textDestino.getText(), textFechaEnvio.getText());
            }
        });
        contentPane.add(btnActualizar);
    }
}
