package view;

import javax.swing.*;
import Model.DestinosClass; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDestinos extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre, textCiudad, textPais, textDescripcion, textIdDestino;

    public FrmDestinos() {
        setTitle("Gestión de Destinos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(107, 11, 63, 24);
        contentPane.add(lblNombre);
        textNombre = new JTextField();
        textNombre.setBounds(180, 11, 129, 24);
        contentPane.add(textNombre);

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(107, 48, 63, 24);
        contentPane.add(lblCiudad);
        textCiudad = new JTextField();
        textCiudad.setBounds(179, 46, 129, 24);
        contentPane.add(textCiudad);

        JLabel lblPais = new JLabel("País:");
        lblPais.setBounds(107, 83, 63, 24);
        contentPane.add(lblPais);
        textPais = new JTextField();
        textPais.setBounds(180, 81, 129, 24);
        contentPane.add(textPais);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(107, 117, 85, 24);
        contentPane.add(lblDescripcion);
        textDescripcion = new JTextField();
        textDescripcion.setBounds(180, 116, 129, 24);
        contentPane.add(textDescripcion);

        JLabel lblIdDestino = new JLabel("ID Destino:");
        lblIdDestino.setBounds(107, 152, 85, 24);
        contentPane.add(lblIdDestino);
        textIdDestino = new JTextField();
        textIdDestino.setBounds(180, 151, 86, 24);
        contentPane.add(textIdDestino);

        JButton btnGuardar = new JButton("");
        btnGuardar.setBounds(37, 187, 113, 78);
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-documento-67.png"));
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DestinosClass cr = new DestinosClass();
                cr.create(textNombre.getText(), textCiudad.getText(), textPais.getText(), 
                          textDescripcion.getText());
            }
        });
        contentPane.add(btnGuardar);

        // Botón Eliminar
        JButton btnEliminar = new JButton("");
        btnEliminar.setBounds(160, 187, 113, 78);
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-full-trash-64.png"));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DestinosClass cr = new DestinosClass();
                cr.delete(Integer.parseInt(textIdDestino.getText()));
            }
        });
        contentPane.add(btnEliminar);

        // Botón Actualizar
        JButton btnActualizar = new JButton("");
        btnActualizar.setBounds(283, 187, 113, 78);
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\icons8-actualizar-en-la-nube-50.png"));
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DestinosClass cr = new DestinosClass();
                cr.update(Integer.parseInt(textIdDestino.getText()), textNombre.getText(), 
                          textCiudad.getText(), textPais.getText(), textDescripcion.getText());
            }
        });
        contentPane.add(btnActualizar);
    }

    // Método principal para ejecutar el JFrame
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmDestinos frame = new FrmDestinos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
